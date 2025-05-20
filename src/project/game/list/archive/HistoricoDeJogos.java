package project.game.list.archive;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import project.game.list.models.Caminhos;
import project.game.list.models.GameList;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HistoricoDeJogos {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void listarHistorico() {

        File pasta = new File(Caminhos.PASTA_JSON);

        File[] arquivos = pasta.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

        if (arquivos == null || arquivos.length == 0) {

            System.out.println("\nNenhum jogo encontrado no histórico.");

            return;

        }

        System.out.println("\n===== HISTÓRICO DE JOGOS ZERADOS =====");

        int contador = 0;

        for (File arquivo : arquivos) {

            try (FileReader reader = new FileReader(arquivo)) {

                GameList jogo = gson.fromJson(reader, GameList.class);

                contador++;

                System.out.println("\n" + contador + "° " + "--------------------------------------------");
                System.out.println("Nome do jogo: " + jogo.getNome());
                System.out.println("Ano de lançamento: " + jogo.getAno());
                System.out.println("Gênero: " + jogo.getGenero());
                System.out.println("Tempo de jogo: " + jogo.getDuracao());
                System.out.println("Data que zerou o jogo: " + jogo.getData());
                System.out.println("-----------------------------------------------");

            } catch (IOException e) {

                System.out.println("Erro ao ler arquivo: " + arquivo.getName());

            }

        }

    }

}