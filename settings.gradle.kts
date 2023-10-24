pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
      google()
      mavenCentral()
  }

  versionCatalogs {
      create("libs") {
        from(files("libs.versions.toml"))
      }

      create("testLibs") {
          from(files("testLibs.versions.toml"))
      }
  }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.7.0")
}

rootProject.name = "Diary"

include(":frontend:android:app")
include(":frontend:ios:app")
include(":frontend:multiplatform")