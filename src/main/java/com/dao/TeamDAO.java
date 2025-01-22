package com.dao;
import java.util.*;

import com.pojo.Player;

	public class TeamDAO {
	    private Map<String, List<Player>> teams = new HashMap<>();

	    public boolean addTeam(String teamName) {
	        if (teams.containsKey(teamName)) {
	            return false; 
	        }
	        teams.put(teamName, new ArrayList<>());
	        return true;
	    }

	    public boolean addPlayer(String teamName, Player player) {
	        if (!teams.containsKey(teamName)) {
	            return false; 
	        }
	        List<Player> players = teams.get(teamName);
	        for (Player p : players) {
	            if (p.getName().equalsIgnoreCase(player.getName())) {
	                return false; 
	            }
	        }
	        players.add(player);
	        return true;
	    }

	    public boolean deletePlayer(String teamName, String playerName) {
	        if (!teams.containsKey(teamName)) {
	            return false; 
	        }
	        List<Player> players = teams.get(teamName);
	        return players.removeIf(player -> player.getName().equalsIgnoreCase(playerName));
	    }

	    public boolean updatePlayer(String teamName, String playerName, String newRole, int newAge) {
	        if (!teams.containsKey(teamName)) {
	            return false; 
	        }
	        for (Player player : teams.get(teamName)) {
	            if (player.getName().equalsIgnoreCase(playerName)) {
	                player.setRole(newRole);
	                player.setAge(newAge);
	                return true;
	            }
	        }
	        return false; 
	    }

	    public List<Player> fetchPlayersByTeam(String teamName) {
	        return teams.getOrDefault(teamName, null);
	    }

	    public Player fetchPlayerByName(String playerName) {
	        for (Map.Entry<String, List<Player>> entry : teams.entrySet()) {
	            for (Player player : entry.getValue()) {
	                if (player.getName().equalsIgnoreCase(playerName)) {
	                    return player;
	                }
	            }
	        }
	        return null; 
	    }

	    public Map<String, List<Player>> fetchAllTeamsAndPlayers() {
	        return teams;
	    }
	}


