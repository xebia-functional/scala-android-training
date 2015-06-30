package com.fortysevendeg.scala.training.service

import org.specs2.mutable.Specification

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}


class UserServiceComponentSpec
  extends Specification {

  "User Service Component" should {

    "return user when add item" in
      new UserServiceTestSupport {

        apiService.readName(ApiReadName) returns Future.successful(Some(NameData))
        apiService.readAge(ApiReadAge) returns Future.successful(Some(AgeData))

        val result = Await.result(userService.addUser, Duration.Inf)

        result shouldEqual user
      }

    "throw an Exception when readName fails" in
      new UserServiceTestSupport {

        apiService.readName(ApiReadName) returns Future.failed[Option[String]](new RuntimeException("Error"))
        apiService.readAge(ApiReadAge) returns Future.successful(Some(AgeData))

        Await.result(userService.addUser, Duration.Inf) must throwA[RuntimeException]

      }

    "throw an Exception when readAge fails" in
      new UserServiceTestSupport {

        apiService.readName(ApiReadName) returns Future.successful(Some(NameData))
        apiService.readAge(ApiReadAge) returns Future.failed[Option[Int]](new RuntimeException("Error"))

        Await.result(userService.addUser, Duration.Inf) must throwA[RuntimeException]

      }

  }

}
