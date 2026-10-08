package com.api.blog.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.blog.dto.request.ComentarioRequestDto;
import com.api.blog.dto.request.PostRequestDto;
import com.api.blog.dto.response.ComentarioResponse;
import com.api.blog.dto.response.PostResponseDto;
import com.api.blog.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Posts e comentários", description = "Operações de Blog API")
@RestController
@RequestMapping("/api/posts")
public class PostController {

private final PostService postService;
	

public PostController(PostService postService) {
	this.postService = postService;
}

@Operation(summary = "Lista posts com paginação")
@GetMapping
public ResponseEntity<List<PostResponseDto>> getAllPosts(){
	return ResponseEntity.ok(postService.findAll());
}
@Operation(summary = "Exibe um post pelo ID")
@GetMapping("/{id}")
public ResponseEntity<PostResponseDto> getPostById(@PathVariable UUID id){
	return ResponseEntity.ok(postService.findById(id));
} 
@Operation(summary = "Cria um novo post")
@PostMapping("/newpost")
public ResponseEntity<PostResponseDto> createPost(@RequestBody @Valid PostRequestDto dto){
	PostResponseDto created = postService.createPost(dto);
	return ResponseEntity.status(HttpStatus.CREATED).body(created);
}
@Operation(summary = "Cria um comentário em um post")
@PostMapping("/comentarios/{postId}")
public ResponseEntity<ComentarioResponse> createComentario(
		@PathVariable UUID postId,
		@RequestBody @Valid ComentarioRequestDto dto){
	return ResponseEntity.status(HttpStatus.CREATED).body(postService.addComentario(postId, dto));
}


}
