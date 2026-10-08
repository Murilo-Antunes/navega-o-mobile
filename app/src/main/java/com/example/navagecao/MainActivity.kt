package com.aulasandroid.navegacaofluxotelas

import android.R.attr.defaultValue
import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aulasandroid.navegacaofluxotelas.screens.LoginScreen
import com.aulasandroid.navegacaofluxotelas.screens.MenuScreen
import com.aulasandroid.navegacaofluxotelas.screens.PedidosScreen
import com.aulasandroid.navegacaofluxotelas.screens.PerfilScreen
import com.aulasandroid.navegacaofluxotelas.ui.theme.NavegacaoFluxoTelasTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoFluxoTelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            )
                        }
                    ){
                        composable (route = "login") {
                            LoginScreen(
                                Modifier.padding(innerPadding),
                                navController
                            )
                        }

                        composable (route = "menu") {
                            MenuScreen(
                                Modifier.padding(innerPadding),
                                navController
                            )
                        }

                        composable (
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument(name = "nome"){
                                    type = NavType.StringType
                                },
                                navArgument(name = "idade"){
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            val nome = it.arguments?.getString("nome") ?: ""
                            val idade = it.arguments?.getInt("idade") ?: 0
                            PerfilScreen(
                                Modifier.padding(innerPadding),
                                navController,
                                nome = nome,
                                idade = idade
                            )
                        }

                        composable(
                            route = "pedidos?numeroPedido={numeroPedido}",
                            arguments = listOf(
                                navArgument("numeroPedido") {
                                    type = NavType.StringType
                                    defaultValue = "Sem pedidos"
                                }
                            )
                        ) {
                            val numeroPedido = it.arguments?.getString("numeroPedido") ?: "Sem pedidos"

                            PedidosScreen(
                                Modifier.padding(innerPadding),
                                navController,
                                numeroPedido = numeroPedido
                            )
                        }
                    }
                }
            }
        }
    }
}