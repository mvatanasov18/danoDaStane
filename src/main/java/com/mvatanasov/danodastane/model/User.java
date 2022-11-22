package com.mvatanasov.danodastane.model;

import org.apache.commons.lang3.ObjectUtils;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@NamedNativeQuery(name = "insertUser",
        query = "INSERT INTO " +
                "Users(Username, Password, FirstName, LastName, CompanyName,RoleId)" +
                " VALUES (?,?,?,?,?,?)")
@Entity
public class User {
    @Id
    private Integer id;
private String username;
private String password;
    private String firstName;
    private String lastName;
    private String companyName;
    @Transient
    private Role role;

    public User() {
    }

    public User(Integer id,String username, String password, String firstName, String lastName, String companyName, Role role) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

        this.companyName = companyName;
        this.role = role;
    }




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
