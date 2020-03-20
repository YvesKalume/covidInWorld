package com.yveskalumenoble.covidinworld.activities

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.yveskalumenoble.covidinworld.R
import com.yveskalumenoble.covidinworld.databinding.ActivityMainBinding
import com.yveskalumenoble.covidinworld.models.Stat
import com.yveskalumenoble.covidinworld.models.Supplier
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        getTips()
        getInfo()
    }

    fun getInfo(){
        val url ="https://corona.lmao.ninja/all"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                val stats = Gson().fromJson(body, Stat::class.java)

                runOnUiThread {
                    binding.confirmedNumber.text = stats.cases.toString()
                    binding.recoveredNumber.text = stats.recovered.toString()
                    binding.deathNumber.text = stats.deaths.toString()
                }

            }

            override fun onFailure(call: Call, e: IOException) {
                binding.confirmedNumber.text = "Pas de connexion"
                binding.recoveredNumber.text = "Pas de connexion"
                binding.deathNumber.text = "Pas de connexion"

                runOnUiThread {
                    val toast = Toast.makeText(this@MainActivity,"Veuillez vous assurer que vous diposez d'une connexion internet, puis relancez l'application",Toast.LENGTH_SHORT)
                    toast.show()
                }
            }

        })
    }


    var i = 0
    fun getTips(){
        if (i== Supplier.tip.size){
            i = 0
        }
        object :CountDownTimer(10000,1000){
            override fun onTick(milliSecondes: Long) {
                if (binding.imageWarning.visibility == View.GONE){
                    binding.imageWarning.visibility = View.VISIBLE
                }else{
                    binding.imageWarning.visibility = View.GONE
                }
            }

            override fun onFinish() {
                var text : String = Supplier.next(i)
                binding.Tipstitle.text = text
                i++
                getTips()
            }

        }.start()
    }
}
