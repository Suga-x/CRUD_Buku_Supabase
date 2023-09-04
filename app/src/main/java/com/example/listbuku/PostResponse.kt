package com.example.listbuku

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("kodeBuku") val kodeBuku: String,
    @SerializedName("judulBuku") val judulBuku: String?,
    @SerializedName("tahunTerbit") val tahunTerbit: String?,
    @SerializedName("namaPenerbit") val namaPenerbit: String?,
    @SerializedName("namaPengarang") val namaPengarang: String?,
)
