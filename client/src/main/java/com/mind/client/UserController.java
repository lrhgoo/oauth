package com.mind.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
class UserController {

    @Autowired
    private OAuth2RestOperations restTemplate;

    @Value("${config.oauth2.resourceURI}")
    private String resourceURI;

    @RequestMapping("/")
    @ResponseBody
    public JsonNode home() {

        return restTemplate.getForObject(resourceURI, JsonNode.class);
    }

}