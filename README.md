# UserManagement. <br />

# This is user management springboot application.<br />

# To Run this Application follow the below steps.<br />
1. Please download or clone the project.
2. Open the project in your favourite code editor.
3. After successfully scanning the index file by code editor please go to UserdetailstestApplication file and Run the file.

# Database
In this project for Database we have used Postgres.
Please change/modify the "application.properties" as per your Database configuration. 


Following are the apis endpoints- 
1. Login endpoint "/api/users/login" -  <br />
   This is a POST request and in this we have to pass "username" and "password" and in respose we get JWT token.  <br />

2. Get All User List "/api/users" -  <br />
   This is GET request to get the list of "Users".  <br />

3. Create User "api/users/create" -  <br />
   This is POST request and in this we have to pass the following JSON data in body.  <br />
   { <br />
    "username": "xxx", <br />
    "last_name":"xxx", <br />
    "email":"xxx@gmail1.com", <br />
    "mobile_number":"98xxxxxxxx", <br />
    "status":"true", <br />
    "password":"passxxxd" <br />
  }  <br />

4. GetUserById "api/users/getById/{id}" -  <br />
   This is GET request to get the user by its "id".  <br />

5. Delete User "api/users/deleteById/{id}" -  <br />
   This is POST request to delete the user by its "id".  <br />

6. UpdateById "/api/users/updateById/{id}" -  <br />
   This is PUT request and in this we have to pass the following JSON data in body. <br />
   { <br />
    "username": "xxx", <br />
    "last_name":"xxx", <br />
    "email":"xxx@gmail1.com", <br />
    "mobile_number":"98xxxxxxxx", <br />
    "status":"true", <br />
    "password":"passxxxd" <br />
  } <br />

  # Thnak you. <br />
   
