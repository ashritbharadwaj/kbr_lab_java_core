package com.mongoapp.repo;

import com.mongoapp.entities.Peak;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends MongoRepository<Peak, String> {
    List<Peak> findByName(String name);
    List<Peak> findByNameNot(String name);
    List<Peak> findByHeightGreaterThan(int height);
    List<Peak> findByNameAndHeight(String name, int height);
    List<Peak> findByNameOrHeight(String name, int height);
    @Query("{ 'location': { $all: ?0 } }")
    List<Peak> findPeaksInLocations(List<String> locations);
    List<Peak> findByAscentsTotalGreaterThan(int total);
}
