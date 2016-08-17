package com.pissiphany.ports.domain.annotation

import kotlin.reflect.KClass

/**
 * Created by kierse on 2016-08-07.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class AutoGson(val autoValueClass: KClass<*>)
