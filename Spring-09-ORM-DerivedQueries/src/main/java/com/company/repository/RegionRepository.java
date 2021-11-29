package com.company.repository;

import com.company.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    //Display all regions in Canada

    List<Region> findRegionByCountry(String country);
    // Select * From regions where country= 'Canada'

    //Display all regions in Canada, without duplicates
    List<Region> findDistinctByCountry(String country);

    //Display all regions with country name includes 'United'
    List<Region> findAllByCountryContains(String chars);

    //Display all regions with country name includes 'United' in order
    List<Region> findByCountryContainsOrderByCountry(String chars);

    //Display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);

}