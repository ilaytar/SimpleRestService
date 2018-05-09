Feature: Find Person in the list of Employees

Scenario: Find Person and verify his\her Job Title
	Given User logs in
	When User closes What is new in Telescope dialog
	And User navigates to All Employees in Telescope
	And User filters employees by city 'Lviv'
	And User filters employees by primary skill 'Automated Testing'
	And User goes through pages to find 'Iryna Laitar' in the list of employees
	Then User verifies Job Title of employee is 'Software Test Automation Engineer'