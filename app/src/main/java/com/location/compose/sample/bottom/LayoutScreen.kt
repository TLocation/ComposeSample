package com.location.compose.sample.bottom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.location.compose.sample.layout.LayoutBoxSample

/**
 *
 * @author tianxiaolong
 * time：2022/9/1 18:47
 * description：
 */
sealed class LayoutScreen(
    val name: String,
    val routeName: String = "Layout/$name",
    val subScreen: List<LayoutScreen>? = null,
    val content: @Composable (
        back: () -> Unit,
        navigateRotate: (String) -> Unit
    ) -> Unit
) {
    companion object {
        const val START = "Layout/home"
        val LayoutItems = listOf(Box, RowHome, Column)
    }
}


private object Box : LayoutScreen("box", content = { back, _ ->
    LayoutBoxSample(back)
})

private object RowHome : LayoutScreen("row", content = { back, _ ->
    Payload(back)
})

private object Column : LayoutScreen("column", content = { back ->
    Payload(back)
})


@Composable
private inline fun Payload(back: () -> Unit) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "占位界面", textAlign =  TextAlign.Center)
    }
}

