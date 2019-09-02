package xyz.jncode.homecredit

import retrofit2.Call
import retrofit2.http.GET
import xyz.jncode.homecredit.Model.RootResponse

interface NetworkRequest {

    @GET("home")
    fun getAllData(): Call<RootResponse>

}