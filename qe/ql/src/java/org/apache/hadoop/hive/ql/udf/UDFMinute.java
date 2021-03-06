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

package org.apache.hadoop.hive.ql.udf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.exec.description;
import org.apache.hadoop.hive.serde2.io.TimestampWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

@description(name = "minute", value = "_FUNC_(date) - Returns the minute of date", extended = "date is a string in the format of 'yyyy-MM-dd HH:mm:ss' or "
    + "'HH:mm:ss'.\n"
    + "Example:\n "
    + "  > SELECT _FUNC_('2009-07-30 12:58:59') FROM src LIMIT 1;\n"
    + "  58\n"
    + "  > SELECT _FUNC_('12:58:59') FROM src LIMIT 1;\n" + "  58")
public class UDFMinute extends UDF {

  private static Log LOG = LogFactory.getLog(UDFMinute.class.getName());

  private SimpleDateFormat formatter1 = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");
  private SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
  private Calendar calendar = Calendar.getInstance();

  IntWritable result = new IntWritable();

  public UDFMinute() {
  }

  public IntWritable evaluate(Text dateString) {

    if (dateString == null) {
      return null;
    }

    try {
      Date date = null;
      try {
        date = formatter1.parse(dateString.toString());
      } catch (ParseException e) {
        date = formatter2.parse(dateString.toString());
      }
      calendar.setTime(date);
      result.set(calendar.get(Calendar.MINUTE));
      return result;
    } catch (ParseException e) {
      return null;
    }
  }

  public IntWritable evaluate(TimestampWritable t) {
    if (t == null) {
      return null;
    }

    calendar.setTime(t.getTimestamp());
    result.set(calendar.get(Calendar.MINUTE));
    return result;
  }

}
