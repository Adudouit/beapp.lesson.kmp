package fr.beapp.lesson.bicloo.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.beapp.lesson.bicloo.databinding.ContractItemBinding
import fr.beapp.lesson.bicloo.databinding.StationItemBinding
import fr.beapp.lesson.bicloo.logic.ContractEntity

class ContractsAdapter(private val onContratClicked: (ContractEntity) -> Unit) : RecyclerView.Adapter<ContractItem>() {

    private val contracts = mutableListOf<ContractEntity>()

    fun replaceAll(contracts: List<ContractEntity>) {
        this.contracts.clear()
        this.contracts.addAll(contracts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContractItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ContractItem(ContractItemBinding.inflate(layoutInflater, parent, false), onContratClicked)
    }

    override fun onBindViewHolder(holder: ContractItem, position: Int) = holder.bind(contracts[position])

    override fun getItemCount(): Int = contracts.size
}