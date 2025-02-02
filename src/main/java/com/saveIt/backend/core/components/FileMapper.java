package com.saveIt.backend.core.components;

import com.saveIt.backend.core.dto.FileResponse;
import com.saveIt.backend.models.File;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class FileMapper {
    public FileResponse toFileResponse(File file) {
        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/")
                .path(file.getId())
                .toUriString();

        return FileResponse.builder()
                .id(file.getId())
                .filename(file.getFilename())
                .contentType(file.getContentType())
                .size(file.getSize())
                .uploadDate(file.getUploadDate())
                .downloadUrl(downloadUrl)
                .build();
    }
}

