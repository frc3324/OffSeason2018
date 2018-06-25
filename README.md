# OffSeason2018
## Table of Contents
- [GradleRIO](https://github.com/frc3324/OffSeason2018#gradlerio)
  - [Essential Commands](https://github.com/frc3324/OffSeason2018#essential-commands)
  - [Other Commands](https://github.com/frc3324/OffSeason2018#other-important-commands-in-order-of-importance)
### GradleRIO
GradleRIO is a Gradle plugin that is developed by Jaci (@JacisNonsense). First and WPILib have seen great potential in GradleRIO and have made it the standard tool for deploying in the 2019 season. Many teams have incorporated GradleRIO before this change though, and it has far faster deploy and compile times while being far more versatile. GradleRIO has been setup now before the 2019 season and is yet to be tested on a robot.
#### Essential Commands
As this is our first year using GradleRIO I would like to put some important basic fundamentals here, for more information be sure to checkout the [GradleRIO Github](https://github.com/wpilibsuite/GradleRIO). Most of this is taken directly from the Github.
_Please, please use Powershell instead of cmd if on Windows_
- ```./gradlew deploy``` Deploys (and builds) the Robot code.
- ```./gradlew shuffleboard``` Launches the Shuffleboard (SmartDashboard replacement)
- ``` ./gradlew build deploy --offline``` **Deploys and builds while offline (AKA connected to the robot or at competition, important)**

#### Other Important Commands (in order of importance)
- ```./gradlew smartDashboard``` Launches SmartDashboard
- ```./gradlew build``` Will only build your robot code  
- ```./gradlew riolog``` Will display the RoboRIO console output on your computer (run with `-Pfakeds` if you don't have a driverstation connected).  
