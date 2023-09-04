package com.example.listbuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahBukuActivity : AppCompatActivity() {
    private var et_namaBuku : EditText?=null
    private var et_kodeBuku : EditText?=null
    private var et_tahunBuku : EditText?=null
    private var et_namaPenulis : EditText?=null
    private var et_namaPenerbit : EditText?=null
    private var btn_tambahBuku : Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_buku)
        supportActionBar?.hide()
        et_namaBuku=findViewById(R.id.et_namaBuku)
        et_kodeBuku=findViewById(R.id.et_kodeBuku)
        et_tahunBuku=findViewById(R.id.et_tahunBuku)
        et_namaPenulis=findViewById(R.id.et_namaPenulis)
        et_namaPenerbit=findViewById(R.id.et_namaPenerbit)
        btn_tambahBuku = findViewById(R.id.bt_tambahBuku)
        btn_tambahBuku!!.setOnClickListener {
            val namaBuku = et_namaBuku!!.text.toString().trim()
            val kodeBuku = et_kodeBuku!!.text.toString().trim()
            val tahunBuku = et_tahunBuku!!.text.toString().trim()
            val namaPenulis = et_namaPenulis!!.text.toString().trim()
            val namaPenerbit = et_namaPenerbit!!.text.toString().trim()
            if (namaBuku.isEmpty() || kodeBuku.isEmpty() || tahunBuku.isEmpty()|| namaPenulis.isEmpty() || namaPenerbit.isEmpty()){
                Toast.makeText(this, "Masukan Data Dengan !benar !", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                RetrofitHelperPost.instance.postAllData(
                    kodeBuku,namaBuku,tahunBuku,namaPenerbit,namaPenulis
                ).enqueue(object  : Callback<PostResponse>{
                    override fun onResponse(
                        call: Call<PostResponse>,
                        response: Response<PostResponse>,

                    ) {
                        val responCode = response.code().toString()
                        Log.e("000",responCode)

                    }

                    override fun onFailure(call: Call<PostResponse>, t: Throwable) {

                    }

                })

            }
            val intent = Intent(this@TambahBukuActivity, MainActivity::class.java)
            startActivity(intent)

        }
    }
}