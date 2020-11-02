package com.tuan.learn.customcomponent

import android.content.Context
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tuan.learn.R

object MyCustomComponent {
    @JvmStatic
    @Composable
    fun MyButtonComponent(context: Context, buttonText: String, afterClick: () -> Unit) {
        Button(onClick = afterClick)
        {
            Text(
                text = buttonText,
                textAlign = TextAlign.Center,
                color = Color.White
            )

        }
    }

    @Composable
    @JvmStatic
    fun MySimpleImageComponent() {
        val image = imageResource(id = R.drawable.mindorks_cover)
        Column(modifier = Modifier.padding(16.dp)) {
            Image(image)
        }
    }

    @Composable
    fun MyTopAppBarComponent() {
        // TopAppBar is generally used to have the app name or icon for navigation drawer.
        // Basically it is the AppBar that we use in Android.
        TopAppBar(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            title = { Text("App Name") },
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Menu)
                }
            },
            actions = {
                // Here, this is a RowScope and due to this, all children will be placed
                // horizontally.
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Favorite)
                }
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Favorite)
                }
            }
        )
    }
}