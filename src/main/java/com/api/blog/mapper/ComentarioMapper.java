package com.api.blog.mapper;

import org.springframework.stereotype.Component;

import com.api.blog.dto.request.ComentarioRequestDto;
import com.api.blog.dto.response.ComentarioResponse;
import com.api.blog.model.ComentarioModel;
import com.api.blog.model.PostModel;

@Component
public class ComentarioMapper {
	
	public ComentarioModel toEntity(ComentarioRequestDto dto, PostModel entity) {
		if (dto == null) {
			return null;
		}
		return new ComentarioModel(
				dto.comentario().toString(),
				entity
);
		}
		
		public ComentarioResponse toDto(ComentarioModel entity) {
			if (entity == null) {
				return null;
			}	
			return new ComentarioResponse(entity.getId(),entity.getDate(),entity.getComentario());
		}
		}


