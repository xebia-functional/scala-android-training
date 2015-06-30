package com.fortysevendeg.scala.training.service.user.impl

import com.fortysevendeg.scala.training.R
import com.fortysevendeg.scala.training.service.api.ApiServiceComponent
import com.fortysevendeg.scala.training.service.user.{User, UserServiceComponent}
import com.fortysevendeg.scala.training.utils.ContextUtils

import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

trait UserServiceComponentImpl
  extends UserServiceComponent {

  self : ApiServiceComponent with ContextUtils =>

  val userService = new UserServiceImpl

  class UserServiceImpl
    extends UserService {

    override def addUser: Future[User] = for {
      Some(name) <- apiService.readName(getString(R.string.api_read_name))
      Some(age) <- apiService.readAge(getString(R.string.api_read_age))
    } yield User(name, age)
  }

}
