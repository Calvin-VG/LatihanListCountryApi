package com.example.latihannegaraapiactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihannegaraapiactivity.adapter.AdapterNegara
import com.example.latihannegaraapiactivity.model.GetAllNegaraResponItem
import com.example.latihannegaraapiactivity.network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun getDataNegara(){
        ApiClient.instance.getAllNegara()
            .enqueue(object : retrofit2.Callback<List<GetAllNegaraResponItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNegaraResponItem>>,
                    response: Response<List<GetAllNegaraResponItem>>
                ) {
                    if (response.isSuccessful){
                        val dataNegara = response.body()
                        val adapterNegara = AdapterNegara(dataNegara!!)
                        val llm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        rv_daftar_negara.layoutManager = llm
                        rv_daftar_negara.adapter = adapterNegara
                    }else{
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllNegaraResponItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}