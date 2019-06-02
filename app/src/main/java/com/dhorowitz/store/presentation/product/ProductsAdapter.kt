package com.dhorowitz.store.presentation.product

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dhorowitz.store.R
import com.dhorowitz.store.core.extension.inflate
import kotlinx.android.synthetic.main.row_product.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class ProductsAdapter
@Inject constructor() : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    internal var collection: List<ProductViewEntity> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (ProductViewEntity) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.row_product))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position])

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ProductViewEntity) {
            itemView.tvName.text = item.name
            itemView.tvPrice.text = item.formattedPrice
        }
    }
}
