package com.example.musicapp

import LoginRegScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.myComponents.BottomBar
import com.example.musicapp.myComponents.TopBar
import com.example.musicapp.navigation.AppNavGraph
import com.example.musicapp.navigation.BandAePage
import com.example.musicapp.navigation.BandAphxPage
import com.example.musicapp.navigation.BandBocPage
import com.example.musicapp.navigation.BandKyussPage
import com.example.musicapp.navigation.BandToolPage
import com.example.musicapp.navigation.EditProfilePage
import com.example.musicapp.navigation.LoginPage
import com.example.musicapp.navigation.LoginRegScreen
import com.example.musicapp.navigation.MainScreenPage
import com.example.musicapp.navigation.RegisterPage
import com.example.musicapp.navigation.SplashScreenPage
import com.example.musicapp.navigation.UserInfoPage
import com.example.musicapp.pages.BandAe
import com.example.musicapp.pages.BandAphx
import com.example.musicapp.pages.BandBoc
import com.example.musicapp.pages.BandKyuss
import com.example.musicapp.pages.BandTool
import com.example.musicapp.pages.EditProfileScreenPage
import com.example.musicapp.pages.ListScreenPage
import com.example.musicapp.pages.Login
import com.example.musicapp.pages.LoginRegScreen
import com.example.musicapp.pages.MainScreenPage
import com.example.musicapp.pages.RegisterScreenPage
import com.example.musicapp.pages.SplashScreenPage
import com.example.musicapp.pages.UserInfoScreenPage
import com.example.musicapp.ui.theme.MusicAppTheme

/**
 * @author="Perfecto"
 * @param
 * @function
 *
 */
//class MainActivity : ComponentActivity() {
//    @OptIn(ExperimentalMaterial3Api::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        setContent {
//            val navController = rememberNavController()
//
//            MusicAppTheme {
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    topBar = { TopBar() },
//                    bottomBar = { BottomBar() }
//                ) { innerPadding ->
//
//                    NavHost(
//                        navController = navController,
//                        startDestination = BandAePage,
//                        modifier = Modifier.padding(innerPadding)
//                    ) {
//
//                        composable<ListScreenPage> { ListScreenPage() }
//                        composable<LoginRegScreen> { LoginRegScreen() }
//                        composable<LoginPage> { Login() }
//                        composable<RegisterPage> { RegisterScreenPage() }
//                        composable<MainScreenPage> { MainScreenPage() }
//
//                        composable<BandAePage> { BandAe() }
//                        composable<BandAphxPage> { BandAphx() }
//                        composable<BandBocPage> { BandBoc() }
//                        composable<BandKyussPage> { BandKyuss() }
//                        composable<BandToolPage> { BandTool() }
//
//                        composable<UserInfoPage> { UserInfoScreenPage() }
//                    }
//                }
//            }
//        }
//    }
//}

//class MainActivity : ComponentActivity() {
//    @OptIn(ExperimentalMaterial3Api::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        setContent {
//            val navController = rememberNavController()
//
//            MusicAppTheme {
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    topBar = { TopBar() },
//                    bottomBar = { BottomBar() }
//                ) { innerPadding ->
//
//                    NavHost(
//                        navController = navController,
//                        startDestination = BandAePage,
//                        modifier = Modifier.padding(innerPadding)
//                    ) {
//                        composable<UserInfoPage> {
//                            UserInfoScreenPage(
//                                onEditProfile = { navController.navigate(EditProfilePage) }
//                            )
//                        }
//
////                        composable<EditProfilePage> {
////                            EditProfileScreenPage()
////                        }
//
//
//                        composable<EditProfilePage> {
//                            EditProfileScreenPage(
//                                onBack = { navController.popBackStack() }
//                            )
//                        }
//
//                        composable<ListScreenPage> { ListScreenPage() }
//                        composable<LoginRegScreen> { LoginRegScreen() }
//                        composable<LoginPage> { Login() }
//                        composable<RegisterPage> { RegisterScreenPage() }
//                        composable<MainScreenPage> { MainScreenPage() }
//
//                        composable<BandAePage> { BandAe() }
//                        composable<BandAphxPage> { BandAphx() }
//                        composable<BandBocPage> { BandBoc() }
//                        composable<BandKyussPage> { BandKyuss() }
//                        composable<BandToolPage> { BandTool() }
//
//                        composable<UserInfoPage> { UserInfoScreenPage() }
//                    }
//                }
//            }
//        }
//    }
//}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MusicAppTheme {

                val navController = rememberNavController()

                AppNavGraph(navController)
            }
        }
    }
}




