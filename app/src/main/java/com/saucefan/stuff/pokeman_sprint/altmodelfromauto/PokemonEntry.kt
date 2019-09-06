package com.saucefan.stuff.pokeman_sprint.altmodelfromauto


import com.google.gson.annotations.SerializedName

data class PokemonEntry(
    @SerializedName("entry_number")
    var entryNumber: Int,
    @SerializedName("pokemon_species")
    var pokemonSpecies: PokemonSpecies
)