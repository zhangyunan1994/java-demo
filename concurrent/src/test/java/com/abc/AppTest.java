package com.abc;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

  /**
   * Rigorous Test :-)
   */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  public void testLoopRemove() {
    ArrayList<Integer> arrayList = Lists.newArrayList(1, 2, 4, 5, 6, 7, 8);
    int len = arrayList.size();
    arrayList.removeIf(integer -> integer == 6);
  }
}
