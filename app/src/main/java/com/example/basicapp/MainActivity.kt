package com.example.basicapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.basicapp.data.repo.UserRepo
import com.example.basicapp.main.MainNavigation
import com.example.basicapp.ui.theme.BasicAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
//    lateinit var data: String
    lateinit var userRepo: UserRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = userRepo.getUser("ironman", 100)
        Log.d("MainActivity", "onCreate: $user")

//        Log.d("MainActivity", "onCreate: $data")

        setContent {
            BasicAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }

    @Composable
    fun MainApp() {
        MainNavigation()
    }

    @OptIn(ExperimentalMaterial3Api::class)

    @Composable
    fun ScaffoldApp() {

        Scaffold(
            topBar = {
                // Customize the top app bar as needed
                TopAppBar(
                    title = {
                        Text("TopAppBar")
                    },
                    actions = {
                        IconButton(
                            onClick = { /* Handle action */ },

                            ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                modifier = Modifier.size(50.dp),
                                contentDescription = "Search"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color.DarkGray,
                        titleContentColor = Color.White,
                    ),
                )
            },

            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /* Handle FAB click */ }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = " "
                    )
                }
            },

            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "IRON MAN",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.displayMedium
                    )
                    Image(
                        painter = painterResource(R.drawable.peakpx_img),
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = " "
                    )
                }
            },

            bottomBar = {
                var selectedItem = remember { mutableIntStateOf(0) }
                val items = listOf("Songs", "Artists", "Playlists")

                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                            label = { Text(item) },
                            selected = selectedItem.value == index,
                            onClick = { selectedItem.value = index }
                        )
                    }
                }
            },

            )

    }
}


