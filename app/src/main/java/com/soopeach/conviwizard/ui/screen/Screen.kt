package com.soopeach.conviwizard.ui.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.soopeach.conviwizard.R

sealed class Screen(
    val route: String,
    @StringRes val stringResourceId: Int? = null,
    @DrawableRes val unSelectedIcon: Int? = null,
    @DrawableRes val selectedIcon: Int? = null,
    val unSelectedIconImageVector: ImageVector? = null,
    val selectedIconImageVector: ImageVector? = null,
    val arguments: List<NamedNavArgument> = emptyList(),
) {

    data object Home : Screen(
        route = "home",
        stringResourceId = R.string.home,
        unSelectedIconImageVector = Icons.Outlined.Home,
        selectedIconImageVector = Icons.Filled.Home,
    )

    data object Write : Screen(
        route = "write",
        stringResourceId = R.string.write,
    )

    data object Detail: Screen(
        route = "detail/{postId}",
        stringResourceId = R.string.detail,
        arguments = listOf(
            navArgument("postId") { type = NavType.LongType },
        ),
    )

    data object Recommendation : Screen(
        route = "recommendation",
        stringResourceId = R.string.recommendation,
        unSelectedIconImageVector = Icons.Outlined.ThumbUp,
        selectedIconImageVector = Icons.Filled.ThumbUp,
    )

    data object Like : Screen(
        route = "like",
        stringResourceId = R.string.like,
        unSelectedIconImageVector = Icons.Outlined.FavoriteBorder,
        selectedIconImageVector = Icons.Filled.Favorite,
    )

    data object MyPage : Screen(
        route = "myPage",
        stringResourceId = R.string.mypage,
        unSelectedIconImageVector = Icons.Outlined.Person,
        selectedIconImageVector = Icons.Filled.Person,
    )

    companion object {
        val bottomNavigationItems = listOf(Home, Recommendation, Like, MyPage)
    }
}