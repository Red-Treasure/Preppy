# Preppy - Your Smart Kitchen Assistant

![Project Status](https://img.shields.io/badge/status-in%20development-yellow)
![Platform](https://img.shields.io/badge/platform-Android%20%7C%20iOS%20%7C%20Desktop-blue)
![Kotlin Version](https://img.shields.io/badge/Kotlin-2.0.0-blueviolet)

Preppy is a modern, multiplatform application designed to streamline home kitchen management. It helps you keep track of your food inventory, create and organize recipes, plan your meals, and automatically generate grocery lists.

## ✨ Features

-   **Inventory Management:** Keep a real-time log of all your food items. Track quantities, purchase dates, and expiration dates to reduce food waste.
-   **Recipe Book:** A digital home for all your favorite recipes, easily accessible and organizable.
-   **Meal Planner:** Plan your meals for the week or month, and automatically see which ingredients you have and which you need.
-   **Smart Grocery List:** Automatically generates a shopping list based on your meal plan and current inventory levels.

## 🚀 Project Status & Roadmap

This project is currently in the initial development phase. The following table tracks the high-level roadmap. You can find detailed tasks in our [GitHub Project Board](https://github.com/users/Red-Treasure/projects/1).

| Epic                                 | Status      | Key Issues                                                                                                                                          |
| ------------------------------------ | ----------- |-----------------------------------------------------------------------------------------------------------------------------------------------------|
| **Foundational Setup** | **Next Up** | [#55](https://github.com/Red-Treasure/preppy/issues/55) Implement Multiplatform Logging                                                             |
| **UI/UX Enhancements** | Planned     | [#2](https://github.com/Red-Treasure/preppy/issues/56) Implement Theme Picker (Light/Dark/System)                                                   |
| **Core Inventory Functionality** | Planned     | [#3](https://github.com/Red-Treasure/preppy/issues/12) Implement Delete, [#4](https://github.com/Red-Treasure/preppy/issues/13) Implement Update    |
| **Data Model V2 (Type Safety)** | Planned     | [#5](https://github.com/Red-Treasure/preppy/issues/22) Type-Safe Units, [#6](https://github.com/Red-Treasure/preppy/issues/27) Add Thresholds       |
| **Data Model V3 (Categorization)** | Planned     | [#7](https://github.com/Red-Treasure/preppy/issues/36) Item Categories, [#8](https://github.com/Red-Treasure/preppy/issues/41) Nutritional Details  |
| **Foundational Business Logic** | Planned     | [#9](https://github.com/Red-Treasure/preppy/issues/47) Barcode Service, [#10](https://github.com/Red-Treasure/preppy/issues/52) Inventory Query API |
| **Recipe Module** | Planned     | TBD                                                                                                                                                 |
| **Meal Planner & Grocery List** | Planned     | TBD                                                                                                                                                 |

## 🛠️ Tech Stack

This project is built with a modern, multiplatform technology stack:

-   **Language:** [Kotlin](https://kotlinlang.org/)
-   **Framework:** [Kotlin Multiplatform (KMP)](https://kotlinlang.org/docs/multiplatform-mobile-getting-started.html)
-   **UI:** [Jetpack Compose for Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
-   **Local Database (Android):** [AndroidX Room](https://developer.android.com/training/data-storage/room)
-   **Shared ViewModels:** [JetBrains Lifecycle/ViewModel for KMP](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-viewmodel.html)
-   **Date/Time Handling:** [kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime)

## ⚙️ Getting Started

### Prerequisites

-   [Android Studio](https://developer.android.com/studio) (latest version recommended)
-   JDK 17 or higher
-   For the iOS target: a Mac with Xcode

### Building the Project

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Red-Treasure/preppy.git](https://github.com/Red-Treasure/preppy.git)
    cd preppy
    ```

2.  **Open in Android Studio:**
    -   Open Android Studio and select "Open" or "Open an Existing Project".
    -   Navigate to and select the cloned `preppy` directory.

3.  **Sync Gradle:**
    -   Wait for Android Studio to index the files and sync the project with Gradle. This may take a few minutes.

4.  **Build the Android App:**
    -   The best way to ensure all dependencies are downloaded and the code is compiled is to run the `assembleDebug` Gradle task.
    -   In the Gradle tool window on the right, navigate to `Preppy -> composeApp -> Tasks -> build -> assembleDebug`. Double-click to run it.

5.  **Run on a Device/Emulator:**
    -   Select the `composeApp` run configuration from the dropdown at the top of Android Studio.
    -   Choose your connected Android device or an emulator.
    -   Click the "Run" button (▶️).
