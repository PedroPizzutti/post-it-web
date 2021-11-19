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
public class ExceçaoNegocio extends Exception {
    
    private static final long serialVersionUID = 1L;

    public ExceçaoNegocio(String message) {
        super(message);
    }

    public ExceçaoNegocio(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceçaoNegocio(Throwable cause) {
        super(cause);
    }  
}
