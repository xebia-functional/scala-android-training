package com.fortysevendeg.scala.training.service

import com.fortysevendeg.scala.training.service.api.impl.ApiServiceComponentImpl
import com.fortysevendeg.scala.training.service.user.impl.UserServiceComponentImpl

trait ComponentRegistryImpl
  extends ComponentRegistry
  with ApiServiceComponentImpl
  with UserServiceComponentImpl
