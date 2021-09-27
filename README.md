# Demo Price Calculator with Spring Boot & Angular

The price structure and Scenerio is as follows:

Grapes has 20 units per carton. A carton is 500
Apple is 5 units per carton, a carton is 400

* If you purchase single units,to compensate for manual labor the price is acquired using the carton price multiplied by an increase of 30%.
* If you purchase 3 cartons or more, you will receive a 10% discount off the carton price

* The calculation will determine the price of products for a store
* The price engine is to optimize the price (e.g: if you order 25 units and you have 20 units per
carton, the price will be set at 1 carton and 5 single units )

There is a GUI  to list the prices in a table, listing the actual prices for a product from 1-50 units
There is another GUI is to present a simple calculator which lets the user choose product and quantity of
either single units or cartons

Unit Tests are Written to Validate the Calculation Logic
Swagger is Used to API Documentation


# Instruction to Deploy the Application

1. Running the Backend

	i. Open Your Preffered IDE
	ii. Open Project from Existing sources
	iii. open src\main\resources\application-dev.properties and Update the "## Database Properties" Section according to your configuration
	iv. Run the project using IntelliJ
	v. You can navigate to localhost:8080/swagger-ui.html to see the API documentation

2. Running the Front end

	i. open "carton_frontend" from Terminal
	ii. Run "npm install" to install the neccesary packages
	iii. Run "ng s -o" to serve the page in the default browser
