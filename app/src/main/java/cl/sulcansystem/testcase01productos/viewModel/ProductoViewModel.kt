package cl.sulcansystem.testcase01productos.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import cl.sulcansystem.testcase01productos.model.Repository

class ProductoViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: Repository = Repository(application)
    var listProducto = repository.productosList

    init {
        repository = Repository(application)

        repository.loadApiData()
        Log.d("ViewModel", listProducto.toString())

    }


}