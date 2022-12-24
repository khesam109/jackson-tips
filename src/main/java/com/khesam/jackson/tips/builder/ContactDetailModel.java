package com.khesam.jackson.tips.builder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ContactDetailModel.Builder.class)
class ContactDetailModel {

    @JsonProperty("contact_city") private final String city;
    @JsonProperty("contact_address") private final String address;
    @JsonProperty("contact_postalCode") private final String postalCode;

    private ContactDetailModel(Builder builder) {
        city = builder.city;
        address = builder.address;
        postalCode = builder.postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        @JsonProperty("contact_city") private String city;
        @JsonProperty("contact_address") private String address;
        @JsonProperty("contact_postalCode") private String postalCode;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder postalCode(String val) {
            postalCode = val;
            return this;
        }

        public ContactDetailModel build() {
            return new ContactDetailModel(this);
        }
    }
}
