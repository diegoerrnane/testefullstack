package com.sinqia.fullstack.servico.mapper;

import org.mapstruct.Mapper;

import com.sinqia.fullstack.domain.Usuario;
import com.sinqia.fullstack.servico.dto.UsuarioDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO usuarioDTO);

    Usuario toDto(Usuario usuario);
}

