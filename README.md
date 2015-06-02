# Overview
As part of the Hotels.com content team, we have a service which provides hotel information and availability.

This a legacy system and is currently missing tests. 

Using the following business requirements listed below, use any Java library to create a suite of automated tests to interrogate the HotelService class. 


# Business Requirements
Use Cases:

## Lookup a hotel by Id
* Id must be in the following format XXnnnnnn, where XX are a pair of upper alpha chars and nnnnnn are a range (min 4, max 9) of digits.  
* An IllegalArgumentException should be thrown if a validation error occurs
* A missing hotel will return an Optional.empty()

## Find available hotels by date
* Date must be in the format DDMMYYYY (01012015)
* An IllegalArgumentException will be thrown if a validation error occurs
* If there are no hotels available, an empty list will be returned

# Background
* HotelService uses an AvailabilityService which is not maintained by our team, but has a well defined interface.
* The availability provides ranges of dates where the hotel may be booked.
* The hotels exist in a DB, and we have provided an empty, in memory implementation for running with the automated build.
* There have been reports that some parts of the application are not working as expected.

# Note
* This project requires Java 8

