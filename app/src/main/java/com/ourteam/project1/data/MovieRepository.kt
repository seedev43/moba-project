package com.ourteam.project1.data

import com.ourteam.project1.R

object MovieRepository {
    fun recentMovies(): List<MovieItem> {
        return listOf(
            MovieItem(
                id = 1,
                title = "The Amazing Spiderman (2024)",
                desc = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                genre = "Action, Sci-Fi",
                imageResource = R.drawable.gambar,
                rating = 1.2F
            ),
            MovieItem(
                id = 2,
                title = "Avengers: Endgame (2019)",
                desc = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                genre = "Action, Adventure",
                imageResource = R.drawable.image,
                rating = 10F
            ),
            MovieItem(
                id = 3,
                title = "Inception (2010)",
                desc = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                genre = "Action, Sci-Fi",
                imageResource = R.drawable.image,
                rating = 10F
            ),
            MovieItem(
                id = 4,
                title = "Interstellar (2014)",
                desc = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                genre = "Adventure, Drama",
                imageResource = R.drawable.gambar,
                rating = 10F
            ),
        )
    }
    
    fun getPopularMovies(): List<MovieItem> {
        return listOf(
            MovieItem(
                id = 1,
                title = "The Amazing Spiderman (2024)",
                desc = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                genre = "Action, Sci-Fi",
                imageResource = R.drawable.gambar,
                rating = 1.2F
            ),
            MovieItem(
                id = 2,
                title = "Avengers: Endgame (2019)",
                desc = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                genre = "Action, Adventure",
                imageResource = R.drawable.image,
                rating = 10F
            ),
            MovieItem(
                id = 3,
                title = "Inception (2010)",
                desc = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                genre = "Action, Sci-Fi",
                imageResource = R.drawable.image,
                rating = 10F
            ),
            MovieItem(
                id = 4,
                title = "Interstellar (2014)",
                desc = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                genre = "Adventure, Drama",
                imageResource = R.drawable.gambar,
                rating = 10F
            ),
            MovieItem(
                id = 5,
                title = "The Dark Knight (2008)",
                desc = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                genre = "Action, Crime",
                imageResource = R.drawable.image,
                rating = 10F
            )
        )
    }
}
