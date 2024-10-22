NIT3213 Android Application Project

Overview

This is an Android application project developed for the NIT3213 course assignment. The application demonstrates proficiency in Android development, including API integration, dependency injection using Hilt, and UI development with RecyclerView. The app contains Login, Dashboard, and Details screens to interact with the user, providing a seamless experience.

Features

Login Screen: Users can log in using their first name and student ID. The credentials are verified using an API call.

Dashboard Screen: After logging in, users are presented with a list of entities fetched from the server, displayed using a RecyclerView.

Details Screen: Provides detailed information for an entity selected from the Dashboard screen.

Technologies Used

Kotlin: The main programming language for Android development.

Android Studio: Integrated Development Environment (IDE) for Android.

Retrofit: HTTP client for API interaction.

Hilt: Dependency injection to manage dependencies efficiently.

ViewModel & LiveData: Manage UI-related data in a lifecycle-aware manner.

RecyclerView: Display list data efficiently.

ConstraintLayout: Flexible UI design.

Project Structure

app/src/main/java/com/example/nit3213app: Contains all Kotlin files related to the app, including Activities, ViewModels, and Adapters.

di/: Dependency injection setup using Hilt.

network/: Defines API services using Retrofit.

utils/: Utility classes such as PreferenceHelper for managing shared preferences.

res/: XML resource files for UI elements, strings, colors, and themes.

API Integration

The app interacts with a server using the following endpoints:

Login Endpoint: Authenticates user credentials.

Dashboard Endpoint: Retrieves a list of entities that the user can explore further.

API Base URL

https://nit3213-api-h2b3-latest.onrender.com

Setup Instructions

Prerequisites

Android Studio (latest version recommended).

Kotlin development experience.

An active internet connection.

Steps to Setup

Clone the Repository

git clone <repository-url>

Open in Android Studio

Launch Android Studio and select Open an existing project.

Navigate to the folder where the project was cloned.

Sync and Build the Project

Make sure to sync Gradle by clicking Sync Now at the top of the IDE.

If you encounter any errors, ensure that Gradle is updated as outlined below.

Run the Project

Connect an Android device or use an emulator to run the app.

Click the green Run button in Android Studio.

App-level Dependencies

Retrofit for API communication.

Hilt for dependency injection.

Lifecycle Components (ViewModel & LiveData) for managing UI data.

Material Components for designing modern UI.
