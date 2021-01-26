package other.ztoreTemplate.res.layout

fun layoutXml(
  packageName: String,
  activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
 
 <data>
  <import type="android.view.View" />
  
  <variable
   name="vm"
   type="${packageName}.${activityClass}ViewModel" />
 </data>
 
 <RelativeLayout
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  android:background="@color/white">
        
  <com.supermarket.ztore.helper.ui.NetworkConnectionErrorView
   android:id="@+id/network_retry_view"
   android:layout_width="match_parent"
   android:layout_height="match_parent"
   android:visibility="@{safeUnbox(vm.isShowRetryPage)? View.VISIBLE : View.GONE}"
   tools:visibility="gone" />
   
  </RelativeLayout>
</layout>"""