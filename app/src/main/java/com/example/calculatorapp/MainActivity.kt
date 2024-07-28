package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorAppTheme {
                CalculatorScreen()

            }
        }
        Log.d("MainActivity", "onCreate called")
        Toast.makeText(this, "onCreate called", Toast.LENGTH_SHORT).show()
    }


    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called")
        Toast.makeText(this, "onStart called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume called")
        Toast.makeText(this, "onResume called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause called")
        Toast.makeText(this, "onPause called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop called")
        Toast.makeText(this, "onStop called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy called")
        Toast.makeText(this, "onDestroy called", Toast.LENGTH_SHORT).show()
    }
}
