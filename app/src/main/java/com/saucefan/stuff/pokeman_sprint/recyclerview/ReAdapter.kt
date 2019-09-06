package com.saucefan.stuff.pokeman_sprint.recyclerview

import android.widget.ImageView
import com.saucefan.stuff.pokeman_sprint.R
import com.saucefan.stuff.pokeman_sprint.model.PokeForms
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_layout.view.*


class ReAdapter(val list: MutableList<PokeForms>) : RecyclerView.Adapter<ReAdapter.ViewHolder>() {


override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
    return ViewHolder(viewGroup)

}

    override fun getItemCount(): Int {
        return list.size
    }
/*   interface OnRecyclerInterfaceListener {
       fun onItemSelected(item:Items)
    }*/

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      //  holder.nameTv.text = list[position].name

        val currentSelection = list[position]

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTv: TextView = view.tv_poke_name
        val ratingTv: ImageView = view.img_poke


        /*     fun bindModel(currentSelection: Items) {
                 if (currentSelection.ordered) {
                     parentView.setBackgroundColor(ContextCompat.getColor(parentView.context, R.color.bought))
                 } else {
                     parentView.setBackgroundColor(ContextCompat.getColor(parentView.context, R.color.unbought))
                 }
             }*/
    }


}
