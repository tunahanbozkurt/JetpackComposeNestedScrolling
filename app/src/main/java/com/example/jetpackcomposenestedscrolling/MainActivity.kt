package com.example.jetpackcomposenestedscrolling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposenestedscrolling.ui.theme.JetpackComposeNestedScrollingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeNestedScrollingTheme {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    header(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
                    body(items = listOf(10, 11, 12, 13, 14, 15, 16, 17, 18, 19))
                    footer(listOf(10, 11, 12, 13, 14, 15, 16, 17, 18, 19))
                    body(listOf(20, 21, 22, 23, 24, 25, 26, 27, 28, 29), Color.Yellow)
                }
            }
        }
    }
}

fun LazyListScope.header(
    items: List<Int>
) {
    item {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items) {
                HeaderItem(id = it)
            }
        }
    }
}


@Composable
fun HeaderItem(
    id: Int
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
    ) {
        Text(text = id.toString())
    }
}

fun LazyListScope.body(
    items: List<Int>,
    color: Color = Color.Blue
) {
    items(items) {
        BodyItem(id = it, color = color)
    }
}

@Composable
fun BodyItem(id: Int, color: Color) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(color)
    ) {
        Text(text = id.toString())
    }
}

fun LazyListScope.footer(
    items: List<Int>
) {
    item {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(items) {
                FooterItem(id = it)
            }
        }
    }
}

@Composable
fun FooterItem(
    id: Int
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
    ) {
        Text(text = id.toString())
    }
}