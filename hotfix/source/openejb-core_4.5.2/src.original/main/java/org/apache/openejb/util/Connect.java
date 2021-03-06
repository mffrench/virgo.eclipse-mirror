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

import java.net.Socket;

/**
 * @version $Rev: 1431412 $ $Date: 2013-01-10 15:18:26 +0000 (Thu, 10 Jan 2013) $
 */
public class Connect {

    public static boolean connect(int tries, final String host, final int port) {

        Socket s = null;

        try {

            s = new Socket(host, port);
            s.getOutputStream().close();

        } catch (Exception e) {

            if (tries < 2) {

                return false;

            } else {

                try {

                    Thread.sleep(2000);

                } catch (Exception e2) {

                    e.printStackTrace();

                }

                return connect(--tries, host, port);

            }

        } finally {

            if (s != null) {
                try {
                    s.close();
                } catch (Throwable e) {
                    //Ignore
                }
            }
        }

        return true;
    }

}
