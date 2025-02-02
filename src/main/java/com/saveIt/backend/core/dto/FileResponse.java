package com.saveIt.backend.core.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileResponse {
    private String id;
    private String filename;
    private String contentType;
    private long size;
    private String uploadDate;
    private String downloadUrl;
}
