package com.ourteam.project1.pages

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import com.ourteam.project1.ui.theme.MainColor
import com.ourteam.project1.ui.theme.ThirdColor
import com.ourteam.project1.R
import com.ourteam.project1.data.NavItem
import com.ourteam.project1.data.MovieRepository
import com.ourteam.project1.components.ImageSlider
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import kotlinx.coroutines.yield
import kotlinx.coroutines.delay
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.google.accompanist.pager.*
import kotlin.math.absoluteValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.navigation.NavController

@ExperimentalPagerApi
@Composable
fun HomeScreen(navController: NavController) {
    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Search", Icons.Default.Search),
        NavItem("Settings", Icons.Default.Settings),
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
                // ubah warna background
                containerColor = MainColor,
                contentColor = Color.White
            ) {
                navItemList.forEachIndexed { _, navItem ->
                    NavigationBarItem(
                        colors = NavigationBarItemColors(
                            selectedIndicatorColor = Color.Transparent,
                            selectedIconColor = ThirdColor,
                            selectedTextColor = ThirdColor,
                            unselectedIconColor = Color.White,
                            unselectedTextColor = Color.White,
                            disabledIconColor = Color.Gray,
                            disabledTextColor = Color.Gray   
                        ),
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = navItem.label
                            )
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Content(
            modifier = Modifier.padding(paddingValues),
            navController = navController // pass navController here
        )
    }
}

@ExperimentalPagerApi
@Composable
fun Content(modifier: Modifier = Modifier, navController: NavController) { // add navController as parameter
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
    ) {
        // logo tmdb
        Image(
            painter = painterResource(id = R.drawable.tmdb),
            contentDescription = "Logo",
            modifier = Modifier
                .width(120.dp)
                .padding(15.dp)
        )

        // Gambar Slider
        ImageSlider(modifier)

        // Bagian Popular Now
        Text(
            text = "Popular Now",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(15.dp)
        )

        // Daftar Film Populer
        val popularMovies = MovieRepository.getPopularMovies()

        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(popularMovies) { movie ->
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                        .width(120.dp)
                        .clickable {
                            navController.navigate("detail/${movie.id}")
                        }
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(), // Memastikan surface mengisi lebar kolom
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = movie.imageResource),
                            contentDescription = "Film Populer",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.height(160.dp)
                        )
                    }
                    Text(
                        text = movie.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .wrapContentHeight(),
                        maxLines = 4,
                        fontSize = 14.sp
                    )
                    Text(
                        text = movie.genre,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        maxLines = 4,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}
