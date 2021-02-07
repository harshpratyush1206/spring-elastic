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

package org.oaknorth.springelastic.service;

import lombok.extern.slf4j.Slf4j;
import org.oaknorth.springelastic.entities.jpa.Author;
import org.oaknorth.springelastic.events.AuthorAddedEvent;
import org.oaknorth.springelastic.respository.elastic.AuthorSearchRepository;
import org.oaknorth.springelastic.respository.jpa.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorSearchRepository authorSearchRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional
    public Author saveAuthor(Author author) {
        log.debug("Saving author = {}",author);
        authorRepository.save(author);
        applicationEventPublisher.publishEvent(new AuthorAddedEvent(author));
        return author;

    }
}
