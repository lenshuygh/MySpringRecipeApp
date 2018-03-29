package com.lens.gurucourse.recipeproject.recipes.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(Long aLong, MultipartFile file);
}
