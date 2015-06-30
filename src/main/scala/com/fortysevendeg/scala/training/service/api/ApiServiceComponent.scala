package com.fortysevendeg.scala.training.service.api

import scala.concurrent.Future

trait ApiServiceComponent {

  def apiService: ApiService

  trait ApiService {

    def readName(apiReadName: String): Future[Option[String]]

    def readAge(apiReadAge: String): Future[Option[Int]]

  }

}