package cl.sulcansystem.testcase01productos.model
import cl.sulcansystem.testcase01productos.model.pojos.ProductoDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("products")
    fun getProductos() :Call<List<ProductoDetails>>

    @GET("details/{id}")
    fun listaDetalles(@Path("id") id: Int?): Call<ProductoDetails>
}