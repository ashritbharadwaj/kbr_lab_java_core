package com.mongoapp.repo;

import com.mongoapp.entities.Peak;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends MongoRepository<Peak, String> {
    List<Peak> findByNameAndHeight(String name, int height);
    @Query("{ 'location': { $all: ?0 } }")
    List<Peak> findPeaksInLocations(List<String> locations);
    List<Peak> findByAscentsTotalGreaterThan(int total);

    @Query("{ 'ascents.first_winter.year': { $gt: ?0 } }")
    List<Peak> findMountainsFirstAscendedInWinterAfterYear(int year);

    @Query(value = "{}", fields = "{ 'ascents': 0, 'location': 0 }")
    List<Peak> findAllExcludingAscentsAndLocation();

    @Query(value = "{}")
    List<Peak> findTopPeaks(Pageable pageable);
}
