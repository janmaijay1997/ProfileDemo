package com.intent.ProfileDemo.ProfileDemo.Controller;

import com.intent.ProfileDemo.ProfileDemo.Config.BasicConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProfileDemoController {
    private static final Logger LOGGER= LogManager.getLogger(ProfileDemoController.class);
    @Value("${welcome.message}")
    private String welcomeMessage;

    @Autowired
    private BasicConfig configuration;

    @GetMapping("/dynamic-configuration")
    public Map dynamicConfiguration() {
        LOGGER.info(" dynamicConfiguration initiated ");
        // Not the best practice to use a map to store differnt types!
        Map map = new HashMap();
        map.put("message", configuration.getMessage());
        map.put("number", configuration.getNumber());
        map.put("key", configuration.isValue());
        LOGGER.info("operation completed");

        return map;
    }

    @GetMapping("/welcome")
    public String retrieveWelcomeMessage() {
        // Complex Method
        LOGGER.info("Welcome api  initiated ");

        return welcomeMessage;
    }

}
