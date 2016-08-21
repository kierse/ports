package com.pissiphany.ports.ui.di


/**
 * Created by kierse on 2016-08-21.
 */
interface HasComponent<C> {
    val component : C
        get() = component
}