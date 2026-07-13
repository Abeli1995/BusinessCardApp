package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.CardAccent
import com.example.businesscardapp.ui.theme.CardBackground
import com.example.businesscardapp.ui.theme.CardImageBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardScreen()
        }
    }
}


@Composable
fun BusinessCardScreen(backgroundColor: Color = CardBackground) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        NameInfo(
            image = painterResource(id = R.drawable.android_logo_img),
            title = "Abeli Berulava",
            subtitle = "Android Developer Extraordinaire"
        )
        ContactInfo(
            mobileInfo = "+1234567890",
            mailInfo = "@abeliberulava@gmail.com",
            chatInfo = "@abeli25"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardScreenPreview() {
    BusinessCardScreen()
}

@Composable
fun NameInfo(image: Painter, title: String, subtitle: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .background(CardImageBackground)
                .size(100.dp)
        )
        Text(text = title, fontSize = 30.sp, modifier = Modifier.padding(top = 16.dp))
        Text(
            text = subtitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp),
            color = CardAccent
        )
    }
}

@Composable
fun ContactInfo(mobileInfo: String, mailInfo: String, chatInfo: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.width(IntrinsicSize.Max)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter =
                        painterResource(id = android.R.drawable.sym_action_call),
                    contentDescription = null,
                    tint = Color(0xFF3ddc84),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(text = mobileInfo, fontSize = 20.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.sym_action_email),
                    contentDescription = null,
                    tint = Color(0xFF3ddc84),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(text = mailInfo, fontSize = 20.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.sym_action_chat),
                    contentDescription = null,
                    tint = Color(0xFF3ddc84),
                    modifier = Modifier.padding(horizontal = 16.dp)

                )
                Text(text = chatInfo, fontSize = 20.sp)
            }
        }
    }
}

