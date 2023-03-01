package com.capstone.restapi.controller;

import com.capstone.restapi.Service.UserService;
import com.capstone.restapi.exception.ResourceNotFoundException;
import com.capstone.restapi.model.User;
import com.capstone.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.Statement;

import static org.springframework.jdbc.datasource.DataSourceUtils.getConnection;

/**
* Controller class that would have get and post mapping for the rest api
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;
  @PersistenceContext
  private EntityManager em;

  private Connection conn;
  /**
  * Unsafe methods exploiting SQL and vulnerable to attacks
   */
  /**
   * Showcasing unsafe SQL method for authenticating users
   */
  @PostMapping("/unsafe/user/login")
  public List<User> authenticateUnsafeUser(@RequestParam String username, @RequestParam String password) throws SQLException {
    String query = "SELECT * FROM users WHERE username = '" + username + "' and  upassword = '" + password + "'; " +
            "UPDATE users set logged_in = true where username ='"+ username + "' and  upassword = '" + password + "';"; // Unsafe
    System.out.println(query);
    List<User> result = new ArrayList<>();
    try {
      conn = getConn();
      Statement statement = conn.createStatement();
      Boolean hasResult = statement.execute(query);
      if(hasResult) {
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
          User obj = new User();
          obj.setId(resultSet.getLong("id"));
          obj.setUsername(resultSet.getString("username"));
          obj.setCreatedAt(resultSet.getDate("created_at"));
          obj.setLoggedIn(true);
          obj.setEmail(resultSet.getString("email"));
          obj.setRole(resultSet.getString("urole"));
          obj.setCreatedBy(resultSet.getString("created_by"));
          obj.setFirstName(resultSet.getString("firstname"));
          obj.setLastName(resultSet.getString("lastname"));
          result.add(obj);

        }
        result.forEach(x -> System.out.println(x));
        resultSet.close();
      }
      statement.close();
    }finally {
    }
    return result;
  }
  @GetMapping("/unsafesql/getusers")
  public List<User> getUsers(@RequestParam String id) throws SQLException {
    String query = "SELECT * FROM users WHERE id = " + id; // Unsafe
    System.out.println(query);
    List<User> result = new ArrayList<>();
    try {
      conn = getConn();
      Statement statement = conn.createStatement();
      //ResultSet resultSet = statement.executeQuery(query);
      Boolean hasResult = statement.execute(query);
      if(hasResult) {
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
          User obj = new User();
          obj.setId(resultSet.getLong("id"));
          obj.setUsername(resultSet.getString("username"));
          obj.setCreatedAt(resultSet.getDate("created_at"));
          obj.setLoggedIn(resultSet.getBoolean("logged_in"));
          obj.setEmail(resultSet.getString("email"));
          obj.setRole(resultSet.getString("urole"));
          obj.setCreatedBy(resultSet.getString("created_by"));
          obj.setFirstName(resultSet.getString("firstname"));
          obj.setLastName(resultSet.getString("lastname"));
          result.add(obj);

        }
        result.forEach(x -> System.out.println(x));
        resultSet.close();
      }
      statement.close();
    }finally {
    }
    return result;
  }


  /**
   * Showcasing SAFE SQL method for preventing SQL Attacks
   */
  @PostMapping("/safe/user/login")
  public List<User> authenticateSafeUser(@RequestParam String username, @RequestParam String password) throws SQLException {
    String query = "SELECT * FROM users WHERE username = ? and  upassword = ? ;UPDATE users set logged_in = true where username = ? and  upassword = ?;";
    System.out.println(query);
    List<User> result = new ArrayList<>();
    try {
      conn = getConn();
      PreparedStatement  statement = conn.prepareStatement(query);
      statement.setString(1, username);
      statement.setString(2, password);
      statement.setString(3, username);
      statement.setString(4, password);
      System.out.println(query);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        User obj = new User();
        obj.setId(resultSet.getLong("id"));
        obj.setUsername(resultSet.getString("username"));
        obj.setCreatedAt(resultSet.getDate("created_at"));
        obj.setLoggedIn(true);
        obj.setEmail(resultSet.getString("email"));
        obj.setRole(resultSet.getString("urole"));
        obj.setCreatedBy(resultSet.getString("created_by"));
        obj.setFirstName(resultSet.getString("firstname"));
        obj.setLastName(resultSet.getString("lastname"));
        result.add(obj);

      }
      result.forEach(x -> System.out.println(x));
      resultSet.close();

      statement.close();
    }finally {
    }
    return result;
  }

  /**
  * Adding safe execute of getusers to demonstrate preventing sql attack
   */
  @GetMapping("/safe/getusers")
  public List<User> getSafeUsers(@RequestParam String id) throws SQLException {
    String query = "SELECT * FROM users WHERE id = ?";
    List<User> result = new ArrayList<>();
    try {
      conn = getConn();
      PreparedStatement  statement = conn.prepareStatement(query);
      statement.setString(1, id);
      System.out.println(query);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        User obj = new User();
        obj.setId(resultSet.getLong("id"));
        obj.setUsername(resultSet.getString("username"));
        obj.setCreatedAt(resultSet.getDate("created_at"));
        obj.setLoggedIn(resultSet.getBoolean("logged_in"));
        obj.setEmail(resultSet.getString("email"));
        obj.setRole(resultSet.getString("urole"));
        obj.setCreatedBy(resultSet.getString("created_by"));
        obj.setFirstName(resultSet.getString("firstname"));
        obj.setLastName(resultSet.getString("lastname"));
        result.add(obj);

      }
      result.forEach(x -> System.out.println(x));
      resultSet.close();
      statement.close();
    }finally {
    }
    return result;
  }
  /**
  * Following method is recommended method of authentication
  * implementation using JPA Repository, ORM framework
   */
  @PostMapping("/user/login")
  public String authenticateUser(@RequestParam String username, @RequestParam String password)
  {
    /*
    Following method commented below using JPA Repository implementation
     */
//    List<User> users = userRepository.findAll();
//    for (User other : users) {
//      String compareUname = other.getUserName();
//      if (other.getUserName().equals(username) && other.getPassword().equals(password)) {
//          other.setLoggedIn(true);
//        return "SUCCESS";
//      }
//    }

   /*
   Following implementation show using UserService based authentication  method
    */
    List <User> isUserLogged = userService.authenticateUser(username, password);
    System.out.println("----------------------" + isUserLogged.toString());
    return isUserLogged.toString();
  }


  /*
  Miscellaneous/helper methods for retrieving user data from Database
   */
  /*
  Using getAllUsers method from JPA Repository, to get the list of all users
   */
  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  /**
   * Gets users by id.
   */
  @GetMapping("/get/user")
  public ResponseEntity<User> getUsersById(@RequestParam String Id)
      throws ResourceNotFoundException {
    /*
    Following commented implementation of retrieving user from JPA repository
     */
//    User _user =
//        userRepository
//            .findById(userId)
//            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
   /*
   Following implementation using User Service for retrieving users by Id
    */
    User user = userService.getUserById(Id);
    return ResponseEntity.ok().body(user);
  }

  /* Create User, for testing purpose
   */
  @PostMapping("/users")
  public User createUser(@Valid @RequestBody User user) {
    return userRepository.save(user);
  }



  /*
  Added getConn method that connects to jdbc driver, allow local testing by disabling https and allows
  multiple queries in single statement to show sql attacks.
   */
public Connection getConn() throws SQLException {
  String url = "jdbc:mysql://localhost:3306/authUsers?useSSL=false&allowMultiQueries=true";
  String username = "root";
  String password = "chandu13";
  try{
    if(conn == null){
      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection(url, username, password);
      System.out.println("Database connected!");
    }
  }
  catch (SQLException e) {
    throw new IllegalStateException("Cannot connect the database!", e);
  } catch (Exception e){
    e.printStackTrace();
  }
  return conn;
}

}
