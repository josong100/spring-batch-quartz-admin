/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.batch.admin.sample;

import java.util.List;

import org.springframework.batch.admin.web.util.BatchAdminLogger;
import org.springframework.batch.item.ItemWriter;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
public class ExampleItemWriter implements ItemWriter<Object> {

    private boolean fail = false;

    public void setFail(boolean fail) {
        this.fail = fail;
    }

    /**
     * @see ItemWriter#write(List)
     */
    public void write(List<? extends Object> data) throws Exception {
        BatchAdminLogger.getLogger().info(data.toString());
        if (fail) {
            throw new RuntimeException("Planned failure");
        }
    }

}
