pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Stadiumo"
include(":app")
include(":core-network")
include(":core-utils")
include(":core-design")
include(":authorization-api")
include(":authorization-impl")
include(":core-preferences")
include(":home-api")
include(":home-impl")
include(":core-module-injector")
include(":stadium-detail-api")
include(":stadium-detail-impl")
include(":core-deeplink")
