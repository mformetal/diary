plugins {
    id("multiplatform")
}

multiplatform {
    serialization()

    android {
        namespace("metal.diary.listentries.ui")

        main {
            dependencies {
                implementation(libs.android.compose.runtime)
                implementation(libs.koin.android)
                implementation(libs.android.compose.material)
                implementation(libs.android.compose.material3)
                implementation(libs.android.compose.navigation)
                implementation(libs.android.compose.runtime)
                implementation(libs.android.compose.viewmodel)
                implementation(libs.koin.android.compose)

                implementation(projects.addNote.nav)
                implementation(projects.home.nav)
            }
        }
    }

    common {
        main {
            dependencies {
                api(projects.viewmodel)

                implementation(projects.dto)
                implementation(projects.network)
            }
        }

        test {
            dependencies {

            }
        }
    }
}