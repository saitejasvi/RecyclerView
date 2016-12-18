READ ME:

Extract the zip file into Android projects Workspace 
Start the Android Studio and ->open->Meettheteam
Run App
Open the main activity screen which lists all the members of the team in a recycler view and holds the information of each member in a cardview format.
click on any of the team members to see more details about them.
clicking on a particular view starts an othe activity which holds all the details of the member. (This view is made scrollable)
Pressing back button redirects you to the prevous screen listing all the members
pressing the back button yet again closes the app.

Layouts and views used:
->Recycler View
->Card View 
->Relative Layout
->Linear Layout

UI controls
->Text Views
->Image views

Action bar color: Royal Blue
Text color used: Steel Blue
Background: White

To download the images from URL:
->Added universal imageloader library for downloading images.
->Alternate 3rd party libraries like Picasso and Glide can also be used.
->Otherwise we can make a HTTPConnection and download the images using AsyncTask, Services,Threads,Loaders etc.
