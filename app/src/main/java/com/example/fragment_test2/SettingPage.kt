package com.example.fragment_test2

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun SettingPage(){
    val fontFamily = FontFamily(
        Font(R.font.inknutantiqualight)
    )
    Column(){
        Text(
            text = "  Avatar Management  ",
            color = setting_page_font,
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Start,
            fontFamily = fontFamily,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
        UniformButton("Edit Avatar", onClick = {}, modifier = Modifier)
        Spacer(modifier = Modifier.height(8.dp))
        UniformButton("Delete Avatar", onClick = {}, modifier = Modifier)
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "  Account Management  ",
            color = setting_page_font,
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Start,
            fontFamily = fontFamily,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        UniformButton("Change Password", onClick = {}, modifier = Modifier)
        Spacer(modifier = Modifier.height(8.dp))
        UniformButton("Change Icon", onClick = {}, modifier = Modifier)
        Spacer(modifier = Modifier.height(8.dp))
        UniformButton("Change Email", onClick = {}, modifier = Modifier)
        }
    }
}

@Composable
fun UniformButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val fontFamily = FontFamily(
        Font(R.font.inknutantiquamedium)
    )
    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(3.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = buttonColor
        )
    )
    {
        Text(text = text,
            color = setting_page_font,
            fontFamily = fontFamily,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth())
    }
}
