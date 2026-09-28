package com.example.navagecao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.navagecao.ui.theme.NavagecaoTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navagecao.screens.LoginScreen
import com.example.navagecao.screens.MenuScreen
import com.example.navagecao.screens.PedidoScreen
import com.example.navagecao.screens.PerfilScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavagecaoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable (route = "login" ) { LoginScreen(navController = navController) }
                        composable (route = "menu" ) { MenuScreen(navController = navController) }
                        composable (route = "perfil/{nome}" ) {
                            val nome = it.arguments?.getString("nome")
                            PerfilScreen(navController = navController, nome = nome!!)

                        }
                        composable (route = "pedidos?numeroPedido={numeroPediddo}",
                            arguments = listOf(navArgument(name = "numeroPedido"){
                                defaultValue = "Sem Pedidos"
                            })
                        ) {
                            val numeroPedido = it.arguments?.getString("numeeoPedido")
                            PedidoScreen(navController = navController, numeroPedido = numeroPedido!!)

                        }
                    }
                }
            }
        }
    }
}

