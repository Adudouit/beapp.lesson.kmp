package fr.beapp.lesson.bicloo.shared.logic

data class StationEntity(
    val number: Number,
    val name: String,
    val longitude: Double,
    val latitude: Double,
    val state: State,
    val address: String,
    val contractName: String
)

enum class State(val raw: String) {
    OPEN("OPEN"),
    CLOSED("CLOSED"),
    UNKNOWN("")
}
