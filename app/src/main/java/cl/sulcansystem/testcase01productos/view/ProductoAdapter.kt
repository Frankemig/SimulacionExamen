package cl.sulcansystem.testcase01productos.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.sulcansystem.testcase01productos.R
import cl.sulcansystem.testcase01productos.model.pojos.ProductoList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_producto.view.*

class ProductoAdapter(private var productoList: MutableList<ProductoList>) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {


    inner class ProductoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val productoName = itemView.txt_name
        val productoPrecio = itemView.txt_precio
        val productoDescription = itemView.txt_description
        val image = itemView.image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
    return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        Picasso.get().load(productoList.get(position).image).into(holder.image)
        holder.productoName.text=productoList.get(position).name
        holder.productoPrecio.text = productoList.get(position).price.toString()

        holder.itemView.setOnClickListener{
            Log.d("ViewHolder", "${productoList.get(position)}")
        }
    }

    override fun getItemCount(): Int {
        return productoList.size
    }
    fun updateItems(it: List<ProductoList>) {
        productoList.clear()
        productoList.addAll(it)
        notifyDataSetChanged()
    }
}
