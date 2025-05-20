package project.game.list.gui;

import com.google.gson.Gson;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.game.list.models.Caminhos;
import project.game.list.models.GameList;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TelaHistoricoJogos {

    public void exibir() {

        Stage stage = new Stage();
        stage.setTitle("Histórico de jogos zerados");

        TextArea areaTexto = new TextArea();
        areaTexto.setEditable(false);
        areaTexto.setWrapText(true);
        areaTexto.setPrefHeight(600);
        areaTexto.setPrefWidth(400);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(new Label("Jogos encontrados"), areaTexto);

        StringBuilder resultado = new StringBuilder();

        File pasta = new File(Caminhos.PASTA_JSON);

        File[] arquivos = pasta.listFiles(((dir, name) -> name.toLowerCase().endsWith(".json")));

        if (arquivos == null || arquivos.length == 0) {

            resultado.append("Nenhum jogo cadastrado.");

        } else {

            Gson gson = new Gson();

            int contador = 0;

            for (File arquivo : arquivos) {

                try (FileReader reader = new FileReader(arquivo)) {

                    contador++;

                    GameList jogo = gson.fromJson(reader, GameList.class);

                    resultado.append(contador).append("° ").append(jogo.toString()).append("\n");

                } catch (IOException e) {

                    resultado.append("Erro ao ler o arquivo.").append(arquivo.getName()).append("\n");

                }

            }

        }

        areaTexto.setText(resultado.toString());

        stage.setScene(new Scene(layout, 400, 700));
        stage.show();

    }

}
