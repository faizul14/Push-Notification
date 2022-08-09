package com.example.apppushnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.apppushnotification.databinding.ActivityMainBinding
import com.example.apppushnotification.services.PushNotificationService

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pushReceiver : BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPushnotifikasi.setOnClickListener(this)

        pushReceiver = object : BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                Log.d(PushNotificationService.TAG, "push notifikasi")
                Toast.makeText(this@MainActivity, "push notifikasi", Toast.LENGTH_SHORT).show()
            }

        }
        val notifikasiIntentFilter = IntentFilter(PUSH_NOTOFIKASI_STATUS)
        registerReceiver(pushReceiver, notifikasiIntentFilter)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_pushnotifikasi ->{
                val startPushService = Intent(this, PushNotificationService::class.java)
                startService(startPushService)
            }
        }
    }

    companion object{
        const val PUSH_NOTOFIKASI_STATUS = "push_notifikasi_status"
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(pushReceiver)
    }
}