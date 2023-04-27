package com.example.cs481localnotification

import android.Manifest
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
        findViewById<Button>(R.id.btnSend).setOnClickListener {
            sendNotification()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(){
        @RequiresApi(Build.VERSION_CODES.O)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel:NotificationChannel = NotificationChannel("C10", "Title", NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "Description"
            }
            val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(){
        val title = findViewById<EditText>(R.id.etTitle).text.toString()
        val message = findViewById<EditText>(R.id.etMessage).text.toString()
        showAlert(title, message)
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, "C10")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            if (ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(10, builder.build())
        }
    }

    private fun showAlert(title: String, message: String){
        AlertDialog.Builder(this)
            .setTitle("You will see following title and message as notification")
            .setMessage("Title: $title\nMessage: $message")
            .setPositiveButton("Okay"){_,_ ->}
            .show()
    }

}