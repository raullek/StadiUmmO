package com.example.stadiummo.ui.splash

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.authorization_impl.R
import com.example.core_design.theme.StadiumoTheme
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        val itemsList = remember {
            listOf(
                DisplayItem(
                    "Nearby Stadiums",
                    "You don't have to go far to find or call a good stadium,\n" +
                            "we have provided all the stadiums that is \n" +
                            "near you,",
                    R.drawable.ill_onboarding_first
                ),
                DisplayItem(
                    "Just select stadium",
                    "Choose the stadium you like the most, choose the time and date of the game and Just Play :)",
                    R.drawable.ill_onboarding_second
                ),
            )
        }
        val pagerState = rememberPagerState(initialPage = 0, pageCount = { itemsList.size })
        val coroutineScope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .weight(0.5F)
                .padding(top = 82.dp)
        ) {
            HorizontalPager(
                modifier = Modifier
                    .height(240.dp)
                    .fillMaxWidth(),
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 20.dp), pageSpacing = 10.dp,
                verticalAlignment = Alignment.CenterVertically,
                userScrollEnabled = false
            ) { page ->
                PagerItem(modifier = Modifier, imageRes = itemsList[page].imageRes)

            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center,
                text = itemsList[pagerState.currentPage].title,
                style = StadiumoTheme.typography.h2
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                textAlign = TextAlign.Center,
                text = itemsList[pagerState.currentPage].description,
                style = StadiumoTheme.typography.s1
            )
        }

        BottomBar(modifier = Modifier, pagerState) {
            if (pagerState.canScrollForward) {
                val nextPage = (pagerState.currentPage + 1) % itemsList.size
                coroutineScope.launch { pagerState.animateScrollToPage(nextPage) }
            }
        }

    }


}

@Composable
fun PagerItem(modifier: Modifier, imageRes: Int) {
    Image(
        modifier = modifier
            .padding(24.dp)
            .fillMaxSize(),
        painter = painterResource(id = imageRes),
        contentDescription = "onboarding image"
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBar(modifier: Modifier, pagerState: PagerState, onNextPageClick: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(modifier = Modifier.align(Alignment.CenterVertically), text = "Skip")
        Box(
            modifier = Modifier
                .jumpingDotTransition(pagerState, 1.0F)
                .size(12.dp)
                .align(Alignment.CenterVertically)
                .background(
                    color = Color.Black,
                    shape = CircleShape,
                )
        )

        FloatingActionButton(
            onClick = {
                onNextPageClick.invoke()
            },
            modifier = Modifier
                .padding(8.dp), shape = CircleShape,
            containerColor = StadiumoTheme.colorScheme.primary
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_right_24dp),
                contentDescription = "some icon ",
                tint = StadiumoTheme.colorScheme.background
            )
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun Modifier.jumpingDotTransition(pagerState: PagerState, jumpScale: Float) =
    graphicsLayer {
        val pageOffset = pagerState.currentPageOffsetFraction
        val scrollPosition = pagerState.currentPage + pageOffset
        translationX =
            scrollPosition * (size.width + 8.dp.roundToPx()) // 8.dp - spacing between dots

        val scale: Float
        val targetScale = jumpScale - 1f

        scale = if (pageOffset.absoluteValue < .5) {
            1.0f + (pageOffset.absoluteValue * 2) * targetScale;
        } else {
            jumpScale + ((1 - (pageOffset.absoluteValue * 2)) * targetScale);
        }

        scaleX = scale
        scaleY = scale
    }


data class DisplayItem(
    val title: String,
    val description: String,
    val imageRes: Int
)