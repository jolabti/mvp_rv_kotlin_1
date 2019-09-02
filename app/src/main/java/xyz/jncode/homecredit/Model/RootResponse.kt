package xyz.jncode.homecredit.Model

import com.google.gson.annotations.SerializedName

data class RootResponse(

    @SerializedName("data")
    val  data: List<Data>
)