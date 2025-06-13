package com.example.acalanto

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

class FakeNavController(context: Context) : NavController(context)

@Composable
fun MaquinaDeEscrever(frase: String) {

    val poppinsFamily = remember {
        FontFamily(
            Font(R.font.poppins_regular, FontWeight.Normal)
        )
    }

    var textoVisivel by remember { mutableStateOf("") }

    LaunchedEffect(frase) {
        textoVisivel = ""
        for (i in frase.indices) {
            textoVisivel += frase[i]
            delay(100)
        }
    }

    Column {
        Text(
            text = textoVisivel,
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            fontFamily = poppinsFamily,
            modifier = Modifier
                .padding(30.dp)
        )
    }
}

@Composable
fun HomePage(navController: NavController) {

    val poppinsFamily = remember {
        FontFamily(
            Font(R.font.poppins_regular, FontWeight.Normal)
        )
    }

    val frases = listOf(
        "Você é mais forte do que imagina.",
        "Cada pequeno passo te aproxima do seu sonho.",
        "Respire fundo. Tudo vai ficar bem.",
        "Confie no processo. Você está evoluindo.",
        "Hoje é um bom dia para recomeçar.",
        "Permita-se descansar. Você merece paz.",
        "Seu esforço está te levando longe.",
        "Acalme o coração. O tempo vai colocar tudo no lugar.",
        "Seja gentil com você mesmo.",
        "Acredite: dias leves virão.",
        "Você está exatamente onde deveria estar.",
        "Tudo bem ir devagar, o importante é não parar.",
        "A sua jornada é única. Respeite seu ritmo.",
        "Sinta orgulho de quem você está se tornando.",
        "A luz que você procura também está dentro de você.",
        "Mesmo nos dias difíceis, sua coragem aparece em silêncio.",
        "Continue, mesmo quando parecer lento. Você está indo bem.",
        "Às vezes, só parar e respirar já muda tudo ao redor.",
        "O passado ficou pra trás — o agora é uma nova chance.",
        "O mundo pode esperar um pouco enquanto você se cuida.",
        "Cada dia você constrói uma versão mais forte de si mesmo.",
    )

    val fraseAleatoria = remember { frases.random() }

    val fraseAnimacao = remember { mutableStateOf(false) }

    var iniciarAnimacao by remember { mutableStateOf(false) }

    val deslocamentoLogo by animateDpAsState(
        targetValue = if (iniciarAnimacao) (-130).dp else 0.dp,
        animationSpec = tween(durationMillis = 800),
        label = "deslocamentoLogo"
    )

    val descolocamentoBotao by animateDpAsState(
        targetValue = if (iniciarAnimacao) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 800),
        label = "deslocamentoBotao"
    )

    LaunchedEffect(Unit) {
        delay(300)
        fraseAnimacao.value = true
        iniciarAnimacao = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFFFFFEFC)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .offset(y = deslocamentoLogo)
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

        if (fraseAnimacao.value) {
            MaquinaDeEscrever(frase = fraseAleatoria)
        } else {
            Spacer(modifier = Modifier.height(70.dp))
        }

        Column(
            modifier = Modifier
                .offset(y = descolocamentoBotao),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate(Screen.Music.route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6C0AF)),
                modifier = Modifier
                    .size(193.dp, 63.dp)
            ) {
                Text(
                    text = "Ouvir & Acalmar",
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePagePreview() {

    HomePage(
        navController = FakeNavController(LocalContext.current)
    )

}

