import extensions.includeLibraryAs

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from(files("build-logic/gradle/libs.versions.toml"))
        }
    }
}

plugins {
    id("settings")
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "Diary"

includeLibraryAs(":android:app", "android/app")

includeLibraryAs(":add-entry:dto", "multiplatform/add-entry/dto")
includeLibraryAs(":add-entry:nav", "multiplatform/add-entry/nav")
includeLibraryAs(":add-entry:ui", "multiplatform/add-entry/ui")
includeLibraryAs(":auth:dto", "multiplatform/auth/dto")
includeLibraryAs(":auth:nav", "multiplatform/auth/nav")
includeLibraryAs(":auth:ui", "multiplatform/auth/ui")
includeLibraryAs(":home:nav", "multiplatform/home/nav")
includeLibraryAs(":list-entries:nav", "multiplatform/list-entries/nav")
includeLibraryAs(":list-entries:ui", "multiplatform/list-entries/ui")
includeLibraryAs(":network", "multiplatform/network")
includeLibraryAs(":viewmodel", "multiplatform/viewmodel")
includeLibraryAs(":dto", "multiplatform/dto")

include(":backend")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")