package com.tuan.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tuan.learn.appbar.TopAppBarActivity
import com.tuan.learn.customcomponent.MyCustomComponent.MyButtonComponent
import com.tuan.learn.databinding.ActivityMainBinding
import com.tuan.learn.image.ImageActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root.apply { setContentView(this) }
        binding.btnMaterialButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Kaka", Toast.LENGTH_SHORT).show()
        }
        binding.btnMaterialButton.text = "OKOKOKOK"

    }

    fun callMethodJetpackComponent() {
        setContent {
            ScrollableColumn(contentPadding = PaddingValues(8f.dp, 0f.dp, 0f.dp, 8f.dp)) {
                val context = ContextAmbient.current
                Divider(color = Color.Black)
                Button(
                    onClick = {
                        val intent = Intent(this@MainActivity, MaterialButtonActivity::class.java)
                        startActivity(intent)
                    },
                    backgroundColor = Color.Green,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Material Button",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                Divider(color = Color.Green)
                MyButtonComponent(
                    context = this@MainActivity,
                    buttonText = "Cafef.vn",
                    afterClick = {
                        Toast.makeText(context, "My name is Cafef.vn", Toast.LENGTH_SHORT).show()
                    }
                )
                Divider(color = Color.Green)
                MyButtonComponent(
                    context = this@MainActivity,
                    buttonText = "Simple Image",
                    afterClick = {
                        val intent = Intent(context, ImageActivity::class.java)
                        startActivity(intent)
                    }
                )
                Divider(color = Color.Green)
                MyButtonComponent(
                    context = this@MainActivity,
                    buttonText = "Top Appbar",
                    afterClick = {
                        val intent = Intent(context, TopAppBarActivity::class.java)
                        startActivity(intent)
                    }
                )
            }

        }
    }
}