package com.example.ricknmortydojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EpisodesController {

    private static final int seasons =5;

    @GetMapping(value = "/season/count")
    private int getSeasonCount() {
        return seasons;
    }

    ///episodes?season=S01
    @GetMapping(value = "/episodes")
    private String getEpisodesBySeason(@RequestParam String season) {
        RestTemplate restTemplate = new RestTemplate();

        String uri ="https://rickandmortyapi.com/api/episode?episode="+season;
        return restTemplate.getForObject(uri, String.class);
    }

    @GetMapping(value = "/episodes/all")
    private String getEpisodesBySeason() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        String uri ="https://rickandmortyapi.com/api/episode?episode=S0";
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= seasons; i++) {
            ResponseEntity<String> response =
                    restTemplate.getForEntity(uri+i, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode result = root.path("results");
            sb.append(result.asText());
            sb.append(" ");
        }

        return sb.toString();
    }

}
