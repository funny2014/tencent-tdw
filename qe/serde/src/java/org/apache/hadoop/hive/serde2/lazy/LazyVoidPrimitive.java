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
package org.apache.hadoop.hive.serde2.lazy;

import org.apache.hadoop.hive.serde2.lazy.objectinspector.primitive.LazyVoidObjectInspector;
import org.apache.hadoop.io.NullWritable;

public class LazyVoidPrimitive extends
    LazyPrimitive<LazyVoidObjectInspector, NullWritable> {

  public LazyVoidPrimitive(LazyVoidObjectInspector oi) {
    super(oi);
    data = NullWritable.get();
  }

  public LazyVoidPrimitive(LazyVoidPrimitive copy) {
    super(copy);
    data = NullWritable.get();
  }

  @Override
  public void init(ByteArrayRef bytes, int start, int length) {
    isNull = true;
  }

}
