/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.solicitacaobancaria;

/**
 *
 * @author PICHAU
 */
public interface EstadoSolicitacao {

    void analisar(SolicitacaoBancaria solicitacao);

    void aprovar(SolicitacaoBancaria solicitacao);

    void rejeitar(SolicitacaoBancaria solicitacao);

    String getNome();
}