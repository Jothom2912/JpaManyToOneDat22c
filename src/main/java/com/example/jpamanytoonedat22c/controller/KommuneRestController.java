package com.example.jpamanytoonedat22c.controller;

import com.example.jpamanytoonedat22c.model.Kommune;
import com.example.jpamanytoonedat22c.service.ApiServiceKommuner;
import com.example.jpamanytoonedat22c.service.ApiServiceKommunerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KommuneRestController
{

    @Autowired
    ApiServiceKommunerImpl apiServiceKommuner;

    @GetMapping("/getKommuner")
    List<Kommune> getKommuner()
    {
        return apiServiceKommuner.getKommuner();
    }




}
