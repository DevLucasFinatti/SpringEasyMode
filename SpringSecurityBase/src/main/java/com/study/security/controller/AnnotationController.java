package com.study.security.controller;

import com.study.security.base.ApiResponse;
import com.study.security.base.SystemMessages;
import com.study.security.entity.Annotation;
import com.study.security.entity.dto.AnnotationDto;
import com.study.security.service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/annotations")
public class AnnotationController {

    @Autowired
    private AnnotationService annotationService;

    @GetMapping("/all/{id}")
    public ApiResponse getAllAnnotations(@PathVariable("id") String userId) {
        return annotationService.getAllAnnotations(userId);
    }

    @PostMapping
    public ApiResponse createAnnotation(@RequestBody AnnotationDto annotation) {
        return annotationService.saveAnnotation(annotation);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteAnnotation(@PathVariable("id") String id) {
        try {
            annotationService.deleteAnnotation(id);
            return new ApiResponse(id, SystemMessages.Annotation.SUCCESS_DELETED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.Annotation.FAIL_DELETE);
        }
    }
}
