package dataModels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
    private final String name;
    private final String phoneNumber;
    private final String email;

    @JsonCreator
    public Contact(
            @JsonProperty("name") String name,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("email") String email
    ) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonGetter("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonGetter("email")
    public String getEmail() {
        return email;
    }
}
