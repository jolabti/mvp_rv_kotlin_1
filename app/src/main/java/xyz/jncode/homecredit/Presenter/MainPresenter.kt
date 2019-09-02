package xyz.jncode.homecredit.Presenter

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.jncode.homecredit.Contract.GlobalContract
import xyz.jncode.homecredit.MainActivity
import xyz.jncode.homecredit.Model.Data
import xyz.jncode.homecredit.Model.RootResponse
import xyz.jncode.homecredit.RetrofitInstance

class MainPresenter(val view_: MainActivity) : GlobalContract.PresenterContract {

    var view: MainActivity = view_;


    override fun showToast(message: String) {

        view.generateToast(message)
    }

    override fun consumeData() {

        view.showProcess(true)
        val dataServices = RetrofitInstance.create()

        Log.d("trace_tag", "oke")


        dataServices.getAllData().enqueue(object : Callback<RootResponse> {
            override fun onFailure(call: Call<RootResponse>, t: Throwable) {

                Log.d("trace_tag", "on fail")
                Log.d("trace_tag", t?.localizedMessage)
            }

            override fun onResponse(call: Call<RootResponse>, response: Response<RootResponse>) {

                if(response.isSuccessful){
                    view.showProcess(false)
                    view.generateToast("Data consume neatly")
                    val getList :List<Data> = response.body()?.data!!
                    view.populdateData(getList)
                }
                else{

                    view.showProcess(false)
                    view.generateToast("No Callback from API....")
                }
            }
        })



    }
}