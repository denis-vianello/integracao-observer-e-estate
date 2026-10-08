/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package teste;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.solicitacaobancaria.SolicitacaoBancaria;
import com.mycompany.solicitacaobancaria.NotificadorCliente;
import com.mycompany.solicitacaobancaria.NotificadorBancario;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PICHAU
 */
public class SolicitacaoBancariaTest {

    // TESTES DO PADRÃO STATE

    @Test
    public void deveIniciarComoPendente() {
        SolicitacaoBancaria solicitacao =
                new SolicitacaoBancaria("SOL-001");

        assertEquals("Pendente", solicitacao.getEstadoAtual());
    }

    @Test
    public void devePassarParaAnalise() {
        SolicitacaoBancaria solicitacao =
                new SolicitacaoBancaria("SOL-001");

        solicitacao.analisar();

        assertEquals("Em análise", solicitacao.getEstadoAtual());
    }

    @Test
    public void deveAprovarSolicitacaoEmAnalise() {
        SolicitacaoBancaria solicitacao =
                new SolicitacaoBancaria("SOL-001");

        solicitacao.analisar();
        solicitacao.aprovar();

        assertEquals("Aprovada", solicitacao.getEstadoAtual());
    }

    @Test
    public void deveRejeitarSolicitacaoEmAnalise() {
        SolicitacaoBancaria solicitacao =
                new SolicitacaoBancaria("SOL-001");

        solicitacao.analisar();
        solicitacao.rejeitar();

        assertEquals("Rejeitada", solicitacao.getEstadoAtual());
    }

    @Test
    public void naoDeveAprovarSolicitacaoPendente() {
        SolicitacaoBancaria solicitacao =
                new SolicitacaoBancaria("SOL-001");

        solicitacao.aprovar();

        assertEquals("Pendente", solicitacao.getEstadoAtual());
    }

    @Test
    public void naoDeveAlterarSolicitacaoAprovada() {
        SolicitacaoBancaria solicitacao =
                new SolicitacaoBancaria("SOL-001");

        solicitacao.analisar();
        solicitacao.aprovar();
        solicitacao.rejeitar();

        assertEquals("Aprovada", solicitacao.getEstadoAtual());
    }

    // TESTES DO PADRÃO OBSERVER

    @Test
    public void deveNotificarUmObservador() {
        SolicitacaoBancaria solicitacao =
                new SolicitacaoBancaria("SOL-001");
        NotificadorCliente cliente = new NotificadorCliente();

        solicitacao.addObserver(cliente);
        solicitacao.analisar();

        assertEquals(
                "Solicitação SOL-001: Pendente -> Em análise",
                cliente.getUltimaNotificacao()
        );
    }

    @Test
    public void deveNotificarDoisObservadores() {
        SolicitacaoBancaria solicitacao =
                new SolicitacaoBancaria("SOL-001");
        NotificadorCliente cliente = new NotificadorCliente();
        NotificadorBancario banco = new NotificadorBancario();

        solicitacao.addObserver(cliente);
        solicitacao.addObserver(banco);
        solicitacao.analisar();

        String mensagem =
                "Solicitação SOL-001: Pendente -> Em análise";

        assertEquals(mensagem, cliente.getUltimaNotificacao());
        assertEquals(mensagem, banco.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarObservadorNaoInscrito() {
        SolicitacaoBancaria solicitacao =
                new SolicitacaoBancaria("SOL-001");
        NotificadorCliente cliente = new NotificadorCliente();

        solicitacao.analisar();

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarQuandoEstadoNaoMuda() {
        SolicitacaoBancaria solicitacao =
                new SolicitacaoBancaria("SOL-001");
        NotificadorCliente cliente = new NotificadorCliente();

        solicitacao.addObserver(cliente);
        solicitacao.aprovar();

        assertNull(cliente.getUltimaNotificacao());
        assertEquals("Pendente", solicitacao.getEstadoAtual());
    }
}

