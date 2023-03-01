package com.capstone.restapi.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    private boolean loggedIn = false;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "upassword", nullable = false)
    private String passwrd;

    @Column(name = "urole", nullable = false)
    private String role;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "created_at", insertable = false, updatable = false)
    @CreationTimestamp //this adds the default timestamp on save
    private Date createdAt;

    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private String createdBy;

    /**
    * getters and setter methods below or
     * storing and retrieving data from database
     */
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

  public String getEmail() {
        return email;
    }

  public void setEmail(String email) {
        this.email = email;
    }

  public Date getCreatedAt() {
        return createdAt;
    }

  public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

  public String getCreatedBy() {
        return createdBy;
    }

  public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

  public String getUserName() {
        return username;
    }

  public void setUsername(String username) {
        this.username = username;
    }

  public String getPassword() {
        return passwrd;
    }

  public void setPassword(String passwrd) {
        this.passwrd = passwrd;
  }

  public String getRole() {
        return role;
    }

  public void setRole(String role) {
    this.role = role;
  }

  public boolean getLoggedIn(){
    return loggedIn;
  }
    public void setLoggedIn(Boolean loggedIn){
        this.loggedIn = loggedIn;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + passwrd + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", username=" + username +
                ", role='" + role + '\'' +
                '}';
    }

}
