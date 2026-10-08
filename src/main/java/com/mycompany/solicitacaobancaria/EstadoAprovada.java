/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solicitacaobancaria;

/**
 *
 * @author PICHAU
 */
public class EstadoAprovada implements EstadoSolicitacao {

    @Override
    public void analisar(SolicitacaoBancaria solicitacao) {
        System.out.println("A solicitação já foi aprovada.");
    }

    @Override
    public void aprovar(SolicitacaoBancaria solicitacao) {
        System.out.println("A solicitação já foi aprovada.");
    }

    @Override
    public void rejeitar(SolicitacaoBancaria solicitacao) {
        System.out.println("Não é possível rejeitar uma solicitação aprovada.");
    }

    @Override
    public String getNome() {
        return "Aprovada";
    }
}