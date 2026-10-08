/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solicitacaobancaria;

/**
 *
 * @author PICHAU
 */
public class EstadoRejeitada implements EstadoSolicitacao {

    @Override
    public void analisar(SolicitacaoBancaria solicitacao) {
        System.out.println("A solicitação já foi rejeitada.");
    }

    @Override
    public void aprovar(SolicitacaoBancaria solicitacao) {
        System.out.println("Não é possível aprovar uma solicitação rejeitada.");
    }

    @Override
    public void rejeitar(SolicitacaoBancaria solicitacao) {
        System.out.println("A solicitação já foi rejeitada.");
    }

    @Override
    public String getNome() {
        return "Rejeitada";
    }
}
