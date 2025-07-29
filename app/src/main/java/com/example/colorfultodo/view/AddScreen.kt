package com.example.colorfultodo.view

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colorfultodo.ui.theme.dark_yellow
import com.example.colorfultodo.ui.theme.yellow

@Preview
@Composable
fun AddScreen() {
    Scaffold (
        Modifier,
        topBar = {
            Row (Modifier.fillMaxWidth()
                .background(color = Color.White)
                .padding(horizontal = 30.dp , 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ){

                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back" ,
                    tint = dark_yellow,
                    modifier = Modifier.padding(end = 20.dp)
                )
                Text("Add Note" , Modifier , fontSize = 24.sp , fontWeight = FontWeight.W600 )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { /*TODO*/ },
                ) {
                    Text(
                        text = "Save",
                        color = Color.White
                    )
                }
                Icon(imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
        },

    ){
        Column(
            Modifier.padding(it).fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 20.dp , 40.dp)
        ) {
            Text("Title" , fontSize = 48.sp , fontWeight = FontWeight.W400)
            Text("Type something..." , Modifier.padding(top = 20.dp) , fontSize = 23.sp , fontWeight = FontWeight.W400)

        }
    }
}