package com.aulasandroid.navegacaofluxotelas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun LoginScreen(modifier: Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .background(Color(184, 60, 60, 255))
            .fillMaxSize()
            .padding(horizontal = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "LOGIN",
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
            text = "ENTRAR",
            onClick = {
                navController.navigate(route = "menu")
            }
        )
    }
}

@Composable
fun ButtonCompose (containerColor: Color, contentColor: Color, text: String, onClick: Function0<Unit>) {
    Button(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        onClick = onClick
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
    }
}