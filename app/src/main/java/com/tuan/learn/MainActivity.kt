package com.tuan.learn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.Dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScrollableColumn(contentPadding = PaddingValues(Dp(8f), Dp(0f), Dp(0f), Dp(8f))) {
                val context = ContextAmbient.current
                Divider(color = Color.Black)
                Button(onClick = {
                    val intent = Intent(this@MainActivity, MaterialButtonActivity::class.java)
                    startActivity(intent)
                }) {
                    Text(text = "Material Button")
                }
            }

        }
    }
}