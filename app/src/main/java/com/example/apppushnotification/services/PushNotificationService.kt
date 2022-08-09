package com.example.apppushnotification.services

import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService
import com.example.apppushnotification.MainActivity

class PushNotificationService : JobIntentService() {
    companion object{
        val TAG = "PushNotificationService"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null){
            enqueueWork(this, this::class.java, 101, intent)
        }
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onHandleWork(intent: Intent) {
        Log.d(TAG, "proses services di jalankan")
        try {
            Thread.sleep(5000)

        }catch (e : InterruptedException){
            e.printStackTrace()
        }

        val notifyPush = Intent(MainActivity.PUSH_NOTOFIKASI_STATUS)
        sendBroadcast(notifyPush)
    }

}