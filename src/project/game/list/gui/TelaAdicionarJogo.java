package project.game.list.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import project.game.list.archive.CriarArquivoJson;
import project.game.list.models.GameList;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TelaAdicionarJogo {

    public void exibir() {

        Stage stage = new Stage();
        stage.setTitle("Adicionar Jogo");

        // Campos
        TextField campoNome = new TextField();
        TextField campoAno = new TextField();
        TextField campoGenero = new TextField();
        TextField campoDuracao = new TextField();
        TextField campoData = new TextField();

        // Botão
        Button salvar = new Button("Salvar Jogo");

        // Layout
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));

        grid.add(new Label("Nome do Jogo: "), 0 ,0);
        grid.add(campoNome, 1, 0);

        grid.add(new Label("Ano de Lançamento: "), 0 ,1);
        grid.add(campoAno, 1, 1);

        grid.add(new Label("Gênero: "), 0 ,2);
        grid.add(campoGenero, 1, 2);

        grid.add(new Label("Duração (hh:mm): "), 0 ,3);
        grid.add(campoDuracao, 1, 3);

        grid.add(new Label("Data em que zerou o jogo (dd/mm/aaaa): "), 0 ,4);
        grid.add(campoData, 1, 4);

        grid.add(salvar, 1, 5);

        // Ação do Botão
        salvar.setOnAction(e -> {
            try {
                GameList jogo = new GameList();

                jogo.setNome(campoNome.getText());
                jogo.setAno(Integer.parseInt((campoAno.getText())));
                jogo.setGenero(campoGenero.getText());
                jogo.setDuracao(campoDuracao.getText());
                jogo.setData(campoData.getText());

                CriarArquivoJson json = new CriarArquivoJson();

                json.arquivoJson(jogo);

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);

                alerta.setTitle("Sucesso!");
                alerta.setHeaderText(null);
                alerta.setContentText("Jogo salvo com sucesso!");
                alerta.showAndWait();

                // Fechar a janela
                stage.close();

            } catch (Exception ex) {
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setTitle("Erro");
                erro.setHeaderText("Erro ao salvar o jogo.");
                erro.setContentText("Verifique os dados e tente novamente!");
                erro.showAndWait();
            }
        });

        stage.setScene(new Scene(grid, 450, 250));
        stage.show();

    }

}
