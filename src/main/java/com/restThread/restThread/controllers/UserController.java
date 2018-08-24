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

    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of users"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        }
    )
    @GetMapping(produces = "application/json")
    public List<User> getAll(){

        return userService.getAllUsers();
    }

    @GetMapping(path = "/search", produces = "application/json")
    public User getUser(@RequestParam String id){

        return userService.getUser(id);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public ResponseEntity addUser(@RequestBody User user){
        try{

            userService.addUser(user);

        } catch (Exception ex) {
            return ResponseEntity.status(WSHTTPConnection.INTERNAL_ERR).body(ex.getMessage());
        }

        return ResponseEntity.ok(user);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    public ResponseEntity updateUser(@RequestBody User user){
        try{

            userService.addUser(user);

        } catch (Exception ex) {
            return ResponseEntity.status(WSHTTPConnection.INTERNAL_ERR).body(ex.getMessage());
        }

        return ResponseEntity.ok(user);
    }
}
