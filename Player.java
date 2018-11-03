/**
 * Ethan Renner
 * CIS 200 Scholars Section
 * Fantasy Football Calculator Team Project
 *
 * This program models a fantasy football player. The player has a name, position,
 * and a hashmap full of statistical categories and their values.
 * It is recommended to create a player instance based off of a text file containing
 * the player's name and position on the first two lines and then each statistical
 * category and value seperated by a comma on each of the following lines.
 */
import java.util.*;
import java.io.*;

public class Player {
  private String name, team, position;
  private int number;
  private double fantasyPoints;
  private HashMap<String, Double> statistics;

  /**
   * Constructs a player instance where only the name and positions is known.
   * The statistical categories and values must either be set one at a time.
   *
   * @param name The player's name.
   * @param position The player's position.
   */
  public Player(String name, String position) {
    this.name = name;
    this.position = position;
    statistics = new HashMap<>();
    fantasyPoints = 0;
  }

  /**
   * Contstructs a player instance based off of the data from "DefaultPlayer.txt".
   * The first two lines of the text file are the player name and position.
   * Every line after is a statistical category followed by a value seperated
   * by a comma.
   *
   * @throws FileNotFoundException If the file is not found.
   */
  public Player() throws FileNotFoundException {
    this("DefaultPlayer.txt");
  }

  /**
   * Contstructs a player instance based off of the data from the file provided.
   * The first two lines of the text file are the player name and position.
   * Every line after is a statistical category followed by a value seperated
   * by a comma.
   *
   * @param fileName The file to read the player info from.
   * @throws FileNotFoundException If the file is not found.
   */
  public Player(String fileName) throws FileNotFoundException {
    statistics = new HashMap<>();
    File file = new File(fileName);
    Scanner fileScanner = new Scanner(file);
    name = fileScanner.nextLine();
    position = fileScanner.nextLine();
    while(fileScanner.hasNextLine()) {
      String[] linePieces = fileScanner.nextLine().split(",");
      statistics.put(linePieces[0], Double.valueOf(linePieces[1]));
    }
  }

  /**
   * Converts player into a string representation
   * Puts the player name and position on each of the first two lines, then
   * puts the statistical category, a comma, and then the value before going to
   * the next line.
   *
   * @return A string representation of this player.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name);
    sb.append("\n");
    sb.append(position);
    sb.append("\n");
    TreeSet<String> tempStatSet = new TreeSet<>();
    tempStatSet.addAll(statistics.keySet());
    for (String key : tempStatSet) {
      sb.append(key);
      sb.append(",");
      sb.append(statistics.get(key));
      sb.append("\n");
    }

    return sb.toString();
  }

  /**
   * Gets the value of a given statistics for this player.
   * ie If a player has 2 sacks in a game then you could
   * putStat("Sack", 2);
   * Check "Categories.txt" for all of the valid categories, note not all players have all categories.
   *
   * @param category The statistical category to put the value into. ie "Sack"
   * @param value The value of the statistical category to put in. ie 2.0
   */
  public void putStat(String category, double value) {
      statistics.put(category, value);
  }

  /**
   * Gets the value of a given statistics for this player.
   * Check "Categories.txt" for all of the valid categories, note not all players have all categories.
   *
   * @param category The statistical category to be retrieved.
   * @return The value of the category stored in the statistics hash map.
   * @throws IllegalArgumentException If the category isn't in the key set.
   */
  public double getStat(String category) throws IllegalArgumentException {
    // Verify that the category is in the statistics list
    if (!statistics.containsKey(category))
      throw new IllegalArgumentException("Category " + category + " not found");
    else {
      return statistics.get(category);
    }
  }

  /**
   * Saves this player's statistics to a text file.
   * Puts the player name and position on each of the first two lines, then
   * puts the statistical category, a comma, and then the value before going to
   * the next line.
   *
   * @param fileName The file name to write this player's data to.
   */
  public void saveToFile(String fileName) throws FileNotFoundException {
    PrintWriter pw = new PrintWriter(fileName);
    String[] lines = toString().split("\n");
    for (String line : lines)
      pw.println(line);
    pw.close();
  }


    /**
     * Sets the players number of fantasy points.
     * This value is calculated elsewhere.
     *
     * @param fp The number of fantasy points this player scored.
     */
    public void setFantasyPoints(double fp) {
      fantasyPoints = fp;
    }

    /**
     * Gets the players number of fantasy points.
     * This value is calculated elsewhere.
     *
     * @return The number of fantasy points this player scored.
     */
    public double getFantasyPoints() {
      return fantasyPoints;
    }

    /**
     * Gets all of the categories this player has stats for.
     *
     * @return This player's statistical categories.
     */
    public TreeSet<String> getCategories() {
      TreeSet<String> categories = new TreeSet<>();
      categories.addAll(statistics.keySet());
      return categories;
    }

    /**
     * Gets this players name.
     *
     * @return The name.
     */
    public String getName() {
      return name;
    }

} // End Player
