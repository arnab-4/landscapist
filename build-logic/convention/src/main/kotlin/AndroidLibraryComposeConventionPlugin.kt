/*
 * Designed and developed by 2020-2022 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.android.build.gradle.LibraryExtension
import com.skydoves.landscapist.configureAndroidCompose
import com.skydoves.landscapist.configureKotlinAndroid
import com.skydoves.landscapist.kotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      pluginManager.apply("com.android.library")
      pluginManager.apply("org.jetbrains.kotlin.android")
      pluginManager.apply("binary-compatibility-validator")
      pluginManager.apply("org.jetbrains.dokka")

      extensions.configure<LibraryExtension> {
        configureKotlinAndroid(this)
        configureAndroidCompose(this)

        kotlinOptions {
          freeCompilerArgs = freeCompilerArgs + listOf("-Xexplicit-api=strict")
        }
      }
    }
  }
}
