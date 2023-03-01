package com.capstone.restapi.Service;

import com.capstone.restapi.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> authenticateUser(String uname, String upass);

    User getUserById(String id);
}