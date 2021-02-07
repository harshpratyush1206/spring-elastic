/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.oaknorth.springelastic.entities.elastic;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@ToString
public class AddressBase {

    @Field(type = FieldType.Text,name = "first_line")
    private String firstLine;

    @Field(type = FieldType.Text,name = "second_line")
    private String secondLine;

    @Field(type = FieldType.Text,name = "city")
    private String city;

    @Field(type = FieldType.Text,name = "state")
    private String state;

    @Field(type = FieldType.Text,name = "country")
    private String country;

    @Field(type = FieldType.Text,name = "zip")
    private String zipCode;

}
