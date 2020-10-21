package cl.sulcansystem.testcase01productos.model

import android.content.Context
import androidx.lifecycle.LiveData
import cl.sulcansystem.testcase01productos.model.db.DataBaseTestCase01
import cl.sulcansystem.testcase01productos.model.db.EntityTestCase01
import cl.sulcansystem.testcase01productos.model.pojos.ProductoDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository (context : Context) {

    var productos = DataBaseTestCase01.getDatabase(context)
    var productosList = productos.getDaoTest().getProductos()

    fun loadApiData() {
        val call = RetrofitClient.retrofitInstance().getProductos()

        call.enqueue(object : Callback<List<ProductoDetails>> {
            override fun onFailure(call: Call<List<ProductoDetails>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<ProductoDetails>>, response: Response<List<ProductoDetails>>) {

                saveDatabase(productoConverter(response.body()!!))
            }
        })
    }
    fun productoConverter(list : List<ProductoDetails>) : List<EntityTestCase01> {
        return list.map { producto -> EntityTestCase01(producto.id, producto.name, producto.description, producto.price, producto.image,producto.lastPrice,producto.credit) }
    }

    fun saveDatabase (listProductoEntity: List<EntityTestCase01>) {
        CoroutineScope(Dispatchers.IO).launch {
            productos.getDaoTest().insertProductos(listProductoEntity)
        }
    }
    fun getDetalles(param1: String): LiveData<EntityTestCase01> {
        return  productos.getDaoTest().getDetalles(param1.toInt())
    }
}