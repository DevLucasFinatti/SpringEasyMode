package com.study.security.repository;

import com.study.security.entity.Annotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, UUID> {
    List<Annotation> findByUser_UserId(UUID userId);
}