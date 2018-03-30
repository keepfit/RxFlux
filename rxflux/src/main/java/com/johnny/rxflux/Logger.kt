/*
 * Copyright (C) 2017 Johnny Shieh Open Source Project
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
package com.johnny.rxflux

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

/**
 * The Logger to track flux flow
 *
 * @author Johnny Shieh (JohnnyShieh17@gmail.com)
 * @version 1.0
 *
 */
object Logger {

    private val log = AnkoLogger("RxFlux")
    var logEnabled = true

    fun logRegisterStore(storeName: String, vararg actionType: String) {
        if (logEnabled) {
            if (actionType.isEmpty()) {
                log.debug("Store $storeName has registered all action")
            } else {
                log.debug("Store $storeName has registered action : $actionType")
            }
        }
    }

    fun logUnregisterStore(storeName: String) {
        if (logEnabled) {
            log.debug("Store $storeName has unregistered")
        }
    }

    fun logPostAction(action: Action) {
        if (logEnabled) {
            log.debug("Dispatcher post action : $action")
        }
    }

    fun logPostError(action: Action) {
        if (logEnabled) {
            log.debug("Dispatcher post error : $action cause message : ${action.throwable?.message}")
        }
    }

    fun logHandleAction(storeName: String, action: Action) {
        if (logEnabled) {
            log.debug("Store $storeName onAction $action")
        }
    }

    fun logHandleError(storeName: String, action: Action) {
        if (logEnabled) {
            log.debug("Store $storeName onError $action")
        }
    }

    fun logHandleException(storeName: String, actionType: String, e: Exception) {
        if (logEnabled) {
            log.debug("Store $storeName handle action $actionType throws Exceptiop", e)
        }
    }
}