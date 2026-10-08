package com.api.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.blog.model.PostModel;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<PostModel, UUID> {

		
}
