package com.saveIt.backend.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    private String name;
    private String email;
    private List<File> filesList;

}
