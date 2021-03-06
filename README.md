# ๐[Android] Jetpack Glide demo

## โ๏ธ Study

- https://yotdark.tistory.com/42
- [[Android] Glide๋ก ์ด๋ฏธ์ง ๋ณด์ฌ์ฃผ๊ธฐ](https://github.com/Junnnnnnnnnnn/android_study/blob/master/Jetpack_glide/%5BAndroid%5D%20Glide%EB%A1%9C%20%EC%9D%B4%EB%AF%B8%EC%A7%80%20%EB%B3%B4%EC%97%AC%EC%A3%BC%EA%B8%B0.md)

## ๐ Setting

- CompileSdk = 30
- Minsdk = 24
- TargetSdk = 30

## ๐คจ Why

- bitmap์ผ๋ก ๋์ฉ๋ ์ด๋ฏธ์ง๋ฅผ ๋ก๋ํด ํผํฌ๋จผ์ค๊ฐ ๋จ์ด์ง๊ณ  ๋ฉ๋ชจ๋ฆฌ ๋ฆญ์ด ๋ฐ์ํ๋ ๋ฌธ์ ๋ฅผ ํด๊ฒฐ
- ์ ๋๋ฉ์ด์, ์๋ฌ ๋ฑ ๊ฐํธํ๊ฒ ๊ตฌํํ  ์ ์์

## ๐ Try 

- Jetpack Glide ์ฌ์ฉํด๋ณด๊ธฐ
- ์ด๋ฏธ์ง ๋ก๋ ์ฑ๊ณต, ๋ก๋ ์ค, ๋ก๋ ์คํจ ์ ๋ฐ๋ฅธ ์ ๋๋งค์ด์ ๋ฐ ์ด๋ฏธ์ง ๋ทฐ์

## โ๏ธ Gradle ์ค์ 

> build.gradle

```groovy
dependencies {
    					.
    					.
    					.
    // Glide
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    // Progress
    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.0.0'
    					.
    					.
    					.
}
```

## โ๏ธ manifest ์ค์ 

> AndroidManifest.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.yotdark.example_glide">
		
		//์ธํฐ๋ท ๊ด๋ฆฌ ํผ๋ฏธ์ ํ์ฉ
    <uses-permission android:name="android.permission.INTERNET" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Example_glide">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

- ๊ถํ ์ค์ 

  ```xml
  <uses-permission android:name="android.permission.INTERNET" />
  ```

## โ๏ธ Glide ๋ฅผ ํตํด ์ด๋ฏธ์ง๋ฅผ ๋ณด์ฌ ์ค View ๊ตฌ์ฑ

> activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="10dp"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/image1"
        android:layout_width="0dp"
        android:layout_height="120dp"
        android:background="@drawable/background_imageview_glide"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/image2"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/image2"
        android:layout_width="0dp"
        android:layout_height="120dp"
        android:layout_marginLeft="10dp"
        android:background="@drawable/background_imageview_glide"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@id/image3"
        app:layout_constraintStart_toEndOf="@+id/image1"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/image3"
        android:layout_width="0dp"
        android:layout_height="120dp"
        android:layout_marginLeft="10dp"
        android:background="@drawable/background_imageview_glide"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@id/image2"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="๋ก๋ ์ฑ๊ณต"
        android:textColor="#333333"
        app:layout_constraintEnd_toEndOf="@id/image1"
        app:layout_constraintStart_toStartOf="@id/image1"
        app:layout_constraintTop_toBottomOf="@id/image1" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="๋ก๋ ์ค"
        android:textColor="#333333"
        app:layout_constraintEnd_toEndOf="@id/image2"
        app:layout_constraintStart_toStartOf="@id/image2"
        app:layout_constraintTop_toBottomOf="@id/image2" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="๋ก๋ ์คํจ"
        android:textColor="#333333"
        app:layout_constraintEnd_toEndOf="@id/image3"
        app:layout_constraintStart_toStartOf="@id/image3"
        app:layout_constraintTop_toBottomOf="@id/image3" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## โ๏ธ GlideActivity ํด๋์ค ์์ฑ

### โ๏ธ Glide ๋ผ์ด๋ธ๋ฌ๋ฆฌ๋ฅผ ํตํด์ ์ด๋ฏธ์ง ๋ก๋

> GlideActivity.kt

```kotlin
@GlideModule
class GlideActivity(private val context: Context): AppGlideModule() {

    fun glideLoadImage(view: ImageView, url: String, type: String){
        when(type){
            "loading" -> Glide.with(context)
                              .load(url)
                              .placeholder(getProgress())
                              .into(view)
            else -> Glide.with(context)
                         .load(url)
                         .placeholder(getProgress())
                         .centerCrop()
                         .error(R.drawable.warn_icon_24)
                         .into(view)
        }
    }

    private fun getProgress() = CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
}
```

- Glide๋ฅผ ์ฌ์ฉํด์ ํ๋ก๊ทธ๋์ค, error, ์ด๋ฏธ์ง ์ ๋ ฌ ๋ฑ ์ฌ๋ฌ๊ฐ์ง ์ต์ ์จ๋ณด๊ธฐ

  ```kotlin
  when(type){
      "loading" -> Glide.with(context)
                        .load(url)
                        .placeholder(getProgress())
                        .into(view)
      else -> Glide.with(context)
                   .load(url)
                   .placeholder(getProgress())
                   .centerCrop()
                   .error(R.drawable.warn_icon_24)
                   .into(view)
  }
  ```

- CircularProgressDrawable ์ฌ์ฉํด์ ๋ก๋ฉ ์ฒ๋ฆฌ ํ๊ธฐ

  ```kotlin
  private fun getProgress() = CircularProgressDrawable(context).apply {
      strokeWidth = 5f
      centerRadius = 30f
      start()
  }
  ```

## โ๏ธ MainActivity ํด๋์ค ์์ฑ

> MainActivity.kt

- ํ์คํธํ  ์ด๋ฏธ์ง๋ทฐ์ ์ด๋ฏธ์ง ๋ก๋

  ```kotlin
  private val glide: GlideActivity by lazy {
      GlideActivity(this@MainActivity)
  }
  
  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
  
      glide.glideLoadImage(image1,
      "https://image.edaily.co.kr/images/photo/files/NP/S/2019/05/PS19050800712.jpg",
      "success")
      glide.glideLoadImage(image2,"https://node.com.haha.jpg","loading")
      glide.glideLoadImage(image3,"https://nothing.nothing","false")
  }
  ```

  
