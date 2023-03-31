package com.example.listscroller.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listscroller.DetailsItem
import com.example.listscroller.R
import com.example.listscroller.model.Affirmation

class ItemAdapter(
    private  val dataset: List<Affirmation>,
    private  val  detailsItem: DetailsItem
)
    :RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(view:View):RecyclerView.ViewHolder(view),View.OnClickListener{
        val textView: TextView = view.findViewById(R.id.item_title)



        init{
            view.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position=adapterPosition
            if(position!=RecyclerView.NO_POSITION)
            {
                detailsItem.clickOnItem(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textView.text = dataset[position].someText
    }
    fun clickOnItem(position: Int){}
}