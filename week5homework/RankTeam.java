/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5homework;

/**
 *
 * @author jameslu
 */
import java.util.Scanner;

public class RankTeam {

	private static void quicksort(int low, int high, String[] teams, int[] wons) {
        int i = low, j = high;
        int pivot = wons[low + (high - low) / 2];
        while (i <= j) {
            while (wons[i] < pivot) {
                i++;
            }
            while (wons[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j, teams, wons);
                i++;
                j--;
            }
        }
        if (low < j) {
            quicksort(low, j, teams, wons);
        }
        if (i < high) {
            quicksort(i, high, teams, wons);
        }
    }

    private static void exchange(int i, int j, String[] teams, int[] wons) {
        int temp = wons[i];
        wons[i] = wons[j];
        wons[j] = temp;
        String tmp = teams[i];
        teams[i] = teams[j];
        teams[j] = tmp;
    }
    
    private static String findWonTeam(String[] teamwins, String name) {
    	for (int i = 0; i < teamwins.length; i ++) {
    		if (teamwins[i].contains(name)) {
    			String[] lines = teamwins[i].split(" ");
    			if (lines.length > 0 && !lines[0].equals(name)) {
    				return lines[0];
    			}
    		}
    	}
    	return "";
    }
    
    private static int findTeamRank(String[] teams, String teamBeatI) {
    	if (teamBeatI.isEmpty()) {
    		return 0;
    	}
    	for (int i = 0; i < teams.length; i++) {
    		if (teams[i].equals(teamBeatI)) {
    			return i;
    		}
    	}
    	return 0;
    }
    
    private static void resolvetie(String[] teams, int[] wons, String[] teamwins) {
    	for (int i = 0; i < teams.length; i++) {
    		if (i + 1 < teams.length) {
                    int j = i+1;
                    while(j < teams.length-1){
                        if (wons[j] == wons[j + 1]) {
    				String teamBeatJ = findWonTeam(teamwins, teams[j]);
    				int teamBeatJRank = findTeamRank(teams, teamBeatJ);
    				String teamBeatJPlus = findWonTeam(teamwins, teams[j+1]);
    				int teamBeatJPlusRank = findTeamRank(teams, teamBeatJPlus);
    				if (teamBeatJRank > teamBeatJPlusRank) {
    					exchange(j, j + 1, teams, wons);
    				}
    			}
                        j++;
                    }
//    			if (wons[i] == wons[i + 1]) {
//    				String teamBeatI = findWonTeam(teamwins, teams[i]);
//    				int teamBeatIRank = findTeamRank(teams, teamBeatI);
//    				String teamBeatIPlus = findWonTeam(teamwins, teams[i]);
//    				int teamBeatIPlusRank = findTeamRank(teams, teamBeatIPlus);
//    				if (teamBeatIRank > teamBeatIPlusRank) {
//    					exchange(i, i + 1, teams, wons);
//    				}
//    			}
    		}
    	}
    }
    
    private static void printTeamRank(String[] teams, int[] wons) {
    	System.out.println("Team ranking and wons:");
    	for (int i = teams.length - 1; i >= 0; i--) {
    		System.out.println("No " + (teams.length - i) + " " + teams[i] + ", " + wons[i]);
    	}
    }
	public static String[] rankTeam(String[] teamwins) {
		String[] teams = new String[teamwins.length];
		int[] wons = new int[teamwins.length];
		for (int i = 0; i < teamwins.length; i++) {
			String[] line = teamwins[i].split(" ");
			if (line.length > 0) {
				teams[i] = line[0];
				wons[i] = line.length - 1;
			}
		}
		quicksort(0, wons.length -1, teams, wons);
		resolvetie(teams, wons, teamwins);
		printTeamRank(teams, wons);
		return teams;
	}
	
	public static void main(String[] args) {
	    System.out.print("Please input the number of teams:\n");
		Scanner input = new Scanner(System.in);	
		String nline = input.nextLine();
		int numberOfTeams = Integer.parseInt(nline);
		String[] teamwins = new String[numberOfTeams];
		try {
		    System.out.print("Please input all the teams and their wons, each team per line:\n");
		    System.out.print("first column is team name (no space in the name) and the rest of columns are the team names that lost against the first column team.\n");
		    System.out.print("between columns is a single space character.\n");
		    System.out.print("e.g.: \"C D A\" means the team C beats team D and A.\n");
                    for (int i = 0; i < numberOfTeams; i++) {
			teamwins[i] = input.nextLine();
                        //System.out.println("done");
                    }
		} finally {
			input.close();
		}
		rankTeam(teamwins);
	}
	
}
