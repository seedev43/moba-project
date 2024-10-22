package com.ourteam.project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ourteam.project1.ui.theme.Project1Theme
import androidx.compose.foundation.rememberScrollState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Container(modifier = Modifier.padding(innerPadding).padding(10.dp))
                }
            }
        }
    }
}

@Composable
fun Container(modifier: Modifier = Modifier) {
    // Menambahkan verticalScroll untuk memungkinkan scrolling vertikal
    val scrollState = rememberScrollState()

    Column(modifier = modifier.verticalScroll(scrollState)) {
        Surface(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
            color = Color.Green,
            shadowElevation = 10.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.meong),
                contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // Menambahkan padding di sini
        Text(
            modifier = Modifier.padding(top = 25.dp), // Padding di atas teks untuk kontrol jarak
            text = "Gambar Kucing Lainnya",
            fontSize = 20.sp
        )

        // Menampilkan gambar kucing dalam beberapa baris
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            CatImageCard(R.drawable.meong)
            CatImageCard(R.drawable.meong)
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            CatImageCard(R.drawable.meong2)
            CatImageCard(R.drawable.meong2)
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            CatImageCard(R.drawable.meong3)
            CatImageCard(R.drawable.meong3)
        }
    }
}

@Composable
fun CatImageCard(imageId: Int) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .size(150.dp), // Ukuran setiap gambar
        color = Color.Gray,
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Cat Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
