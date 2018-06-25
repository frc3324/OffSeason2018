# OffSeason2018

## GradleRIO
GradleRIO is a Gradle plugin that is developed by Jaci (@JacisNonsense). First and WPILib have seen great potential in GradleRIO and have made it the standard tool for deploying in the 2019 season (before it was the Eclipse tools which in my opinion were limiting and inefficient but I digress). Many teams have incorporated GradleRIO before this change though, and it has far faster deploy and compile times while being far more versatile (especially when it comes to 3rd party libraries). GradleRIO has been setup now before the 2019 season and is yet to be tested on a robot (line will be removed after 2019 season begins and deploying has been successful).
##GradleRIO Basics and Commands
As this is our first year using GradleRIO I would like to put some important basic fundamentals here, far more details at the GradleRIO Github. A large amount of this is taken directly from the Github.
###### Essential Commands
**Please, please use Powershell instead of cmd if on Windows**
- ```./gradlew deploy``` Deploys (and builds) the Robot code.
- ```./gradlew shuffleboard``` Launches the Shuffleboard (SmartDashboard replacement)
- ``` ./gradlew build deploy --offline``` **Deploys and builds while offline (AKA connected to the robot or at competition, important)**

###### Other Important Commands (in order of importance)
- ```./gradlew smartDashboard``` Launches SmartDashboard
- ```./gradlew build``` Will only build your robot code  
- ```./gradlew riolog``` Will display the RoboRIO console output on your computer (run with `-Pfakeds` if you don't have a driverstation connected).  
