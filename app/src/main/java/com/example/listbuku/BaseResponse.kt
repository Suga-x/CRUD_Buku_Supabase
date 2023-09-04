package com.example.listbuku

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("kodeBuku") var kodeBuku: String,
    @SerializedName("judulBuku") var judulBuku: String?,
    @SerializedName("tahunTerbit") var tahunTerbit: String?,
    @SerializedName("namaPenerbit") var namaPenerbit: String?,
    @SerializedName("namaPengarang") var namaPengarang: String?,

)
