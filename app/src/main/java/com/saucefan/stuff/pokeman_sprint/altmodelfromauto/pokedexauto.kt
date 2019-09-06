package com.saucefan.stuff.pokeman_sprint.altmodelfromauto


import com.google.gson.annotations.SerializedName

data class pokedexauto(
    var descriptions: List<Description>,
    var id: Int,
    @SerializedName("is_main_series")
    var isMainSeries: Boolean,
    var name: String,
    var names: List<Name>,
    @SerializedName("pokemon_entries")
    var pokemonEntries: List<PokemonEntry>,
    var region: Region,
    @SerializedName("version_groups")
    var versionGroups: List<VersionGroup>
)