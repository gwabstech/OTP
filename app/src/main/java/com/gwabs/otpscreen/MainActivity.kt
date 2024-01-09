package com.gwabs.otpscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gwabs.otpscreen.ui.theme.OTPScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OTPScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OTPScreen()
                }
            }
        }
    }
}

// otp Composable
@Composable
fun OTPScreen(
    modifier: Modifier = Modifier) {
    var otpText by remember{
        mutableStateOf("")
    }
    
    BasicTextField(value = otpText,
        onValueChange = {
            if (it.length <= 4)
                otpText = it
    }) {

        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            repeat(4){ index->
                val number = when{
                    index >= otpText.length -> ""
                    else -> otpText[index]
                }

                Column (
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = number.toString())
                    Box(modifier = Modifier
                        .width(40.dp)
                        .height(2.dp)
                        .background(Color.Black)
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OTPScreenTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            OTPScreen()
        }

    }
}