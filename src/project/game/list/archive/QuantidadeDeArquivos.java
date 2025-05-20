package project.game.list.archive;

import project.game.list.models.Caminhos;

import java.io.File;
import java.nio.file.Paths;

public class QuantidadeDeArquivos {

    public void quantidade() {

        File pasta = new File(String.valueOf(Paths.get(Caminhos.PASTA_JSON)));

        if (pasta.isDirectory()) {

            File[] arquivos = pasta.listFiles();

            if (arquivos == null || arquivos.length == 0) {

                System.out.println("\nNenhum jogo adicionado.");

            } else {

                int quantidadeArquivos = 0;

                for (File arquivo : arquivos) {

                    if (arquivo.isFile()) {

                        quantidadeArquivos++;

                    }

                }

                System.out.println("\nQuantidade de jogos adicionados: " + quantidadeArquivos);

            }

        } else {

            System.out.println("\nO caminho especificado não é uma pasta.\n");

        }

    }

}
