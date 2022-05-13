package com.example.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import org.w3c.dom.Text
import java.time.format.TextStyle

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Jetpack Compose 1!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit."),
    MyMessage("Hola Jetpack Compose 2!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit, nec volutpat eros mi nec dui. Vivamus quis laoreet magna, in mattis leo."),
    MyMessage("Hola Jetpack Compose 3!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit, nec volutpat eros mi nec dui. Vivamus quis laoreet magna, in mattis leo. Donec accumsan eleifend leo, et consequat eros mollis sed. Maecenas maximus diam a commodo ullamcorper. Integer suscipit posuere metus et lobortis."),
    MyMessage("Hola Jetpack Compose 4!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit."),
    MyMessage("Hola Jetpack Compose 5!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit, nec volutpat eros mi nec dui. Vivamus quis laoreet magna, in mattis leo."),
    MyMessage("Hola Jetpack Compose 6!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit, nec volutpat eros mi nec dui. Vivamus quis laoreet magna, in mattis leo. Donec accumsan eleifend leo, et consequat eros mollis sed. Maecenas maximus diam a commodo ullamcorper. Integer suscipit posuere metus et lobortis."),
    MyMessage("Hola Jetpack Compose 7!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit, nec volutpat eros mi nec dui."),
    MyMessage("Hola Jetpack Compose 8!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit, nec volutpat eros mi nec dui. Vivamus quis laoreet magna, in mattis leo. Donec accumsan eleifend leo, et consequat eros mollis sed."),
    MyMessage("Hola Jetpack Compose 9!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit, nec volutpat eros mi nec dui. Vivamus quis laoreet magna, in mattis leo. Donec accumsan eleifend leo, et consequat eros mollis sed."),
    MyMessage("Hola Jetpack Compose 10!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit, nec volutpat eros mi nec dui. Vivamus quis laoreet magna, in mattis leo. Donec accumsan eleifend leo, et consequat eros mollis sed. Maecenas maximus diam a commodo ullamcorper. Integer suscipit posuere metus et lobortis."),
    MyMessage("Hola Jetpack Compose 11!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit, nec volutpat eros mi nec dui."),
    MyMessage("Hola Jetpack Compose 12!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit, mauris luctus tempus bibendum, sapien dolor consectetur elit, nec volutpat eros mi nec dui."),
    MyMessage("Hola Jetpack Compose 13!", "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme() {
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn{
        items(messages) { message ->
            MyComponent(message)
        }
    }
}

@Composable
fun MyComponent(message: MyMessage) {
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "Mi imagen de prueba",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
    )
}

@Composable
fun MyTexts(message: MyMessage) {

    var expanded by remember{ mutableStateOf(false) }

    Column(modifier = Modifier.padding(start = 8.dp).clickable {
        expanded = !expanded
    }) {
        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style = style, maxLines = lines)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
    JetpackComposeTutorialTheme {
        MyMessages(messages)
    }
}
