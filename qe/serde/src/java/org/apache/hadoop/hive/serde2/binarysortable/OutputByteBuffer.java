/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hive.serde2.binarysortable;

import java.util.Arrays;

public class OutputByteBuffer {

  byte[] data = new byte[128];
  int length;

  public void reset() {
    length = 0;
  }

  public final void write(byte b) {
    write(b, false);
  }

  public final void write(byte b, boolean invert) {
    if (length == data.length) {
      data = Arrays.copyOf(data, data.length * 2);
    }
    if (invert) {
      data[length++] = (byte) (0xff ^ b);
    } else {
      data[length++] = b;
    }
  }

  public final byte[] getData() {
    return data;
  }

  public final int getLength() {
    return length;
  }

  public String dumpHex() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      byte b = data[i];
      int v = (b < 0 ? 256 + b : b);
      sb.append(String.format("x%02x", v));
    }
    return sb.toString();
  }

}
