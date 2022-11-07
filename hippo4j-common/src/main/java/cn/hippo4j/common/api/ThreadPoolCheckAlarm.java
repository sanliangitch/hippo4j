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

package cn.hippo4j.common.api;

import org.springframework.boot.CommandLineRunner;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Thread-pol check alarm.
 *
 * <p>Dynamic thread pool check and send logic wait for refactoring,
 * Try not to rely on this component for custom extensions, because it is undefined.
 */
public interface ThreadPoolCheckAlarm extends CommandLineRunner {

    /**
     * Check pool capacity alarm.
     *
     * @param threadPoolId       thread-pool id
     * @param threadPoolExecutor thread-pool executor
     */
    void checkPoolCapacityAlarm(String threadPoolId, ThreadPoolExecutor threadPoolExecutor);

    /**
     * Check pool activity alarm.
     *
     * @param threadPoolId       thread-pool id
     * @param threadPoolExecutor thread-pool executor
     */
    void checkPoolActivityAlarm(String threadPoolId, ThreadPoolExecutor threadPoolExecutor);

    /**
     * Async send rejected alarm.
     *
     * @param threadPoolId thread-pool id
     */
    void asyncSendRejectedAlarm(String threadPoolId);

    /**
     * Async send execute time-out alarm.
     *
     * @param threadPoolId       thread-pool id
     * @param executeTime        execute time
     * @param executeTimeOut     execute time-out
     * @param threadPoolExecutor thread-pool executor
     */
    void asyncSendExecuteTimeOutAlarm(String threadPoolId, long executeTime, long executeTimeOut, ThreadPoolExecutor threadPoolExecutor);
}
