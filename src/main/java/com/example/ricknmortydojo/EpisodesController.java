package com.example.ricknmortydojo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EpisodesController {

    @GetMapping(value = "/season/count")
    private int getSeasonCount() {
        return 5;
    }

    ///episodes?season=S01
    @GetMapping(value = "/episodes")
    private String getEpisodesBySeason(@RequestParam String season) {
        RestTemplate restTemplate = new RestTemplate();

        String uri ="https://rickandmortyapi.com/api/episode?episode="+season;
        return restTemplate.getForObject(uri, String.class);
    }

}
