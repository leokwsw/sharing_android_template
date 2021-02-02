package other.ztoreTemplate

import com.android.tools.idea.wizard.template.*
import java.io.File

val customViewTemplate
  get() = template {
    name = "Ztore Custom View Activity XML"
    description = "Create a new activity along layout file."
    revision = 1 // version
    category = Category.Other //Android Template Category
    formFactor = FormFactor.Mobile
    screens = listOf(
      WizardUiContext.ActivityGallery,
      WizardUiContext.MenuEntry
//      WizardUiContext.NewProject,
//      WizardUiContext.NewModule
    )

    val activityClass = stringParameter {
      name = "Entity Name (Without 'Activity')"
      default = "Ztore"
      help = "The name of the entity class to create and use in Activity"
      constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
    }

    val layoutName = stringParameter {
      name = "Layout Name"
      default = "activity_ztore"
      help = "The name of the layout to create for the activity"
      constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
      suggest = { activityToLayout(activityClass.value.toLowerCase()) }
    }

    val packageName = defaultPackageNameParameter

    widgets(
      TextFieldWidget(activityClass),
      TextFieldWidget(layoutName),
      PackageNameWidget(packageName),
    )

    thumb {
      File("template_empty_activity.png")
    }

    recipe = { data: TemplateData ->
      ztoreRecipe(
        data as ModuleTemplateData,
        activityClass.value,
        layoutName.value,
        packageName.value
      )
    }
  }

val defaultPackageNameParameter
  get() = stringParameter {
    name = "Package name"
    visible = { !isNewModule }
    default = "com.mycompany.myapp"
    constraints = listOf(Constraint.PACKAGE)
    suggest = { packageName }
  }

// override toLowerCase from OrderDetails to order_details
fun String.toLowerCase(): String {
  val list = arrayListOf<String>()
  this.toMutableList().forEach {
    list.add(
      if (it.isUpperCase()) {
        if (list.size > 0) {
          "_"
        } else {
          ""
        } + it.toLowerCase()
      } else {
        it
      }.toString()
    )
  }
  return list.joinToString(separator = "")
}