package com.saucefan.stuff.pokeman_sprint.recyclerview

import android.content.Intent
import android.widget.ImageView
import com.saucefan.stuff.pokeman_sprint.R
import com.saucefan.stuff.pokeman_sprint.model.PokeForms
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saucefan.stuff.pokeman_sprint.activities.DetailActivity
import com.saucefan.stuff.pokeman_sprint.networking.ApiInterface.Factory.Companion.pokedexList
import kotlinx.android.synthetic.main.activity_main.view.*
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
        holder.pokeName.text=currentSelection.name
        Glide.with(holder.pokeIMG.context)
            .load(currentSelection.sprites.front_default)
            .into(holder.pokeIMG)
        holder.btn.setOnClickListener{
            pokedexList.remove(currentSelection)
            notifyItemRemoved(position)
        }
        holder.pokeIMG.setOnClickListener{
                var intent_details:Intent = Intent(it.context, DetailActivity::class.java)
                intent_details.putExtra("pokeID",currentSelection.id.toString() ?:"151")
                intent_details.putExtra("pokeSpriteURL", currentSelection.sprites.front_default)
                startActivity(it.context, intent_details, null)
        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokeName: TextView = view.tv_poke_name
        val pokeIMG: ImageView = view.img_poke
        val btn = view.delete


        /*     fun bindModel(currentSelection: Items) {
                 if (currentSelection.ordered) {
                     parentView.setBackgroundColor(ContextCompat.getColor(parentView.context, R.color.bought))
                 } else {
                     parentView.setBackgroundColor(ContextCompat.getColor(parentView.context, R.color.unbought))
                 }
             }*/
    }


}
