package com.example.acalanto

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.filled.SkipNext

@Composable
fun MusicPage(navController: NavController){

    val poppinsFamily = remember {
        FontFamily(
            Font(R.font.poppins_regular, FontWeight.Normal)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(52.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ) {
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
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box {
                Image(
                    painter = painterResource(R.drawable.imagemusc),
                    contentDescription = "capa da música",
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .size(200.dp),
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "musica - autor",
                fontFamily = poppinsFamily,
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6C0AF)),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        tint = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(100.dp))

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6C0AF)),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.SkipNext,
                        contentDescription = "Próxima música",
                        tint = Color.Black,

                    )
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun MusicPreview(){
    MusicPage(
        navController = FakeNavController(LocalContext.current)
    )
}