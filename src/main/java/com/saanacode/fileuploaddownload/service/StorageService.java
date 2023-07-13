package com.saanacode.fileuploaddownload.service;

import com.saanacode.fileuploaddownload.entity.ImageData;
import com.saanacode.fileuploaddownload.repository.StorageRepository;
import com.saanacode.fileuploaddownload.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = storageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType()).
                imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "File uploaded successfully" + file.getOriginalFilename();
        }
        return "File upload failed" + file.getOriginalFilename();

    }

    public byte[] downloadImage(String fileName) {
        Optional<ImageData> imageData = storageRepository.findByName(fileName);
        if (imageData.isPresent()) {
            return ImageUtils.decompressImage(imageData.get().getImageData());
        }
        return null;
    }
}
