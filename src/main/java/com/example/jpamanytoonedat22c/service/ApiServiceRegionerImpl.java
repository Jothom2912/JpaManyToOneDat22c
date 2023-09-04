package com.example.jpamanytoonedat22c.service;

import com.example.jpamanytoonedat22c.Repository.RegionRepository;
import com.example.jpamanytoonedat22c.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class ApiServiceRegionerImpl implements ApiServiceRegioner
{

    private final RestTemplate restTemplate;

    private final RegionRepository regionRepository;

    public ApiServiceRegionerImpl(RestTemplate restTemplate, RegionRepository regionRepository)
    {
        this.restTemplate = restTemplate;
        this.regionRepository = regionRepository;
    }

    private void saveRegioner(List<Region> regions)
    {
        /*for(Region region: regions)
        {
            regionRepository.save(region);
        }*/
        //Lambda-utryk gør det samme
        regions.forEach(region -> regionRepository.save(region));
    }

    @Override
    public List<Region> getRegioner()
    {

        String regionUrl = "https://api.dataforsyningen.dk/regioner";


        //List<Region> regions = new ArrayList<>();

        ResponseEntity<List<Region>> listResponseEntity = restTemplate.exchange(regionUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Region> >()
                {
                });

        List<Region> regions = listResponseEntity.getBody();
        saveRegioner(regions);

        return regions;
    }
}
