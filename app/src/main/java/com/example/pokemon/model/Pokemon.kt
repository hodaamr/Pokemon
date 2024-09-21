package com.example.pokemon.model

import androidx.compose.ui.graphics.Color
import com.example.pokemon.ui.theme.fireBadge
import com.example.pokemon.ui.theme.fireBg
import com.example.pokemon.ui.theme.grassBadge
import com.example.pokemon.ui.theme.grassBg
import com.example.pokemon.ui.theme.undefinedBadge
import com.example.pokemon.ui.theme.undefinedBg
import com.example.pokemon.ui.theme.waterBadge
import com.example.pokemon.ui.theme.waterBg

data class Pokemon(
    val name: String,
    val type: PokemonType,
    val attack: Int,
    val defense: Int,
    val image: Int
)

enum class PokemonType(val typeName: String, val badgeColor: Color, val backgroundColor: Color){
    FIRE("fire", fireBadge, fireBg),
    WATER("water", waterBadge, waterBg),
    GRASS("grass", grassBadge, grassBg),
    UNDEFINED("Undefined",undefinedBadge, undefinedBg)
}

