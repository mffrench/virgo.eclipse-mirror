/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.openejb.config;

import org.apache.openejb.config.sys.Resources;
import org.apache.openejb.jee.bval.ValidationConfigType;

import java.util.HashMap;
import java.util.Map;

public class Module {
    private static int currentId = 1; // unique id to be able to bind something for each module in the jndi tree
    
    private boolean isStandaloneModule = true;

    private ClassLoader classLoader;

    private ValidationConfigType validationConfig;
    private final Map<String, Object> altDDs = new HashMap<String, Object>();
    private String uniqueId;
    private AppModule appModule = null;
    private Resources resources;

    public Module() {
        uniqueId = Integer.toString(currentId++);
    }

    public ValidationConfigType getValidationConfig() {
        return validationConfig;
    }

    public void setValidationConfig(ValidationConfigType v) {
        validationConfig = v;
    }

    public Map<String, Object> getAltDDs() {
        return altDDs;
    }

    public String getUniqueId() {
        return uniqueId;
    }
    
    public boolean isStandaloneModule() {
        return isStandaloneModule;
    }
    
    public void setStandaloneModule(boolean isStandalone) {
        isStandaloneModule = isStandalone;
    }    

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void initAppModule(AppModule appModule) {
        if (this.appModule == appModule) {
            return;
        }

        if (this.appModule != null) {
            throw new UnsupportedOperationException("AppModule is already set");
        }

        this.appModule = appModule;
        if (resources != null) {
            this.appModule.getResources().addAll(resources.getResource());
        }
    }

    public AppModule getAppModule() {
        return appModule;
    }

    public void initResources(Resources resources) {
        if (this.resources != null) {
            throw new UnsupportedOperationException("resources.xml is already set");
        }

        this.resources = resources;
    }
}
