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
package com.dkarv.jdcallgraph.util.target.mapper;

import com.dkarv.jdcallgraph.util.*;
import com.dkarv.jdcallgraph.util.target.*;

import java.io.*;
import java.util.*;

public class ThreadsMapper extends Mapper {
  Map<Long, Processor> threads = new HashMap<>();

  public ThreadsMapper(Processor next) {
    super(next);
  }

  @Override
  public void start(long threadId) {
    threads.put(threadId, next.copy());
  }

  @Override
  public void edge(long threadId, StackItem from, StackItem to) throws IOException {
    threads.get(threadId).edge(threadId, from, to);
  }

  @Override
  public void edge(long threadId, StackItem from, StackItem to, String info) throws IOException {
    threads.get(threadId).edge(threadId, from, to, info);
  }

  @Override
  public void end() {
    // TODO add threadId to end?
  }

  @Override
  public void close() throws IOException {
    for (Processor p : threads.values()) {
      p.close();
    }
  }

  @Override
  public ThreadsMapper copy() {
    return new ThreadsMapper(next);
  }
}
