package com.example.fragment_test2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically)
        {
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.usericon), // Replace with your drawable resource ID
                contentDescription = "Circular Image",
                modifier = Modifier
                    .size(80.dp)     // Set the desired size
                    .clip(CircleShape) // Apply the circle shape clip
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "  User Name",
                color = setting_page_font,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontFamily = fontFamily,
                modifier = Modifier.wrapContentWidth()
            )

        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = setting_page_font, thickness = 2.dp, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "  Avatar Management  ",
            color = setting_page_font,
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
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
            textAlign = TextAlign.Center,
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
