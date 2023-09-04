package com.example.listbuku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class EditBukuActivity : AppCompatActivity() {
    private var et_namaBuku : EditText?=null
    private var et_kodeBuku : EditText?=null
    private var et_tahunBuku : EditText?=null
    private var et_namaPenulis : EditText?=null
    private var et_namaPenerbit : EditText?=null
    private var btn_editBuku : Button?=null
    private var ID : Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_buku)
        et_namaBuku=findViewById(R.id.et_namaBuku)
        et_kodeBuku=findViewById(R.id.et_kodeBuku)
        et_tahunBuku=findViewById(R.id.et_tahunBuku)
        et_namaPenulis=findViewById(R.id.et_namaPenulis)
        et_namaPenerbit=findViewById(R.id.et_namaPenerbit)
        btn_editBuku = findViewById(R.id.bt_EditBuku)
        val apiService: ApiService ?=null

        val mIntent = intent
        ID = mIntent.getIntExtra("id",0)
        et_namaBuku?.setText(mIntent.getStringExtra("judulBuku"))
        et_kodeBuku?.setText(mIntent.getStringExtra("kodeBuku"))
        et_tahunBuku?.setText(mIntent.getStringExtra("tahunTerbit"))
        et_namaPenulis?.setText(mIntent.getStringExtra("namaPengarang"))
        et_namaPenerbit?.setText(mIntent.getStringExtra("namaPenerbit"))
        btn_editBuku?.setOnClickListener {
            updateData()
//            RetrofitHelperPost.instance.updateDataById(
//                id = ID,
//                kodeBuku = et_kodeBuku?.text.toString().trim(),
//                judulBuku = et_namaBuku?.text.toString().trim(),
//                tahunTerbit = et_tahunBuku?.text.toString().trim(),
//                namaPenerbit = et_namaPenerbit?.text.toString().trim(),
//                namaPengarang = et_namaPenulis?.text.toString().trim()
//
//            ).enqueue(object  : Callback<PostResponse>{
//                override fun onResponse(
//                    call: Call<PostResponse>,
//                    response: Response<PostResponse>,
//                ) {
//                    val responCode = response.code().toString()
//                    Log.e("000",responCode)
//                    val responseText = "ResponCode ${responCode}\n " +
//                            "id ${ID} \n " +
//                            "kodeBuku ${et_kodeBuku} \n " +
//                            "judulBuku ${et_namaBuku}\n " +
//                            "tahunBuku ${et_tahunBuku}\n " +
//                            "namaPenerbit ${et_namaPenerbit} \n " +
//                            "namaPenulis ${et_namaPenulis}"
//                    Log.e("rcode000",responseText)
//                }
//                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
//                    if (t is HttpException) {
//                        val errorBody = t.response()?.errorBody()?.string()
//                        Log.e("HTTP Error", errorBody.toString())
//                    }
//                }
//
//            })
        }
    }

    private fun updateData() {
        RetrofitHelperPost.instance.getAllData().enqueue(object : Callback<ArrayList<BaseResponse>>{
            override fun onResponse(
                call: Call<ArrayList<BaseResponse>>,
                response: Response<ArrayList<BaseResponse>>,
            ) {
                val responCode = response.code().toString()
                Log.e("000",responCode)
                if (response.isSuccessful){
                    val postData = response.body()
                    if (postData !=null){
                        val bukuUpdate = postData.find { it.id == ID }
                        if (bukuUpdate !=null){
                            val kodeBuku = et_kodeBuku!!.text.toString().trim()
                            val judulBuku = et_namaBuku!!.text.toString().trim()
                            val tahunTerbit = et_tahunBuku!!.text.toString().trim()
                            val namaPenerbit = et_namaPenerbit!!.text.toString().trim()
                            val namaPengarang = et_namaPenulis!!.text.toString().trim()

                            bukuUpdate.kodeBuku = kodeBuku
                            bukuUpdate.judulBuku = judulBuku
                            bukuUpdate.tahunTerbit = tahunTerbit
                            bukuUpdate.namaPenerbit = namaPenerbit
                            bukuUpdate.namaPengarang = namaPengarang

                            RetrofitHelperPost.instance.updateDataById(
                                bukuUpdate.id,
                                bukuUpdate.kodeBuku,
                                judulBuku = judulBuku,
                                tahunTerbit = tahunTerbit,
                                namaPenerbit = namaPenerbit,
                                namaPengarang = namaPengarang
                            ).enqueue(object : Callback<PostResponse>{
                                override fun onResponse(
                                    call: Call<PostResponse>,
                                    response: Response<PostResponse>,
                                ) {
                                    val responCode = response.code().toString()
                                    Log.e("000",responCode)
                                    val responseText = "ResponCode ${responCode}\n " +
                                            "id ${bukuUpdate.id} \n " +
                                            "kodeBuku ${kodeBuku} \n " +
                                            "judulBuku ${judulBuku}\n " +
                                            "tahunBuku ${tahunTerbit}\n " +
                                            "namaPenerbit ${namaPenerbit} \n " +
                                            "namaPenulis ${namaPengarang}"
                                    Log.e("rcode000",responseText)
                                }

                                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                                    Log.e("HTTP Error", "Gagal mengirim permintaan PUT/PATCH")
                                }

                            })
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<BaseResponse>>, t: Throwable) {
                Log.e("HTTP Error", t.message ?: "Gagal mengambil data dari API")
            }

        })
    }
}



