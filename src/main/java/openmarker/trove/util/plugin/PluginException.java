/*
 *  Copyright 1997-2011 teatrove.org
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package openmarker.trove.util.plugin;

import openmarker.trove.util.FilterException;

/**
 * This exception is thrown from a plugin when a plugin specific exception
 * is thrown.
 *
 * @author Scott Jappinen
 */
public class PluginException extends FilterException {

    public PluginException() {
        super();
    }

    public PluginException(String message) {
        super(message);
    }

    public PluginException(Throwable rootCause) {
        super(rootCause);
    }

    public PluginException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}

