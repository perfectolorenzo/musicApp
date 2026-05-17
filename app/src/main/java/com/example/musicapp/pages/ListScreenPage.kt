package com.example.musicapp.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.myComponents.GridViewComponent
import com.example.musicapp.pages.detail.AeDetailScreenPage

/**
 * @author="Perfecto"
 * @param
 */
//@Composable
// fun SplashScreenPage() {
// GridViewComponent()
// }

//@Preview
//@Composable

// fun SplashScreenPreview() {
// SplashScreenPage()
// }
@Composable
fun ListScreenPage(modifier: Modifier = Modifier) {

    AeDetailScreenPage()
    //GridViewComponent()


}

@Preview
@Composable
fun ListScreenPreview() {

    ListScreenPage()

}