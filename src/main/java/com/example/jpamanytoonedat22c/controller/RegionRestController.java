package com.example.jpamanytoonedat22c.controller;

import com.example.jpamanytoonedat22c.model.Region;
import com.example.jpamanytoonedat22c.service.ApiServiceRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionRestController
{
    @Autowired
    ApiServiceRegioner apiServiceRegioner;

    @GetMapping("/getregioner")
    List<Region> getRegioner(){
        return apiServiceRegioner.getRegioner();
    }
}
