package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(136, 171, 223)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardBody(name: String, occupation: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            painter = painterResource(id = R.drawable.python_logo2),
            contentDescription = "Python logo",
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
        )
        Text(
            text = name,
            fontSize = 40.sp,
        )

        Text(
            text = occupation,
            color = Color(255, 207, 63),
            fontSize = 15.sp,
            modifier = modifier.padding(top = 5.dp)
        )
    }
}
@Composable
fun CardReference(text: String, imageId: Int, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    )
    {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null

        )
        Text(
            text = text,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}
@Composable
fun CardReferences(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardReference(text = "+420 303 405 803", imageId = R.drawable.baseline_local_phone_black_24dp)
        CardReference(text = "huzilkon@gmail.com", imageId = R.drawable.baseline_email_black_24dp)
    }
}
@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    BusinessCardBody(name = "Konstantyn Huzil", occupation = "Python developer")
    CardReferences()
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}