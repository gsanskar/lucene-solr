package org.apache.lucene.demo.html;

/**
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.*;

class Test {
  public static void main(String[] argv) throws Exception {
    if ("-dir".equals(argv[0])) {
      String[] files = new File(argv[1]).list();
      java.util.Arrays.sort(files);
      for (int i = 0; i < files.length; i++) {
	System.err.println(files[i]);
	File file = new File(argv[1], files[i]);
	parse(file);
      }
    } else
      parse(new File(argv[0]));
  }

  public static void parse(File file) throws Exception {
    HTMLParser parser = new HTMLParser(file);
    System.out.println("Title: " + Entities.encode(parser.getTitle()));
    System.out.println("Summary: " + Entities.encode(parser.getSummary()));
    LineNumberReader reader = new LineNumberReader(parser.getReader());
    for (String l = reader.readLine(); l != null; l = reader.readLine())
      System.out.println(l);
  }
}
