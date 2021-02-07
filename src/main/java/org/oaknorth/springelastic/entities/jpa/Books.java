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

package org.oaknorth.springelastic.entities.jpa;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.oaknorth.springelastic.audit.Auditable;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "books")
public class Books extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "publish_year", nullable = false)
    private Year publishYear;

    @Column(name = "publish_month", nullable = false)
    private Month publishMonth;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description",length = 500, nullable = false)
    private String description;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Book_Author",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    @LazyCollection(
            value = LazyCollectionOption.EXTRA
    )
    Set<Author> authors = new HashSet<>();
}
