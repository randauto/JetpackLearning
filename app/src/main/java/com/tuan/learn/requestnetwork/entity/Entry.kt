package com.tuan.learn.requestnetwork.entity

import java.util.*

data class Entry(
    private val id: String = "",
    private var title: String = "",
    private var link: String = "",
    private var updated: Long
) {
    override fun toString(): String {
        return Date(updated).toString() + "\n$title"
    }
}