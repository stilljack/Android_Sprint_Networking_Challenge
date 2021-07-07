package com.saucefan.stuff.pokeman_sprint.recyclerview

import android.content.Intent
import android.widget.ImageView
import com.saucefan.stuff.pokeman_sprint.R
import com.saucefan.stuff.pokeman_sprint.model.PokeForms
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saucefan.stuff.pokeman_sprint.activities.DetailActivity
import com.saucefan.stuff.pokeman_sprint.networking.ApiInterface.Factory.Companion.pokedexList
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.list_layout.view.*
import kotlin.random.Random


class ReAdapter(val list: MutableList<PokeForms>) : RecyclerView.Adapter<ReAdapter.ViewHolder>() {
companion object {
    var deleteList = mutableListOf<PokeForms>()
}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout, parent, false)
    return ViewHolder(viewGroup)

}

    override fun getItemCount(): Int {
        return list.size
    }
/*   interface OnRecyclerInterfaceListener {
       fun onItemSelected(item:Items)
    }*/
fun kill(pokeform:PokeForms,position: Int) {
    pokedexList.removeAt(position)
}
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      //  holder.nameTv.text = list[position].name
        val currentSelection = list[position]
        fun chooseRandomSprite() : String {
            var that =""
                  when (Random.nextInt(1,3)) {
                      1-> that = currentSelection.sprites.front_default
                      2-> that = currentSelection.sprites.front_shiny
                     else -> that = currentSelection.sprites.front_default
                 }
            return that
        }
        Glide.with(holder.pokeIMG.context)
            .load(chooseRandomSprite())
            .into(holder.pokeIMG)
        holder.pokeIMG.setOnClickListener{

            var intent_details:Intent = Intent(it.context, DetailActivity::class.java)
            intent_details.putExtra("pokeID",currentSelection.id.toString() ?:"151")
            intent_details.putExtra("pokeSpriteURL", currentSelection.sprites.front_default)
            startActivity(it.context, intent_details, null)
        }

        holder.pokeIMG.setOnLongClickListener{ it: View? ->
           //     Toast.makeText(it!!.context,"just great",Toast.LENGTH_SHORT).show();
             val selected = ContextCompat.getDrawable(it!!.context,R.drawable.ic_launcher_background)
            val unselected =ContextCompat.getDrawable(it.context,R.drawable.ic_android_black_24dp)
            if (deleteList.contains(currentSelection)) {
                it.background= unselected
                deleteList.remove(currentSelection)

            } else {
                it.background = selected
                deleteList.add(currentSelection)
            }
            true
        }




  /*    for list layout

    holder.pokeName.text=currentSelection.name
         holder.btn.setOnClickListener{
            pokedexList.remove(currentSelection)
            notifyItemRemoved(position)
        }
        */

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var pokeParent: ConstraintLayout = view.llcardview
        val pokeIMG: ImageView = view.img_poke

     /* list layout

       val pokeName: TextView = view.tv_poke_name
        val btn = view.delete
*/


    }


}
