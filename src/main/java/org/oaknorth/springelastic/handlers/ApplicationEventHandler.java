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

package org.oaknorth.springelastic.handlers;

import org.oaknorth.springelastic.entities.elastic.AuthorDocument;
import org.oaknorth.springelastic.entities.jpa.Author;
import org.oaknorth.springelastic.events.AuthorAddedEvent;
import org.oaknorth.springelastic.respository.elastic.AuthorSearchRepository;
import org.oaknorth.springelastic.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class ApplicationEventHandler {

    @Autowired
    private AuthorSearchRepository authorSearchRepository;

    @TransactionalEventListener
    public void handleEvent(AuthorAddedEvent authorAddedEvent){
        Author author = (Author) authorAddedEvent.getSource();
        AuthorDocument authorDocument = ObjectMapperUtil.convertValue(author, AuthorDocument.class);
       authorDocument.setFirstLine(author.getAddress().getFirstLine());
       authorDocument.setSecondLine(author.getAddress().getSecondLine());
       authorDocument.setCity(author.getAddress().getCity());
       authorDocument.setCountry(author.getAddress().getCountry());
        authorSearchRepository.save(authorDocument);
    }
}
