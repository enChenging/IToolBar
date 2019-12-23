IToolBar
-
[![](https://jitpack.io/v/enChenging/IToolBar.svg)](https://jitpack.io/#enChenging/IToolBar)

自定义IToolBar，是为了使实际开发过程中对ToolBar的使用更加快捷、方便。

效果图如下：

<div align="left" >
	<img src="https://github.com/enChenging/IToolBar/blob/master/screenshot/screen.jpg" width="200">
	<img src="https://github.com/enChenging/IToolBar/blob/master/screenshot/screen2.jpg" width="200">
	<img src="https://github.com/enChenging/IToolBar/blob/master/screenshot/screen3.jpg" width="200">
	<img src="https://github.com/enChenging/IToolBar/blob/master/screenshot/screen4.jpg" width="200">
</div>

## 用法

>Android Studio

将其添加到存储库build.gradle中
```xml
allprojects {
    repositories {
      	...
        maven{url 'https://jitpack.io'}
    }
}
```
 在build.gradle文件中的dependencies下添加引用：
	
```java
implementation 'com.github.enChenging:IToolBar:1.0.0'
```

布局中
```xml
<com.release.itoolbar.IToolBar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```


## 混淆

```java
#IToolBar
-dontwarn com.release.itoolbar.**
-keep class com.release.itoolbar.**{*;}

```

声明
-
本应用用作分享与学习。

关于作者
-
[CSDN博客：https://blog.csdn.net/AliEnCheng/article/details/89031855](https://blog.csdn.net/AliEnCheng/article/details/89031855)





