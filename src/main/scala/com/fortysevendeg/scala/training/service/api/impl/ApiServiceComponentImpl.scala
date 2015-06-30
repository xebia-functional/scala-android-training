package com.fortysevendeg.scala.training.service.api.impl

import com.fortysevendeg.scala.training.service.api.ApiServiceComponent
import org.apache.http.impl.client.DefaultHttpClient

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._

trait ApiServiceComponentImpl
  extends ApiServiceComponent {

  val apiService = new ApiServiceImpl

  class ApiServiceImpl
    extends ApiService {

    val netService = new NetService(new DefaultHttpClient())

    override def readName(apiReadName: String): Future[Option[String]] =
      Future(blocking(netService.readContent(apiReadName)))

    override def readAge(apiReadAge: String): Future[Option[Int]] =
      Future(blocking(netService.readContent(apiReadAge) map (_.toInt)))

  }

}
