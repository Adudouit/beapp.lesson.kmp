# Database

## Add [SQLDelight](https://cashapp.github.io/sqldelight/2.0.0-alpha05/) dependencies

```
plugins {
   id("app.cash.sqldelight") version "2.0.0-alpha05"
}
```

add the *drivers*

```
val androidMain by getting {
	dependencies {
	    implementation("app.cash.sqldelight:android-driver:2.0.0-alpha05")
	}
}
val iosMain by creating {
    dependencies {
        implementation("app.cash.sqldelight:native-driver:2.0.0-alpha05")
    }
}
```

## Declare the db in the gradle

```
sqldelight {
  databases {
    create("Database") {
      packageName.set("com.example")
    }
  }
}
```

- Create the `src/commonMain/sqldelight/com/example/ ` folder and create the `Station.sq` & `Contract.sq` 
- create the tables
- add the `insert` & `selects` methods 
- build the project to generate the sqldelight classes
- apply each proper *drivers*

## Use flows

- using `flows`, rework the ws method calls to send back either local or async datas for android & iOS

