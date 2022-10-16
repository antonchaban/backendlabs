package ua.kpi.fict.backendlabs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@RequestMapping("/")
@Controller
public class HomeController {
    @GetMapping
    ResponseEntity<Void> redirect() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("https://github.com/antonchaban/backendlabs/blob/master/README.md"))
                .build();
    }
}
