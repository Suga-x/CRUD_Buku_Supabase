package com.example.listbuku

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface ApiService {
    @GET("buku?select=*")
    fun getAllData() : Call<ArrayList<BaseResponse>>
    @FormUrlEncoded
    @POST("buku")
    fun postAllData(
        @Field("kodeBuku") kodeBuku :String,
        @Field("judulBuku") judulBuku :String,
        @Field("tahunTerbit") tahunTerbit :String,
        @Field("namaPenerbit") namaPenerbit :String,
        @Field("namaPengarang") namaPengarang :String,
    ) : Call<PostResponse>
    @FormUrlEncoded
    @PATCH("buku")
    fun updateDataById(
        @Query("id") id: Int,
        kodeBuku:String,
        judulBuku:String,
        tahunTerbit:String,
        namaPenerbit:String,
        namaPengarang:String,
    ) : Call<PostResponse>
}
