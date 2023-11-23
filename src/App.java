// Classe base que representa uma solicitação

import javax.swing.JOptionPane;

class Solicitacao {
    private String categoria;

    public Solicitacao(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}// Handler abstrato que define o comportamento comum para todos os handlers

abstract class Item {
    protected Item proximoItem;

    public void definirProximoItem(Item item) {
        proximoItem = item;
    }

    public abstract void processarSolicitacao(Solicitacao solicitacao);
}// ConcreteHandler que trata uma solicitação específica

class HandlerSalgado extends Item {
    public void processarSolicitacao(Solicitacao solicitacao) {
        if (solicitacao.getCategoria().equals("Salgado")) {
            System.out.println("HandlerSalgado trata a solicitação do item de categoria Salgado.");
            String mensagem = "HandlerSalgado trata a solicitação do item de categoria Salgado.";
            JOptionPane.showMessageDialog(null, mensagem);
        } else if (proximoItem != null) {
            proximoItem.processarSolicitacao(solicitacao);
        }
    }
}// ConcreteHandler que trata outra solicitação específica

class HandlerBolo extends Item {
    public void processarSolicitacao(Solicitacao solicitacao) {
        if (solicitacao.getCategoria().equals("Bolo")) {
            System.out.println("HandlerBolo trata a solicitação do item de categoria Bolo.");

            String mensagem = "HandlerBolo trata a solicitação do item de categoria Bolo.";
            JOptionPane.showMessageDialog(null, mensagem);
        } else if (proximoItem != null) {
            proximoItem.processarSolicitacao(solicitacao);
        }
    }
}// ConcreteHandler que trata outra solicitação específica

class HandlerBebida extends Item {
    public void processarSolicitacao(Solicitacao solicitacao) {
        if (solicitacao.getCategoria().equals("Bebida")) {
            System.out.println("HandlerBebida trata a solicitação do item de categoria Bebida.");
            String mensagem = "HandlerBebida trata a solicitação do item de categoria Bebida.";
            JOptionPane.showMessageDialog(null, mensagem);
        } else if (proximoItem != null) {
            proximoItem.processarSolicitacao(solicitacao);
        }
    }
}

public class App {
    public static void main(String[] args) {
        // Criando a cadeia de handlers
        Item salgado = new HandlerSalgado();
        Item bolo = new HandlerBolo();
        Item bebida = new HandlerBebida();
        salgado.definirProximoItem(bolo);
        bolo.definirProximoItem(bebida);// Processando solicitações
        Solicitacao solicitacaoA = new Solicitacao("Salgado");
        Solicitacao solicitacaoB = new Solicitacao("Bolo");
        Solicitacao solicitacaoC = new Solicitacao("Bebida");
        Solicitacao solicitacaoD = new Solicitacao("Doce");
        salgado.processarSolicitacao(solicitacaoA);
        salgado.processarSolicitacao(solicitacaoB);
        salgado.processarSolicitacao(solicitacaoC);
        salgado.processarSolicitacao(solicitacaoD);
    }
}