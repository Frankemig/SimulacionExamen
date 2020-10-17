package cl.sulcansystem.testcase01productos.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class EntityTestCase01(
@PrimaryKey
val id: Int,
val name : String,
val price : String,
val image : String,
val description : String,
val lastPrice : String,
val credit : String
)