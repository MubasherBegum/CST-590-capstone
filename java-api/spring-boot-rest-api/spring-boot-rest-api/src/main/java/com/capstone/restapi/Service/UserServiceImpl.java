package com.capstone.restapi.Service;

import com.capstone.restapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.restapi.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    //@Autowired
    private UserRepository userRepo;
    @Autowired
    public void setUserRepository(UserRepository userRepo){
        this.userRepo=userRepo;
    }


    @Transactional
    public List<User> authenticateUser(String uname, String upass){
        List <User> _user = userRepo.loggedInUser(uname, upass);
        return _user;
    }
    @Transactional
    public User getUserById(String id) {
        User newUser = userRepo.getUserById(id);

        return newUser;
    }
}