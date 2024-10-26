package com.ourteam.project1.pages

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import com.ourteam.project1.data.MovieItem
import com.ourteam.project1.data.MovieRepository
import com.ourteam.project1.ui.theme.MainColor
import com.ourteam.project1.ui.theme.ThirdColor
import androidx.navigation.NavController
import com.ourteam.project1.R

@ExperimentalMaterial3Api
@Composable
fun DetailScreen(movieId: Int, navController: NavController) {
    Scaffold(
        containerColor = MainColor,
        contentColor = Color.White,
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = "Home",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = { 
                        navController.navigate("home") 
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back to Home",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MainColor,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        
            ContentDetail(
                movieId = movieId,
                modifier = Modifier.padding(paddingValues)
            )
        
    }
}

@Composable
fun ContentDetail(movieId: Int, modifier: Modifier = Modifier) {
    val movie: MovieItem? = MovieRepository.getPopularMovies().find { it.id == movieId }
    val scrollState = rememberScrollState()
    var rating by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            // .padding(16.dp)
            .verticalScroll(scrollState)
            .fillMaxSize()
    ) {
        movie?.let {
            Box(
                modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "Detail Film",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
            ) {
                Column {
                    Text(
                        text = it.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = it.rating.toString(),
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

                    Text(
                        text = it.genre,
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Description",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = it.desc,
                        fontSize = 13.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Rating This Film",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        (1..5).forEach { index ->
                            IconButton(
                                onClick = { rating = index } 
                            ) {
                                Icon(
                                    imageVector = if (index <= rating) Icons.Filled.Star else Icons.Outlined.Star,
                                    contentDescription = "Rate $index stars",
                                    tint = ThirdColor,
                                    modifier = Modifier
                                    .size(30.dp)
                                )
                            }
                        }
                    }

                    Text(
                    text = "You rated: $rating/5",
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        } ?: run {
            Text(
                textAlign = TextAlign.Center,
                text = "Movie not found",
                fontSize = 50.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

    // Column {

    //     Box(
    //     modifier = Modifier
    //     .fillMaxWidth()
    //     .height(300.dp)
    // ) {
    //     Image(
    //         painter = painterResource(id = R.drawable.image),
    //         contentDescription = "Detail Film",
    //         contentScale = ContentScale.Crop,
    //         modifier = Modifier.fillMaxSize()
    //     )
    //     Text(
    //         modifier = Modifier
    //         .align(Alignment.TopStart)
    //         .padding(35.dp),
    //         color = Color.White,
    //         fontSize = 26.sp,
    //         text = "Home"
    //     )
    // }
    // Surface(
    //     modifier = Modifier
    //     .fillMaxSize(),
    //     color = MainColor
    // ) {
        
    // }
    // }
    // Scaffold(
    //     containerColor = MainColor,
    //     contentColor = Color.White
    // ) { paddingValues ->
    //     Column(
    //         modifier = Modifier
    //             .padding(paddingValues)
    //             .padding(16.dp)
    //             .fillMaxSize()
    //     ) {
    //         movie?.let {
    //             Image(
    //                 painter = painterResource(id = it.imageResource),
    //                 contentDescription = "Movie Poster",
    //                 contentScale = ContentScale.Crop,
    //                 modifier = Modifier
    //                     .fillMaxWidth()
    //                     .height(300.dp)
    //                     .padding(bottom = 16.dp)
    //             )
    //             Text(
    //                 text = it.title,
    //                 fontSize = 24.sp,
    //                 fontWeight = FontWeight.Bold,
    //                 color = Color.White,
    //                 modifier = Modifier.padding(bottom = 8.dp)
    //             )
    //             Text(
    //                 text = "Genre: ${it.genre}",
    //                 fontSize = 16.sp,
    //                 color = Color.White,
    //                 modifier = Modifier.padding(bottom = 8.dp)
    //             )
    //             // Misalkan kita juga menambahkan rating ke model
    //             Text(
    //                 text = "Rating: ${it.rating}", // Pastikan rating ada dalam model
    //                 fontSize = 16.sp,
    //                 color = Color.White,
    //                 modifier = Modifier.padding(bottom = 16.dp)
    //             )
    //             Text(
    //                 text = "Description of the movie goes here...",
    //                 fontSize = 14.sp,
    //                 color = Color.White,
    //                 lineHeight = 20.sp
    //             )
    //         } ?: run {
    //             Text(
    //                 text = "Movie not found",
    //                 fontSize = 18.sp,
    //                 color = Color.White,
    //                 modifier = Modifier.padding(bottom = 16.dp)
    //             )
    //         }
    //     }
    // }
// }