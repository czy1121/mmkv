# mmkv

使用 kotlin 委托属性封装的 mmkv 库，代替 SharedPreferences，简单好用

- 支持基本类型：int/long/float/double/boolean
- 支持对象类型：字符串，字符串集合，字节数组
- 支持可空对象类型：字符串，字符串集合，字节数组
- 支持Parcelable类型

## Usage

委托属性添加在实现了 MMKVOwner 的类上，委托属性的值存储在从 MMKVOwner 获取的 MMKV 实例中

否则存储在默认的 MMKV 实例中

``` kotlin
class SomeActivity : Activity {

    // 委托属性的值存储在默认的 MMKV 实例中
    private var isFirstLaunch by mmkvBoolean(default = true)


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // 赋值
        isFirstLaunch = false

        // 判断
        if (isFirstLaunch) {
            // todo
        }
    }
}
```


``` kotlin
object SomeManager {
    private object store : MMKVOwner {
        // store 对象的委托属性的值存储此 MMKV 实例中
        override val mmkv: MMKV = MMKV.mmkvWithID("some")

        var intValue by mmkvInt()
        var longValue by mmkvLong()
        var floatValue by mmkvFloat(0f)
        var booleanValue by mmkvBoolean(false)
        var stringValue by mmkvString("some")
        var nullableStringValue by mmkvNullableString()
    }
}
```

## LICENSE

The Component is open-sourced software licensed under the [Apache license](LICENSE).