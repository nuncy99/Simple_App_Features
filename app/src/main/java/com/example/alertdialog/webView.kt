package com.example.alertdialog

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class webView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)

        val webView = findViewById<WebView>(R.id.webView)

        //Enable JavaScrpipt if the webpage requires it

        webView.settings.javaScriptEnabled = true

        //ensure link opens with webview
        //load the Webpage
        webView.loadUrl("https://www.google.com")

        }
    }
