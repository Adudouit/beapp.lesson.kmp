package fr.beapp.lesson.bicloo.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import fr.beapp.lesson.bicloo.databinding.CitySelectionActivityBinding
import fr.beapp.lesson.bicloo.logic.ContractEntity
import fr.beapp.lesson.bicloo.shared.Greeting
import fr.beapp.lesson.bicloo.ui.station.StationsActivity


class CitySelectionActivity : AppCompatActivity() {

    private val adapter = ContractsAdapter(this::onContractClicked)

    private lateinit var binding: CitySelectionActivityBinding
    private val viewModel: CitySelectionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set view
        binding = CitySelectionActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.contractRecyclerView.adapter = adapter

        binding.editText.addTextChangedListener {
            viewModel.searchForContract(it.toString())
        }
        viewModel.contracts.observe(this, adapter::replaceAll)
        viewModel.loadContracts()

        val greeting = Greeting().greeting()
        println("MSG FROM KMP = $greeting")
    }

    private fun onContractClicked(contractEntity: ContractEntity) {
        startActivity(StationsActivity.intent(this, contractEntity.name))
    }
}