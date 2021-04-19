# Author: Gurpreet Singh
# Date: 17th April 2021
# Description: 
@SearchUsedCars, @Sanity
Feature: Search Used Cars Functionality
	Background:
		Given the user is on the home page
		
	Scenario Outline: Query for an existing Used Car and confirm the details shown for that car
		
		Given the user is on the used cars page
		When the user searches for a <carName> used car
		Then validate the <details> of the car are displayed on the screen
	
	Examples:
		| carName           | details |
		| 2008 Ford Transit | Number plate, Kilometres, Body, Seats |