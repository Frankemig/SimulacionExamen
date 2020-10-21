package cl.sulcansystem.testcase01productos.model.pojos

import com.google.gson.annotations.SerializedName


class ProductoList(
    @SerializedName("id")
    val id: Int ,
    @SerializedName("name")
    val name: String ,
    @SerializedName("price")
    val price: Int ,
    @SerializedName("image")
    val image: String
)