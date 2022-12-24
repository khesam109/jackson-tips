package com.khesam.jackson.tips.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuilderTest {

    private static final String JSON = "{\"contact_city\":\"Tehran\",\"contact_address\":\"Near to tehran balls\",\"contact_postalCode\":\"1234567890\"}";

    private final ObjectMapper objectMapper;

    public BuilderTest() {
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testSerialization() {
        ContactDetailModel contactDetailModel = ContactDetailModel.Builder.builder()
                .city("Tehran")
                .address("Near to tehran balls")
                .postalCode("1234567890")
                .build();

        try {
            String json = objectMapper.writeValueAsString(contactDetailModel);
            Assertions.assertEquals(json, JSON);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDeserialization() {
        try {
            ContactDetailModel contactDetailModel = objectMapper.readValue(JSON, ContactDetailModel.class);
            Assertions.assertEquals(contactDetailModel.getCity(), "Tehran");
            Assertions.assertEquals(contactDetailModel.getAddress(), "Near to tehran balls");
            Assertions.assertEquals(contactDetailModel.getPostalCode(), "1234567890");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
