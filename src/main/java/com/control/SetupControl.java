package com.control;

import com.entity.Address;
import com.entity.Credential;
import com.entity.User;
import com.entity.UserType;
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
import java.util.Set;

@RestController
@RequestMapping("setup")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SetupControl {
    public UserTypeService userTypeService;
    public UserService userService;

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
        Set<Address> addressSet1 = Collections.singleton(address1);
        Set<Address> addressSet2 = Collections.singleton(address2);
        Set<Address> addressSet3 = Collections.singleton(address3);
        Set<Address> addressSet4 = Collections.singleton(address4);
        Set<Address> addressSet5 = Collections.singleton(address5);
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
}
