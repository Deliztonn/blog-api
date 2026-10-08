package com.api.blog.service;

import java.util.List;
import java.util.UUID;

import com.api.blog.dto.request.ComentarioRequestDto;
import com.api.blog.dto.request.PostRequestDto;
import com.api.blog.dto.response.ComentarioResponse;
import com.api.blog.dto.response.PostResponseDto;

public interface PostService {

List<PostResponseDto> findAll();

PostResponseDto findById(UUID id);

PostResponseDto createPost (PostRequestDto dto);

ComentarioResponse addComentario(UUID postId, ComentarioRequestDto dto);

}
