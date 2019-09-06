package com.saucefan.stuff.pokeman_sprint.networking

import com.google.gson.Gson
import com.saucefan.stuff.pokeman_sprint.model.PokeForms
import com.saucefan.stuff.pokeman_sprint.model.Pokedex
import com.saucefan.stuff.pokeman_sprint.model.Pokemon
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiInterface {
    @GET("pokedex/{id}")
    fun getPokedex(@Path("id") id:String): Call<Pokedex>

    @GET("pokemon-form/{name}")
    fun getPokemonForm(@Path("name") name: String): Call<PokeForms>

  @GET("pokemon-species/{name}")
 fun getPokemonDetails(@Path("name") name: String): Call<Pokemon>


    class Factory {
        companion object {
            var pokedexList = mutableListOf<PokeForms>()
            val BASE_URL = "https://pokeapi.co/api/v2/"
            val gson = Gson()


            fun create(): ApiInterface {

                        // we don't need this at the moment
             /*   val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BASIC
                logger.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .retryOnConnectionFailure(false)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build()*/
                val retrofit = Retrofit.Builder()
               //     .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)) //gson
                    .build()

                return retrofit.create(ApiInterface::class.java)
            }
        }
    }

}