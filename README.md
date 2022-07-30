# Aboard-The-Cruise-Ship_Local

Created an Android Full-Stack App for Cruise companies to efficiently manage, track, manipulate, and share all Information for the company's Cruises!

Utilized:
- The SQLiteOpenHelper Android interface 
- The SQLiteDatabase Android class <br>

To implement CRUD operations using SQL Queries, String.format() statements, Android Content Values, Android rawQuery Cursors, and SQLiteDatabase's delete() & update() functions with @Overriden implementations.

Going on a Cruise! Use the App!
<br>


### Gif#1: Add A New Passenger To The Cruise
#### By creating an SQLite Writeable database instance, the app collects user entered data and add to the connected SQLite Databases.
<p align="center">
  <img src="http://g.recordit.co/bkuUUyauUM.gif" alt="animated" />
</p>

### Gif#2: Updating Passenger Information
#### Using the Passenger's unique ID, we can alter any Passenger specific data that were originally entered by the user 
<p align="center">
  <img src="http://g.recordit.co/DUXzFxN2K6.gif" alt="animated" />
</p>

### Gif#3: Remove The Passenger From The Cruise Database
#### Using the Passenger's unique Passport Number, we can search the Cruise Database for such a record.
#### If such a record is found, delete record from the Database and return a int flag.
<p align="center">
  <img src="http://g.recordit.co/wSqupJBU1o.gif" alt="animated" />
</p>
