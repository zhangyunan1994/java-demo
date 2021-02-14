package com.abc.ds.jexl3;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.junit.Assert;
import org.junit.Test;

public class TestJexl3 {
  @Test
  public void testExpression() {
    JexlEngine jexl = new JexlBuilder().create();
    JexlContext jc = new MapContext();
    jc.set("verifyStatus", 1);
    JexlExpression expression = jexl.createExpression("verifyStatus == 1");
    boolean result = (boolean) expression.evaluate(jc);
    Assert.assertTrue(result);
  }
}
