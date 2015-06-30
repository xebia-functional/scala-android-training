package com.fortysevendeg.scala.training.service.user

import scala.concurrent.Future

trait UserServiceComponent {

  def userService: UserService

  trait UserService {

    def addUser: Future[User]

  }

}
