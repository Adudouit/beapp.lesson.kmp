package fr.beapp.lesson.bicloo.logic

data class StationEntity(
    val number: Number,
    val name: String,
    val longitude: Number,
    val latitude: Number,
    val state: State,
    val address: String,
    val contractName: String
)

enum class State(val raw: String) {
    OPEN("OPEN"),
    CLOSED("CLOSED"),
    UNKNOWN("")
}
