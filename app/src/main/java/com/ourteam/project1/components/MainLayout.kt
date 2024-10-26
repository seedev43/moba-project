package com.ourteam.project1.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ourteam.project1.ui.theme.MainColor

@Composable
fun MainLayout(
    modifier: Modifier = Modifier,
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                containerColor = MainColor,
                contentColor = Color.White
            ) {
                // Tambahkan item navigasi jika diperlukan
            }
        },
        content = { paddingValues ->
            content(paddingValues)
        }
    )
}
