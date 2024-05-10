package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}


@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = colorResource(id = R.color.light_green)),
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            val image = painterResource(id = R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = null,
                modifier = modifier
                    .background(colorResource(id = R.color.blue))
                    .width(120.dp)
                    .padding(8.dp)
            )

            Text(
                text = stringResource(R.string.full_name),
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                fontSize = 38.sp,
            )
            Text(
                text = stringResource(R.string.title),
                modifier = Modifier.padding(bottom = 8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = colorResource(id = R.color.green)
            )
        }

        Column(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column {
                ContactInfo(
                    text = stringResource(R.string.phone_number),
                    painter = R.drawable.phone_24dp
                )
                ContactInfo(
                    text = stringResource(R.string.link),
                    painter = R.drawable.share_24dp
                )
                ContactInfo(
                    text = stringResource(R.string.email),
                    painter = R.drawable.email_24dp
                )
            }
        }
    }
}

@Composable
fun ContactInfo(text: String, painter: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(painter),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 24.dp)
                .width(22.dp),
            tint = colorResource(id = R.color.green)
        )
        Text(
            text = text,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}