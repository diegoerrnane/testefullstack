package com.sinqia.fullstack.servico;

import com.sinqia.fullstack.domain.Usuario;
import com.sinqia.fullstack.servico.dto.UsuarioDTO;

public interface UsuarioService {

    void save(UsuarioDTO usuarioDTO) throws Exception;
    Usuario findByEmail (String email);
    UsuarioDTO findByEmailDTO (String email);

}
