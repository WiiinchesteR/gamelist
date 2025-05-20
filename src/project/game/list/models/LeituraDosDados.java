package project.game.list.models;

import project.game.list.archive.CriarArquivoJson;

import java.io.IOException;
import java.util.Scanner;

public class LeituraDosDados {

    private GameList jogo = new GameList();

    public void receberDados() throws IOException {

        Scanner scanner = new Scanner(System.in);

        CriarArquivoJson criarJson = new CriarArquivoJson();

        System.out.print("\nDigite o nome do jogo: ");
        String nome = scanner.nextLine();

        this.jogo.setNome(nome.trim());

        while (true) {

            try {

                System.out.print("Digite o ano de lançamento: ");
                String ano = scanner.nextLine();
                int anoInt = Integer.parseInt(ano.trim());

                this.jogo.setAno(anoInt);

                break;

            } catch (NumberFormatException e) {

                System.out.println("Digite somente números inteiros...");

            }

        }

        System.out.print("Digite o gênero: ");
        String genero = scanner.nextLine();

        this.jogo.setGenero(genero.trim());

        System.out.println("\nUtilize os formatos abaixo\n");

        System.out.print("Tempo jogado (hh:mm): ");
        String duracao = scanner.nextLine();

        this.jogo.setDuracao(duracao.trim());

        System.out.print("Data em que zerou o jogo (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        this.jogo.setData(data.trim());

        criarJson.arquivoJson(this.jogo);

        System.out.println("\nJogo adicionado com sucesso!");

    }

}
