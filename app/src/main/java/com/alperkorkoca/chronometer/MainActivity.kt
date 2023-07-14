package com.alperkorkoca.chronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.alperkorkoca.chronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var stoptime:Long = 0
        binding.button.setOnClickListener {
            binding.chronometer.base= SystemClock.elapsedRealtime()+stoptime
            binding.chronometer.start()
            binding.button.visibility = View.GONE
            binding.button2.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }

        binding.button2.setOnClickListener {
            stoptime = binding.chronometer.base -SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.button2.visibility = View.GONE
            binding.button.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }


        binding.button3.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            stoptime = 0
            binding.button2.visibility = View.GONE
            binding.button.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start ))
        }



    }
}