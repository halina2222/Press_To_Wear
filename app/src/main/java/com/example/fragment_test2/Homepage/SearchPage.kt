package com.example.fragment_test2.Homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fragment_test2.SearchFont
import com.example.fragment_test2.searchBar
import com.example.fragment_test2.searchBar_Text

@Composable
fun SearchPage(navController:NavController){
    Column {
        Text(text = "Search Page undo")
        Button(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = searchBar,
                contentColor = searchBar_Text
            ),
            onClick = {  navController.navigate(Screen.Home.route)})
        {
            Text("Home", fontFamily = SearchFont, color = searchBar_Text)
        }
        Button(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = searchBar,
                contentColor = searchBar_Text
            ),
            onClick = {  navController.navigate(Screen.Result.route)})
        {
            Text("Result", fontFamily = SearchFont, color = searchBar_Text)
        }
    }

}