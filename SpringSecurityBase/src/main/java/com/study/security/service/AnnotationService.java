package com.study.security.service;

import com.study.security.base.ApiResponse;
import com.study.security.base.SystemMessages;
import com.study.security.entity.Annotation;
import com.study.security.entity.User;
import com.study.security.entity.dto.AnnotationDto;
import com.study.security.entity.dto.AnnotationResponseDto;
import com.study.security.repository.AnnotationRepository;
import com.study.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AnnotationService {

    @Autowired
    private AnnotationRepository annotationRepository;

    @Autowired
    private UserRepository userRepository;

    public ApiResponse getAllAnnotations(String userId) {
        try {
            Optional<User> user = userRepository.findById(UUID.fromString(userId));
            if (user.isEmpty()) {
                return new ApiResponse(userId, SystemMessages.User.NOT_FOUND);
            }

            List<Annotation> annotationList = annotationRepository.findByUser_UserId(user.get().getUserId());
            if (annotationList.isEmpty()) {
                return new ApiResponse(annotationList, SystemMessages.Annotation.NO_ANNOTATIONS);
            }

            // Mapeamento de Annotation para AnnotationResponseDto
            List<AnnotationResponseDto> annotationResponses = annotationList.stream()
                    .map(annotation -> {
                        AnnotationResponseDto annotationResponse = new AnnotationResponseDto();
                        annotationResponse.setId(annotation.getAnnotationId().toString());
                        annotationResponse.setName(annotation.getName());
                        annotationResponse.setMessage(annotation.getMessage());
                        annotationResponse.setUserId(annotation.getUser().getUserId().toString());
                        return annotationResponse;
                    })
                    .collect(Collectors.toList());

            return new ApiResponse(annotationResponses, SystemMessages.Annotation.SUCCESS_GOT);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.Annotation.FAIL_GET);
        }
    }

    public ApiResponse saveAnnotation(AnnotationDto annotationDto) {
        try {
            if (annotationDto.getName() == null || annotationDto.getName().isEmpty() ||
                    annotationDto.getMessage() == null || annotationDto.getMessage().isEmpty() ||
                    annotationDto.getUserId() == null) {
                return new ApiResponse(annotationDto, SystemMessages.Annotation.MISSING_VALUES);
            }

            Optional<User> user = userRepository.findById(UUID.fromString(annotationDto.getUserId()));
            if (user.isEmpty()) {
                return new ApiResponse(annotationDto, SystemMessages.User.NOT_FOUND);
            }

            Annotation annotation = new Annotation();
            annotation.setName(annotationDto.getName());
            annotation.setMessage(annotationDto.getMessage());
            annotation.setUser(user.get());

            annotationRepository.save(annotation);
            return new ApiResponse(annotation, SystemMessages.Annotation.SUCCESS_CREATED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.Annotation.FAIL_CREATE);
        }
    }

    public void deleteAnnotation(String id) {
        annotationRepository.deleteById(UUID.fromString(id));
    }
}
