package org.spring.template.datastore.entity.postgre;

/**
 * Created by osman on 8.5.2017.
 */

import javax.persistence.*;

@Entity()
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", columnDefinition = "serial")
    private Long id;

    @Column( name = "first_name")
    private String firstName;

    @Column( name = "last_name")
    private String lastName;

    @Column( name = "gender")
    private String gender;

    @Column( name = "nationality")
    private String nationality;

    public Long getId() {
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
