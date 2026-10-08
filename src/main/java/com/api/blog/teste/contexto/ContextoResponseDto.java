
package com.api.blog.teste.contexto;

public record ContextoResponseDto(
		String locale,
		String timezone,
		String data,
		String moeda,
		String numero
		) {
}
