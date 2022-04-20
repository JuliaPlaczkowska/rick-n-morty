package com.example.ricknmortydojo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EpisodesController {

    @GetMapping(value = "/joke")
    private String getBook() {
        RestTemplate restTemplate = new RestTemplate();

        String uri ="https://rickandmortyapi.com/api/episode";
        return restTemplate.getForObject(uri, String.class);
    }
}
