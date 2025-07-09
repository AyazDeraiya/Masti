package org.example.integerating_external_api.Repository;

import org.example.integerating_external_api.Entity.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@org.springframework.stereotype.Repository
//@EnableMongoRepositories(basePackageClasses = Repository.class)
public interface PictureRepository extends MongoRepository<Entity, Integer> {

}
