package me.reezy.cosmo.mmkv

import com.tencent.mmkv.MMKV

interface MMKVOwner {
    val mmkv: MMKV
}