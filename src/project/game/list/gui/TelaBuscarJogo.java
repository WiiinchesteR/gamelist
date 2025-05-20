package project.game.list.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.game.list.archive.BuscarArquivo;
import project.game.list.models.Caminhos;

import java.io.File;

public class TelaBuscarJogo {

    public void exibir() {

        Stage stage = new Stage();
        stage.setTitle("Buscar Jogo por Nome");

        // Campo
        TextField campoBusca = new TextField();
        campoBusca.setPromptText("Digite o nome do Jogo");

        // Botão
        Button buscar = new Button("Buscar");

        TextArea areaResultado = new TextArea();
        areaResultado.setEditable(false);
        areaResultado.setWrapText(true);

        TextArea areaJogos = new TextArea();
        areaJogos.setEditable(false);
        areaJogos.setWrapText(true);
        areaJogos.setPrefHeight(100);
        areaJogos.setPrefWidth(200);
        areaJogos.setPromptText("Jogos disponíveis");

        areaJogos.setText(obterNomes());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                new Label("Nome do Jogo: "), campoBusca, buscar, areaResultado,
                new Label("Jogos disponíveis para busca: "), areaJogos
        );

        // Ação
        buscar.setOnAction(e -> {

            String nome = campoBusca.getText().trim();

            if (nome.isEmpty()) {

                areaResultado.setText("Digite um nome para buscar");
                return;

            }

            BuscarArquivo buscador = new BuscarArquivo();

            String resultado = buscador.buscar(nome);

            areaResultado.setText(resultado);

        });

        stage.setScene(new Scene(layout, 310, 500));
        stage.show();

    }

    private String obterNomes() {

        File pasta = new File(Caminhos.PASTA_JSON);

        File[] arquivos = pasta.listFiles(((dir, name) -> name.toLowerCase().endsWith(".json")));

        if (arquivos == null || arquivos.length == 0) {

            return "Nenhum jogo disponível.";

        }

        StringBuilder nomes = new StringBuilder();

        for (File arquivo : arquivos) {

            String nome = arquivo.getName().replace(".json", "").replace("_", " ");
            nomes.append("- ").append(nome.toUpperCase()).append("\n");

        }

        return nomes.toString();

    }


}
