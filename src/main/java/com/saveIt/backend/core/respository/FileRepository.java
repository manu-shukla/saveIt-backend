package com.saveIt.backend.core.respository;

import com.saveIt.backend.models.File;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FileRepository extends MongoRepository<File, String> {

    File findByFilename(String fileName);

}
