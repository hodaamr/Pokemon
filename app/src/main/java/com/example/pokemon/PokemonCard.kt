package com.example.pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pokemon.model.Pokemon
import com.example.pokemon.model.PokemonType

@Composable
fun PokemonCard(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Box(modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(color = pokemon.type.backgroundColor, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ){
        ConstraintLayout(modifier.fillMaxWidth()) {
            val (pokemonName, pokemonType, pokemonAttack, pokemonAttackValue, pokemonDefense, pokemonDefenseValue, pokemonImage) = createRefs()

            Text(text = pokemon.name,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(pokemonName) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )

            Text(text = pokemon.type.typeName,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .background(pokemon.type.badgeColor, shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .constrainAs(pokemonType) {
                        top.linkTo(pokemonName.bottom)
                        start.linkTo(pokemonName.start)
                        bottom.linkTo(pokemonDefense.top)
                    }
            )

            Text(text = stringResource(R.string.attack),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(pokemonAttack) {
                        top.linkTo(pokemonName.bottom, 5.dp)
                        start.linkTo(pokemonType.end, 5.dp)
                    }
            )

            Text(text = pokemon.attack.toString(),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(pokemonAttackValue) {
                        top.linkTo(pokemonName.bottom, 5.dp)
                        start.linkTo(pokemonAttack.end)
                    }
            )

            Text(text = stringResource(R.string.defense),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(pokemonDefense) {
                        top.linkTo(pokemonAttack.bottom)
                        start.linkTo(pokemonAttack.start)
                    }
            )

            Text(text = pokemon.defense.toString(),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(pokemonDefenseValue) {
                        top.linkTo(pokemonAttack.bottom)
                        start.linkTo(pokemonDefense.end)
                    }
            )

            Image(painter = painterResource(id = R.drawable.ivysaur),
                contentDescription = "Pokemon Image",
                modifier = Modifier
                    .background(color = Color.White.copy(.3f), shape = CircleShape)
                    .size(100.dp)
                    .padding(5.dp)
                    .constrainAs(pokemonImage){
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )


        }
    }

}

@Preview(showBackground = true)
@Composable
private fun PokemonCardPreview() {
    PokemonCard(
        pokemon =
        Pokemon(
            name = "Bulbasaur",
            type = PokemonType.WATER,
            image = R.drawable.bulbasaur,
            attack = 65,
            defense = 65
        )
    )

}