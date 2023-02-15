package fr.beapp.lesson.bicloo.shared.logic

data class ContractEntity(
    val cities: List<String>?,
    val commercialName: String,
    val countryCode: String,
    val name: String
)