package com.saucefan.stuff.pokeman_sprint.model



//this one sucked and was from that website
//i mean sucked is the worng word... kinda sucked
data class PokeForms (
    val formName: String,
    val formNames: List<Any?>,
    val formOrder: Long,
    val id: Long,
    val isBattleOnly: Boolean,
    val isDefault: Boolean,
    val isMega: Boolean,
    val name: String,
    val names: List<Any?>,
    val order: Long,
    val pokemon: PokemonClass,
    val sprites: Sprites,
    val versionGroup: PokemonClass
)

data class PokemonClass (
    val name: String,
    val url: String
)

data class Sprites (
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String
)
