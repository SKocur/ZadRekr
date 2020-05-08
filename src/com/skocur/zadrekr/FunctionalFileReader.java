package com.skocur.zadrekr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

class FunctionalFileReader {

  private String fileName;

  FunctionalFileReader(String fileName) {
    this.fileName = fileName;
  }

  void forEachReadLine(Consumer<String> lineConsumer) {
    try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = bf.readLine()) != null) {
        lineConsumer.accept(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
