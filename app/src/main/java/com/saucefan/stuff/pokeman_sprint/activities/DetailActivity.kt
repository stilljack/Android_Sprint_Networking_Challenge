package com.saucefan.stuff.pokeman_sprint.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.bumptech.glide.Glide
import com.saucefan.stuff.pokeman_sprint.R
import com.saucefan.stuff.pokeman_sprint.altmodelfromauto.Pokemon
import com.saucefan.stuff.pokeman_sprint.altmodelfromauto.PokemonDetails
import com.saucefan.stuff.pokeman_sprint.model.PokeForms
import com.saucefan.stuff.pokeman_sprint.networking.ApiInterface
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_layout.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity(), Callback<PokemonDetails> {
    override fun onFailure(call: Call<PokemonDetails>, t: Throwable) {
        t.printStackTrace()
        val response = "faliure; ${t.message}"
        Toast.makeText(this@DetailActivity, response, Toast.LENGTH_SHORT).show()

    }

    override fun onResponse(
        call: Call<PokemonDetails>,
        response: Response<PokemonDetails>
    ) {
        val detailedPokemon: PokemonDetails? = response.body()

        tv1.text = "Pokdex number: ${detailedPokemon?.id.toString()}"
        tv2.text = "Name: ${detailedPokemon?.name.toString()}"
        tv3.text = "Capture Rate: ${detailedPokemon?.captureRate.toString()}"



    }


    var pokedexRetrofit =  ApiInterface.Factory.create() // make an instance just for pokedex calls
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val sprite:String = intent.getStringExtra("pokeSpriteURL")
        val type = intent.getStringExtra("pokeID")
        Glide.with(this@DetailActivity)
            .load(sprite)
            .into(imgview)

        pokedexRetrofit.getPokemonDetails(type).enqueue(this)
        imgview.setOnClickListener{
            var intent_details = Intent(this@DetailActivity, MainActivity::class.java)
            startActivity(intent_details)
        }
    }
}
