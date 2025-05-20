package project.game.list.archive;

import project.game.list.models.Caminhos;

import java.io.File;

public class ExcluirArquivoJson {

    public boolean excluirArquivo(String nomeJogo) {

        String nomeSanitizado = nomeJogo.trim().toLowerCase().replaceAll("[^a-z0-9]", "_");

        String nomeArquivo = nomeSanitizado + ".json";

        File arquivo = new File(Caminhos.PASTA_JSON, nomeArquivo);

        if (arquivo.exists()) {

            return arquivo.delete();

        }

        return false;

    }

    public boolean verificarSeExiste(String nomeJogo) {

        String nomeSanitizado = nomeJogo.toLowerCase().replaceAll("[^a-z0-9]", "_");

        String nomeArquivo = nomeSanitizado + ".json";

        File arquivo = new File(Caminhos.PASTA_JSON, nomeArquivo);

        return arquivo.exists();

    }

}
