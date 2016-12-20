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
package org.apache.hadoop.hive.serde;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import org.apache.log4j.Logger;

public class Constants {

  public static final String SERIALIZATION_LIB = "serialization.lib";

  public static final String SERIALIZATION_CLASS = "serialization.class";

  public static final String SERIALIZATION_FORMAT = "serialization.format";

  public static final String SERIALIZATION_DDL = "serialization.ddl";

  public static final String SERIALIZATION_NULL_FORMAT = "serialization.null.format";

  public static final String SERIALIZATION_LAST_COLUMN_TAKES_REST = "serialization.last.column.takes.rest";

  public static final String SERIALIZATION_SORT_ORDER = "serialization.sort.order";

  public static final String SERIALIZATION_USE_JSON_OBJECTS = "serialization.use.json.object";

  public static final String FIELD_DELIM = "field.delim";

  public static final String COLLECTION_DELIM = "colelction.delim";

  public static final String LINE_DELIM = "line.delim";

  public static final String MAPKEY_DELIM = "mapkey.delim";

  public static final String QUOTE_CHAR = "quote.delim";

  public static final String ESCAPE_CHAR = "escape.delim";

  public static final String VOID_TYPE_NAME = "void";

  public static final String BOOLEAN_TYPE_NAME = "boolean";

  public static final String TINYINT_TYPE_NAME = "tinyint";

  public static final String SMALLINT_TYPE_NAME = "smallint";

  public static final String INT_TYPE_NAME = "int";

  public static final String BIGINT_TYPE_NAME = "bigint";

  public static final String FLOAT_TYPE_NAME = "float";

  public static final String DOUBLE_TYPE_NAME = "double";

  public static final String STRING_TYPE_NAME = "string";

  public static final String DATE_TYPE_NAME = "date";

  public static final String DATETIME_TYPE_NAME = "datetime";

  public static final String TIMESTAMP_TYPE_NAME = "timestamp";

  public static final String LIST_TYPE_NAME = "array";
  
  public static final String BYTEARRAY_NAME = "bytearray";

  public static final String MAP_TYPE_NAME = "map";

  public static final String STRUCT_TYPE_NAME = "struct";

  public static final String UNION_TYPE_NAME = "uniontype";

  public static final String LIST_COLUMNS = "columns";

  public static final String LIST_COLUMN_TYPES = "columns.types";

  public static final String PB_JAR_PATH = "pb.jar";

  public static final String PB_MSG_NAME = "pb.msg.name";

  public static final String PB_OUTER_CLASS_NAME = "pb.outer.class.name";

  public static final String SERIALIZATION_CHARSET = "charset";

  public static final String TABLE_SERVER = "ip";

  public static final String TABLE_PORT = "port";

  public static final String TBALE_DB = "db_name";

  public static final String DB_URSER = "user_name";

  public static final String DB_PWD = "pwd";

  public static final String DB_TYPE = "db_type";

  public static final String TBALE_SQL = "sql";

  public static final String TABLE_NAME = "table_name";

  public static final String ISCTAS = "isctas";

  public static final Set<String> ConstantNames = new HashSet<String>();
  static {
    ConstantNames.add(SERIALIZATION_LIB);
    ConstantNames.add(SERIALIZATION_CLASS);
    ConstantNames.add(SERIALIZATION_FORMAT);
    ConstantNames.add(SERIALIZATION_DDL);
    ConstantNames.add(SERIALIZATION_NULL_FORMAT);
    ConstantNames.add(SERIALIZATION_LAST_COLUMN_TAKES_REST);
    ConstantNames.add(SERIALIZATION_SORT_ORDER);
    ConstantNames.add(SERIALIZATION_USE_JSON_OBJECTS);
    ConstantNames.add(FIELD_DELIM);
    ConstantNames.add(COLLECTION_DELIM);
    ConstantNames.add(LINE_DELIM);
    ConstantNames.add(MAPKEY_DELIM);
    ConstantNames.add(QUOTE_CHAR);
    ConstantNames.add(ESCAPE_CHAR);
    ConstantNames.add(SERIALIZATION_CHARSET);
  }

  public static final Set<String> PrimitiveTypes = new HashSet<String>();
  static {
    PrimitiveTypes.add("void");
    PrimitiveTypes.add("boolean");
    PrimitiveTypes.add("tinyint");
    PrimitiveTypes.add("smallint");
    PrimitiveTypes.add("int");
    PrimitiveTypes.add("bigint");
    PrimitiveTypes.add("float");
    PrimitiveTypes.add("double");
    PrimitiveTypes.add("string");
    PrimitiveTypes.add("date");
    PrimitiveTypes.add("datetime");
    PrimitiveTypes.add("timestamp");
  }

  public static final Set<String> CollectionTypes = new HashSet<String>();
  static {
    CollectionTypes.add("array");
    CollectionTypes.add("map");
  }

}
