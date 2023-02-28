# Dependencies injection

## Add [Kodein](https://kosi-libs.org/kodein/7.18/index.html) dependencies


```
val commonMain by getting {
    dependencies {
        implementation("org.kodein.di:kodein-di:7.18.0")
    }
}
```

- replace `object` with `class` in managers

- implement kodein to use di inside the shared module