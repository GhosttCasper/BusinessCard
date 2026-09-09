package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
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
                BusinessCard(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


@Composable
private fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = colorResource(id = R.color.light_green))
            .safeDrawingPadding(),
    ) {
        ProfileSection(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        ContactSection(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp)
        )
    }
}

@Composable
private fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .background(colorResource(id = R.color.blue))
                .size(120.dp)
                .padding(8.dp)
        )

        Text(
            text = stringResource(R.string.full_name),
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
            fontSize = 38.sp,
        )
        Text(
            text = stringResource(R.string.title),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = colorResource(id = R.color.green)
        )
    }
}

@Composable
private fun ContactSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ContactRow(
            text = stringResource(R.string.phone_number),
            iconDescriptor = stringResource(R.string.phone),
            iconRes = R.drawable.phone_24dp,
        )
        ContactRow(
            text = stringResource(R.string.link),
            iconDescriptor = stringResource(R.string.social),
            iconRes = R.drawable.share_24dp
        )
        ContactRow(
            text = stringResource(R.string.email),
            iconDescriptor = stringResource(R.string.email_label),
            iconRes = R.drawable.email_24dp
        )
    }

}

@Composable
private fun ContactRow(
    text: String,
    iconDescriptor: String,
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.semantics(mergeDescendants = true) {},
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = iconDescriptor,
            modifier = Modifier
                .size(22.dp),
            tint = colorResource(id = R.color.green)
        )
        Spacer(Modifier.width(24.dp))
        Text(
            text = text,
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}

@Preview(
    device = "spec:width=411dp,height=891dp,dpi=420,orientation=landscape",
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun BusinessCardLandscapePreview() {
    BusinessCardTheme {
        BusinessCard(modifier = Modifier.fillMaxSize())
    }
}