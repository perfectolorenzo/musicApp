package com.example.musicapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.R
import com.example.musicapp.myComponents.FlowAe
import com.example.musicapp.myComponents.LazyCardColumnAeComponent
import com.example.musicapp.myComponents.LazyRowComponentAe
import com.example.musicapp.styles.boxModifier
import com.example.musicapp.styles.flowMod
import com.example.musicapp.styles.lazyRowMod
import com.example.musicapp.styles.rowCardModifier
import com.example.musicapp.styles.rowModifier


@Composable
fun BandAe(modifier: Modifier = Modifier) {

    Box(boxModifier) {
        Row(rowModifier) {
            Image(
                painter = painterResource(R.drawable.autechre_sticker),
                contentDescription = "",
                contentScale = ContentScale.Inside,
            )
        }
        Row(rowCardModifier) {
            LazyCardColumnAeComponent()


        }
        Row(flowMod) {
            FlowAe()
        }


        Row(lazyRowMod) {
            LazyRowComponentAe()
        }
    }
}


@Preview
@Composable
fun BandPrev() {
    BandAe()
}
