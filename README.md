# 🏃[Android] Jetpack Glide demo

## ✏️ Study

## 🌍 Setting

- CompileSdk = 30
- Minsdk = 24
- TargetSdk = 30

## 🤨 Why

- bitmap으로 대용량 이미지를 로드해 퍼포먼스가 떨어지고 메모리 릭이 발생하는 문제를 해결
- 애니메이션, 에러 등 간편하게 구현할 수 있음

## 🙋 Try 

- Jetpack Glide 사용해보기
- 이미지 로드 성공, 로드 중, 로드 실패 에 따른 애니매이션 및 이미지 뷰잉

## ✏️ Gradle 설정

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

## ✏️ manifest 설정

> AndroidManifest.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.yotdark.example_glide">
		
		//인터넷 관리 퍼미션 허용
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

- 권한 설정

  ```xml
  <uses-permission android:name="android.permission.INTERNET" />
  ```

## ✏️ Glide 를 통해 이미지를 보여 줄 View 구성

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
        android:text="로드 성공"
        android:textColor="#333333"
        app:layout_constraintEnd_toEndOf="@id/image1"
        app:layout_constraintStart_toStartOf="@id/image1"
        app:layout_constraintTop_toBottomOf="@id/image1" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="로드 중"
        android:textColor="#333333"
        app:layout_constraintEnd_toEndOf="@id/image2"
        app:layout_constraintStart_toStartOf="@id/image2"
        app:layout_constraintTop_toBottomOf="@id/image2" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="로드 실패"
        android:textColor="#333333"
        app:layout_constraintEnd_toEndOf="@id/image3"
        app:layout_constraintStart_toStartOf="@id/image3"
        app:layout_constraintTop_toBottomOf="@id/image3" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## ✏️ GlideActivity 클래스 생성

### ✏️ Glide 라이브러리를 통해서 이미지 로드

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

- Glide를 사용해서 프로그래스, error, 이미지 정렬 등 여러가지 옵션 써보기

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

- CircularProgressDrawable 사용해서 로딩 처리 하기

  ```kotlin
  private fun getProgress() = CircularProgressDrawable(context).apply {
      strokeWidth = 5f
      centerRadius = 30f
      start()
  }
  ```

## ✏️ MainActivity 클래스 생성

> MainActivity.kt

- 테스트할 이미지뷰에 이미지 로드

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

  
