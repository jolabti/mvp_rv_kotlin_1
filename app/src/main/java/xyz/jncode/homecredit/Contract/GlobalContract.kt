package xyz.jncode.homecredit.Contract

import xyz.jncode.homecredit.Model.Data

interface GlobalContract {

    interface PresenterContract {


        fun consumeData()

        fun showToast(message: String)

    }


    interface MainActivityContract {

        fun showProcess(boolCondition: Boolean)

        fun populdateData(generatedList: List<Data>)

        fun generateToast(message: String)


    }

}