package com.khloud.FutureMovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.khloud.FutureMovies.R
import com.khloud.FutureMovies.ui.fragments.details.DetailsFragment
import com.khloud.FutureMovies.ui.fragments.explore.ExploreFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        deleteSubFolders(applicationContext.getExternalFilesDir(null)!!.absolutePath)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(mainBottomNav, navController)
    }


    private fun deleteSubFolders(path: String) {
        val currentFolder = File(path)
        val files: Array<File> = currentFolder.listFiles() ?: return
        for (f in files) {
            if (f.isDirectory) deleteSubFolders(f.toString())
            f.delete()
        }
    }

    override fun onBackPressed() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        with(navHostFragment!!.childFragmentManager.fragments[0]) {
            when (this){
                is ExploreFragment  -> checkCloseApp(this.onBackPressed())
                is DetailsFragment -> checkCloseApp(this.onBackPressed())
                else -> super.onBackPressed()
            }
        }
    }

    private fun checkCloseApp(close: Boolean){
        if(close)
            finish()
    }
}