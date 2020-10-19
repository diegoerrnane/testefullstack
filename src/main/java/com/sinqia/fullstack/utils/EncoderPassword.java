package com.sinqia.fullstack.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface EncoderPassword {
	default String codificarSenha(String senha) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		return pe.encode(senha);
	}

}
