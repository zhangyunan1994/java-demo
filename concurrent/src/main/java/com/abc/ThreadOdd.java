package com.abc;

import java.util.ArrayList;
import java.util.List;

public class ThreadOdd {

  public static int cnt = 0;
  public static final int RANGE = 1000;
  public static List<Integer> ans = new ArrayList<>(RANGE);

  public static void main(String[] argus) {
    Thread oddPrinter = new Thread(() -> {
      while (cnt < RANGE) {
        if ((cnt & 1) == 1) {
          //System.out.println(cnt);
          ans.add(cnt);
          cnt++;
        }
      }
    }, "oddPrinter");

    Thread evenPrinter = new Thread(() -> {
      while (cnt < RANGE) {
        if ((cnt & 1) == 0) {
          //System.out.println(cnt);
          ans.add(cnt);
          cnt++;
        }
      }
    }, "evenPrinter");

    try {
      oddPrinter.start();
      evenPrinter.start();
      oddPrinter.join();
      evenPrinter.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
    ans.forEach((a) -> System.out.print(a + " "));
  }
}
