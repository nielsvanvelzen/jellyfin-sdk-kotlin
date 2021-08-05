enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

// Core
include(":jellyfin-core")
include(":jellyfin-model")
include(":jellyfin-api")

// Platforms
include(":jellyfin-platform-android")

// Code generation
include(":openapi-generator")

// Samples
include(":samples:compose")
include(":samples:kotlin-cli")
include(":samples:java-cli")

// Add Compose plugin repository
pluginManagement {
	repositories {
		gradlePluginPortal()
		maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
	}
}
