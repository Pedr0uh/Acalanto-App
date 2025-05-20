package com.example.acalanto

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.text.font.Font
import kotlinx.coroutines.delay

@Composable
fun SplashPage(navController: NavController){

    val poppinsFamily = remember {
        FontFamily(
            Font(R.font.poppins_regular)
        )
    }

    Box(
        modifier = modifier
             .fillMaxSize()
            .background(Color(0XFFFFFEFC)),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.flor_acalanto),
                contentDescription = "Logo de Flor",

                modifier = modifier
                    .size(140.dp)
            )
            Text(
                text = stringResource(R.string.app_name),
                fontSize = 25.sp,
                fontFamily = poppinsFamily,
                modifier = modifier
            )
        }
    }

    LaunchedEffect(Unit) {
        delay(2000)
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun SplashPreviwe(){
    SplashPage(
        navController = NavController(LocalContext.current)
    )
}