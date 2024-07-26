package com.su.flinggesturescomposepager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import kotlin.math.absoluteValue


@Composable
fun SampleFlingGesturePager(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        FlingGesturePager()
    }
}

@Composable
fun FlingGesturePager(modifier: Modifier = Modifier) {

    val pagerState = rememberPagerState(pageCount = { 10 })

    HorizontalPager(
        state = pagerState,
        beyondViewportPageCount = 10,
    ) { page ->

        val pageOffset = pagerState.getOffsetDistanceInPages(page).absoluteValue

        SongItem()
    }
}

@Preview
@Composable
private fun SongItem(
    songImage: Int = R.drawable.ic_launcher_background,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
    ) {
        Box(modifier = Modifier.padding(32.dp)) {
            Image(
                painter = painterResource(id = songImage),
                contentDescription = "baby",
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .height(230.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Artist")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "A Song Title", fontSize = 18.sp)
            Row(modifier = Modifier.height(22.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "rating"
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "rating"
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "rating"
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "rating"
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "rating"
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_music_note),
                contentDescription = "music note"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "DRAG TO LISTEN",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "down"
            )
        }
    }
}