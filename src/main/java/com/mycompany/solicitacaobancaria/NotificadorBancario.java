/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solicitacaobancaria;
import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author PICHAU
 */

public class NotificadorBancario implements Observer {

    private String ultimaNotificacao;

    @Override
    public void update(Observable origem, Object argumento) {
        if (origem instanceof SolicitacaoBancaria) {
            ultimaNotificacao = (String) argumento;
        }
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}