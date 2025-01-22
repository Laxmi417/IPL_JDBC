package com.controller;
import java.util.*;

import com.pojo.Player;
import com.service.TeamService;
public class TeamController {
	

	
	    private TeamService teamService = new TeamService();
	    private Scanner scanner = new Scanner(System.in);

	    public void run() {
	        int choice;
	        do {
	            System.out.println("\n--- IPL Team and Player Management System ---");
	            System.out.println("1. Add a new team");
	            System.out.println("2. Add a player to a team");
	            System.out.println("3. Delete a player from a team");
	            System.out.println("4. Update player details");
	            System.out.println("5. Fetch all players by team name");
	            System.out.println("6. Fetch player details by player name");
	            System.out.println("7. Display all teams and their players");
	            System.out.println("8. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1 -> handleAddTeam();
	                case 2 -> handleAddPlayer();
	                case 3 -> handleDeletePlayer();
	                case 4 -> handleUpdatePlayer();
	                case 5 -> handleFetchPlayersByTeam();
	                case 6 -> handleFetchPlayerByName();
	                case 7 -> handleDisplayAllTeamsAndPlayers();
	                case 8 -> System.out.println("Exiting the system. Goodbye!");
	                default -> System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 8);
	    }

	    private void handleAddTeam() {
	        System.out.print("Enter team name: ");
	        String teamName = scanner.nextLine();
	        System.out.println(teamService.addTeam(teamName));
	    }

	    private void handleAddPlayer() {
	        System.out.print("Enter team name: ");
	        String teamName = scanner.nextLine();
	        System.out.print("Enter player name: ");
	        String playerName = scanner.nextLine();
	        System.out.print("Enter role (batsman/bowler/all-rounder): ");
	        String role = scanner.nextLine();
	        System.out.print("Enter age: ");
	        int age = scanner.nextInt();
	        scanner.nextLine(); 
	        System.out.println(teamService.addPlayer(teamName, playerName, role, age));
	    }

	    private void handleDeletePlayer() {
	        System.out.print("Enter team name: ");
	        String teamName = scanner.nextLine();
	        System.out.print("Enter player name: ");
	        String playerName = scanner.nextLine();
	        System.out.println(teamService.deletePlayer(teamName, playerName));
	    }

	    private void handleUpdatePlayer() {
	        System.out.print("Enter team name: ");
	        String teamName = scanner.nextLine();
	        System.out.print("Enter player name: ");
	        String playerName = scanner.nextLine();
	        System.out.print("Enter new role: ");
	        String newRole = scanner.nextLine();
	        System.out.print("Enter new age: ");
	        int newAge = scanner.nextInt();
	        scanner.nextLine(); 
	        System.out.println(teamService.updatePlayer(teamName, playerName, newRole, newAge));
	    }

	    private void handleFetchPlayersByTeam() {
	        System.out.print("Enter team name: ");
	        String teamName = scanner.nextLine();
	        List<Player> players = teamService.fetchPlayersByTeam(teamName);
	        if (players == null) {
	            System.out.println("Team does not exist.");
	        } else if (players.isEmpty()) {
	            System.out.println("No players in this team.");
	        } else {
	            players.forEach(System.out::println);
	        }
	    }

	    private void handleFetchPlayerByName() {
	        System.out.print("Enter player name: ");
	        String playerName = scanner.nextLine();
	        Player player = teamService.fetchPlayerByName(playerName);
	        if (player == null) {
	            System.out.println("Player not found.");
	        } else {
	            System.out.println(player);
	        }
	    }

	    private void handleDisplayAllTeamsAndPlayers() {
	        Map<String, List<Player>> teams = teamService.fetchAllTeamsAndPlayers();
	        if (teams.isEmpty()) {
	            System.out.println("No teams available.");
	        } else {
	            teams.forEach((teamName, players) -> {
	                System.out.println("Team: " + teamName);
	                if (players.isEmpty()) {
	                    System.out.println("  No players in this team.");
	                } else {
	                    players.forEach(player -> System.out.println("  " + player));
	                }
	            });
	        }
	    }
	}


