# TESTS

## Add the tests dependencies

```
kotlin {
    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
            }
        }
        val androidTest by getting

        val androidAndroidTest by getting {
            dependencies {
                implementation("androidx.test.ext:junit:1.1.5")
                implementation("androidx.test.ext:junit-ktx:1.1.5")
                implementation("androidx.test.espresso:espresso-core:3.5.1")
            }
        }

        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "fr.beapp.lesson.bicloo.shared"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

```

## Create the tests

- using the proper sourceSets, implements some platform specific tests on the file storage