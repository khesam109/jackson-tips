package com.khesam.jackson.tips.polymorphicsubtype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RealPersonModel extends PersonModel {

    @JsonProperty("first_name") private final String firstname;

    @JsonCreator
    public RealPersonModel(
            @JsonProperty("_id") String id,
            @JsonProperty("first_name") String firstname
    ) {
        super(id);
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }
}
