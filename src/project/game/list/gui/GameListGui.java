package project.game.list.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameListGui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("GameList - Lista de jogos zerados.");

        // Botões
        Button adicionar = new Button("Adicionar Jogo");
        Button buscar = new Button("Buscar Jogo por Nome");
        Button historico = new Button("Listar Histórico");
        Button remover = new Button("Remover Jogo por Nome");
        Button quantidade = new Button("Quantidade de jogos");
        Button sair = new Button("Sair");


        // Ações
        adicionar.setOnAction(e -> new TelaAdicionarJogo().exibir());
        buscar.setOnAction(e -> new TelaBuscarJogo().exibir());
        historico.setOnAction(e -> new TelaHistoricoJogos().exibir());
        remover.setOnAction(e -> new TelaRemoverJogo().exibir());
        quantidade.setOnAction(e -> new TelaContagemJogos().exibir());
        sair.setOnAction(e -> stage.close());

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                adicionar,
                buscar,
                historico,
                remover,
                quantidade,
                sair
        );

        // Cena
        Scene scene = new Scene(layout,400, 250);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }
}
