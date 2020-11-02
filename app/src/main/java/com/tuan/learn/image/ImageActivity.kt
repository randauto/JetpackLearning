package com.tuan.learn.image

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.tuan.learn.customcomponent.MyCustomComponent

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                Text(text = "This is a simple image")

            }
            MyCustomComponent.MySimpleImageComponent()
            Text(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                text = "This is an image with rounded corners"
            )
        }
    }
}