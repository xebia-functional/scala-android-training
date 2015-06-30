package com.fortysevendeg.scala.training.service

import com.fortysevendeg.scala.training.service.api.ApiServiceComponent
import com.fortysevendeg.scala.training.service.user.UserServiceComponent
import com.fortysevendeg.scala.training.utils.ContextUtils

trait ComponentRegistry
  extends ApiServiceComponent
  with UserServiceComponent
  with ContextUtils
