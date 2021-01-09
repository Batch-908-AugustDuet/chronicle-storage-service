package com.revature.chronicle.services;

import com.revature.chronicle.daos.UserRepo;
import com.revature.chronicle.models.User;
import com.revature.chronicle.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Service to handle user related any business logic needed prior to data access layer for Users
 */
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }

    /**
     * Calls findAll() from UserRepo (JpaRepository method)
     * Finds all Users stored in the database
     * @return returns a list of all the Users found in the "Users" database table
     * if Exception is caught, it returns a new ArrayList()
     */
    public List<User> findAll() {
        try{
            return userRepo.findAll();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Calls findById() from UserRepo (JpaRepository method)
     * Finds a User by matching its id with the parameter id passed into the method
     * @param id the id used to match a User's id stored in the "users" database table
     * @return a User matching the id passed in as a parameter
     * if Exception is caught, it returns an empty Optional instance
     */
    public Optional<User> findById(int id){
        try{
            return userRepo.findById(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * Calls save() from UserRepo (JpaRepository method)
     * Saves a User into the "Users" database table
     * @param user the User to be saved into our database
     * @return boolean true if the User was saved
     * if Exception is caught, it returns false
     */
    public boolean save(User user){
        userRepo.save(user);
        return true;
    }

    /**
     * NOTE: This method is redundant since save does the same thing
     * Updates a User in the "Users" database table
     * @param user the User to be saved into our database
     * @return boolean true if the User was saved
     * if Exception is caught, it returns false
     */
    public boolean update(User user){
        //Check to see if exists? If not?
        userRepo.save(user);
        return true;
    }

    /**
     * Calls delete() from UserRepo (JpaRepository method)
     * deletes a User from the "Users" database table
     * @param user the User to be removed from our database
     * @return boolean true if the User was removed
     * if Exception is caught, it returns false
     */
    public boolean delete(User user){
        userRepo.delete(user);
        return true;
    }
}
