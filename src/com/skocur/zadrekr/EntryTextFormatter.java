package com.skocur.zadrekr;

import java.util.Collection;
import java.util.Map.Entry;

class EntryTextFormatter {

  static String formatResultFrom(Entry<String, Collection<Integer>> entry) {
    int count = entry.getValue().size();
    return String
        .format("%s - %d - pozycje -> %s", entry.getKey(), count, entry.getValue().toString());
  }
}
