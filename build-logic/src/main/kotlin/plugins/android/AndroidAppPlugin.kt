package plugins.android

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.AppPlugin
import extensions.catalog
import extensions.intVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension
import org.jetbrains.kotlin.gradle.model.KotlinAndroidExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinAndroidPluginWrapper
import plugins.lint.LintPlugin

class AndroidAppPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with (target) {
            apply<AppPlugin>()
            apply<KotlinAndroidPluginWrapper>()
            apply<LintPlugin>()

            configure<KotlinProjectExtension> {
                jvmToolchain(catalog().intVersion("jvmVersion"))
            }

            configure<KotlinAndroidProjectExtension> {
                compilerOptions {
                    allWarningsAsErrors.set(true)
                }
            }

            configure<ApplicationAndroidComponentsExtension> {
                finalizeDsl { applicationExtension ->
                    applicationExtension.compileSdk = catalog().intVersion("androidCompileSdk")

                    applicationExtension.defaultConfig {
                        minSdk = catalog().intVersion("androidMinSdk")
                        targetSdk = catalog().intVersion("androidTargetSdk")
                    }

                    applicationExtension.compileOptions {
                        kotlinExtension
                    }
                }
            }
        }
    }
}