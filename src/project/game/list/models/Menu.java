package project.game.list.models;

import project.game.list.archive.BuscarArquivo;
import project.game.list.archive.ExcluirArquivoJson;
import project.game.list.archive.HistoricoDeJogos;
import project.game.list.archive.QuantidadeDeArquivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public void menuDeOpcoes() throws IOException {

        Scanner scanner = new Scanner(System.in);

        LeituraDosDados leitura = new LeituraDosDados();

        File pasta = new File(Caminhos.PASTA_JSON);

        while (true) {

            try {

                System.out.println("\n[1] ADICIONAR JOGO");
                System.out.println("[2] EXIBIR QUANTIDADE DE JOGOS ADICIONADOS");
                System.out.println("[3] BUSCAR JOGO POR NOME");
                System.out.println("[4] LISTAR HISTÓRICO DE JOGOS");
                System.out.println("[5] EXCLUIR JOGO POR NOME");
                System.out.println("[6] SAIR");
                System.out.println("---------------------------------------------");
                System.out.print("Escolha a opção ==> ");

                String opcao = scanner.nextLine();
                int opcaoInt = Integer.parseInt(opcao);

                if (opcaoInt == 6) {

                    System.out.println("\nSaindo da aplicação...");

                    break;

                }

                switch (opcaoInt) {

                    case 1:

                        leitura.receberDados();

                        break;

                    case 2:

                        QuantidadeDeArquivos quantidadeDeArquivos = new QuantidadeDeArquivos();

                        quantidadeDeArquivos.quantidade();

                        break;

                    case 3:

                        if (pasta.exists() && pasta.isDirectory()) {

                            File[] arquivos = pasta.listFiles();

                            if (arquivos == null || arquivos.length == 0) {

                                System.out.println("\nNão há item a ser buscado.");

                            } else {

                                File[] jogos = new File(Caminhos.PASTA_JSON).listFiles();

                                System.out.println("\nJogos disponíveis para busca:");

                                for (File file : jogos) {

                                    System.out.println("- " + file.getName().replace(".json", "")
                                            .replace("_", " ").toUpperCase());

                                }

                                BuscarArquivo buscarArquivo = new BuscarArquivo();

                                System.out.print("\nDigite o nome do jogo: ");
                                String buscarJogo = scanner.nextLine();

                                System.out.println(buscarArquivo.buscar(buscarJogo));

                            }

                        } else {

                            System.out.println("\nO caminho não é uma pasta válida ou não existe.");

                        }

                        break;

                    case 4:

                        HistoricoDeJogos historico = new HistoricoDeJogos();

                        historico.listarHistorico();

                        break;

                    case 5:

                        if (pasta.exists() && pasta.isDirectory()) {

                            File[] arquivos = pasta.listFiles();

                            if (arquivos == null || arquivos.length == 0) {

                                System.out.println("\nNão há nada para ser excluido...");

                            } else {

                                File[] jogos = new File(Caminhos.PASTA_JSON).listFiles();

                                System.out.println("\nJogos disponíveis:");

                                for (File file : jogos) {

                                    System.out.println("- " + file.getName().replace(".json", "")
                                            .replace("_", " ").toUpperCase());

                                }

                                System.out.print("\nDigite o nome do jogo a ser apagado: ");
                                String nomeJogo = scanner.nextLine();

                                ExcluirArquivoJson excluir = new ExcluirArquivoJson();

                                excluir.excluirArquivo(nomeJogo);

                            }

                        } else {

                            System.out.println("\nO caminho não é uma pasta válida ou não existe.");

                        }

                        break;

                    default:

                        System.out.println("\nOpção inválida!");

                }

            } catch (NumberFormatException e) {

                System.out.println("\nDigite somente números inteiros...");

            }

        }

    }

}
