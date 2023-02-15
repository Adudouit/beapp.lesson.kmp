package fr.beapp.lesson.bicloo.shared.rest

import fr.beapp.lesson.bicloo.shared.logic.ContractEntity

@kotlinx.serialization.Serializable
class ContractDTO {

    var cities: List<String>? = null
    var commercial_name: String? = null
    var country_code: String? = null
    var name: String = ""

    fun toEntity(): ContractEntity = ContractEntity(cities, commercial_name?:"", country_code?:"", name)
}