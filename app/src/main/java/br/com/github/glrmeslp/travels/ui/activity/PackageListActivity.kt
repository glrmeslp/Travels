package br.com.github.glrmeslp.travels.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import br.com.github.glrmeslp.travels.R
import br.com.github.glrmeslp.travels.dao.PackageDAO
import br.com.github.glrmeslp.travels.model.Package
import br.com.github.glrmeslp.travels.ui.adapter.PackageListAdapter

class PackageListActivity : AppCompatActivity() {

    private lateinit var lvPackage: ListView
    private val tittleAppBar = "Packages"

    companion object {
        const val keyPackage: String = "package"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_list)
        title = tittleAppBar
        configurePackageList()


    }

    private fun configurePackageList() {
        lvPackage = findViewById(R.id.lv_package)
        lvPackage.adapter = PackageListAdapter(PackageDAO().packages)
        configureItemClick()
    }

    private fun configureItemClick() {
        lvPackage.onItemClickListener = AdapterView.OnItemClickListener{_,_,position,_ ->
            val packageTravel: Package = PackageDAO().packages[position]
            openPackageSummary(packageTravel)
        }
    }

    private fun openPackageSummary(packageTravel: Package) {
        startActivity(
            Intent(
                this,
                PackageSummaryActivity::class.java
            ).apply {
                putExtra(keyPackage, packageTravel)
            }
        )
    }
}