/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solicitacaobancaria;

/**
 *
 * @author PICHAU
 */
public class EstadoPendente implements EstadoSolicitacao {

    @Override
    public void analisar(SolicitacaoBancaria solicitacao) {
        solicitacao.setEstado(new EstadoEmAnalise());
        System.out.println("Solicitação encaminhada para análise.");
    }

    @Override
    public void aprovar(SolicitacaoBancaria solicitacao) {
        System.out.println("Não é possível aprovar uma solicitação "
                + "que ainda está pendente.");
    }

    @Override
    public void rejeitar(SolicitacaoBancaria solicitacao) {
        System.out.println("Não é possível rejeitar uma solicitação "
                + "antes da análise.");
    }

    @Override
    public String getNome() {
        return "Pendente";
    }
}
