package fr.beapp.lesson.bicloo.core.rest

import fr.beapp.lesson.bicloo.logic.State
import fr.beapp.lesson.bicloo.logic.StationEntity

class StationDTO {
    var number: Int = 0
    var name: String = ""
    var position: PositionDTO = PositionDTO(0.0, 0.0)
    var status: String = ""
    var address: String = ""
    var contractName: String = ""

    fun toEntity(): StationEntity {
        println("STATION $name -> $status")
        return StationEntity(number, name, position.longitude, position.latitude, State.valueOf(status), address, contractName)
    }

    data class PositionDTO(val latitude: Double, val longitude: Double)
}


