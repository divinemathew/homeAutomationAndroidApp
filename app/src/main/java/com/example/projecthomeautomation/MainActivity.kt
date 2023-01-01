package com.example.projecthomeautomation


//Header Imports
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


//Main Activity Coding Starts
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val database = Firebase.database;

        //Data Base Reference Pointers
        val lightStatus = database.getReference("light_status")
        val fanStatus = database.getReference("fan_status")
        val exhaustFanStatus = database.getReference("exhaust_fan_status")
        val motorStatus = database.getReference("motor_status")

        //Calling Main Activity.xml for viewing Android App
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Passing Button ID to variable
        val lightOn  = findViewById<Button>(R.id.lightOn)
        val lightOff = findViewById<Button>(R.id.lightOff)
        val fanOn  = findViewById<Button>(R.id.fanOn)
        val fanOff = findViewById<Button>(R.id.fanOff)

        //Onclick Function of Light On Button
        lightOn.setOnClickListener{
            val text = "Light Turned ON"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            lightStatus.setValue(true)      //Changing Firebase Value
            toast.show()                    //To show a pop up in the bottom
        }
        //Onclick Function of Light Off Button
        lightOff.setOnClickListener{
            val text = "Light Turned OFF"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            lightStatus.setValue(false) //Changing Firebase Value
            toast.show()                //To show a pop up in the bottom
        }


        //Onclick Function of Fan On Button
        fanOn.setOnClickListener{
            val text = "Fan Turned ON"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            fanStatus.setValue(true)    //Changing Firebase Value
            toast.show()                //To show a pop up in the bottom
        }

        //Onclick Function of Fan Off Button
        fanOff.setOnClickListener{
            val text = "Fan Turned OFF"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            fanStatus.setValue(false)   //Changing Firebase Value
            toast.show()                //To show a pop up in the bottom
        }
    }
}
