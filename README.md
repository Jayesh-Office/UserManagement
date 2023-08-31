# UserManagement
This is user management springboot application.

Following are the apis endpoints- 
1. Login endpoint "/api/users/login" -  <br />
   This is a POST request and in this we have to pass "username" and "password" and in respose we get JWT token.  <br />

2. Get All User List "/api/users" -  <br />
   This is GET request to get the list of "Users".  <br />

3. Create User "api/users/create" -  <br />
   This is POST request and in this we have to pass the following JSON data in body.  <br />
   {
    "username": "xxx",
    "last_name":"xxx",
    "email":"xxx@gmail1.com",
    "mobile_number":"98xxxxxxxx",
    "status":"true",
    "password":"passxxxd"
  }  <br />

4. GetUserById "api/users/getById/{id}" -  <br />
   This is GET request to get the user by its "id".  <br />

5. Delete User "api/users/deleteById/{id}" -  <br />
   This is POST request to delete the user by its "id".  <br />

6. UpdateById "/api/users/updateById/{id}" -  <br />
   This is PUT request and in this we have to pass the following JSON data in body. <br />
   {
    "username": "xxx",
    "last_name":"xxx",
    "email":"xxx@gmail1.com",
    "mobile_number":"98xxxxxxxx",
    "status":"true",
    "password":"passxxxd"
  } <br />
   
