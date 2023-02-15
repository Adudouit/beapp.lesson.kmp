package fr.beapp.lesson.bicloo.shared.rest

import fr.beapp.lesson.bicloo.shared.logic.ContractEntity
import fr.beapp.lesson.bicloo.shared.logic.StationEntity
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object DataSource {
    private const val rootUrl = "api.jcdecaux.com"
    private val client = HttpClient {
        install(HttpTimeout) {
            requestTimeoutMillis = 20_000L
            connectTimeoutMillis = 20_000L
            socketTimeoutMillis = 20_000L
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }

        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }

    }

    suspend fun getContracts(): List<ContractEntity> {
        val resultDTO : List<ContractDTO> = client
            .get("https://api.jcdecaux.com/vls/v3/contracts?apiKey=d94ebd2490a22f90451dbc3eb183b341acd0355d")
            .body()

        return resultDTO.map { it.toEntity() }
    }

    suspend fun getStationsOfCity(city: String): List<StationEntity> {
        return get<List<StationDTO>>(
            "stations",
            params = mapOf("contract" to city)
        ).map { it.toEntity() }
    }

    private suspend inline fun <reified T> get(
        path: String,
        params: Map<String, String?> = emptyMap()
    ): T {

        val response = client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = rootUrl //"api.jcdecaux.com"
                path("vls/v3")
                appendEncodedPathSegments(path)
                params.forEach { param -> param.value?.let { parameter(param.key, it) } }
                parameters.append("apiKey", "d94ebd2490a22f90451dbc3eb183b341acd0355d")
            }
        }

        return response.body()
    }

}

class HttpLogger : Logger {

    companion object {
        val DEFAULT: HttpLogger get() = HttpLogger()
    }

    override fun log(message: String) {
        println("[HTTP] $message")
    }
}