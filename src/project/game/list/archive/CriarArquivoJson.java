package project.game.list.archive;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import project.game.list.models.Caminhos;
import project.game.list.models.GameList;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class CriarArquivoJson {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String caminho;

    public void arquivoJson(GameList jogo) throws IOException {

        String nomeSanitizado = jogo.getNome().trim().toLowerCase().replaceAll("[^a-z0-9]", "_");

        String nomeArquivo = nomeSanitizado + ".json";

        this.caminho = String.valueOf(Paths.get(Caminhos.PASTA_JSON  + nomeArquivo));

        FileWriter escrita = new FileWriter(this.caminho);

        escrita.write(this.gson.toJson(jogo));

        escrita.close();

    }

}
