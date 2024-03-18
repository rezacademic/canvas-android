/*
 * Copyright (C) 2019 - present Instructure, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.instructure.canvasapi2.apis

import com.instructure.canvasapi2.StatusCallback
import com.instructure.canvasapi2.builders.RestBuilder
import com.instructure.canvasapi2.builders.RestParams
import com.instructure.canvasapi2.models.Progress
import com.instructure.canvasapi2.utils.DataResult
import retrofit2.Call
import retrofit2.http.*

object ProgressAPI {

    interface ProgressInterface {
        @GET("progress/{progressId}")
        fun getProgress(@Path("progressId") progressId: String): Call<Progress>

        @GET("progress/{progressId}")
        suspend fun getProgress(@Path("progressId") progressId: String, @Tag params: RestParams): DataResult<Progress>

        @POST("progress/{progressId}/cancel")
        suspend fun cancelProgress(@Path("progressId") progressId: String, @Tag params: RestParams): DataResult<Progress>
    }

    fun getProgress(adapter: RestBuilder, params: RestParams, progressId: String, callback: StatusCallback<Progress>) {
        callback.addCall(adapter.build(ProgressInterface::class.java, params).getProgress(progressId)).enqueue(callback)
    }
}
