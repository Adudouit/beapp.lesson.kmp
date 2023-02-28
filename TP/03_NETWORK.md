# NETWORK

### Part 1

## DTOs & entities
##### 1. Transfer all necessary data into the shared module


## Add Ktor dependencies
To use the Ktor HTTP client in your project, you need to add at least two dependencies: a client dependency and an engine dependency. Open the `shared/build.gradle.kts` file and follow the steps below:

##### 1. Specify Ktor version inside sourceSets:

```
sourceSets {
    val ktorVersion = "2.2.3"
}
```

##### 2. To use the Ktor client in common code, add the dependency to ktor-client-core to the commonMain source set:

```
val commonMain by getting {
    dependencies {
		implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    }
}
```

##### 3. Add an engine dependency for the required platform to the corresponding source set:
For Android, add the ktor-client-okhttp dependency to the androidMain source set:


```
val androidMain by getting {
    dependencies {
        implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    }
}

```

For iOS, add the ktor-client-darwin dependency to iosMain:

```
val iosMain by creating {
    dependsOn(commonMain)
    iosX64Main.dependsOn(this)
    iosArm64Main.dependsOn(this)
    iosSimulatorArm64Main.dependsOn(this)
    dependencies {
        implementation("io.ktor:ktor-client-darwin:$ktorVersion")
    }
}

```
##### 4. Add the serialization plugins & libs

```
plugins {
    kotlin("plugin.serialization").version("1.8.0")
}
```
```
val commonMain by getting {
    dependencies {

		implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")

		implementation("io.ktor:ktor-client-serialization:$ktorVersion")
		implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

}
```
## Make the first call
##### 1. Copy the `Contract` Dto & Entities in the shared module

##### 2. Create a RestDatsource object and add the `contracts` call

```
object RestDataSource {

	private val client = HttpClient()

	suspend fun getContracts(): List<ContractEntity> {
		client.get(....)
		// 
	}
}
```

#### 3. Replace the `RestManager` with the shared `RestDataSource` in the ViewModels
#### 4. Do the same for the other webservice

## Add some log
#### 1. add the dependency

```
implementation("io.ktor:ktor-client-logging:$ktor_version")
```
#### 2. install the plugin to the http client
[documentation](https://ktor.io/docs/client-logging.html#add_dependencies)

## Do the same on the iOS part

#### 1. Generate a new framework
#### 2. Delete all unecessary core & logic files
#### 3. Replace the ws calls by the ones from the shared module

### Part 2

#### 1. fix the interop issues
#### 2. fix the scope issues with the `internal` kotlin modifier
#### 2. Add the [dokka](https://kotlinlang.org/docs/dokka-get-started.html) plugin and generate the html documention



