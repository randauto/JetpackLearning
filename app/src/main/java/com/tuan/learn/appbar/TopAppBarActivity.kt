package com.tuan.learn.appbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.ui.platform.setContent
import com.tuan.learn.customcomponent.MyCustomComponent

class TopAppBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                MyCustomComponent.MyTopAppBarComponent()
            }
        }
    }
}