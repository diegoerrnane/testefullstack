package com.sinqia.fullstack.servico.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import com.sinqia.fullstack.domain.Usuario;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private Long id;
    private String nome;
    private String cpf;
    private String dataNasc;
    private String email;
    private String telefone;
    private String senha;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;
    
	public UsuarioDTO(Usuario usuario) {
    	this.id = usuario.getId();
    	this.nome = usuario.getNome();
    	this.cpf = usuario.getCpf();
    	this.dataNasc = usuario.getDataNasc();
    	this.email = usuario.getEmail();
    	this.telefone = usuario.getTelefone();
    	this.senha = usuario.getSenha();
    	this.cep = usuario.getCep();
    	this.logradouro = usuario.getLogradouro();
    	this.uf = usuario.getUf();
    	this.complemento = usuario.getComplemento();
    	this.cidade = usuario.getCidade();
    	this.bairro = usuario.getBairro();
    	this.numero = usuario.getNumero();
    	
    }
}

