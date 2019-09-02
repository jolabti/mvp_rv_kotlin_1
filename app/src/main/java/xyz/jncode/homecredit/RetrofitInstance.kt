package xyz.jncode.homecredit

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory


//https://segunfamisa.com/posts/using-retrofit-on-android-with-kotlin
class RetrofitInstance {

     companion object {


         fun create(): NetworkRequest {

                val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(StaticLink.BASE_URL)
                    .build()

                return  retrofit.create(NetworkRequest::class.java)
         }


     }

}