package com.api.blog.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.blog.dto.request.ComentarioRequestDto;
import com.api.blog.dto.request.PostRequestDto;
import com.api.blog.dto.response.ComentarioResponse;
import com.api.blog.dto.response.PostResponseDto;

public interface PostService {

Page<PostResponseDto> findAll(Pageable pageable);

Page<PostResponseDto> findAll(Pageable pageable, String titulo);

PostResponseDto findById(UUID id);

PostResponseDto createPost (PostRequestDto dto);

ComentarioResponse addComentario(UUID postId, ComentarioRequestDto dto);

}
