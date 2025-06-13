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
import android.media.MediaPlayer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.material3.Slider
import androidx.compose.material.icons.filled.Pause

@Composable
fun MusicPage(navController: NavController) {

    data class Musica(
        val nome: String,
        val capaResId: Int,
        val audioRedId: Int
            )

    val musicas = listOf(

        Musica(
            nome = "And I Love Her - The Beatles",
            capaResId = R.drawable.beatles,
            audioRedId = R.raw.and_i_love_her
        ),
        Musica(
            nome = "Don´t Forget - Laura Shigihara",
            capaResId = R.drawable.delta,
            audioRedId = R.raw.dont_forget
        ),
        Musica(
            nome = "Heart To Heart - Mac DeMarco",
            capaResId = R.drawable.health,
            audioRedId = R.raw.heart_to_heart
        ),
        Musica(
            nome = "Novo Amor - Anchor",
            capaResId = R.drawable.anchor,
            audioRedId = R.raw.novo_amor_anchor
        ),
        Musica(
            nome = "Saitama Theme (Ballad Version)",
            capaResId = R.drawable.hero,
            audioRedId = R.raw.saitama_theme
        ),
        Musica(
            nome = "Unpacking - End Credits",
            capaResId = R.drawable.unpacking,
            audioRedId = R.raw.unpacking_end_credits
        )
    )

    val poppinsFamily = remember {
        FontFamily(
            Font(R.font.poppins_regular, FontWeight.Normal)
        )
    }

    val context = LocalContext.current
    var musicaAtualIndex by remember { mutableStateOf(0) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    var tocando by remember { mutableStateOf(false) }

    var posicaoAtual: Float by remember { mutableStateOf(0f) }
    var duracaoTotal by remember { mutableStateOf(1f) }

    fun tocarMusica() {

        if (mediaPlayer == null) {
            val musica = musicas[musicaAtualIndex]
            mediaPlayer = MediaPlayer.create(context, musica.audioRedId)
            duracaoTotal = (mediaPlayer?.duration?.toFloat() ?: 1f) / 1000f
        }

        mediaPlayer?.start()
        tocando = true

    }

    fun proximaMusica(){

        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null

        musicaAtualIndex = (musicaAtualIndex + 1) % musicas.size

        val novaMusica = musicas[musicaAtualIndex]
        mediaPlayer = MediaPlayer.create(context, novaMusica.audioRedId)
        duracaoTotal = (mediaPlayer?.duration?.toFloat() ?: 1f) / 1000f
        mediaPlayer?.start()
        tocando = true

    }

    fun pausarMusica(){

        mediaPlayer?.pause()
        tocando = false

    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

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
                    painter = painterResource(id = musicas[musicaAtualIndex].capaResId),
                    contentDescription = "capa da música",
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .size(200.dp),
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = musicas[musicaAtualIndex].nome,
                fontFamily = poppinsFamily,
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Slider(
                value = posicaoAtual,
                onValueChange = {
                    posicaoAtual = it
                    mediaPlayer?.seekTo((it * 1000).toInt())
                },
                valueRange = 0f..duracaoTotal,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Row {
                Button(
                    onClick = {
                        if(tocando){
                            pausarMusica()
                        }else {
                            tocarMusica()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6C0AF)),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                ) {
                    Icon(
                        imageVector = if (tocando) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = if (tocando) "Pausar" else "Tocar",
                        tint = Color.Black
                    )
                }

                Spacer(modifier = Modifier.width(24.dp))

                Button(
                    onClick = { proximaMusica() },
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
            LaunchedEffect(tocando, mediaPlayer) {
                while (tocando && mediaPlayer != null) {
                    posicaoAtual = (mediaPlayer?.currentPosition?.toFloat() ?: 0f) / 1000f
                    kotlinx.coroutines.delay(500)
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
fun MusicPreview() {
    MusicPage(
        navController = FakeNavController(LocalContext.current)
    )
}