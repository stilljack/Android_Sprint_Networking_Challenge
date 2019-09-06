package com.saucefan.stuff.pokeman_sprint.model


data class Pokedex (
    val descriptions: List<Description>,
    val id: Long,
    val isMainSeries: Boolean,
    val name: String,
    val names: List<Name>,
    val pokemonEntries: List<PokemonEntry>,
    val region: Region,
    val versionGroups: List<Region>
)

data class Description (
    val description: String,
    val language: Region
)

data class Region (
    val name: String,
    val url: String
)

data class Name (
    val language: Region,
    val name: String
)

data class PokemonEntry (
    val entryNumber: Long,
    val pokemonSpecies: Region
)
