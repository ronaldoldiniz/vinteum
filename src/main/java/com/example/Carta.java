package com.example;

public class Carta {

    private int numero;
    private Naipe naipe;

    public Carta(int numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    /**
     * Retorna o caminho relativo da imagem da carta conforme os arquivos em classic-cards.
     */
    public String imagePath() {
        String prefixo = nomeNumero();
        return "classic-cards/" + prefixo + this.naipe + ".png";
    }

    private String nomeNumero() {
        switch (numero) {
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return String.valueOf(numero);
        }
    }

    public int getNumero() {
        return numero;
    }

    public Naipe getNaipe() {
        return naipe;
    }
}

