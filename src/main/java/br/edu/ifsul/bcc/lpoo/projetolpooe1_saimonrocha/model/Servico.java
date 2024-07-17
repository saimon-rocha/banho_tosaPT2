/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Saimon AS Rocha
 */
public enum Servico {
    TOSA(30.00),
    UNHAS(20.00),
    BANHO(80.00);

    private final double valor;

    Servico(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
