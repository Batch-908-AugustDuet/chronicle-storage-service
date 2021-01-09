package com.revature.chronicle.services;

import com.revature.chronicle.daos.TagRepo;
import com.revature.chronicle.models.Tag;
import com.revature.chronicle.security.FirebaseInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service to handle business logic surrounding data access layer for tags
 */
@Service
public class TagService {
    private static final Logger logger = LoggerFactory.getLogger(FirebaseInitializer.class);
    @Autowired
    private TagRepo tagRepo;

    public TagService(TagRepo tagRepo) {
        this.tagRepo = tagRepo;
    }

    /**
     * Calls findAll() from TagRepo (JpaRepository method)
     * Finds all tags stored in the database
     * @return returns a list of all the tags found in the "tags" database table
     * if Exception is caught, it returns a new ArrayList()
     */
    public List<Tag> findAll() {
        try {
            return tagRepo.findAll();
        }
        catch (Exception e) {
            logger.warn(e.getMessage());
            return new ArrayList<Tag>();
        }

    }

    /**
     * Calls findById() from TagRepo (JpaRepository method)
     * Finds a Tag by matching its id with the parameter id passed into the method
     * @param id the id used to match a Tag's id stored in the "tags" database table
     * @return a Tag matching the id passed in as a parameter
     * if Exception is caught, it returns an empty Optional instance
     */
    public Optional<Tag> findById(int id) {
        try{
            return tagRepo.findById(id);
        }
        catch (Exception e){
            logger.warn(e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * Calls save() from TagRepo (JpaRepository method)
     * Saves a Tag into the "tags" database table
     * @param tag the tag to be saved into our database
     * @return boolean true if the tag was saved
     * if Exception is caught, it returns false
     */
    public boolean save(Tag tag) {
        try {
            tagRepo.save(tag);
            return true;
        }
        catch (Exception e) {
            logger.warn(e.getMessage());
            return false;
        }
    }

    /**
     * Calls deleteById() from TagRepo (JpaRepository method)
     * deletes a Tag from the "tags" database table
     * @param tagID the tag to be removed from our database
     * @return boolean true if the tag was removed
     * if Exception is caught, it returns false
     */
    public boolean deleteByID(int tagID) {
        try {
            tagRepo.deleteById(tagID);
            return true;
        }
        catch (Exception e) {
            logger.warn(e.getMessage());
            return false;
        }
    }
}
