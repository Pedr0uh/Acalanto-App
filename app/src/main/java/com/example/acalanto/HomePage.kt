package com.example.acalanto

import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.navigation.testing.TestNavHostController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = "Logo de Flor",
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            Text(
                text = stringResource(R.string.app_name),
                fontFamily = poppinsFamily,
                fontSize = 20.sp
            )
        }
        Text(
            text = "Cada pequeno passo te aproxima do seu sonho",
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            fontFamily = poppinsFamily,
            modifier = Modifier
                .padding(24.dp)
        )
        Button(
            onClick = { navController.navigate("music") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6C0AF)),
            modifier = Modifier
                .size(193.dp, 63.dp)
        ){
            Text(
                text = "Ouvir & Acalmar",
                color = Color.Black,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePagePreview(){

    HomePage(
        navController = TestNavHostController(LocalContext.current)
    )

}

