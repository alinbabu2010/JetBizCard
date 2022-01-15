package com.compose.jetbizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            elevation = 4.dp
        ) {

            Column(modifier = Modifier.height(300.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), thickness = 1.5.dp)
                CreateInfo()
                Button(onClick = {
                    Log.d("Sys", "CreateBizCard: Clicked")
                }) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(Modifier.padding(16.dp)) {
        Text(
            text = "Alin Babu",
            color = MaterialTheme.colors.primaryVariant,
            style = MaterialTheme.typography.h4
        )
        Text(
            text = "Android Developer",
            Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "@alinabu2010",
            Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(154.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}