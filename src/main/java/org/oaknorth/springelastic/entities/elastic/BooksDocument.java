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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.oaknorth.springelastic.audit.Auditable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "books_index")
public class BooksDocument extends Auditable {

    @Id
    private long id;

    @Field(name = "publish_year",type = FieldType.Long)
    private long publishYear;

    @Field(name = "publish_month",type = FieldType.Integer)
    private int publishMonth;

    @Field(name = "title",type = FieldType.Text)
    private String title;

    @Field(name = "description",type = FieldType.Text)
    private String description;

    @Field(name = "authors")
    Set<AuthorDocument> authors = new HashSet<>();
}
