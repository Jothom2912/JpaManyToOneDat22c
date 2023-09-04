package com.example.jpamanytoonedat22c.Repository;


import com.example.jpamanytoonedat22c.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, String>
{


}
