package com.ourteam.project1.pages

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import kotlinx.coroutines.yield
import kotlinx.coroutines.delay
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.util.lerp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.google.accompanist.pager.*
import kotlin.math.absoluteValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star


@ExperimentalPagerApi
@ExperimentalMaterial3Api
@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = MainColor,
        contentColor = Color.White
    ) { paddingValues ->
        Content(
            modifier = Modifier.padding(paddingValues).padding(top = 10.dp)
        )
    }
}

@ExperimentalPagerApi
@Composable
fun Content(modifier: Modifier = Modifier) {
    val imageSlider = listOf(
        painterResource(id = R.drawable.image),
        painterResource(id = R.drawable.image),
        painterResource(id = R.drawable.image)
    )
    val pagerState = rememberPagerState(initialPage = 0)

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % imageSlider.size
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.tmdb),
            contentDescription = "Logo",
            modifier = modifier
            .width(120.dp)
            .padding(15.dp)
        )

        // Gambar Slider
        HorizontalPager(
            count = imageSlider.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 15.dp),
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                // .offset(y = (-40).dp)
        ) { page ->
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        scaleX = lerp(0.85f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
                        scaleY = scaleX
                        alpha = lerp(0.5f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
                    }
            ) {
                Box {
                    Image(
                        painter = imageSlider[page],
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    
                    Column(
                        modifier = Modifier
                            // mengatur teks agar di posisi pojok kiri bawah
                            .align(Alignment.BottomStart) 
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "The Amazing Spiderman (2024)", 
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Action, Sci-Fi", 
                                color = Color.White,
                                fontSize = 12.sp
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically 
                            ) {
                                Text(
                                    text = "8.5",
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = "Rating",
                                    tint = ThirdColor,
                                    modifier = Modifier.padding(start = 4.dp).size(16.dp) 
                                )
                            }
                        }
                    }
                }
            }
        }

        // Indikator Pager
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
                // .offset(y = (-30).dp),
            activeColor = Color.White,
            inactiveColor = Color.DarkGray
        )

        // Jarak antara slider dan bagian Popular Now
        // Spacer(modifier = Modifier.height(5.dp))

        // Bagian Popular Now
        Text(
            text = "Popular Now",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(15.dp)
        )

        // Daftar Film Populer
        val popularMovies = listOf(
    R.drawable.image, 
    R.drawable.image,
    R.drawable.image,
    R.drawable.image,
    R.drawable.image
)

LazyRow(
    modifier = Modifier.fillMaxWidth()
) {
    items(popularMovies) { movie ->
        Column(
            modifier = Modifier
                .padding(15.dp)
                .width(110.dp) // Mengatur lebar kolom
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(), // Memastikan surface mengisi lebar kolom
                shape = RoundedCornerShape(8.dp)
            ) {
                Image(
                    painter = painterResource(id = movie),
                    contentDescription = "Film Populer",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(160.dp)
                )
            }
            Text(
                text = "The Amazing Spiderman (2024)",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 8.dp),
                maxLines = 4,
                fontSize = 14.sp
            )
            Text(
                text = "Action, Sci-Fi",
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

