package com.serial;

import com.entity.Address;
import com.entity.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class UserSerial extends StdSerializer<User> {
    public UserSerial(){
        this(null);
    }
    public UserSerial(Class<User> t) {
        super(t);
    }
    public void serialize(User user, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("userId", user.getUserId());
        gen.writeStringField("firstName", user.getFirstName());
        gen.writeStringField("lastName", user.getLastName());
        gen.writeStringField("email", user.getEmail());
        gen.writeStringField("phoneNumber", user.getPhoneNumber());
        gen.writeObjectField("userType", user.getUserType());
//        for (Address address: user.getAddresses()){
////            gen.writeStartObject();
////            gen.writeNumberField("addressId", address.getAddressId());
////            gen.writeEndObject();
//        }
        gen.writeObjectField("credential", user.getCredential());
        gen.writeEndObject();
    }
//    private Set<Address> addresses;
}
