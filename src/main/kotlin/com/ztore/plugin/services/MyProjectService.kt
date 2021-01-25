package com.ztore.plugin.services

import com.intellij.openapi.project.Project
import com.ztore.plugin.MyBundle

class MyProjectService(project: Project) {

  init {
    println(MyBundle.message("projectService", project.name))
  }
}
