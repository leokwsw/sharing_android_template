package other.ztoreTemplate.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun viewModel(
  activityClass:String,
  packageName:String
) = """
  package $packageName
  
  import androidx.lifecycle.MutableLiveData
  import androidx.lifecycle.ViewModel
  import io.reactivex.disposables.CompositeDisposable
  import javax.inject.Inject
  
  class ${activityClass}ViewModel @Inject constructor(
   //
  ) : ViewModel() {
   private val mCompositeDisposable = CompositeDisposable()
   
   val isLoading = MutableLiveData<Boolean>()
   val isShowRetryPage = MutableLiveData<Boolean>()
  }
"""