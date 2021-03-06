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
package org.springframework.social.salesforce.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.salesforce.api.Salesforce;

/**
 * @author Umut Utkan
 * @author Jared Ottley
 */
public class SalesforceConnectionFactory extends OAuth2ConnectionFactory<Salesforce> {

    public SalesforceConnectionFactory(String clientId, String clientSecret) {
        super(SalesforceServiceProvider.ID, new SalesforceServiceProvider(clientId, clientSecret),
                new SalesforceAdapter());
    }
    
    public SalesforceConnectionFactory(String clientId, String clientSecret, boolean sandbox) {
        super(SalesforceServiceProvider.ID, new SalesforceServiceProvider(clientId, clientSecret, sandbox),
                sandbox ? new SalesforceAdapter(sandbox) : new SalesforceAdapter());
    }

    public SalesforceConnectionFactory(String clientId, String clientSecret, String instanceUrl) {
        super(SalesforceServiceProvider.ID, new SalesforceServiceProvider(clientId, clientSecret),
              new SalesforceAdapter(instanceUrl));
    }
    
    public SalesforceConnectionFactory(String clientId, String clientSecret, String instanceUrl, boolean sandbox) {
        super(SalesforceServiceProvider.ID, new SalesforceServiceProvider(clientId, clientSecret, sandbox),
              sandbox ? new SalesforceAdapter(instanceUrl, sandbox) : new SalesforceAdapter(instanceUrl));
    }

    @Deprecated
    public SalesforceConnectionFactory(String clientId, String clientSecret, String authorizeUrl, String tokenUrl) {
        super(SalesforceServiceProvider.ID, new SalesforceServiceProvider(clientId, clientSecret,
                authorizeUrl, tokenUrl), new SalesforceAdapter());
    }

    @Deprecated
    public SalesforceConnectionFactory(String clientId, String clientSecret, String authorizeUrl, String tokenUrl, String instanceUrl) {
        super(SalesforceServiceProvider.ID, new SalesforceServiceProvider(clientId, clientSecret,
                                                          authorizeUrl, tokenUrl), new SalesforceAdapter(instanceUrl));
    }
    
    @Deprecated
    public SalesforceConnectionFactory(String clientId, String clientSecret, String authorizeUrl, String tokenUrl, String instanceUrl, String gatewayUrl) {
        super("salesforce", new SalesforceServiceProvider(clientId, clientSecret,
                                                          authorizeUrl, tokenUrl), new SalesforceAdapter(instanceUrl, gatewayUrl));
    }

}
