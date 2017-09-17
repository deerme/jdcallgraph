package com.dkarv.jdcallgraph.util;

import org.junit.Assert;
import org.junit.Test;

public class StackItemTest {
  private final static String className = "abd.def.Example";
  private final static String methodName = "method(String)";
  private final static int lineNumber = 123;

  @Test
  public void testGetters() {
    StackItem item = new StackItem(className, methodName, lineNumber);
    Assert.assertEquals(className, item.getClassName());
    Assert.assertEquals(methodName, item.getMethodName());
    Assert.assertEquals(lineNumber, item.getLineNumber());

    Assert.assertEquals(Formatter.join(className, methodName, lineNumber), item.toString());
  }

  @Test
  public void testEquals() {
    StackItem i1 = new StackItem(className, methodName, lineNumber);
    StackItem i2 = new StackItem(className, methodName, lineNumber);
    Assert.assertTrue(i1.equals(i2) && i2.equals(i1));
    Assert.assertTrue(i1.hashCode() == i2.hashCode());
    Assert.assertFalse(i1.equals(null));
    Assert.assertFalse(i2.equals(this));
    Assert.assertTrue(i1.equals(i1));
    Assert.assertFalse(i1.hashCode() == new StackItem(className, methodName, lineNumber + 1).hashCode());
  }
}
