/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solicitacaobancaria;
import java.util.Observable;

/**
 *
 * @author PICHAU
 */
public class SolicitacaoBancaria extends Observable {

    private String identificador;
    private EstadoSolicitacao estado;

    public SolicitacaoBancaria(String identificador) {
        this.identificador = identificador;
        this.estado = new EstadoPendente();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void analisar() {
        alterarEstado(() -> estado.analisar(this));
    }

    public void aprovar() {
        alterarEstado(() -> estado.aprovar(this));
    }

    public void rejeitar() {
        alterarEstado(() -> estado.rejeitar(this));
    }

    public String getEstadoAtual() {
        return estado.getNome();
    }

    public void setEstado(EstadoSolicitacao novoEstado) {
        this.estado = novoEstado;
    }

    private void alterarEstado(Runnable operacao) {
        String estadoAnterior = getEstadoAtual();

        operacao.run();

        String estadoAtual = getEstadoAtual();

        if (!estadoAnterior.equals(estadoAtual)) {
            setChanged();
            notifyObservers(
                "Solicitação " + identificador
                + ": " + estadoAnterior
                + " -> " + estadoAtual
            );
        }
    }
}
