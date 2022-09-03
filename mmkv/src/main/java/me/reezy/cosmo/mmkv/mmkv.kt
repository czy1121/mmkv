package me.reezy.cosmo.mmkv

import android.os.Parcelable
import com.tencent.mmkv.MMKV


fun mmkvInt(default: Int = 0) = MMKVValuable(MMKV::decodeInt, MMKV::encode, default)
fun mmkvLong(default: Long = 0L) = MMKVValuable(MMKV::decodeLong, MMKV::encode, default)
fun mmkvFloat(default: Float = 0f) = MMKVValuable(MMKV::decodeFloat, MMKV::encode, default)
fun mmkvDouble(default: Double = 0.0) = MMKVValuable(MMKV::decodeDouble, MMKV::encode, default)
fun mmkvBoolean(default: Boolean = false) = MMKVValuable(MMKV::decodeBool, MMKV::encode, default)


fun mmkvString(default: String = "") = MMKVObject(MMKV::decodeString, MMKV::encode, default)
fun mmkvStringSet(default: Set<String> = setOf()) = MMKVObject(MMKV::decodeStringSet, MMKV::encode, default)
fun mmkvBytes(default: ByteArray = byteArrayOf()) = MMKVObject(MMKV::decodeBytes, MMKV::encode, default)

fun mmkvNullableString(default: String? = null) = MMKVObject(MMKV::decodeString, MMKV::encode, default)
fun mmkvNullableStringSet(default: Set<String>? = null) = MMKVObject(MMKV::decodeStringSet, MMKV::encode, default)
fun mmkvNullableBytes(default: ByteArray? = null) = MMKVObject(MMKV::decodeBytes, MMKV::encode, default)

inline fun <reified T : Parcelable> mmkv(default: T) = MMKVParcelable(T::class.java, default)



private val defaultMMKV: MMKV by lazy { MMKV.defaultMMKV() }

internal fun mmkv(thisRef: Any): MMKV = when (thisRef) {
    is MMKVOwner -> thisRef.mmkv
    else -> defaultMMKV
}


