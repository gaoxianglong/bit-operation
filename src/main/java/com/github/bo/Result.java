/*
 * Copyright 2019-2119 gao_xianglong@sina.com
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
package com.github.bo;

/**
 * @author gao_xianglong@sina.com
 * @version 0.1-SNAPSHOT
 * @date created in 2022/5/17 18:35
 */
public class Result {
    private boolean success;
    private String answer;

    public Result(boolean success, String answer) {
        this.success = success;
        this.answer = answer;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success='" + success + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
