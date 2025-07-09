package org.example.integerating_external_api.Controller;

import org.example.integerating_external_api.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    Service service;
    @GetMapping("/Nehanshu")
    public ResponseEntity<ByteArrayResource> getNehanshu() {
        return service.getImage(1);
    }
    @GetMapping("/Rudra")
    public ResponseEntity<ByteArrayResource> getRudra(){
        return service.getImage(2);
    }
    @GetMapping("/chetak")
    public ResponseEntity<ByteArrayResource> getChetak(){
        return service.getImage(3);
    }
    @PostMapping
    public ResponseEntity<String> post(@RequestParam("file") MultipartFile file) throws IOException {
        return service.putImage(file);
    }
}
