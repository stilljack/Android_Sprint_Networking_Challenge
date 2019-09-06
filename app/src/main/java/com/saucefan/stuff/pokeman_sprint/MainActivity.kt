package com.saucefan.stuff.pokeman_sprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


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
                *
                *
                *
                *
                *
                *
                *
                *
                *
                * */














class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
