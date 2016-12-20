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
package org.apache.hadoop.hive.metastore.api;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Constants {

  public static final String META_TABLE_COLUMNS = "columns";

  public static final String META_TABLE_COLUMN_TYPES = "columns.types";

  public static final String BUCKET_FIELD_NAME = "bucket_field_name";

  public static final String BUCKET_COUNT = "bucket_count";

  public static final String FIELD_TO_DIMENSION = "field_to_dimension";

  public static final String META_TABLE_NAME = "name";

  public static final String META_TABLE_DB = "db";

  public static final String META_TABLE_LOCATION = "location";

  public static final String META_TABLE_SERDE = "serde";

  public static final String META_TABLE_PARTITION_COLUMNS = "partition_columns";

  public static final String FILE_INPUT_FORMAT = "file.inputformat";

  public static final String FILE_OUTPUT_FORMAT = "file.outputformat";

  public static final String PROJECTION = "projection";

  public static final String TABLE_TYPE = "type";

  public static final String COMPRESS = "compress";

}
