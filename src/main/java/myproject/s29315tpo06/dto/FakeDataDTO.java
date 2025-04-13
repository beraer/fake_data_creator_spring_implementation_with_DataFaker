package myproject.s29315tpo06.dto;

import java.util.Map;

public class FakeDataDTO {
    private String firstName;
    private String lastName;
    private String birthDate;
    private Map<String, String> additionalFields;

    public FakeDataDTO(String firstName, String lastName, String birthDate, Map<String, String> additionalFields) {
        this.firstName = firstName;
        this.additionalFields = additionalFields;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public Map<String, String> getAdditionalFields() {
        return additionalFields;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAdditionalFields(Map<String, String> additionalFields) {
        this.additionalFields = additionalFields;
    }
}
