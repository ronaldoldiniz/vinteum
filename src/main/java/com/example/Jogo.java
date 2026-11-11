package com.example;

public class Jogo {

    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo() {
        monte.embaralhar();
    }

    /**
     * Vira uma carta do monte e entrega ao jogador, caso ele ainda não tenha parado.
     */
    public Carta distribuiCartaParaJogador(Jogador jogador) {
        if (jogador == null || jogador.parou()) {
            return null;
        }
        Carta carta = monte.virar();
        if (carta != null) {
            jogador.receberCarta(carta);
        }
        return carta;
    }

    public boolean acabou() {
        boolean osDoisPararam = jogador.parou() && computador.parou();
        boolean alguemEstourou = jogadorEstourou() || computadorEstourou();
        return osDoisPararam || alguemEstourou;
    }

    public String resultado() {
        if (pontuacaoEmpatou() || (jogadorEstourou() && computadorEstourou())) {
            return "Empate";
        }
        if (computadorEstourou() || (!jogadorEstourou() && jogador.getPontos() > computador.getPontos())) {
            return "Você ganhou";
        }
        return "Você perdeu";
    }

    public Computador getComputador() {
        return computador;
    }

    public Jogador getJogador() {
        return jogador;
    }

    private boolean jogadorEstourou() {
        return jogador.getPontos() > 21;
    }

    private boolean computadorEstourou() {
        return computador.getPontos() > 21;
    }

    private boolean pontuacaoEmpatou() {
        return jogador.getPontos() == computador.getPontos();
    }
}

