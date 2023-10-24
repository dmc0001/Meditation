package com.example.meditation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.meditation.Feature
import com.example.meditation.R
import com.example.meditation.Screen
import com.example.meditation.ui.theme.ButtonBlue
import com.example.meditation.ui.theme.DarkerButtonBlue
import com.example.meditation.ui.theme.DeepBlue
import com.example.meditation.utils.features

@Composable
fun DetailScreen(navController: NavController, id: Int?) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth()


        ) {
            LazyColumn(
                Modifier.weight(1f)
            ) {
                item {
                    TopBar(navController)
                }
                item {
                    CurrentFeatured(
                        feature = features[id!!]
                    )
                }
                item {
                    LunchSection()
                }
                item {
                    Divider(
                        thickness = 1.dp,
                        color = DarkerButtonBlue,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                item {
                    Text(
                        text = "Related",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                item {
                    RelatedSection(
                        features =  features
                    )
                }
            }
        }
    }

}

@Composable
fun TopBar(navController: NavController) {
    AnimatedVisibility(
        visible = true,
        exit = fadeOut(animationSpec = tween(2000))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) {
                                inclusive = true
                            }
                        }
                    }
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_start),
                contentDescription = "Star",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


@Composable
fun CurrentFeatured(feature: Feature) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = feature.title, style = MaterialTheme.typography.headlineMedium)
        Text(text = feature.description, style = MaterialTheme.typography.bodyMedium)
        Box(
            modifier = Modifier
                .padding(0.dp, 16.dp)
                .aspectRatio(1.5f)
                .clip(RoundedCornerShape(10.dp))
                .background(feature.lightColor)
                .padding(32.dp)
        ) {
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.description,
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )

        }
        Text(
            text = "Sleep music • 45 min",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(0.dp, 8.dp)
        )
        Text(
            text = "Easy the mind into a restful night's sleep \nwith  these deep , ambient tones.",
            style = MaterialTheme.typography.bodyLarge
        )

    }
}

@Composable
fun LunchSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_start),
            contentDescription = "Star",
            tint = Color.White,
            modifier = Modifier.size(24.dp),
            )
        Text(
            text = "12,542  Saved",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_headphone),
            contentDescription = "Star",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "43,453  Listening",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
    }

}

@Composable
fun RelatedSection(features: List<Feature>) {
    for (index in features.indices step 2) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 7.5.dp, end = 7.5.dp, bottom = 8.dp)
        ) {
            if (index < features.size) {
                RelatedItem2(feature = features[index])
            }
            if (index + 1 < features.size) {
                RelatedItem2(feature = features[index + 1])
            }
        }
    }
}

@Composable
fun RowScope.RelatedItem2(feature: Feature) {

    Box(
        modifier = Modifier
            .weight(1f)
            .fillMaxSize()
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
            .padding(16.dp)
    ) {
        Text(
            text = feature.title,
            style = MaterialTheme.typography.headlineSmall,
            lineHeight = 26.sp,
            modifier = Modifier.align(Alignment.TopStart)
        )
        Icon(
            painter = painterResource(id = feature.iconId),
            contentDescription = feature.title,
            tint = Color.White,
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Text(
            text = "Start",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            modifier = Modifier
                .clickable {
                    // Handle the click
                }
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(10.dp))
                .background(ButtonBlue)
                .padding(vertical = 6.dp, horizontal = 15.dp)
        )
    }

}

