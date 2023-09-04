package com.example.listbuku

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    private const val baseUrl = "https://oqqmbfsgrrkleszyldbf.supabase.co/rest/v1/"
    private const val apikey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9xcW1iZnNncnJrbGVzenlsZGJmIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTMyMDQ2MDQsImV4cCI6MjAwODc4MDYwNH0.jITaHLeu3lMiHjKRJT9xtgxV1BSe2F_wzt3r_U5jNeM"
    private const val  autorization = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9xcW1iZnNncnJrbGVzenlsZGJmIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTMyMDQ2MDQsImV4cCI6MjAwODc4MDYwNH0.jITaHLeu3lMiHjKRJT9xtgxV1BSe2F_wzt3r_U5jNeM"
    val okHttpClient = OkHttpClient.Builder().addInterceptor {
            chain ->
        val original = chain.request()
        val request = original.newBuilder()
            .header("Authorization", "Bearer $autorization")
            .header("apikey", apikey)
            .method(original.method(), original.body())
            .build()
        chain.proceed(request)
    }.build()
    val instance : ApiService by lazy {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
        retrofit.create(ApiService::class.java)
    }
}
object RetrofitHelperPost{
    private const val baseUrl = "https://oqqmbfsgrrkleszyldbf.supabase.co/rest/v1/"
    private const val apikey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9xcW1iZnNncnJrbGVzenlsZGJmIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTMyMDQ2MDQsImV4cCI6MjAwODc4MDYwNH0.jITaHLeu3lMiHjKRJT9xtgxV1BSe2F_wzt3r_U5jNeM"
    private const val  autorization = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9xcW1iZnNncnJrbGVzenlsZGJmIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTMyMDQ2MDQsImV4cCI6MjAwODc4MDYwNH0.jITaHLeu3lMiHjKRJT9xtgxV1BSe2F_wzt3r_U5jNeM"
    val okHttpClient = OkHttpClient.Builder().addInterceptor {
            chain ->
        val original = chain.request()
        val request = original.newBuilder()
            .header("Authorization", "Bearer $autorization")
            .header("apikey", apikey)
            .header("Content-Type","Content-Type")
            .method(original.method(), original.body())
            .build()
        chain.proceed(request)
    }.build()
    val instance : ApiService by lazy {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
        retrofit.create(ApiService::class.java)
    }
}