package com.example.colorfultodo.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colorfultodo.R
import com.example.colorfultodo.model.BottomBarModel
import com.example.colorfultodo.ui.theme.blue
import com.example.colorfultodo.ui.theme.darkGray
import com.example.colorfultodo.ui.theme.dark_violet
import com.example.colorfultodo.ui.theme.gray_white
import com.example.colorfultodo.ui.theme.green
import com.example.colorfultodo.ui.theme.orange
import com.example.colorfultodo.ui.theme.pink
import com.example.colorfultodo.ui.theme.red
import com.example.colorfultodo.ui.theme.rose
import com.example.colorfultodo.ui.theme.violet
import com.example.colorfultodo.ui.theme.yellow

@Preview
@Composable
fun HomeScreen() {
    val isGrid by remember { mutableStateOf(true) }
    Scaffold(
        Modifier,
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Notes",
                    modifier = Modifier,
                    fontWeight = FontWeight.W600,
                    fontSize = 36.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_color_lens_24),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(
                        painter = painterResource(id = R.drawable.outline_grid_view_24),
                        contentDescription = null
                    )
                }
            }

        },
        bottomBar = {
            val data = listOf(
                BottomBarModel(R.drawable.outline_sticky_note_2_24, "Notes"),
                BottomBarModel(R.drawable.outline_help_24, "Help"),
                BottomBarModel(R.drawable.outline_person_24, "Me")
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = gray_white,
                        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                    )
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                data.forEach {
                    Column(
                        Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = it.img),
                            contentDescription = null
                        )
                        Text(it.text)
                    }
                }
            }

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                Modifier,
                containerColor = Color(0xffFFB347),
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Icon(Icons.Filled.Add, "Localized description", tint = Color.White)
            }
        }
    ) {
        if (false) {
            Box(
                Modifier
                    .padding(it)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(R.drawable.content_writing),
                        contentDescription = null
                    )
                    Text("Write your first note!", Modifier.padding(top = 10.dp), fontSize = 20.sp)
                }
            }
        }else {
            Column(
                Modifier.padding(it)
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                if (!isGrid) {
                    LazyColumn(
                        Modifier.padding(horizontal = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(25.dp),
                    ) {
                        items(10) {
                            ListItem()
                        }
                    }
                }
                if (isGrid) {
                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Fixed(2),
                        Modifier.padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalItemSpacing = 20.dp
                    ) {
                        items(10) {
                            ListItem()
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ListItem() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(green, RoundedCornerShape(16.dp))
            .padding(horizontal = 20.dp, vertical = 30.dp)
    ) {
        Text("Ui Concepts worth existing", Modifier, fontSize = 18.sp)
    }
}

@Preview
@Composable
fun FilterScreen(){
    Column (
        Modifier.fillMaxWidth()
            .padding(30.dp)
            .clip(RoundedCornerShape(20.dp))
    ){
        Text("Filter by colours", Modifier.padding(top = 20.dp), fontSize = 24.sp)
        Row (
            Modifier.fillMaxWidth().padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                Modifier.size(height = 40.dp, width = 100.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(gray_white)
                    .border(1.dp, Color.Black, RoundedCornerShape(20.dp))
            )
            ColorItem(red)
            ColorItem(orange)
        }
        Row (
            Modifier.fillMaxWidth().padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            ColorItem(yellow)
            ColorItem(green)
            ColorItem(blue)
        }
        Row (
            Modifier.fillMaxWidth().padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            ColorItem(pink)
            ColorItem(violet)
            ColorItem(dark_violet)
        }
        Row (
            Modifier.fillMaxWidth().padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            ColorItem(rose)
            ColorItem(gray_white)
            ColorItem(darkGray)
        }
    }
}
@Composable
fun ColorItem(color : Color) {
    Box(
        Modifier.size(height = 40.dp, width = 100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color)
    )
}
