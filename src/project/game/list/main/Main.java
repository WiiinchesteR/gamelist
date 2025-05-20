package project.game.list.main;

import project.game.list.models.Menu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();

        System.out.println("\n===== GAMELIST - Lista de Jogos zerados =====");

        menu.menuDeOpcoes();

    }

}
