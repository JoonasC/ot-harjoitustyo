package dataModels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) && phoneNumber.equals(contact.phoneNumber) && email.equals(contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, email);
    }
}
