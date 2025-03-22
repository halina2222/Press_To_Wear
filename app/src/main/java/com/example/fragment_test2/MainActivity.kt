package com.example.fragment_test2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragment_test2.databinding.ActivityMainBinding
import me.ibrahimsn.lib.SmoothBottomBar

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomBar: SmoothBottomBar = findViewById(R.id.bottomBar)

        bottomBar.setOnItemSelectedListener {
            when(it){
                0->{
                    goToFragment(Fragment1())
                }
                1->{
                    goToFragment(Fragment2())
                }
                2->{
                    goToFragment(Fragment3())
                }
                3->{
                    goToFragment(Fragment4())
                }
            }
        }

    }
    private fun goToFragment(frament: Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,frament).commit()
    }
}
