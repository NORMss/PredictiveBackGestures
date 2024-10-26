package ru.normno.mypredictivebackgestures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import ru.normno.mypredictivebackgestures.screens.SheetScreen
import ru.normno.mypredictivebackgestures.screens.TextScreen
import ru.normno.mypredictivebackgestures.ui.theme.MyPredictiveBackGesturesTheme

@Serializable
data object ScreenA

@Serializable
data object ScreenB

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPredictiveBackGesturesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                        startDestination = ScreenA
                    ) {
                        composable<ScreenA> {
                            TextScreen(
                                onButtonClick = {
                                    navController.navigate(ScreenB)
                                }
                            )
                        }
                        composable<ScreenB> {
                            SheetScreen()
                        }
                    }
                }
            }
        }
    }
}