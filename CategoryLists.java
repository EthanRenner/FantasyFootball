/**
 * Ethan Renner
 * CIS 200 Scholars Section
 * Fantasy Football Calculator Team Project
 *
 * This program contains lists of statistical categories that are important in
 * fantasy football for each kind of position (Offense, defense, and kicker).
 * All of the categories are in a uniform manner, meaning they are spelled and
 * formatted in the way the category should be stored in the text files.
 */
import java.util.*;

public class CategoryLists{
  private TreeSet<String> offenseCategories;
  private TreeSet<String> defenseCategories;
  private TreeSet<String> kickerCategories;
  private TreeSet<String> allCategories;

  public CategoryLists() {
    generateOffense();
    generateDST();
    generateKicker();
    generateAll();
  }

  /**
   * Saves the list of all categories to a text file.
   *
   * @param fileName The file to save all the categories to.
   */
  public void saveToFile(String fileName) {
    PrintWriter pw = new PrintWriter(fileName);
    for (String category : allCategories)
      pw.println(category);
    pw.close();
  }

  /**
   * Gets a tree set of all of the categories important to an offensive player.
   * Passing completions, attempts, yards, tds, interceptions
   * Rushing attemtps, yards, tds
   * Receiving targets, catches, yards, tds
   * 2 point conversion, fumbles lost, return tds
   *
   * @return Tree Set containing all above categories in uniform manner.
   */
  public TreeSet<String> getOffenseCategories() {
    return offenseCategories;
  }

  /**
   * Gets a tree set of all of the categories important to a defensive player.
   * Return tds, interceptions, safeties, sacks, blocked kicks, points allowed
   *
   * @return Tree Set containing all above categories in uniform manner.
   */
  public TreeSet<String> getDefenseCategories() {
    return defenseCategories;
  }

  /**
   * Gets a tree set of all of the categories important to a kicker.
   * Made/Missed for 1-39, 40-49, 50+, extra points
   *
   * @return Tree Set containg all above categories in uniform manner.
   */
  public TreeSet<String> getKickerCategories() {
    return kickerCategories;
  }

  /**
   * Gets a tree set of all of the categories for all of the different types of
   * players, also for all the values needed for fantasy point spreads
   *
   * @return Tree Set containing all categories in a uniform manner.
   */
  public TreeSet<String> getAllCategories() {
    return allCategories;
  }

  private void generateAll() {
    allCategories = new TreeSet<>();
    allCategories.addAll(offenseCategories);
    allCategories.addAll(defenseCategories);
    allCategories.addAll(kickerCategories);
  }
  private void generateOffense() {
    offenseCategories = new TreeSet<>();
    offenseCategories.add("Passing completions");
    offenseCategories.add("Passing attempts");
    offenseCategories.add("Passing yards");
    offenseCategories.add("Passing TD");
    offenseCategories.add("Passing interception");
    offenseCategories.add("Rushing attempts");
    offenseCategories.add("Rushing yards");
    offenseCategories.add("Receptions");
    offenseCategories.add("Targets");
    offenseCategories.add("Receiving yards");
    offenseCategories.add("Receiving TD");
    offenseCategories.add("2 point conversion");
    offenseCategories.add("Fumbles lost");
    offenseCategories.add("Return TD");
  }

  private void generateDST() {
    defenseCategories = new TreeSet<>();
    defenseCategories.add("Return TD");
    defenseCategories.add("Interception");
    defenseCategories.add("Fumble recovered");
    defenseCategories.add("Sack");
    defenseCategories.add("Safety");
    defenseCategories.add("Blocked kick");
    defenseCategories.add("Points allowed");
  }

  private void generateKicker() {
    kickerCategories = new TreeSet<>();
    kickerCategories.add("Made 1-39");
    kickerCategories.add("Missed 1-39");
    kickerCategories.add("Made 40-49");
    kickerCategories.add("Missed 49-49");
    kickerCategories.add("Made 50+");
    kickerCategories.add("Missed 50+");
    kickerCategories.add("Made extra point");
    kickerCategories.add("Missed extra point");
  }
}
