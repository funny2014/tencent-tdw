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

package org.apache.hadoop.hive.ql.exec;

import java.util.List;

import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;

public class AmbiguousMethodException extends UDFArgumentException {

  private static final long serialVersionUID = 1L;

  Class<?> funcClass;

  List<TypeInfo> argTypeInfos;

  public AmbiguousMethodException(Class<?> funcClass,
      List<TypeInfo> argTypeInfos) {
    super("Ambiguous method for " + funcClass + " with " + argTypeInfos);
    this.funcClass = funcClass;
    this.argTypeInfos = argTypeInfos;
  }

  Class<?> getFunctionClass() {
    return funcClass;
  }

  List<TypeInfo> getArgTypeList() {
    return argTypeInfos;
  }
}
