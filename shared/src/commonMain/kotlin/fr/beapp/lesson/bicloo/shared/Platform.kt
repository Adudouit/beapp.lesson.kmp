package fr.beapp.lesson.bicloo.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform