/**
 * Ethan Renner
 * CIS 200 Scholars Section
 * Fantasy Football Calculator Team Project
 *
 * This program is a testing input and output for PlayerApp.java.
 * Implemented methods to pick fantasy spread option, player input option.
 * The player input option leads to either asking for the file name, or a
 * loop through each of the categories the player's position will get points in
 * to enter the values manually.
 *
 * Not yet implemented...
 * Asking to enter in fantasy spread either one value at a time or by file name.
 * Asking to save a new player file or a new fantasy spread file.
 * A neat way to output the player's information.
 */

import java.io.*;
import java.util.*;

public class IO {
  private Scanner s;
  private CategoryLists cl;

  public IO() {
    s = new Scanner(System.in);
    cl = new CategoryLists();
  }

  public void displayMessage(String m) {
    System.out.println("\n" + m + "\n");
  }

  public int pickFPSpreadOption() {
    System.out.println("\n(1) Enter your own fantasy point spread (Yet to be implemented)");
    System.out.println("(2) Load fantasy point spread from file (Yet to be implemented)");
    System.out.println("(3) Use default fantasy point spread");
    System.out.print("\nPlease select an option: ");

    try {
      return Integer.parseInt(s.nextLine());
    } catch (NumberFormatException nf) {
      return Integer.MIN_VALUE;
    }
  }

  public int pickPlayer() {
    System.out.println("\n(1) Enter all of player info");
    System.out.println("(2) Enter player name and pull from ESPN (Yet to be implemented)");
    System.out.println("(3) Load player data from file ");
    System.out.print("\nPlease select an option: ");

    try {
      return Integer.parseInt(s.nextLine());
    } catch (NumberFormatException nf) {
      return Integer.MIN_VALUE;
    }
  }

  public String askPlayerFileName() {
    System.out.print("Enter the player's file name: ");
    return s.nextLine();
  }

  public Player askPlayerInfo() {
    System.out.print("Enter name: ");
    String name = s.nextLine();
    System.out.print("Enter position: ");
    String position = s.nextLine();
    Player p = new Player(name, position);

    TreeSet<String> categories;
    if (position.equals("Defense")) {
      categories = cl.getDefenseCategories();
    } else if (position.equals("Kicker"))
      categories = cl.getKickerCategories();
    else {
      categories = cl.getOffenseCategories();
    }

    for (String category : categories) {
      System.out.print("Enter value for " + category + ": ");
      p.putStat(category, Double.valueOf(s.nextLine()));
    }

    return p;
  }
} // End IO
