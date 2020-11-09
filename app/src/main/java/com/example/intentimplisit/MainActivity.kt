package com.example.intentimplisit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun openweb(view: View){
        var uri = Uri.parse(et_url.text.toString())
        startActivity(Intent(Intent.ACTION_VIEW,uri))
    }

    fun openmaps (view: View){
        val uri = Uri.parse("geo:0,0?q="+et_loc.text.toString())
        val mapIntent = Intent(Intent.ACTION_VIEW,uri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    fun sendtext (view: View){
        ShareCompat.IntentBuilder.from(this)
            .setText(et_teks.text.toString())
            .setChooserTitle("Kirim Pesan")
            .setType("text/plain")
            .startChooser()
    }
}
