# Fitter - Twitter Filtering API in Java
Created by [David Sudia](https://github.com/dsudia), [Rachel Koldenhoven](https://github.com/rachelkoldenhoven) and [Ben Hernandez](https://github.com/benaychh)
## Uses and Users
Fitter is a standalone API. It can be used to filter tweets in a variety of ways and send those filtered tweets on to a front-end client. Its users are people who want to build a client that can present these filtered tweets to end-users.

## Technologies Involved
Fitter is built in Java using the Spring IO platform. Specifically, it uses Spring Data to access a Mongo database, Spring Framework to handle route mapping, and Spring Session to manage connections. It also uses Twitter's HoseBird Client to access Twitter's 1% public firehose of tweets.

## Features
Fitter filters tweets by geolocation, keyword (both in the body and hash tags) and/or semantic analysis depending on query parameters sent in a GET request. It opens up a websocket and continues to steam tweets matching the selected filters until the connection is closed by the client.

## Project Tracking
[Pivotal Tracker](https://www.pivotaltracker.com/n/projects/1572541)
