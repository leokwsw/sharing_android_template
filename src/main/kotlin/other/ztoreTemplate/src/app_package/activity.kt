package other.ztoreTemplate.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

//${if (applicationPackage.applicationPackage != null) "import ${applicationPackage.applicationPackage}.R" else ""}
//${if (applicationPackage.applicationPackage != null) "import ${applicationPackage.applicationPackage}.base.BaseActivity" else ""}

fun activity(
  applicationPackage: ProjectTemplateData,
  activityClass: String,
  layoutName: String,
  packageName: String
) = """
package $packageName

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import ${applicationPackage.applicationPackage}.R
import ${applicationPackage.applicationPackage}.base.BaseActivity
import ${applicationPackage.applicationPackage}.databinding.Activity${activityClass}Binding


class ${activityClass}Activity : BaseActivity<Activity${activityClass}Binding>() {
 private var mIsLoading = false
 
 private val viewModel: ${activityClass}ViewModel by lazy {
  getInjectViewModel(${activityClass}ViewModel::class.java)
 }

 override fun getLayoutId(): Int = R.layout.${layoutName}

 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  getComponent().inject(this)
  initData()
  setupView()
  loadApi()
  observe()
 }
 
 fun initData() {
  mBinding.vm = viewModel
 }
 
 fun setupView() {
  
 }
 
 fun loadApi() {
 
 }
 
 private fun observe() {
  viewModel.isLoading.observe(this, Observer {
   mIsLoading = it!!
  })
 }
 
 override fun onNewIntent(intent: Intent?) {
  super.onNewIntent(intent)
  
 }
 
 override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
  super.onActivityResult(requestCode, resultCode, data)
  
 }
 
 override fun onBackPressed() {
 
 }
 
 override fun onPageRetry() {
  viewModel.isShowRetryPage.value = true
 }
 
 } 
"""