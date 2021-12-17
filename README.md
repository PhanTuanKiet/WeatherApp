# WeatherApp
## Architure diagram
![architecture](https://camo.githubusercontent.com/959a6d988b607ed85a3c513a6f6c9c6cea849eafe52221dfe6ef93ca2265d8d5/68747470733a2f2f636f64696e67776974686d697463682e73332e616d617a6f6e6177732e636f6d2f7374617469632f626c6f672f382f6d76766d5f6172636869746563747572652e706e67)
## Project Structure
[![structure](https://i.postimg.cc/vBnHg6TD/stt.png)](https://postimg.cc/ph2t3rDt)
- Base: contains all base classes.
- Data: this folder for data layer related classes/dependencies
   - Local: Local data source (DB/SQLite)
   - Remote: remote data source (API)
   - Repository: the repository pattern to access the data source. We can handle what data source to get when there is an action from the View layer (currently there is only remote data source)
- DI ( Dependency Injection): this folder for dependency inject works. The more complicated the app, the more classes will be here 
- Model : contains data models of the app
- Network: network and all related model. 
- UI: the folder of View layer
- Utils : the folder of some utils like constants, date time converter, math...
- ViewModel: contains view models of the app

**Note**: because I don't apply the UseCase design so all UI business logics of the app are in ViewModel.
## Technical/Libraries
- Language: Kotlin
- Libs: Hilt, Retrofit, LiveData, View Binding, RxJava, Gson, Junit, Mockito.
