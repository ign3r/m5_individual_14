package com.example.m5individual14.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.m5individual14.view.DetailView
import com.example.m5individual14.view.DetailView2
import com.example.m5individual14.view.HomeView
import com.example.m5individual14.viewmodel.IMCViewModel


@Composable
fun NavManager (viewModel: IMCViewModel,context: Context){
    val navController= rememberNavController()
    NavHost(navController, startDestination = "Home" ){
        composable("Home") {
            HomeView(viewModel, navController,context)
        }
        composable("DetailView") {
            DetailView(viewModel,navController)
        }
        composable("DetailView2/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {backStackEntry ->
//            DetailView2(id=id,viewModel,navController)

            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailView2(id, viewModel,navController,)
        }

    }
}