/*
 * MIT License
 * <p>
 * Copyright (c) 2017 David Krebs
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.dkarv.jdcallgraph.util;

public class StackItem {
  private final String className;
  private final String methodName;
  private final int lineNumber;

  private final String formatted;

  public StackItem(String className, String methodName, int lineNumber) {
    this.className = className;
    this.methodName = methodName;
    this.lineNumber = lineNumber;

    this.formatted = Formatter.join(className, methodName, lineNumber);
  }

  public String getClassName() {
    return className;
  }

  public String getMethodName() {
    return methodName;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  @Override
  public String toString() {
    return formatted;
  }

  @Override
  public int hashCode() {
    return 31 * 31 * className.hashCode()
        + 31 * methodName.hashCode()
        + lineNumber;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof StackItem)) {
      return false;
    }
    if (this == other) {
      return true;
    }
    StackItem o = (StackItem) other;
    return className.equals(o.className) &&
        methodName.equals(o.methodName) &&
        lineNumber == o.lineNumber;
  }
}