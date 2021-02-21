package com.serial;

import com.entity.Address;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class AddressSerial extends StdSerializer<Address> {
    public AddressSerial(){
        this(null);
    }
    public AddressSerial(Class<Address> t){
        super(t);
    }
    public void serialize(
            Address address, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("addressId", address.getAddressId());
        gen.writeStringField("streetAddress", address.getStreetAddress());
        gen.writeStringField("cityAddress", address.getCityAddress());
        gen.writeStringField("zipAddress", address.getZipAddress());
        gen.writeStringField("stateAddress", address.getStateAddress());
        gen.writeEndObject();
    }
}
