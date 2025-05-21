package com.example.acalanto

import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun HomePage(navController: NavController) {

    val poppinsFamily = remember {
        FontFamily(
            Font(R.font.poppins_regular, FontWeight.Normal)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0XFFFFFEFC)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Column {
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = "Logo de Flor"
            )
            Text(
                text = stringResource(R.string.app_name),
                fontFamily = poppinsFamily
            )
        }
        Text(
            text = "Cada pequeno passo te aproxima do seu sonho"
        )
        Button(
            onClick = { navController.navigate("music") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFE6E0))
        ){
            Text(
                text = "Ouvir & Acalmar"
            )
        }
    }
}

@Preview
@Composable
fun HomePagePreview(){

    HomePage(
        navController = rememberNavController()
    )

}

