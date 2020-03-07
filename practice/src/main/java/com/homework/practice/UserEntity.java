package com.homework.practice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(query = "SELECT u FROM UserEntity u WHERE u.email = :email", name = UserEntity.FIND_BY_EMAIL),
        @NamedQuery(query= "SELECT u FROM UserEntity u", name = UserEntity.FIND_ALL),
        @NamedQuery(query= "SELECT u FROM UserEntity u WHERE u.lastName = :lastName", name = UserEntity.FIND_BY_LASTNAME),
        @NamedQuery(query = "SELECT u FROM UserEntity u WHERE u.lastName LIKE CONCAT('%',:word,'%') OR u.firstName LIKE CONCAT('%',:word,'%')",
        name=UserEntity.FIND_BY_WORD)
})

public class UserEntity {

    public static final String FIND_BY_EMAIL = "UserEntity.FIND_BY_EMAIL";
    public static final String FIND_ALL = "UserEntity.FIND_ALL";
    public static final String FIND_BY_LASTNAME = "UserEntity.FIND_BY_LASTNAME";
    public static final String FIND_BY_WORD = "UserEntity.FIND_BY_WORD";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
