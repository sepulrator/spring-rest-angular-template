package org.spring.template.service.dto.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by osman on 8.5.2017.
 */
public class Person {

    @NotNull
    private long id;

    @NotNull
    @Size(min=1)
    private String firstName;

    @NotNull
    @Size(min=1)
    private String lastName;

    @Pattern(regexp = "F|M", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String gender;

    private String nationality;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
