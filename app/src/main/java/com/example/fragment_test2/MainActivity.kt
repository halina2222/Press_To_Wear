package com.example.fragment_test2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import com.example.fragment_test2.Fitting_and_cart.FittingPage
import com.example.fragment_test2.Fitting_and_cart.cartPage
import com.example.fragment_test2.Homepage.HomePage
import com.example.fragment_test2.databinding.ActivityMainBinding
import me.ibrahimsn.lib.SmoothBottomBar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var composeView :ComposeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomBar: SmoothBottomBar = findViewById(R.id.bottomBar)
        composeView = findViewById(R.id.View)
        composeView.setContent { HomePage() }
        bottomBar.setOnItemSelectedListener {
            when(it){
                0->{
                    composeView.setContent {
                        HomePage()
                    }
                }
                1->{
                    composeView.setContent {
                        FittingPage()
                    }
                }
                2->{
                    composeView.setContent {
                        cartPage()

                    }
                }
                3->{
                    composeView.setContent {
                        SettingPage()

                    }
                }
            }
        }
    }
}
