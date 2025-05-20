package project.game.list.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.game.list.models.Caminhos;

import java.io.File;

public class TelaContagemJogos {

    public void exibir() {

        Stage stage = new Stage();
        stage.setTitle("Quantidade de jogos adicionados");

        int quantidade = contarArquivosJson();

        Label resultado = new Label("Jogos encontrados: " + quantidade);

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(new Label("Total de jogos cadastrados no sistema: "), resultado);

        stage.setScene(new Scene(layout, 350, 120));
        stage.show();

    }

    private int contarArquivosJson() {

        File pasta = new File(Caminhos.PASTA_JSON);

        File[] arquivos = pasta.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

        return (arquivos == null) ? 0 : arquivos.length;

    }

}