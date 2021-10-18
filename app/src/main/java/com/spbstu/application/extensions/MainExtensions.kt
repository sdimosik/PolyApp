package com.spbstu.application.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.text.Html
import android.text.Spanned

fun <E : Enum<E>> Enum<E>.getValue(): String = toString().lowercase()

@Suppress("DEPRECATION")
fun String.toHtml(): Spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
} else {
    Html.fromHtml(this)
}

fun Context.openLink(link: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    startActivity(intent)
}