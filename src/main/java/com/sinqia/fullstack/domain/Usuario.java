package com.sinqia.fullstack.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sinqia.fullstack.servico.dto.UsuarioDTO;
import com.sinqia.fullstack.utils.EncoderPassword;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TB_USUARIO")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Usuario implements Serializable, EncoderPassword {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1)
    private Long id;

    @Column(name = "NOME_USUARIO")
    private String nome;

    @Column(name = "CPF_USUARIO")
    private String cpf;

    @Column(name = "DATA_NASC_USUARIO")
    private String dataNasc;

    @Column(name = "EMAIL_USUARIO")
    private String email;

    @Column(name = "TELEFONE_USUARIO")
    private String telefone;

    @Column(name = "SENHA_USUARIO")
    private String senha;

    @Column(name = "CEP_USUARIO")
    private String cep;

    @Column(name = "LOGRADOURO_USUARIO", length = 100)
    private String logradouro;

    @JoinColumn(name = "ESTADO_USUARIO")
    private String uf;

    @Column(name = "CIDADE_USUARIO")
    private String cidade;
    
    @Column(name = "COMPLEMENTO_USUARIO")
    private String complemento;

    @Column(name = "BAIRRO_USUARIO", length = 100)
    private String bairro;

    @Column(name = "NUMERO_USUARIO", length = 10)
    private String numero;
    
    public Usuario(UsuarioDTO usuarioDTO) {
    	this.id = usuarioDTO.getId();
    	this.nome = usuarioDTO.getNome();
    	this.cpf = usuarioDTO.getCpf();
    	this.dataNasc = usuarioDTO.getDataNasc();
    	this.email = usuarioDTO.getEmail();
    	this.telefone = usuarioDTO.getTelefone();
    	this.senha = codificarSenha(usuarioDTO.getSenha());
    	this.cep = usuarioDTO.getCep();
    	this.logradouro = usuarioDTO.getLogradouro();
    	this.uf = usuarioDTO.getUf();
    	this.cidade = usuarioDTO.getCidade();
    	this.complemento = usuarioDTO.getComplemento();
    	this.bairro = usuarioDTO.getBairro();
    	this.numero = usuarioDTO.getNumero();
    }
}

