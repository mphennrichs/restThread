package com.restThread.restThread.controllers;

import com.restThread.restThread.domain.User;
import com.restThread.restThread.services.UserService;
import com.sun.xml.internal.ws.transport.http.WSHTTPConnection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@Api(value="user", description="Operations related to user management.")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Retrieve a list of all users",response = Iterable.class)
    public List<User> getAll(){

        return userService.getAllUsers();
    }

    @GetMapping(path = "/search", produces = "application/json")
    @ApiOperation(value = "Retrieve user by id",response = User.class)
    public User getUser(@RequestParam Long id){

        return userService.getUser(id);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    @ApiOperation(value = "Add a user and return the same user if the operation succeeds",response = User.class)
    public ResponseEntity addUser(@RequestBody User user){
        try{

            userService.addUser(user);

        } catch (Exception ex) {
            return ResponseEntity.status(WSHTTPConnection.INTERNAL_ERR).body(ex.getMessage());
        }

        return ResponseEntity.ok(user);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    @ApiOperation(value = "Update user data and return the same user if the operation succeeds",response = User.class)
    public ResponseEntity updateUser(@RequestBody User user){
        try{

            userService.addUser(user);

        } catch (Exception ex) {
            return ResponseEntity.status(WSHTTPConnection.INTERNAL_ERR).body(ex.getMessage());
        }

        return ResponseEntity.ok(user);
    }
}
