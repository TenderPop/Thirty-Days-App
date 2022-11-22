@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.thirtydays

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydays.data.GoalRepository
import com.example.thirtydays.model.Goal


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoalCard(modifier: Modifier = Modifier, goal: Goal) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Card(modifier = modifier
        .padding(25.dp),
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface,
        onClick = { expanded = !expanded }) {
        Column(modifier = Modifier.padding(25.dp)) {

            // Day
            Text(text = stringResource(goal.day), style = MaterialTheme.typography.h3)

            Spacer(modifier = Modifier.height(20.dp))

            // The title of the card
            Text(
                text = stringResource(goal.title),
                style = MaterialTheme.typography.body1,
                softWrap = false
            )
            // Used to align the image
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    ), horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //Image
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .requiredSizeIn(maxHeight = 400.dp, maxWidth = 420.dp)
                ) {
                    Image(
                        painter = painterResource(goal.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }

                // Information on the image
                if (expanded) {
                    Text(
                        text = stringResource(goal.description),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}

@Composable
fun GoalCardList(modifier: Modifier = Modifier, goalList: List<Goal>) {
    // List of Goal cards
    LazyColumn(modifier = modifier, content = {
        items(goalList) { item: Goal ->
            GoalCard(goal = item)
        }
    })
}

@Composable
fun GoalApp() {
    Scaffold(content = { contentPadding ->
        GoalCardList(modifier = Modifier.padding(contentPadding), goalList = GoalRepository.goals)
    }, topBar = {
        TopAppBar(content = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(id = R.string.appbar_title),
                    style = MaterialTheme.typography.h1
                )
            }
        })
    })


}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun GoalCardPreview() {

}