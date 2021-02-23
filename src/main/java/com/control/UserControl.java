package com.control;

import com.obj.User;
import com.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserControl {
    public UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("{userId}")
    public ResponseEntity<User> findByUserId(@PathVariable int userId){
        User user = userService.findByUserId(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("street")
    public ResponseEntity<String> getStreetAddress(){
        String street = userService.getOneAddress();
        return new ResponseEntity<>(street, HttpStatus.OK);
    }
    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteUserByUserId(@PathVariable int userId){
        userService.deleteByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
