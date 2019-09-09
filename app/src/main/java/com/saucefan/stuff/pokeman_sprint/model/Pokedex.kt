package com.saucefan.stuff.pokeman_sprint.model


import com.google.gson.annotations.SerializedName

data class Pokedex(
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
) {
    data class Description(
        var description: String,
        var language: Language
    ) {
        data class Language(
            var name: String,
            var url: String
        )
    }

    data class Name(
        var language: Language,
        var name: String
    ) {
        data class Language(
            var name: String,
            var url: String
        )
    }

    data class PokemonEntry(
        @SerializedName("entry_number")
        var entryNumber: Int,
        @SerializedName("pokemon_species")
        var pokemonSpecies: PokemonSpecies
    ) {
        data class PokemonSpecies(
            var name: String,
            var url: String
        )
    }

    data class Region(
        var name: String,
        var url: String
    )

    data class VersionGroup(
        var name: String,
        var url: String
    )
}