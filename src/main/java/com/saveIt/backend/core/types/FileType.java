package com.saveIt.backend.core.types;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum FileType {
    PDF("application/pdf", ".pdf"),
    TXT("text/plain", ".txt"),
    JSON("application/json", ".json"),
    JPEG("image/jpeg", ".jpg", ".jpeg"),
    PNG("image/png", ".png"),
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document", ".docx"),
    XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx");

    private final String mimeType;
    private final List<String> extensions;

    FileType(String mimeType, String... extensions) {
        this.mimeType = mimeType;
        this.extensions = Arrays.asList(extensions);
    }

    public static boolean isSupportedContentType(String contentType) {
        return Arrays.stream(FileType.values())
                .anyMatch(type -> type.getMimeType().equals(contentType));
    }

    public static boolean isSupportedFileExtension(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        return Arrays.stream(FileType.values())
                .anyMatch(type -> type.getExtensions().contains(extension));
    }

}
