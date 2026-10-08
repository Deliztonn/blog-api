package com.api.blog.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.blog.dto.request.PostRequestDto;
import com.api.blog.dto.response.ComentarioResponse;
import com.api.blog.dto.response.PostResponseDto;
import com.api.blog.model.ComentarioModel;
import com.api.blog.model.PostModel;

@Component
public class PostMapper {

	 private final ComentarioMapper comentarioMapper;
	 
	 public PostMapper(ComentarioMapper comentarioMapper) {
	        this.comentarioMapper = comentarioMapper;
	    }
	
	public PostModel toEntity(PostRequestDto dto) {

		if (dto == null) {
			return null;

		}	return new PostModel(dto.autor(), dto.titulo(), dto.texto());
	}

	public PostResponseDto toDto(PostModel entity) {
		
		if (entity == null) {
			return null;
		}
		List<ComentarioResponse> comentarioDto = new ArrayList<>();
		
		if(entity.getComentarios() != null) {
			for (ComentarioModel comentario : entity.getComentarios()) {
				ComentarioResponse dto = comentarioMapper.toDto(comentario);
				comentarioDto.add(dto);
			}
		}		
		
		return new PostResponseDto(
				entity.getId(),
				entity.getAutor(),
				entity.getData(),
				entity.getTitulo(),
				entity.getTexto(),
				comentarioDto
				);
	}
	
		
	}
