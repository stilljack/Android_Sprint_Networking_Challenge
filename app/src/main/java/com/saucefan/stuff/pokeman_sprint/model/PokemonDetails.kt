package com.saucefan.stuff.pokeman_sprint.model


import com.google.gson.annotations.SerializedName

data class PokemonDetails(
    @SerializedName("base_happiness")
    var baseHappiness: Int,
    @SerializedName("capture_rate")
    var captureRate: Int,
    var color: Color,
    @SerializedName("egg_groups")
    var eggGroups: List<EggGroup>,
    @SerializedName("evolution_chain")
    var evolutionChain: EvolutionChain,
    @SerializedName("evolves_from_species")
    var evolvesFromSpecies: Any?,
    @SerializedName("flavor_text_entries")
    var flavorTextEntries: List<FlavorTextEntry>,
    @SerializedName("form_descriptions")
    var formDescriptions: List<Any>,
    @SerializedName("forms_switchable")
    var formsSwitchable: Boolean,
    @SerializedName("gender_rate")
    var genderRate: Int,
    var genera: List<Genera>,
    var generation: Generation,
    @SerializedName("growth_rate")
    var growthRate: GrowthRate,
    var habitat: Habitat,
    @SerializedName("has_gender_differences")
    var hasGenderDifferences: Boolean,
    @SerializedName("hatch_counter")
    var hatchCounter: Int,
    var id: Int,
    @SerializedName("is_baby")
    var isBaby: Boolean,
    var name: String,
    var names: List<Name>,
    var order: Int,
    @SerializedName("pal_park_encounters")
    var palParkEncounters: List<PalParkEncounter>,
    @SerializedName("pokedex_numbers")
    var pokedexNumbers: List<PokedexNumber>,
    var shape: Shape,
    var varieties: List<Variety>
) {
    data class Color(
        var name: String,
        var url: String
    )

    data class EggGroup(
        var name: String,
        var url: String
    )

    data class EvolutionChain(
        var url: String
    )

    data class FlavorTextEntry(
        @SerializedName("flavor_text")
        var flavorText: String,
        var language: Language,
        var version: Version
    ) {
        data class Language(
            var name: String,
            var url: String
        )

        data class Version(
            var name: String,
            var url: String
        )
    }

    data class Genera(
        var genus: String,
        var language: Language
    ) {
        data class Language(
            var name: String,
            var url: String
        )
    }

    data class Generation(
        var name: String,
        var url: String
    )

    data class GrowthRate(
        var name: String,
        var url: String
    )

    data class Habitat(
        var name: String,
        var url: String
    )

    data class Name(
        var language: Language,
        var name: String
    ) {
        data class Language(
            var name: String,
            var url: String
        )
    }

    data class PalParkEncounter(
        var area: Area,
        @SerializedName("base_score")
        var baseScore: Int,
        var rate: Int
    ) {
        data class Area(
            var name: String,
            var url: String
        )
    }

    data class PokedexNumber(
        @SerializedName("entry_number")
        var entryNumber: Int,
        var pokedex: Pokedex
    ) {
        data class Pokedex(
            var name: String,
            var url: String
        )
    }

    data class Shape(
        var name: String,
        var url: String
    )

    data class Variety(
        @SerializedName("is_default")
        var isDefault: Boolean,
        var pokemon: Pokemon
    ) {
        data class Pokemon(
            var name: String,
            var url: String
        )
    }
}