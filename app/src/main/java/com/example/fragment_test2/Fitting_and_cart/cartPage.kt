package com.example.fragment_test2.Fitting_and_cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fragment_test2.R
import com.example.fragment_test2.*
import com.example.fragment_test2.buttonTextColor

@Composable
fun cartPage(){

    val ButtonFont = FontFamily(
        Font(R.font.inriasans)
    )


    Column {
        Row (modifier = Modifier.fillMaxWidth().height(60.dp)){
            var searchingitem by remember { mutableStateOf("") }
            OutlinedTextField(
                modifier = Modifier.width(280.dp).padding(horizontal = 5.dp),
                value = searchingitem,
                onValueChange = {newText -> searchingitem = newText},
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedLabelColor = searchBar,
                    unfocusedContainerColor = searchBar,
                    unfocusedIndicatorColor = searchBar_Text,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = searchBarBound,
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon", tint = searchBar_Text)
                },

                label = {Text("Search in cart", fontFamily = SearchFont, color = searchBar_Text)},
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                )
                )
            Button(
                onClick = { },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = buttonColor
                ),
                modifier = Modifier.fillMaxHeight().padding(top= 8.dp, start = 5.dp, end = 5.dp)
            ){
                Text(text = "Search", fontFamily = ButtonFont, fontSize = 14.sp)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        var myList = getAllSavedClothes()

        LazyColumn(
            contentPadding =  PaddingValues(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(myList, itemContent = { index, item ->
                ClothesCard(item = item)
            }
            )
        }
    }
}
@Composable
private fun ClothesCard(item: savedClothes){
    val TextFont = FontFamily(
        Font(R.font.inknutantiqualight)
    )
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        content = {
            Row(){
                Image(painter = painterResource(id = item.imageRes),
                    contentDescription = item.name,
                    modifier = Modifier.size(150.dp).padding(3.dp))
                Spacer(modifier = Modifier.width(5.dp))
                Column(){
                    Row {
                        Text(text = "Brand", fontFamily = TextFont )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Size", fontFamily = TextFont )
                    }
                    Text(text = "Clothes Type", fontFamily = TextFont )
                    Text(text = item.name, fontFamily = TextFont )
                    Text(text = "price", fontFamily = TextFont )

                }

            }
        }
    )
}