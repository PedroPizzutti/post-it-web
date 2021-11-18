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
public class ExceçaoPersistencia extends Exception {

    private static final long serialVersionUID = 1L;

    public ExceçaoPersistencia(String message) {
        super(message);
    }

    public ExceçaoPersistencia(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceçaoPersistencia(Throwable cause) {
        super(cause);
    }
}
