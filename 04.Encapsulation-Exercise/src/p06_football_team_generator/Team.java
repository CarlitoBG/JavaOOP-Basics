package p06_football_team_generator;

import java.util.HashMap;
import java.util.Map;

public class Team {
    private String name;
    private Map<String, Player> players;
    private double rating;

    Team(String name) {
        this.setName(name);
        this.players = new HashMap<>();
        this.rating = 0.0;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    double getRating() {
        if (this.players.size() > 0) {
            for (Player player : this.players.values()) {
                this.rating += player.getOverallSkillLevel();
            }
            this.rating /= this.players.size();
        }
        return this.rating;
    }

    void addPlayer(Player player) {
        this.players.putIfAbsent(player.getName(), player);
    }

    void removePlayer(String playerName) {
        if (!this.players.containsKey(playerName)) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        }
        this.players.remove(playerName);
    }
}