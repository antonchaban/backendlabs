# Basic REST API application for Cost Accounting

### [**Link to heroku**](https://heroku-backend-dockerlab.herokuapp.com)
### [Link to Postman Queries](https://github.com/antonchaban/backendlabs/blob/master/postmanqueries.json)
### [Link to Heroku view categories](https://heroku-backend-dockerlab.herokuapp.com/api/v1/categories/)

## Endpoints:

### Create User:
* **URL:** /api/v1/users
* **Method:** POST
* **Body:**
```json
  {
  "username": "Antoha"
  }
```
### Create category
* **URL:** /api/v1/categories/
* **Method:** POST
* **Body:**
```json
  {
  "categoryName": "War"
  }
  ```
### Create record
* **URL:** /api/v1/records?customerID=5&categoryID=17
* **Method:** POST
* **Body:**
```json
{
  "customerID": "6",
  "categoryID": "14",
  "moneySpent": "433"
}
  ```
### Get categories
* **URL:** /api/v1/categories/
* **Method:** GET

### Get user's records
* **URL:** /api/v1/users/{userID}/records
* **Method:** GET

### Get user's records by category
* **URL:** /api/v1/users/{userID}/categories/{categoryID}/records
* **Method:** GET

### Get all records
* **URL:** /api/v1/records
* **Method:** GET

## Heroku link

### For example link to view all records:
``` https://heroku-backend-dockerlab.herokuapp.com/api/v1/records ```

## How to run locally

* Clone this repository 
* Build .jar file by running
```
  ./mvnw clean install -DskipTests=true
```
* Run Docker Compose using
```
docker-compose up
```
* To stop - press Ctrl + C
* To remove containers: ``` docker-compose down ```
#### If you have troubles with build version
1. Remove docker images (``` docker rmi ```)
2. Delete target folder (manually or ```./mvnw clean```)
3. Then build again and run docker compose

 
