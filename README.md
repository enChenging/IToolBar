IToolBar
-
[![](https://jitpack.io/v/enChenging/IToolBar.svg)](https://jitpack.io/#enChenging/IToolBar)

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
implementation 'com.github.enChenging:IToolBar:1.0.4'
```

在布局中使用：
```xml
 <com.release.itoolbar.IToolBar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:background="@color/Amber"
        app:title="标题"
        app:titleColor="@color/White"
        app:titleSize="15sp"
        app:rightVisible="true"
        app:rightText="帮助"
        app:rightColor="@color/White"
        app:rightSize="12sp"
        app:backIcon="@mipmap/toolbar_back_white"
        app:bottom_line_visible="true"
        app:bottom_line_color="@color/Black"
        app:bottom_line_height="3dp"
        />
```
IToolBar实现了返回键的返回功能，使用时不用再对返回键做处理。

代码中可更改的属性：
```java
//标题内容
setTitle(String title)
//标题内容
setTitle(int textId)
//标题颜色
setTitleColor(int color）
//标题大小
setTitleSize(int textSize)
//标题是否被选中
setTitleSelected(boolean b)
//背景色
setBgColor(int color)
//布局高度
setHeight(int height)
//设置返回按钮的隐藏
setBackIconVisible(int visible)
//返回键图标
setBackDrawable(Drawable drawable)
//返回键图标
setBackDrawable(int color)
//右边文本内容
setRight(String right)
//右边文本内容
setRight(int right)
//右边文本点击监听事件
setOnRightClickListener(OnRightClickListener clickListener)
//右边文本显隐
setRightGone(int Visible)
//右边文本颜色
setRightTextColor(int color)
//右边文本大小
setRightSize(int textSize)
//设置底部line的显隐
setBottomLineVisible(int visible)
//设置底部line的高度
setBottomLineHeight(int height)
//设置底部line的颜色
setBottomLineColor(int color)
```

在application中可以全局修改IToolBar的样式风格，不设置则使用默认样式
```java
 @Override
    public void onCreate() {
        super.onCreate();

        //第一种方式：只统一IToolBar背景色
        IToolBar.init(R.color.Green);
        //第二种方式：统一IToolBar背景色、标题色、返回键图标
        IToolBar.init(R.color.Purple,R.color.White,R.mipmap.toolbar_back_white);
        //第三种方式：统一IToolBar背景色、标题色、右边文本颜色、返回键图标、整体高度
        IToolBar.init(R.color.Blue,R.color.White,R.color.Yellow,R.mipmap.toolbar_back_white,120);
    }
```


## 混淆

```java
#IToolBar
-dontwarn com.release.itoolbar.**
-keep class com.release.itoolbar.**{*;}

```

声明
-
本控件用作分享与学习。

关于作者
-
[CSDN博客：https://blog.csdn.net/AliEnCheng/article/details/103663861](https://blog.csdn.net/AliEnCheng/article/details/103663861)





