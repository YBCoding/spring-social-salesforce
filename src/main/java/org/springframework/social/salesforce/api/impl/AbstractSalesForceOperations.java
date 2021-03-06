/**
 * Copyright (C) 2017 https://github.com/jottley/spring-social-salesforce
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.salesforce.api.impl;

import org.springframework.social.ApiBinding;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.connect.SalesforceServiceProvider;

/**
 * @author Umut Utkan
 * @author Jared Ottley
 */
public class AbstractSalesForceOperations<T extends ApiBinding> {

    protected T api;


    public AbstractSalesForceOperations(T api) {
        this.api = api;
    }

    protected void requireAuthorization() {
        if (!api.isAuthorized()) {
            throw new MissingAuthorizationException(SalesforceServiceProvider.ID);
        }
    }

    protected static String BASE_URL = "https://na7.salesforce.com/services/data";
    
    
    public String getVersion()
    {
        return ((Salesforce)api).apiOperations().getVersion();
    }

}
