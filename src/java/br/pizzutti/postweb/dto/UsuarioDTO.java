/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.dto;

import java.io.Serializable;

/**
 *
 * @author Pedro
 * Classe DTO para os usuários.
 * 
 */
public class UsuarioDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int idUsuario;
    private String usuario;
    private String senha;
    private String nome;

    public UsuarioDTO() {
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
