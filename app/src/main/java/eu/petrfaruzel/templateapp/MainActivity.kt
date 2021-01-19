package eu.petrfaruzel.templateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import eu.petrfaruzel.templateapp.utils.ThemeManager
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var navController : NavController
    private lateinit var bottomBar : AnimatedBottomBar

    private lateinit var toolbarButtonsContainer : LinearLayout

    private val rootNavigationItems = setOf(
        R.id.nav_main,
        R.id.nav_settings,
        // TODO -> Add all root nav items
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ThemeManager.applyActiveTheme(this)
        setContentView(R.layout.activity_main)

        setupNavigationWithToolbar()
    }

    private fun setupNavigationWithToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val drawer = findViewById<NavigationView>(R.id.drawer_main_left)
        bottomBar = findViewById(R.id.bottom_bar)

        //https://stackoverflow.com/questions/50502269/illegalstateexception-link-does-not-have-a-navcontroller-set
        navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        appBarConfiguration = AppBarConfiguration(rootNavigationItems, drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)
        drawer.setupWithNavController(navController)

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        bottomBar.setupWithNavController(menu, navController)

        // Hide top navigation items
        for (item in rootNavigationItems) menu.findItem(item)?.isVisible = false

        return true
    }

    private fun setupBottomBar(){

    }

    fun setToolbarButtonsVisible(value: Boolean){
        if(value) toolbarButtonsContainer.visibility = View.VISIBLE
        else toolbarButtonsContainer.visibility = View.INVISIBLE
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}