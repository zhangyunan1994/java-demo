package com.abc.ds.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.junit.Assert;
import org.junit.Test;

public class TestGroovy {

  @Test
  public void testExpression() {
    Binding binding = new Binding();
    binding.setVariable("verifyStatus", 1);
    GroovyShell shell = new GroovyShell(binding);
    boolean result = (boolean) shell.evaluate("verifyStatus == 1");
    Assert.assertTrue(result);
  }


}
