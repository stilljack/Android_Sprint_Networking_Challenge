package com.saucefan.stuff.pokeman_sprint.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.saucefan.stuff.pokeman_sprint.R
import com.saucefan.stuff.pokeman_sprint.model.Pokedex
import com.saucefan.stuff.pokeman_sprint.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
*
* 2. implement the pattern similar to m03 of creating an interface class with a companion object to handle getting the info from the api
*
*
*
*
*
*
*
* */














class MainActivity : AppCompatActivity() {


 var pokedexRetrofit =  ApiInterface.Factory.create() // make an instance just for pokedex calls



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pokedexRetrofit.getPokedex("2").enqueue(object: Callback<Pokedex> {
            override fun onFailure(call: Call<Pokedex>, t: Throwable) {
                t.printStackTrace()
                val response = "faliure; ${t.message}"
                Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()

            }
                override fun onResponse(
                    call: Call<Pokedex>,
                    response: Response<Pokedex>
                ) {
                    Toast.makeText(this@MainActivity, response.body().toString(),Toast.LENGTH_SHORT).show()
                }
            })


    }
}