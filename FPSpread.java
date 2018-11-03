/**
 * Ethan Renner
 * CIS 200 Scholars Section
 * Fantasy Football Calculator Team Project
 *
 * This program models a fantasy point spread. The fantasy spread has a hash map
 * containing all of the important statistical categories as a key and the
 * number of points it is worth as the value.
 *
 * Yet to be implemented...
 * The defensive points allowed statistical category scores points dependent on
 * ranges of values (ie 0 points allowed = 5 points, 1-6 points allowed = 4
 * points, etc.) right now defensive points allowed is just 0 points regardless.
 */

import java.util.*;
import java.io.*;

public class FPSpread {
  HashMap<String, Double> spread;
  public FPSpread() throws FileNotFoundException{
    this("DefaultFantasyPointSpread.txt");
  }

  public FPSpread(String fileName) throws FileNotFoundException{
    spread = new HashMap<>();
    File file = new File(fileName);
    Scanner fileScanner = new Scanner(file);
    while(fileScanner.hasNextLine()) {
      String[] linePieces = fileScanner.nextLine().split(",");
      spread.put(linePieces[0], Double.valueOf(linePieces[1]));
    }
  }

  /**
   * Gets the fantasy point value of a given category
   * Check "Categories.txt" for all of the valid categories, note not all players have all categories.
   *
   * @param category The statistical category to be retrieved.
   * @return The value of the category stored in the fantasy points spread hash map.
   * @throws IllegalArgumentException If the category isn't in the key set.
   */
  public double getFPVal(String category) throws IllegalArgumentException {
    // Verify that the category is in the statistics list
    if (!spread.containsKey(category))
      throw new IllegalArgumentException("Category " + category + " not found");
    else {
      return spread.get(category);
    }
  } // End getFPVal

} // End FPSpread
