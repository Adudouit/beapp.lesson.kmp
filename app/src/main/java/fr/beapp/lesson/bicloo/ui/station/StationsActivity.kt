package fr.beapp.lesson.bicloo.ui.station

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import fr.beapp.lesson.bicloo.databinding.StationsActivityBinding
import fr.beapp.lesson.bicloo.shared.logic.StationEntity

class StationsActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_CONTRACT_NAME = "EXTRA_CONTRACT_NAME"
        fun intent(context: Context, contract: String) = Intent(context, StationsActivity::class.java)
            .putExtra(EXTRA_CONTRACT_NAME, contract)
    }

    private val adapter = StationsAdapter(this::onStationClicked)
    private val viewModel by viewModels<StationsViewModel>()
    private val contractName: String by lazy { intent.getStringExtra(EXTRA_CONTRACT_NAME) ?: throw Exception("Requires a contract name") }
    private lateinit var binding: StationsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StationsActivityBinding.inflate(layoutInflater)
        binding.stationsFragmentRecyclerView.adapter = adapter
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    override fun onResume() {
        super.onResume()
        viewModel.stations.observe(this, adapter::replaceAll)
        viewModel.loadAllStations(contractName)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun onStationClicked(station: StationEntity) {
        println("Station ${station.name} selected")
    }

}