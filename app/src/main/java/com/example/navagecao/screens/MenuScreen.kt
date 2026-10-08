package com.aulasandroid.navegacaofluxotelas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(modifier: Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .background(Color(19, 36, 144, 255))
            .fillMaxSize()
            .padding(horizontal = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MENU",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.size(80.dp))

        ButtonCompose(
            containerColor = Color.White,
            contentColor = Color.Blue,
            text = "Perfil",
            onClick = {
                navController.navigate(route = "perfil/Maria/20")
            }
        )

        Spacer(modifier = Modifier.size(250.dp))

        ButtonCompose(
            containerColor = Color.White,
            contentColor = Color.Blue,
            text = "Pedidos",
            onClick = {
                navController.navigate(route = "pedidos")
            }
        )

        Spacer(modifier = Modifier.size(20.dp))

        ButtonCompose(
            containerColor = Color.White,
            contentColor = Color.Blue,
            text = "Sair",
            onClick = {
                navController.navigate(route = "login")
            }
        )

    }
}