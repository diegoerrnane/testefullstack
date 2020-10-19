package com.sinqia.fullstack.servico.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sinqia.fullstack.domain.Usuario;
import com.sinqia.fullstack.security.UserSS;
import com.sinqia.fullstack.servico.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioService.findByEmail(email);
		
		if(usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(usuario.getId(), usuario.getEmail(), usuario.getSenha());
	}

}
