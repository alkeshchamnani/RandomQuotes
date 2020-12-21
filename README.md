# Task-Random Quote

# Architecture Related
The app for built on Android Studio using Gradle build system
Kotlin programming language was used for the development
The MVVM architecture desgin patter was used for the development
Android's Architecture Components components were used to to acheive MVVM e.g LiveData, AndroidViewModel
Kotlins Coroutines were used asynchronous programming
Retrofit was used for Networking along with OkHttp
Room is used as a Database
# Task Related
Firstly When API is called the responce is considered as DTO.  then DTO is converted in DB Model and saved into room database. Then DTO is converted into UIModel.
Function in Repo is written in such a what that. When there is No Internet Connection. It returns random quotes from From Database and converted into UIModel.


![Repo](https://user-images.githubusercontent.com/28890660/88197266-44645780-cc53-11ea-98f6-0e4ef5e7850c.png)
