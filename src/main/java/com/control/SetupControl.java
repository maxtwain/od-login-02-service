package com.control;

import com.obj.Address;
import com.obj.Credential;
import com.obj.User;
import com.obj.UserType;
import com.service.AddressService;
import com.service.CredentialService;
import com.service.UserService;
import com.service.UserTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("setup")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SetupControl {
    public AddressService addressService;
    public CredentialService credentialService;
    public UserService userService;
    public UserTypeService userTypeService;

    @PostMapping
    public ResponseEntity<String> setup(){
        UserType userType1 = new UserType("general");
        UserType userType2 = new UserType("moderator");
        UserType userType3 = new UserType("admin");
        UserType userType4 = new UserType("tester");
        userTypeService.save(userType1);
        userTypeService.save(userType2);
        userTypeService.save(userType3);
        userTypeService.save(userType4);

        Address address1 = new Address("4314 Parkway Street",
                "Barstow", "92311", "CA");
        Address address2 = new Address("674 Jacobs Street",
                "Pittsburgh", "15212", "PA");
        Address address3 = new Address("1536 Essex Court",
                "Fairlee", "05045", "VT");
        Address address4 = new Address("862 Richards Avenue",
                "Tracy", "95376", "CA");
        Address address5 = new Address("2579 Sherman Street",
                "Hope", "67451", "KS");
        List<Address> addressSet1 = Collections.singletonList(address1);
        List<Address> addressSet2 = Collections.singletonList(address2);
        List<Address> addressSet3 = Collections.singletonList(address3);
        List<Address> addressSet4 = Collections.singletonList(address4);
        List<Address> addressSet5 = Collections.singletonList(address5);
        Credential credential1 = new Credential("ant", "apple");
        Credential credential2 = new Credential("boar", "bananna");
        Credential credential3 = new Credential("cat", "carot");
        Credential credential4 = new Credential("dog", "dewberry");
        Credential credential5 = new Credential("elephant", "eggfruit");
        User user1 = new User("Joyce", "Contra", "matsn@aol.com", "6825519477", userType1, addressSet1, credential1);
        User user2 = new User("Kristy", "Richards", "hoangle@optonline.net", "5806880672", userType1, addressSet2, credential2);
        User user3 = new User("Leo", "Rossi", "luvirini@me.com", "6308980966", userType1, addressSet3, credential3);
        User user4 = new User("Alexandre", "Hopkins", "nasarius@icloud.com", "4433479677", userType1, addressSet4, credential4);
        User user5 = new User("Cari", "Larson", "mwilson@verizon.net", "5124434591", userType1, addressSet5, credential5);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("address")
    public ResponseEntity<String> setupAddress(){
        Address address = new Address("4360 Capitol Avenue",
                "New Castle", "47362", "IN");
        addressService.save(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("credential")
    public ResponseEntity<String> setupCredential(){
        Credential credential = new Credential("ferret", "fennel");
        credentialService.save(credential);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("user")
    public ResponseEntity<String> setupUser(){
        Address address = new Address("538 Stratford Drive",
                "New Castle", "96814", "HI");
        List<Address> addresses = Collections.singletonList(address);
        Credential credential = new Credential("gorilla", "grape");
        UserType userType = new UserType("lifter");
        User user = new User("Gordon", "Fisher", "wgomicmu@gmail.com", "8083860701", userType, addresses, credential);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("usertype")
    public ResponseEntity<String> setupUserType(){
        UserType userType = new UserType("smithy");
        userTypeService.save(userType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
