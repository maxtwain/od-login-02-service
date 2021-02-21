package com.control;

import com.entity.Address;
import com.entity.User;
import com.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    @GetMapping("street")
    public ResponseEntity<String> getStreetAddress(){
        System.out.println("mark 01");
        User user = userService.getOne();
        System.out.println("mark 02:");
        List<Address> addresses = new ArrayList<>(user.getAddresses());
        System.out.println("mark 03");
        Address address = addresses.get(0);
        System.out.println("mark 04");
        String street = address.getStreetAddress();
        System.out.println("mark 05");
        return new ResponseEntity<>(street, HttpStatus.OK);
    }

}
