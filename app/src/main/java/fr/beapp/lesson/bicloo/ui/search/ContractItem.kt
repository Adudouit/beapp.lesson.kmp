package fr.beapp.lesson.bicloo.ui.search

import androidx.recyclerview.widget.RecyclerView
import fr.beapp.lesson.bicloo.databinding.ContractItemBinding
import fr.beapp.lesson.bicloo.logic.ContractEntity

class ContractItem(private val binding: ContractItemBinding, private val onContractClicked: (ContractEntity) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(contract: ContractEntity) {
        binding.contractName.text = contract.name
        binding.root.setOnClickListener { onContractClicked(contract) }
    }
}