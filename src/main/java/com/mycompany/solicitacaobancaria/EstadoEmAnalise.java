/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solicitacaobancaria;

/**
 *
 * @author PICHAU
 */
public class EstadoEmAnalise implements EstadoSolicitacao {

    @Override
    public void analisar(SolicitacaoBancaria solicitacao) {
        System.out.println("A solicitação já está em análise.");
    }

    @Override
    public void aprovar(SolicitacaoBancaria solicitacao) {
        solicitacao.setEstado(new EstadoAprovada());
        System.out.println("Solicitação aprovada.");
    }

    @Override
    public void rejeitar(SolicitacaoBancaria solicitacao) {
        solicitacao.setEstado(new EstadoRejeitada());
        System.out.println("Solicitação rejeitada.");
    }

    @Override
    public String getNome() {
        return "Em análise";
    }
}
