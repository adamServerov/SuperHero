package com.example.superheroapp

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superheroapp.data.Heroes
import com.example.superheroapp.model.Hero
import com.example.superheroapp.ui.theme.SuperheroAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HeroApp()

                }
            }
        }
    }
}

@Composable
fun HeroApp() {
    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier.fillMaxWidth(), backgroundColor = MaterialTheme.colors.background) {
                TopBarElement()
            }
        }


    ) {
        LazyColumn() {
            items(Heroes.heroList) { hero ->
                HeroItem(hero = hero, modifier = Modifier.clip(RoundedCornerShape(20.dp)))
            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {

    Card(
        elevation = 4.dp,
        modifier = modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(12.dp)),
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeroInfoItem(heroName = hero.nickName, heroAbill = hero.abilitiDes)
            Spacer(modifier = Modifier.weight(1f))
            HeroICon(heroImage = hero.image, heroName = hero.nickName)


        }

    }
}

@Composable
fun TopBarElement() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = " ")
        Spacer(modifier = Modifier.weight(0.3f))
        Text(
            text = "Superheroes",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.weight(0.9f),

        )
    }
}

@Composable
fun HeroICon(heroImage: Int, heroName: Int) {
    Image(
        painter = painterResource(id = heroImage),
        contentDescription = stringResource(id = heroName),
        modifier = Modifier
            .size(85.dp)
            .padding(14.dp)
            .clip(RoundedCornerShape(5.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HeroInfoItem(heroName: Int, heroAbill: Int) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .width(200.dp)
    ) {
        Text(
            text = stringResource(id = heroName),
            style = MaterialTheme.typography.h2,
            // modifier = Modifier.
        )
        Spacer(modifier = Modifier.height(4.dp))
        val text: String = stringResource(id = heroAbill)

        Text(

            text = stringResource(id = heroAbill),
            style = MaterialTheme.typography.body1,
            //overflow = TextOverflow.,
            softWrap = true,
            maxLines = 2


        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperheroAppTheme {
        HeroApp()
    }
}