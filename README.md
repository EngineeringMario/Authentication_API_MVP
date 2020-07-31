# Authentication_API_MVP
Authenticating users with an access token

Hello and welcome to my Android app. I have proudly built a front end application for an API that retrieves cameras. Before accessing the API, the user must firstly log in with
a username and password. Additionally they must also submit an access token which authenticates them. This was the difficult part for me, because the API's I've played around
with didn't require authentication. It was certainly interesting learning how to do this because it's very much relevant in the IT world.

I will now discuss how I built the app. The app's architechture is MVP, Model, View, Presenter. I made use of Retrofit for interacting with the API. Three activities were
created: the login activity, where the login is done. The main activity where the recyclerview displays the JSON data objects (which are cameras
in this case), and finally the parcelable activity which displays the data of an individual object (our camera) in another activity screen.
