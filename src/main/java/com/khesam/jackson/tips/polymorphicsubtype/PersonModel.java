package com.khesam.jackson.tips.polymorphicsubtype;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use= JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({@JsonSubTypes.Type(RealPersonModel.class), @JsonSubTypes.Type(LegalPersonModel.class)})
class PersonModel  {

    @JsonProperty("_id") private final String personId;

    public PersonModel(String personId) {
        this.personId = personId;
    }

    public String getPersonId() {
        return personId;
    }
}
