package com.example.myroom1p9.view.uicontroller

import com.example.myroom1p9.view.EntrySiswaScreen
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myroom1p9.view.DetailSiswaScreen
import com.example.myroom1p9.view.EditSiswaScreen
import com.example.myroom1p9.view.HomeScreen
import com.example.myroom1p9.view.route.DestinasiDetailSiswa
import com.example.myroom1p9.view.route.DestinasiEditSiswa
import com.example.myroom1p9.view.route.DestinasiEntry
import com.example.myroom1p9.view.route.DestinasiHome


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {

        composable(route = DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(route = DestinasiEntry.route) },

                navigateToItemDetail = { id ->

                    navController.navigate("${DestinasiDetailSiswa.route}/$id")
                }
            )
        }

        composable(route = DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }

        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetailSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                navigateBack = { navController.popBackStack() },
                navigateToEditItem = {
                    navController.navigate("${DestinasiEditSiswa.route}/${it}")
                },
                onNavigateUp = { navController.navigateUp() }
            )
        }

        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetailSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}