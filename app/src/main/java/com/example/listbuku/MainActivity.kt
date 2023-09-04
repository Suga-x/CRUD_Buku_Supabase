package com.example.listbuku


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var fab_tambahBuku : FloatingActionButton?=null
    private var cardBuku : CardView ?=null
    var adapter :BukuAdapter?=null
    val list = ArrayList<BaseResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        fab_tambahBuku = findViewById(R.id.floatingActionButton_add)
        fab_tambahBuku!!.setOnClickListener{
            val intent = Intent(this@MainActivity, TambahBukuActivity::class.java)
            startActivity(intent)
        }
        var rv_buku = findViewById<RecyclerView>(R.id.recyclerView)
        rv_buku.setHasFixedSize(true)
        rv_buku.layoutManager = LinearLayoutManager(this)
        RetrofitHelper.instance.getAllData().enqueue(object : Callback<ArrayList<BaseResponse>>{
            override fun onResponse(
                call: Call<ArrayList<BaseResponse>>,
                response: Response<ArrayList<BaseResponse>>,
            ) {
                val responCode = response.code().toString()
                Log.e("000",responCode)
                response.body()?.let { list.addAll(it) }
                adapter = BukuAdapter(list)
                rv_buku.adapter = adapter

            }

            override fun onFailure(call: Call<ArrayList<BaseResponse>>, t: Throwable) {

            }

        })



    }

}