package me.reezy.cosmo.mmkv

import com.tencent.mmkv.MMKV
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class MMKVValuable<T>(
    private val get: MMKV.(String, T) -> T,
    private val set: MMKV.(String, T) -> Boolean,
    private val default: T,
) : ReadWriteProperty<Any, T> {

    override operator fun getValue(thisRef: Any, property: KProperty<*>): T {
        return mmkv(thisRef).get(property.name, default)
    }

    override operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        mmkv(thisRef).set(property.name, value)
    }
}