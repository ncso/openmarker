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

package openmarker.trove.util.tq;

/**
 * Defines a unit of work to be performed in a {@link TransactionQueue}.
 *
 * @author Brian S O'Neill
 */
public interface Transaction {
    /**
     * Called by {@link TransactionQueue} to service this transaction.
     */
    public void service() throws Exception;

    /**
     * Called by {@link TransactionQueue} to cancel this transaction if an
     * exception is thrown from the service method or if this transaction was
     * in the queue too long and expired.
     *
     * @see TransactionQueueListener#transactionException
     */
    public void cancel() throws Exception;
}
