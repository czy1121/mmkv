package me.reezy.cosmo.mmkv

import android.os.Parcelable
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MMKVParcelable<T : Parcelable>(private val clazz: Class<T>, private val default: T) : ReadWriteProperty<Any, T> {

    override operator fun getValue(thisRef: Any, property: KProperty<*>): T {
        return mmkv(thisRef).decodeParcelable(property.name, clazz) ?: default
    }

    override operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        mmkv(thisRef).encode(property.name, value)
    }
}