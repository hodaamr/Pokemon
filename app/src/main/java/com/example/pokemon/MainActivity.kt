package com.example.pokemon

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemon.model.Pokemon
import com.example.pokemon.model.PokemonType

val pokemonList = mutableListOf<Pokemon>()

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initPokemonData()
        setContent {
            LazyColumn(modifier = Modifier.statusBarsPadding()) {

                items(pokemonList) {
                    PokemonCard(pokemon = it)

                }
            }

        }

    }

    private fun initPokemonData() {

        assets.open("pokemon_data.csv").bufferedReader().use { reader ->
            reader.forEachLine { line ->
                val row = line.split(",")
                val pokemonType = when (row[1]) {
                    "fire" -> PokemonType.FIRE
                    "water" -> PokemonType.WATER
                    "grass" -> PokemonType.GRASS
                    else -> PokemonType.UNDEFINED
                }
                val pokemon = Pokemon(
                    row[0],
                    pokemonType,
                    row[2].toInt(),
                    row[3].toInt(),
                    resources.getIdentifier(
                        row[0].lowercase(),
                        "drawable",
                        packageName
                    )

                )
                pokemonList.add(pokemon)
            }
        }

    }
}



