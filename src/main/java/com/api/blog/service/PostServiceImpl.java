package com.api.blog.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.blog.dto.request.ComentarioRequestDto;
import com.api.blog.dto.request.PostRequestDto;
import com.api.blog.dto.response.ComentarioResponse;
import com.api.blog.dto.response.PostResponseDto;
import com.api.blog.mapper.ComentarioMapper;
import com.api.blog.mapper.PostMapper;
import com.api.blog.model.ComentarioModel;
import com.api.blog.model.PostModel;
import com.api.blog.repository.ComentarioRepository;
import com.api.blog.repository.PostRepository;


@Service
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;
	private final PostMapper postMapper;
	private final ComentarioRepository comentarioRepository;
	private final ComentarioMapper comentarioMapper;
	
	
	public PostServiceImpl(PostRepository postrepository, PostMapper postMapper, ComentarioRepository comentarioRepository, ComentarioMapper comentarioMapper) {
		this.postRepository = postrepository;
		this.postMapper = postMapper;
		this.comentarioRepository = comentarioRepository;
		this.comentarioMapper = comentarioMapper;
	}

	@Override
	@Transactional(readOnly = true)
	 public Page<PostResponseDto> findAll(Pageable pageable) {
        Page<PostModel> posts = postRepository.findAll(pageable);

        return posts.map(post -> {
            PostResponseDto dto = postMapper.toDto(post);
            return dto;
        });
    }

	@Override
	@Transactional(readOnly = true)
	public PostResponseDto findById(UUID id) {		
Optional<PostModel> optionalPost = postRepository.findById(id);
		
if (optionalPost.isEmpty()) {
	throw new RuntimeException("Post não encontrado com o ID: " + id);
}
PostModel post = optionalPost.get();
		return postMapper.toDto(post);
	}

	@Override
	@Transactional
	public PostResponseDto createPost(PostRequestDto dto) {
		PostModel post = postMapper.toEntity(dto);
		PostModel saved = postRepository.save(post);
		return postMapper.toDto(saved);
	}

	@Override
	@Transactional
	public ComentarioResponse addComentario(UUID postId, ComentarioRequestDto dto) {
		Optional<PostModel> optionalPost = postRepository.findById(postId);
		PostModel post = optionalPost.get();
		ComentarioModel comentario = new ComentarioModel(dto.comentario(), post);
		post.adicionarComentario(comentario);
		ComentarioModel saved = comentarioRepository.save(comentario);
		return comentarioMapper.toDto(saved);
		
	}

}
