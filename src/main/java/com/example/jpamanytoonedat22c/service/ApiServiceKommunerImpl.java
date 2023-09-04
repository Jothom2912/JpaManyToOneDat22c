package com.example.jpamanytoonedat22c.service;

import com.example.jpamanytoonedat22c.Repository.KommuneRepository;
import com.example.jpamanytoonedat22c.model.Kommune;
import com.example.jpamanytoonedat22c.model.Region;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceKommunerImpl implements ApiServiceKommuner
{

    private final RestTemplate restTemplate;

    private final KommuneRepository kommineRepository;

    public ApiServiceKommunerImpl(RestTemplate restTemplate, KommuneRepository kommineRepository)
    {
        this.restTemplate = restTemplate;
        this.kommineRepository = kommineRepository;
    }

    private void saveKommuner(List<Kommune> kommuneList)
    {
        /*for(Region region: regions)
        {
            regionRepository.save(region);
        }*/
        //Lambda-utryk gør det samme
        kommuneList.forEach(kommune -> kommineRepository.save(kommune));
    }

    @Override
    public List<Kommune> getKommuner()
    {

        String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";


        //List<Region> regions = new ArrayList<>();

        ResponseEntity<List<Kommune>> listResponseEntity = restTemplate.exchange(kommuneUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Kommune> >()
                {
                });

        List<Kommune> kommunes = listResponseEntity.getBody();
        saveKommuner(kommunes);

        return kommunes;
    }
}

