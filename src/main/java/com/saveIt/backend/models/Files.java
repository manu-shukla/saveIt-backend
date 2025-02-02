package com.saveIt.backend.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Files {
    private String fileName;
    private String fileUrl;
    private String fileType;
    private long fileSize;

}
