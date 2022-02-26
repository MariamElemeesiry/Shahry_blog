<p align="center">
  <a href="#requirements">Requirements</a> •
  <a href="#Task">Task</a> •
  <a href="#Challenges">Challenges</a> •
  <a href="#Thoughts">Thoughts</a> 
</p>

# Requirements

● Kotlin or Java.<br />
● High code quality and reusability.<br />
● Clean architecture using design pattern (MVVM or MVI).<br />
● Proper unit, ideally measured.<br />
● Care about the internet connection and the status for each API request.<br />
● Some type of caching is necessary like if there's no internet connection so you'll list the
previous cached list.<br />
● The UI is fitting in different screen resolutions.<br />
● Data Binding if you'll use XML for UI.<br />
● Git flow.<br />
● Coroutines with flow or RX (your choice and show to us in the readme why do you prefer it).<br />
● We prefer to code review commit per commit, and to do so, we will need ideally a private
GitHub/Bitbucket repo.<br />

# Task

We need you do develop a client app for our new micro blogging platform.<br />
This list represents a high level user interactions available in the app:<br />
On entry you're taken to the list of authors with their avatar, where clicking on an author you get
to the details screen<br />
On the author details screen there is :<br />
A header with the author's details available<br />
A listing of all the posts written by this author (title, date, body ...)<br />
The needed API endpoints are described here: https://sym-json- server.herokuapp.com<br />

# Challenges

● Task Required using too many libraries and lots of cases to handle.<br />
● this would be suitable for 5 days of work but I only had 2 days to work on (already have job)
. <br />
● taking decision of what to use in a very short time and may change mind while implementing and
collecting requirements. <br />
● used lots of work around to balance between submitting requirements and creating a presentable
application. <br />

# Thoughts

● overall I enjoyed working on such a task that require using lot's of libraries and tools some of
theme I did'nt had the chance to use before.<br />
● I always wanted to experience using Coroutines because I knew it's easier than RX and has lots of
features so tried to use it in few places like in paging.<br />
● That was my first project using hilt for DI (used only for small parts in previous apps).<br />
● didn't have time to read more about Jetpack data store for caching so went for RoomDB.<br />
● didn't have time implement TDD app and show how I write test cases but tried to implement the base
for it in my app like making interfaces for repositories and data sources.<br />
● didn't have time for handling more of network connection exceptions.<br />
● didn't have time for caching images.<br />
● didn't have time handling empty data in UI as easy as it was (just to check lists size and create
layout for it).<br />


