package com.example.fragment_test2.Fitting_and_cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fragment_test2.Homepage.searchedClothes
import com.example.fragment_test2.R
import com.example.fragment_test2.buttonColor
import com.example.fragment_test2.setting_page_font

@Composable
fun cartPage(){
    var searchingitem by remember { mutableStateOf("") }
    val TextFont = FontFamily(
        Font(R.font.inknutantiqualight)
    )
    val SearchFont = FontFamily(
        Font(R.font.inriasans)
    )
    Column {
        Row (modifier = Modifier.fillMaxWidth()){
            TextField(
                value = searchingitem,
                onValueChange = {searchingitem = it},
                label = { Text(text ="Search in cart",
                    fontFamily = SearchFont)},
                leadingIcon ={
                    Icon(painter = painterResource(R.drawable.searchicon), contentDescription = "")
                },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.height(40.dp).width(250.dp).padding(horizontal = 5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Transparent,
                    unfocusedIndicatorColor = Transparent
                )
            )
            Button(
                onClick = { },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = buttonColor
                ),
                modifier = Modifier.height(40.dp).padding(horizontal = 5.dp)
            ){
                Text(text = "Search", fontFamily = SearchFont)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        var myList = getAllSavedClothes()

        LazyColumn(
            contentPadding =  PaddingValues(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(myList, itemContent = { index, item ->
                ClothesItem(item = item)
            }
            )
        }
    }
}
@Composable
private fun ClothesItem(item: savedClothes){
    Image(painter = painterResource(id = item.imageRes),
        contentDescription = item.name,
        modifier = Modifier.size(150.dp).padding(3.dp))
}