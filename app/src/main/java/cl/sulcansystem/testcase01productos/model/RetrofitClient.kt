package cl.sulcansystem.testcase01productos.model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "http://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"

class RetrofitClient {

    companion object {

        fun retrofitInstance() : API {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(API::class.java)
        }
    }
}