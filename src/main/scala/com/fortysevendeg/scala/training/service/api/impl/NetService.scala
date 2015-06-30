package com.fortysevendeg.scala.training.service.api.impl

import java.io.{BufferedReader, Closeable, InputStream, InputStreamReader}

import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.{HttpEntity, HttpResponse}

import scala.util.control.Exception._
import scala.util.{Success, Try}

class NetService(httpClient: HttpClient) {

  val Encoding = "UTF-8"

  def readContent(url: String): Option[String] = {
    Try {
      val httpGet: HttpGet = createHttpGet(url)
      val httpResponse: HttpResponse = httpClient.execute(httpGet)
      val httpEntity: HttpEntity = httpResponse.getEntity
      val is: InputStream = httpEntity.getContent
      val reader: BufferedReader = new BufferedReader(new InputStreamReader(is, Encoding), 8)
      withResource(reader)(r => Stream.continually(r.readLine()).takeWhile(Option(_).isDefined).mkString)
    } match {
      case Success(response) => Some(response.trim)
      case _ => None
    }
  }

  def createHttpGet(url: String): HttpGet = new HttpGet(url)

  private def withResource[C <: Closeable, R](closeable: C)(f: C => R) = {
    allCatch.andFinally(closeable.close())(f(closeable))
  }

}
