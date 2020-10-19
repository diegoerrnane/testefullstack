package com.sinqia.fullstack.servico.impl;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinqia.fullstack.domain.Usuario;
import com.sinqia.fullstack.repositorio.UsuarioRepository;
import com.sinqia.fullstack.servico.UsuarioService;
import com.sinqia.fullstack.servico.dto.UsuarioDTO;
import com.sinqia.fullstack.servico.mapper.UsuarioMapper;

import lombok.RequiredArgsConstructor;

/**
 * Implementação da Service para gerenciar Usuario
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    private final UsuarioRepository usuarioRepository;

    /**
     * Salvar um usuario
     *
     * @param usuarioDTO entidade a ser Salva
     */
    @Override
    public void save(UsuarioDTO usuarioDTO) throws Exception {
        log.debug("Requisição para salvar : {}", usuarioDTO);
        usuarioRepository.save(new Usuario(usuarioDTO));
    }

	@Override
	public Usuario findByEmail(String email) {
		
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public UsuarioDTO findByEmailDTO(String email) {
		UsuarioDTO usuarioDTO = new UsuarioDTO (usuarioRepository.findByEmail(email));
		return usuarioDTO;
	}
}

