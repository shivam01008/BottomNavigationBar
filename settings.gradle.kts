pluginManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
        maven {
            name = "GitHubPackages"
            url = uri("https://jitpack.io")  // JitPack repository
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven {
            name = "GitHubPackages"
            url = uri("https://jitpack.io")
        }
    }
}

rootProject.name = "UrHeath"
include(":app")
include(":network")
include(":BttomNavigationBar")
