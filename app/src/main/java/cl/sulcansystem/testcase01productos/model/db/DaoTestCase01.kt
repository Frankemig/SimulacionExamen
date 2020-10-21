package cl.sulcansystem.testcase01productos.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.sulcansystem.testcase01productos.model.pojos.ProductoList

    @Dao
    interface DaoTestCase01 {
    @Query("SELECT * FROM productos")
    fun getProductos() : LiveData<List<ProductoList>>

     @Query ("SELECT * FROM productos WHERE id=:id")
    fun getDetalles(id: Int) : LiveData<EntityTestCase01>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductos(productosList : List<EntityTestCase01>)
}