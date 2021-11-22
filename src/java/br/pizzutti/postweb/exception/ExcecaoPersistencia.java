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
 * classe responsável por encapsular as exceções de persistência
 */
public class ExcecaoPersistencia extends Exception {

    private static final long serialVersionUID = 1L;

    public ExcecaoPersistencia(String message) {
        super(message);
    }

    public ExcecaoPersistencia(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcecaoPersistencia(Throwable cause) {
        super(cause);
    }
}
