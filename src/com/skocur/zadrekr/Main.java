package com.skocur.zadrekr;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

  private static Map<String, Collection<Integer>> presence = new TreeMap<>(
      String.CASE_INSENSITIVE_ORDER);

  public static void main(String[] args) {
    FunctionalFileReader fileReader = new FunctionalFileReader("zadanie.txt");
    fileReader.forEachReadLine(Main::processLine);

    displayResult();
  }

  //assuming that - and " and numbers are words or part of them
  private static void processLine(String line) {
    line = line.replaceAll("[.,:()]", "")
        .replaceAll(" – ", " ");

    String[] data = line.split("\\s+");
    int perLineCounter = 1;
    for (String word : data) {
      if (word.equals("") || word.equals(" ")) {
        continue;
      }

      if (presence.containsKey(word)) {
        presence.get(word).add(perLineCounter);
      } else {
        List<Integer> list = new LinkedList<>();
        list.add(perLineCounter);
        presence.put(word, list);
      }
      perLineCounter++;
    }
  }

  private static void displayResult() {
    for (Entry<String, Collection<Integer>> entry : presence.entrySet()) {
      System.out.println(EntryTextFormatter.formatResultFrom(entry));
    }
  }
}
