package com.example.navigatingbetweenscreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    // Поля для навигационного контроллера, конфигурации панели действий и боковой панели
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Находим навигационный контроллер во фрагменте в макете activity_main.xml
        navController = findNavController(R.id.fragmentContainerView3)

        // Находим боковую панель  и навигационное меню
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        // Связываем навигационное меню с навигационным контроллером
        navigationView.setupWithNavController(navController)

        // Создаем конфигурацию панели действий, связывая ее с графом навигации и боковой панелью
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        // Настраиваем панель действий (ActionBar) с навигационным контроллером и конфигурацией
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    // Обработка нажатия на кнопку "Домой" или элементы навигационного меню
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView3)

        // Обрабатываем навигацию вверх, используя навигационный контроллер и конфигурацию панели действий
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
