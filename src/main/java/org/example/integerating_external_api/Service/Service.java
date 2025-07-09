package org.example.integerating_external_api.Service;

import org.example.integerating_external_api.Entity.Entity;
import org.example.integerating_external_api.Repository.PictureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    PictureRepository repository;
    public ResponseEntity<ByteArrayResource> getImage(int id){
        Optional<Entity> entity=repository.findById(id);

        if(entity.isPresent()) {
//            String contentType = entity.get().getImage().getContentType();
//            MediaType mediaType = MediaType.parseMediaType(contentType);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new ByteArrayResource(entity.get().getImage()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> putImage(MultipartFile file) throws IOException {
        int count= (int) repository.count();
        int Id=count+1;
        Entity putEntity = new Entity();
        putEntity.setId(Id);
        putEntity.setImage(file.getBytes());
        repository.save(putEntity);
        return ResponseEntity.ok("success");
    }
}
