package ru.netology;

import java.lang.management.PlatformLoggingMXBean;
import java.util.LinkedList;

public class Game {
    LinkedList<Player> players;

    public Game() {
        players = new LinkedList<Player>();
    }

    public void register(Player player) {
        this.players.add(player);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {

        Player player2;
        Player player1;
        if (scan(playerName1) == -1) {
            throw new NotRegisteredException("ошибка не зарегистрирован пользователь " + playerName1);
        }
        if (scan(playerName2) == -1) {
            throw new NotRegisteredException("ошибка не зарегистрирован пользователь " + playerName1);
        }

        player2 = players.get(scan(playerName2));
        player1 = players.get(scan(playerName1));
        int a = player1.strength - player2.strength;


        if (a > 0)
            return 1;
        if (a < 0)
            return 2;
        return 0;
    }

    private int scan(String playerName) {
        Player tmp;
        for (int i = 0; i <= players.size() - 1; i++) {
            tmp = players.get(i);
            if (playerName == tmp.name) {
                return i;
            }
        }
        return -1;
    }
}



