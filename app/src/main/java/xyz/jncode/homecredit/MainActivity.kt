package xyz.jncode.homecredit

import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_section_divider_bar.*
import kotlinx.android.synthetic.main.item_section_navigation.*
import xyz.jncode.homecredit.Adapter.ProductNavAdapter
import xyz.jncode.homecredit.Adapter.RvAdapter
import xyz.jncode.homecredit.Contract.GlobalContract
import xyz.jncode.homecredit.Model.Data
import xyz.jncode.homecredit.Model.NewsModel
import xyz.jncode.homecredit.Model.ProductModel
import xyz.jncode.homecredit.Presenter.MainPresenter
import xyz.jncode.homecredit.Share.TypeObject

class MainActivity : AppCompatActivity(), GlobalContract.MainActivityContract {

    var adapterNav : ProductNavAdapter? = null
    var adapterNews : RvAdapter? = null
    var navCollectList = ArrayList<ProductModel>()
    var navCollectNews = ArrayList<NewsModel>()
    private var presenter: MainPresenter? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter?.consumeData()



    }


    override fun populdateData(generatedList: List<Data>) {


        Log.d("trace_populate", generatedList.get(0).section);
        Log.d("trace_populate", generatedList.get(1).section);

        item_divider_id.setText(generatedList.get(1).section_title)

        navCollectList.clear()
        for (i in 0..generatedList.get(0).items.size-1) {

            navCollectList.add(ProductModel(generatedList.get(0).items.get(i).product_name,generatedList.get(0).items.get(i).product_image))

            Log.d("trace_navcolist", generatedList.get(0).items.get(i).product_name+" "+generatedList.get(0).items.get(i).product_image)
        }


        navCollectNews.clear()
        for (i in 0..generatedList.get(1).items.size-1) {

            navCollectNews.add(NewsModel(generatedList.get(1).items.get(i).article_title,generatedList.get(1).items.get(i).article_image))

            Log.d("trace_navnwslist", generatedList.get(1).items.get(i).article_title+" "+generatedList.get(0).items.get(i).article_image)
        }






        adapterNav = ProductNavAdapter(navCollectList,this)
        adapterNews = RvAdapter(navCollectNews, this)


        gvProducts.adapter=adapterNav

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_app_id!!.layoutManager = linearLayoutManager
        rv_app_id!!.isNestedScrollingEnabled = true
        rv_app_id!!.setHasFixedSize(true)


        rv_app_id.layoutManager = linearLayoutManager
        rv_app_id.adapter=adapterNews


    }

    override fun showProcess(boolCondition: Boolean) {

           if(boolCondition==true){
               progressBar.progress==100
           }
           progressBar.isVisible = boolCondition



    }


    override fun generateToast(message: String) {

        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }



    companion object {
        const val FLAG_PRODUCT: String = "products"
        const val FLAG_ARTICLE: String = "articles"
    }
}


