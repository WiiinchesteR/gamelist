package project.game.list.archive;

import com.google.gson.Gson;
import project.game.list.models.Caminhos;
import project.game.list.models.GameList;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

public class BuscarArquivo {

    public String buscar(String nomeJogo) {

        File pasta = new File(Caminhos.PASTA_JSON);

        String nomeSanitizado = nomeJogo.trim().toLowerCase().replaceAll("[^a-z0-9]", "_");

        String nomeArquivo = nomeSanitizado + ".json";

        File[] arquivos = pasta.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {

                return name.equals(nomeArquivo);

            }

        });


        if (arquivos == null || arquivos.length == 0) {

            return "Nenhum jogo encontrado.";

        }

        Gson gson = new Gson();

        StringBuilder resultado = new StringBuilder();

        for (File arquivo : arquivos) {

            try (FileReader reader = new FileReader(arquivo)) {

                GameList jogo = gson.fromJson(reader, GameList.class);

                if (jogo.getNome().toLowerCase().contains(nomeJogo.toLowerCase())) {

                    resultado.append("             --- Jogo encontrado ---\n\n" + jogo.toString());

                }

            } catch (IOException e) {

                resultado.append("\nErro ao ler o arquivo: ").append(arquivo.getName());

            }

        }

        return resultado.length() == 0
                ? "\nNenhum jogo encontrado com esse nome."
                : resultado.toString();
    }
}
