/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.exception;

/**
 *
 * @author Pedro
 * 
 * Classe de exceção para os objetos de negócio.
 */
public class ExcecaoNegocio extends Exception {
    
    private static final long serialVersionUID = 1L;

    public ExcecaoNegocio(String message) {
        super(message);
    }

    public ExcecaoNegocio(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcecaoNegocio(Throwable cause) {
        super(cause);
    }  
}
