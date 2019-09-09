package com.saucefan.stuff.pokeman_sprint.activities

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.saucefan.stuff.pokeman_sprint.R
import com.saucefan.stuff.pokeman_sprint.model.PokeForms
import com.saucefan.stuff.pokeman_sprint.model.Pokedex
import com.saucefan.stuff.pokeman_sprint.networking.ApiInterface
import com.saucefan.stuff.pokeman_sprint.networking.ApiInterface.Factory.Companion.pokedexList
import com.saucefan.stuff.pokeman_sprint.recyclerview.ReAdapter
import com.saucefan.stuff.pokeman_sprint.recyclerview.ReAdapter.Companion.deleteList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_layout.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random


/*
*
* initial scouting of api
* BASE_URL ="https://pokeapi.co/api/v2/"
* https://pokeapi.co/api/v2/pokemon-species/[id]/ will give us our particular pokemons details
* https://pokeapi.co/api/v2/pokedex/[regional pokedex]/ gives us the list of pokemon for a region
*
* I'M JUST GONNA DO REGION TWO INITIALLY, KANTO OR THE ORIGINAL 150 POKEMON
*
* postman tells me:
*
* should be able to build a list out of pokedex/2 without a terrible amount of trouble
* pokedex/{id} is a - ok for getting everything we need for details view
*
* trailing / is uncessary
* ~~ whiteboard and try to figure out everything that needs to get built
*
* 1. build data class for pokedex  -- used app.quicktype.io and "Kotlin Dataclass from JSON plugin" to compare alternate strategies for
* quickly parsing json <-- I imagine we'll return to this soon
* 2. implement the pattern similar to m03 of creating an interface class with a companion object to handle getting the info from the api
* 3. I'm thinking about this problem too hard
* 4. so our current imperfect data class pokemon can capture a searched for pokemons name and at least some of its details successfully using
*       getPokemonDetails("name") -- i want to get to mvp today before the cows come  home so we'll come back to altering the pokedex calls later
* 5. out current search implementation correctly grabs a url for the image and sets it with glide, also grabs the ID successfully which is all we need for a details view.
*6. so we are gonna make a detail activity which will take in the pokemon ID
* end. we got the recycler view and such pretty much for free.
*
* */














class MainActivity : AppCompatActivity() {


 var pokedexRetrofit =  ApiInterface.Factory.create() // make an instance just for pokedex calls




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*

        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycle_view.layoutManager = manager
*/
        //recycle_view.setHasFixedSize(true)
        val manager = StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL)
        val adapter = ReAdapter(pokedexList)
        recycle_view.layoutManager = manager
        recycle_view.adapter = adapter


        fun makeArandomPokedex(number: Int) {

            for (i in 1 until number) {

                pokedexRetrofit.getPokemonForm(Random.nextInt(1, 950).toString())
                    .enqueue(object : Callback<PokeForms> {
                        override fun onFailure(call: Call<PokeForms>, t: Throwable) {
                            t.printStackTrace()
                            val response = "faliure; ${t.message}"
                            Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()

                        }

                        override fun onResponse(
                            call: Call<PokeForms>,
                            response: Response<PokeForms>
                        ) {
                            val newPokedex: PokeForms? = response.body()
                            if (newPokedex != null) {
                                pokedexList.add(newPokedex)
                            }


                        }

                    })

            }
            adapter.notifyDataSetChanged()
        }
        makeArandomPokedex(70)
        btn_submit.setOnClickListener {
            pokedexRetrofit.getPokemonForm(et_pokeentry.text.toString()).enqueue(object : Callback<PokeForms> {
                override fun onFailure(call: Call<PokeForms>, t: Throwable) {
                    t.printStackTrace()
                    val response = "faliure; ${t.message}"
                    Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()

                }

                override fun onResponse(
                    call: Call<PokeForms>,
                    response: Response<PokeForms>
                ) {
                    val newPokedex: PokeForms? = response.body()
                    if (newPokedex != null) {
                        pokedexList.add(newPokedex)
                    }
                    adapter.notifyDataSetChanged()

                   /* val mainLayout = findViewById<FrameLayout>(R.id.frame_content)
                    val view = getLayoutInflater().inflate(R.layout.list_layout, mainLayout, false )
                       mainLayout.addView(view)

                    view.tv_poke_name.text = newPokedex?.id.toString()
                    Glide.with(this@MainActivity)
                        .load(newPokedex?.sprites?.front_default)
                        .into(view.img_poke)


                    view.setOnClickListener{
                        var intent_details = Intent(this@MainActivity,DetailActivity::class.java)
                        intent_details.putExtra("pokeID",newPokedex?.id.toString() ?:"151")
                        intent_details.putExtra("pokeSpriteURL", newPokedex?.sprites?.front_default ?: "https://assets.carolus.raywenderlich.com/assets/artwork/getting-started-android@2x-2006205d82bd24a83b14c885d490a2f4008e7fc19b81d5db8046da010d57c833.png")
                        startActivity(intent_details)
                    }*/


                    // "name: ${newPokedex?.name.toString()} \n id: ${newPokedex?.id.toString()} \n" +
                             //   " habitat: ${sprites.toString()}"
                   // Toast.makeText(this@MainActivity, newPokedex?.sprites?.front_default.toString(), Toast.LENGTH_SHORT)
                       // .show()
                }
            })
            pokedexRetrofit.getPokedex(et_pokeentry.text.toString()).enqueue(object : Callback<Pokedex> {
                override fun onFailure(call: Call<Pokedex>, t: Throwable) {
                    t.printStackTrace()
                    val response = "faliure; ${t.message}"
                    Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()

                }

                override fun onResponse(
                    call: Call<Pokedex>,
                    response: Response<Pokedex>
                ) {
                    val newPokedex: Pokedex? = response.body()
                 /*   tv.text =
                        "name: ${newPokedex?.name.toString()} \n habitat: ${newPokedex?.id.toString()} \n" +
                                " habitat: ${newPokedex?.id.toString()}"*/
                    Toast.makeText(this@MainActivity, newPokedex?.id.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }




        btn_delete.setOnClickListener{
                pokedexList.removeAll(deleteList)
            deleteList.removeAll(deleteList)
            adapter.notifyDataSetChanged()


            var i = 9
        }


        }




    }




/*

working pokemon details object

pokedexRetrofit.getPokemonDetails(et_pokeentry.text.toString()).enqueue(object : Callback<Pokemon> {
                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    t.printStackTrace()
                    val response = "faliure; ${t.message}"
                    Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()

                }

                override fun onResponse(
                    call: Call<Pokemon>,
                    response: Response<Pokemon>
                ) {
                    val newPokedex: Pokemon? = response.body()
                    tv.text =
                        "name: ${newPokedex?.name.toString()} \n habitat: ${newPokedex?.id.toString()} \n" +
                                " habitat: ${newPokedex?.id.toString()}"
                    Toast.makeText(this@MainActivity, newPokedex?.id.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            })
 */