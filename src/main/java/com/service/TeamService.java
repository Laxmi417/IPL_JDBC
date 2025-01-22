package com.service;
import java.util.*;

import com.dao.TeamDAO;
import com.pojo.Player;
public class TeamService {
	

	    private TeamDAO teamDAO = new TeamDAO();

	    public String addTeam(String teamName) {
	        if (teamDAO.addTeam(teamName)) {
	            return "Team added successfully.";
	        }
	        return "Team already exists.";
	    }

	    public String addPlayer(String teamName, String playerName, String role, int age) {
	        if (teamDAO.addPlayer(teamName, new Player(playerName, role, age))) {
	            return "Player added successfully.";
	        }
	        return "Failed to add player. Either team does not exist or player already exists.";
	    }

	    public String deletePlayer(String teamName, String playerName) {
	        if (teamDAO.deletePlayer(teamName, playerName)) {
	            return "Player deleted successfully.";
	        }
	        return "Failed to delete player. Either team or player does not exist.";
	    }

	    public String updatePlayer(String teamName, String playerName, String newRole, int newAge) {
	        if (teamDAO.updatePlayer(teamName, playerName, newRole, newAge)) {
	            return "Player details updated successfully.";
	        }
	        return "Failed to update player. Either team or player does not exist.";
	    }

	    public List<Player> fetchPlayersByTeam(String teamName) {
	        return teamDAO.fetchPlayersByTeam(teamName);
	    }

	    public Player fetchPlayerByName(String playerName) {
	        return teamDAO.fetchPlayerByName(playerName);
	    }

	    public Map<String, List<Player>> fetchAllTeamsAndPlayers() {
	        return teamDAO.fetchAllTeamsAndPlayers();
	    }
	}


