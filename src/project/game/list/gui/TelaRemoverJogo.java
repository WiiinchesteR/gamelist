package project.game.list.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.game.list.archive.ExcluirArquivoJson;
import project.game.list.models.Caminhos;

import java.io.File;
import java.util.Optional;

public class TelaRemoverJogo {

    public void exibir() {

        Stage stage = new Stage();
        stage.setTitle("Remover Jogo");

        Label label = new Label("Digite o nome do jogo a ser removido: ");
        TextField campoNome = new TextField();
        campoNome.setPromptText("Nome do jogo");

        Button remover = new Button("Remover");

        Label resultado = new Label();

        // Área com os nomes disponíveis
        TextArea areaJogos = new TextArea();
        areaJogos.setEditable(false);
        areaJogos.setWrapText(true);
        areaJogos.setPrefHeight(300);
        areaJogos.setPrefWidth(400);
        areaJogos.setPromptText("Jogos disponíveis");

        areaJogos.setText(obterNomes());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(
                label, campoNome, remover, resultado, new Label("Jogos disponíveis: "), areaJogos
        );

        remover.setOnAction(e -> {

            String nomeJogo = campoNome.getText().trim();

            ExcluirArquivoJson excluidor = new ExcluirArquivoJson();

            if (nomeJogo.isEmpty()) {

                resultado.setText("Digite um nome válido.");
                return;

            }

            boolean existe = excluidor.verificarSeExiste(nomeJogo);

            if (!existe) {

                resultado.setText("Jogo não encontrado.");
                return;

            }

            // Confirmação
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmar exclusão");
            confirmacao.setHeaderText("Deseja realmente excluir \"" + nomeJogo + "\"?");
            confirmacao.setContentText("Essa ação não pode ser desfeita.");

            // Define explicitamente os botões
            confirmacao.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> resposta = confirmacao.showAndWait();

            if (resposta.isPresent() && resposta.get() == ButtonType.YES) {

                boolean sucesso = excluidor.excluirArquivo(nomeJogo);

                if (sucesso) {

                    resultado.setText("Jogo removido com sucesso!");
                    areaJogos.setText(obterNomes());

                } else {

                    resultado.setText("Erro ao remover o jogo.");

                }

            } else {

                resultado.setText("A exclusão foi cancelada.");

            }

        });

        stage.setScene(new Scene(layout,310, 500));
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