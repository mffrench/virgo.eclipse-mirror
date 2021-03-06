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


package org.apache.openejb.util;

import java.net.URI;

/**
 * @version $Rev: 1423884 $ $Date: 2012-12-19 15:28:37 +0000 (Wed, 19 Dec 2012) $
 */
public class UniqueDefaultLinkResolver<E> extends LinkResolver<E> {
    public E resolveLink(String link, URI moduleUri) {
        //jpa anyway has a default matching rule
        if (link == null || link.length() == 0) {
            return getUniqueMember();
        }
        return super.resolveLink(link, moduleUri);
    }

}
