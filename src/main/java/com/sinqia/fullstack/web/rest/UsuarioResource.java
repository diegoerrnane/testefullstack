package com.sinqia.fullstack.web.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.sinqia.fullstack.servico.UsuarioService;
import com.sinqia.fullstack.servico.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/createAccount")
@RequiredArgsConstructor
public class UsuarioResource {

    private final Logger log = LoggerFactory.getLogger(UsuarioService.class);
    private final UsuarioService usuarioService;

    @PostMapping(path = "/incluir")
    @Timed
    public ResponseEntity incluir(
            @Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception {

        try {
            usuarioService.save(usuarioDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping(path = "/editar")
    @Timed
    public ResponseEntity editar(
    		@Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception {
    	
    	try {
    		usuarioService.save(usuarioDTO);
    		return ResponseEntity.ok().build();
    	} catch (Exception e) {
    		log.error(e.getMessage(), e);
    		return ResponseEntity.badRequest().build();
    	}
    }
    
    @GetMapping(path = "/{email}")
    @Timed
    public ResponseEntity<UsuarioDTO> findById(
            @Valid @PathVariable String email) throws Exception {

        try {
            return new ResponseEntity<>(usuarioService.findByEmailDTO(email), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }
}


