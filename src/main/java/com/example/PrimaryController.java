package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {

    @FXML private HBox mesaDoJogador;
    @FXML private HBox mesaDoComputador;
    @FXML private ImageView monte;

    @FXML private Label pontosMesa;
    @FXML private Label pontosJogador;
    @FXML private Label resultado;

    private Jogo jogo = new Jogo();

    public void turno(){
        if (!jogo.jogador.parou()) {
            jogo.distribuiCartaParaJogador(jogo.jogador);
        }
        if (!jogo.computador.parou()) {
            jogo.distribuiCartaParaJogador(jogo.computador);
        }
        atualizar();
    }

    public void atualizar(){
        pontosJogador.setText("Jogador: " + jogo.jogador.getPontos());
        pontosMesa.setText("Mesa: " + jogo.computador.getPontos());
        
        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();

        jogo.jogador.getCartas().forEach((carta) -> mesaDoJogador.getChildren().add(imagemCarta(carta)));
        jogo.computador.getCartas().forEach((carta) -> mesaDoComputador.getChildren().add(imagemCarta(carta)));

        if (jogo.acabou()) {
            resultado.setText(jogo.resultado());
        }
    }

    public void novoJogo(){
        jogo = new Jogo();
        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();
        pontosJogador.setText("Jogador: 0");
        pontosMesa.setText("Mesa: 0");
        resultado.setText("");
    }

    public void pedirCarta(){
        if (!jogo.acabou()) {
            turno();
        }
    }

    public void parar(){
        if (jogo.acabou()) {
            return;
        }
        jogo.jogador.parar();
        while (!jogo.acabou()) {
            turno();
        }
        atualizar();
    }
    

    private ImageView imagemCarta(Carta carta) {
        return new ImageView(App.class.getResource(carta.imagePath()).toString());
    }

}
