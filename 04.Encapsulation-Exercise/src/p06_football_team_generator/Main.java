package p06_football_team_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();

        String line;
        while (true) {
            if ("END".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            try {
                switch (command) {
                    case "Team":
                        createTeam(teams, teamName);
                        break;
                    case "Add":
                        addPlayer(teams, tokens);
                        break;
                    case "Remove":
                        removePlayer(teams, tokens);
                        break;
                    case "Rating":
                        printRating(teams, teamName);
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

        }

    }

    private static void createTeam(Map<String, Team> teams, String teamName) {
        Team team = new Team(teamName);
        teams.putIfAbsent(team.getName(), team);
    }

    private static void addPlayer(Map<String, Team> teams, String[] tokens) {
        String teamName = tokens[1];
        String playerName = tokens[2];

        if (teams.containsKey(teamName)) {
            teams.get(teamName).addPlayer(new Player(playerName, Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]),
                    Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7])));
        } else {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
    }

    private static void removePlayer(Map<String, Team> teams, String[] tokens) {
        String teamName = tokens[1];
        String playerName = tokens[2];

        teams.get(teamName).removePlayer(playerName);
    }

    private static void printRating(Map<String, Team> teams, String teamName) {
        if (teams.containsKey(teamName)) {
            System.out.println(String.format("%s - %.0f", teamName, teams.get(teamName).getRating()));
        } else {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
    }
}