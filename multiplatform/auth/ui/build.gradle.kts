plugins {
    id("multiplatform")
}

multiplatform {
    android {
        namespace("metal.diary.auth.ui")

        main {
            dependencies {
                implementation(libs.android.compose.runtime)
                implementation(libs.koin.android)
                implementation(libs.android.compose.material)
                implementation(libs.android.compose.navigation)
                implementation(libs.android.compose.runtime)
                implementation(libs.android.compose.viewmodel)
                implementation(libs.koin.android.compose)
                implementation(projects.home.nav)
            }
        }
    }

    common {
        main {
            dependencies {
                implementation(libs.coroutines.core)
                implementation(libs.koin)
                implementation(libs.ktor.client)
                api(projects.viewmodel)
            }
        }

        test {
            dependencies {
                implementation(libs.kotest.assertions.core)
                implementation(libs.kotest.framework.engine)
                implementation(libs.kotest.property)
            }
        }
    }
}