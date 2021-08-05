import org.jetbrains.compose.compose

plugins {
	kotlin("jvm")
	id("org.jetbrains.compose") version "1.0.0-alpha1"
}

repositories {
	maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

compose.desktop {
	application {
		mainClass = "org.jellyfin.sample.compose.MainKt"
	}
}

dependencies {
	// Depend on the library project
	implementation(projects.jellyfinCore)

	// Use Kotlin coroutines to interact with the library
	implementation(libs.kotlinx.coroutines)

	// Use Compose
	implementation(compose.desktop.currentOs)

	// Logging
	implementation(libs.slf4j.simple)
}
