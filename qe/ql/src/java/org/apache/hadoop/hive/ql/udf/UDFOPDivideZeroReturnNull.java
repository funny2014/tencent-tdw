/**
* Tencent is pleased to support the open source community by making TDW available.
* Copyright (C) 2014 THL A29 Limited, a Tencent company. All rights reserved.
* Licensed under the Apache License, Version 2.0 (the "License"); you may not use 
* this file except in compliance with the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software distributed 
* under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS 
* OF ANY KIND, either express or implied. See the License for the specific language governing
* permissions and limitations under the License.
*/

package org.apache.hadoop.hive.ql.udf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.exec.description;
import org.apache.hadoop.hive.serde2.io.ByteWritable;
import org.apache.hadoop.hive.serde2.io.DoubleWritable;
import org.apache.hadoop.hive.serde2.io.ShortWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.hive.ql.exec.NumericOpMethodResolver;

@description(name = "/", value = "a _FUNC_ b - Divide a by b", extended = "Example:\n"
    + "  > SELECT 3 _FUNC_ 2 FROM src LIMIT 1;\n" + "  1.5")
public class UDFOPDivideZeroReturnNull extends UDF {

  private static Log LOG = LogFactory
      .getLog("org.apache.hadoop.hive.ql.udf.UDFOPDivide");

  protected DoubleWritable doubleWritable = new DoubleWritable();

  public DoubleWritable evaluate(DoubleWritable a, DoubleWritable b) {
    if ((a == null) || (b == null))
      return null;
    double res = a.get() / b.get();
    if (Math.abs(res) >= 0 && Math.abs(res) <= Double.MAX_VALUE) {
      doubleWritable.set(res);
      return doubleWritable;
    }
    return null;
  }
}
