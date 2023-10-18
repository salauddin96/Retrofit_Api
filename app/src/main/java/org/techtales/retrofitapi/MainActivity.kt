package org.techtales.retrofitapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteApi = RetrofitBuilder.getInstance().create(MyInterface::class.java)

        GlobalScope.launch {
            val result = quoteApi.getQuotes()
            if (result!=null){
               Log.d("Salauddin", result.body().toString())
               // Toast.makeText(this@MainActivity,result.body().toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}