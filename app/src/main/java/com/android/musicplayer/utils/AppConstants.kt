package com.android.musicplayer.utils

import java.io.UnsupportedEncodingException
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

object AppConstants {

    fun formatMillis(timeInMillis: Long): String {
        var timeInMillis = timeInMillis
        var sign = ""
        if (timeInMillis < 0) {
            sign = "-"
            timeInMillis = Math.abs(timeInMillis)
        }

        val minutes = timeInMillis / TimeUnit.MINUTES.toMillis(1)
        val seconds = timeInMillis % TimeUnit.MINUTES.toMillis(1) / TimeUnit.SECONDS.toMillis(1)

        val formatted = StringBuilder(20)
        formatted.append(sign)
        formatted.append(String.format("%02d", minutes))
        formatted.append(String.format(":%02d", seconds))

        return try {
            String(formatted.toString().toByteArray(), Charset.forName("UTF-8"))
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            "00:00"
        }

    }
}