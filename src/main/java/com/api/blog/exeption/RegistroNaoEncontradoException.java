package com.api.blog.exeption;

import java.util.UUID;

public class RegistroNaoEncontradoException extends RuntimeException{

	public RegistroNaoEncontradoException(String message,UUID id) {
		super(message);
	}
	
}
