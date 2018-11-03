/**
 * Ethan Renner
 * CIS 200 Scholars Section
 * Fantasy Football Calculator Team Project
 *
 * This program is a testing controller for Player.java and FPSpread.java.
 * Right now, it will ask the user which fantasy spread option to use (only
 * implemented the default fantasy spread).
 * Then it will ask the player to either enter in all of a player's statistics,
 * or to a file name to read the player's statistics from (the file must follow
 * the formatting as set in the Player.java class).
 * Finally it will print out the player's information, and how many fantasy
 * points they scored this week.
 *
 * This is not what the final program outline will look like, but is meant for
 * testing purposes only.
 */

import java.util.*;
import java.io.*;
public class PlayerApp {

  public static void main(String[] args) throws FileNotFoundException{
    IO io = new IO();
    FPSpread fpSpread = null;
    Player p1 = null;
    int choice;
    /* Loop to ask for and verify fantasy spread option.
     * Only implemented a default fantasy spread that generates from empty
     * constructor.
     */
    do {
      choice = io.pickFPSpreadOption();
      if (choice == 1) {
        // fpSpread = io.askFPSpread();
      } else if (choice == 3) {
        fpSpread = new FPSpread();
      } else {
        choice = Integer.MIN_VALUE;
        io.displayMessage("Invalid choice entered.");
      }
    } while(choice == Integer.MIN_VALUE);

    /* Loop to ask for and verify entry of player data.
     * Implemented either entering player info one at a time or getting from
     * file, there is no file verification system in place yet.
     */
    do {
      choice = io.pickPlayer();
      if (choice == 1) {
        p1 = io.askPlayerInfo();
        // p1.saveToFile("ExPlayer");
      } else if (choice == 3) {
        p1 = new Player(io.askPlayerFileName());
      } else {
        choice = Integer.MIN_VALUE;
        io.displayMessage("Invalid choice entered.");
      }
    } while(choice == Integer.MIN_VALUE);

    /* Print out the player's information, and how many fantasy points earned.
     * Also I'm cheating here by putting print statements in my controller
     * instead of using IO so don't actually do this it's bad practice.
     */
    System.out.println(p1);
    System.out.println("\n" + p1.getName() + " has " + calculateFPTotal(p1, fpSpread) + " fantasy points");
  } // End main

  /**
   * Calculate the number of fantasy points a given player scored given the
   * fantasy point spread. Loops through all of the categories the player has
   * and multiplies the player's stat value by the fp spread value.
   *
   * @param p The player to calculate fantasy points scored.
   * @param fpSpread The fantasy point spread to use to calculate number of points earned.
   * @return The total number of fantasy points earned.
   */
  public static double calculateFPTotal(Player p, FPSpread fpSpread) {
    double total = 0;
    for (String category : p.getCategories()) {
      total += fpSpread.getFPVal(category) * p.getStat(category);
    }
    return total;
  }
} // End PlayerApp
