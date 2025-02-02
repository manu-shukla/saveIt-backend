package com.saveIt.backend.core.service;

import com.saveIt.backend.core.components.FileMapper;
import com.saveIt.backend.core.dto.FileResponse;
import com.saveIt.backend.core.exceptions.FileValidationException;
import com.saveIt.backend.core.respository.FileRepository;
import com.saveIt.backend.core.types.FileType;
import com.saveIt.backend.models.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FileService {

    @Autowired
    FileMapper fileMapper;
    @Autowired
    private FileRepository fileRepository;

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileValidationException("Failed to store empty file.");
        }

        String filename = file.getOriginalFilename();
        if (filename == null || filename.isBlank()) {
            throw new FileValidationException("Failed to store file with empty name.");
        }

        // Check if content type is supported
        if (!FileType.isSupportedContentType(file.getContentType())) {
            throw new FileValidationException(
                    "File type not supported. Supported types are: PDF, TXT, JSON, JPG, PNG, DOCX, XLSX"
            );
        }

        // Check if file extension is supported
        if (!FileType.isSupportedFileExtension(filename)) {
            throw new FileValidationException(
                    "File extension not supported. Supported extensions are: .pdf, .txt, .json, .jpg, .jpeg, .png, .docx, .xlsx"
            );
        }
    }

    public FileResponse saveFile(MultipartFile file) throws IOException {

        validateFile(file);

        File fileToSave = new File();
        fileToSave.setFilename(file.getOriginalFilename());
        fileToSave.setContentType(file.getContentType());
        fileToSave.setSize(file.getSize());
        fileToSave.setContent(file.getBytes());
        fileToSave.setUploadDate(LocalDateTime.now().toString());

        File savedFile = fileRepository.save(fileToSave);
        return fileMapper.toFileResponse(savedFile);
    }

    public Optional<File> getFile(String id) {
        return fileRepository.findById(id);
    }

    public List<FileResponse> getAllFiles() {
        return fileRepository.findAll().stream().map(fileMapper::toFileResponse).collect(Collectors.toList());
    }

    public void deleteFile(String id) {
        fileRepository.deleteById(id);
    }
}
