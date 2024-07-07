# car-search-application
This is a web application where you can search for cars given by certain criteria, and download the result as xml

## Running the application
1. Clone the Reposiroty
2. Ensure you have the Java (latest version) and Maven installed.
3. Update the 'application.properties' file with your database connection details. (details in nextsection ##Database Configuration and Setup)
4. Run the application using Maven command: mvn spring-boot:run
   Access the web application on http://localhost:8080/cars


## Database Configuration and Setup
This application uses Microsoft SQL Serever for storing car data.

1. Ensure you have Microsoft SQL Server installed and running.
2. Run the 'database_setup.sql' script located in the root directory of this repo to create the necessasry database and tables.
3. Update the 'application.properties' file with your local SQL server details:
	
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=car_db;encrypt=false <!-- Check port no. and modify if required -->
spring.datasource.username=your_username <!--Enter username used to connect to your local database -->
spring.datasource.password=your_password  <!--Enter password used to connect to your local database -->
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.database-platform=org.hibernate.dialect.SQLServer2012Dialect
spring.jpa.hibernate.ddl-auto=none


## Screen Shots from the Application

1. Search Page
![Screenshot 1](C:/Users/lenovo/OneDrive/Desktop/Screenshot_Search_Page_1.png)

1. Search Page with search criteria
![Screenshot 1](C:/Users/lenovo/OneDrive/Desktop/Screenshot_Search_Page_2.png)

2. Search Results Page
![Screenshot 1](C:/Users/lenovo/OneDrive/Desktop/Screenshot_Search_Result_Page_1.png)
