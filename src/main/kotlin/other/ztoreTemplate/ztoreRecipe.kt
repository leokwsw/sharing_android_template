package other.ztoreTemplate

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import other.ztoreTemplate.res.layout.layoutXml
import other.ztoreTemplate.src.app_package.activity
import other.ztoreTemplate.src.app_package.viewModel

fun RecipeExecutor.ztoreRecipe(
  moduleData: ModuleTemplateData,
  activityClass: String,
  layoutName: String,
  packageName: String
) {
  val (projectData, srcOut, resOut) = moduleData
  val ktOrJavaExt = projectData.language.extension

  // Activity
  save(
    activity(projectData, activityClass, layoutName, packageName),
    srcOut.resolve("${activityClass}Activity.kt")
  )

  // Layout XML
  save(
    layoutXml(packageName, activityClass),
    resOut.resolve("layout/${layoutName}.xml")
  )

  save(
    viewModel(activityClass, packageName),
    srcOut.resolve("${activityClass}ViewModel.kt")
  )

  generateManifest(
    moduleData = moduleData,
    activityClass = "${activityClass}Activity",
    activityTitle = "",
    packageName = packageName,
    isLauncher = false,
    hasNoActionBar = false,
    generateActivityTitle = false,
//    requireTheme = false,
//    useMaterial2 = false
  )
}