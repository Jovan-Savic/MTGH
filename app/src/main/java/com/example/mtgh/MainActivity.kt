package com.example.mtgh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.mtgh.ui.theme.MTGHTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    var ucitane: MutableList<MTGC> = mutableListOf()

    val Minthara = MTGC(
        title = "Minthara, Merciless Soul",
        manaCost = listOf("2", "w", "b"),
        description = "Ward x, where X is the number of experience counters you have. At the beginning of your end step, if a permanent you controlled left the battlefield this turn, you get an experience counter. Creatures you control get +1/+0 for each experience counter you have.",
        type = "Legendary Creature - Elf Cleric",
        strength = 2,
        toughness = 2
    )

    val Ureni = MTGC(
        title = "Ureni, the Song Unending",
        manaCost = listOf("5", "g", "u", "r"),
        description = "Flying, protection from white and from black When Ureni enters, it deals X damage divided as you choose among any number of target creatures and/or planeswalkers your opponents control, where X is the number of lands you control.",
        type = "Legendary Creature - Spirit Dragon",
        strength = 10,
        toughness = 10

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ucitane.add(Minthara)
        ucitane.add(Ureni)
        setContent {
            MTGHTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn {
                        items(ucitane) { MTGCard ->
                            display(MTGCard, innerPadding)

                        }
                    }
                }
            }
        }

    }

    @Composable
    private fun display(card: MTGC, innerPadding: PaddingValues) {
        Card( modifier = Modifier.padding(innerPadding)){
            Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                Row() {
                    Text(text = card.title, modifier = Modifier.weight(1f))
                    displaymana(card);
                }
                Image(painter = painterResource(id = R.drawable.placeholder) , contentDescription = "placeholder for a card", modifier = Modifier.size(width = 320.dp, height = 229.dp)
                    .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop)
                Text(text = card.type)
                Text(text = card.description)
                Text(text = ""+ card.strength + "/" + card.toughness,modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End)
            }
        }
    }

    @Composable
    private fun displaymana(card:MTGC) {
        Row(){

            card.manaCost.forEach { curr ->
                when {
                    curr == "1" -> Image(
                        painter = painterResource(id = R.drawable.c1),
                        contentDescription = "colorless mana",
                        modifier = Modifier.size(18.dp).padding(1.dp, 1.dp)
                    )

                    curr == "2" -> Image(
                        painter = painterResource(id = R.drawable.c2),
                        contentDescription = "colorless mana",
                        modifier = Modifier.size(18.dp).padding(1.dp, 1.dp)
                    )

                    curr == "3" -> Image(
                        painter = painterResource(id = R.drawable.c3),
                        contentDescription = "colorless mana",
                        modifier = Modifier.size(18.dp).padding(1.dp, 1.dp)
                    )

                    curr == "4" -> Image(
                        painter = painterResource(id = R.drawable.c4),
                        contentDescription = "colorless mana",
                        modifier = Modifier.size(18.dp).padding(1.dp, 1.dp)
                    )

                    curr == "5" -> Image(
                        painter = painterResource(id = R.drawable.c5),
                        contentDescription = "colorless mana",
                        modifier = Modifier.size(18.dp).padding(1.dp, 1.dp)
                    )


                    curr == "b" -> Image(
                        painter = painterResource(id = R.drawable.b),
                        contentDescription = "black mana",
                        modifier = Modifier.size(18.dp).padding(1.dp, 1.dp)
                    )

                    curr == "w" -> Image(
                        painter = painterResource(id = R.drawable.w),
                        contentDescription = "white mana",
                        modifier = Modifier.size(18.dp).padding(1.dp, 1.dp)
                    )

                    curr == "r" -> Image(
                        painter = painterResource(id = R.drawable.r),
                        contentDescription = "red mana",
                        modifier = Modifier.size(18.dp).padding(1.dp, 1.dp)
                    )

                    curr == "g" -> Image(
                        painter = painterResource(id = R.drawable.g),
                        contentDescription = "green mana",
                        modifier = Modifier.size(18.dp).padding(1.dp, 1.dp)
                    )

                    curr == "u" -> Image(
                        painter = painterResource(id = R.drawable.u),
                        contentDescription = "blue mana",
                        modifier = Modifier.size(18.dp).padding(1.dp, 1.dp)
                    )

                }
            }


        }

    }


}
