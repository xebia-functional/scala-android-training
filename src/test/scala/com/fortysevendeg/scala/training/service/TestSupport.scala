package com.fortysevendeg.scala.training.service

import com.fortysevendeg.scala.training.R
import com.fortysevendeg.scala.training.service.api.ApiServiceComponent
import com.fortysevendeg.scala.training.service.user.User
import com.fortysevendeg.scala.training.service.user.impl.UserServiceComponentImpl
import com.fortysevendeg.scala.training.utils.ContextUtils
import org.specs2.mock.Mockito
import org.specs2.specification.Scope

trait MockedDependencies extends Mockito {

  val ApiReadName = "http://example.org/readName"

  val ApiReadAge = "http://example.org/readInt"

  val NameData = "John Macarty"

  val AgeData = 18

  trait MockApiServiceComponent extends ApiServiceComponent {
    override val apiService: ApiService = mock[ApiService]
  }

  trait MockContextUtils extends ContextUtils {
    def getString(n : Int) : String = n match {
      case R.string.api_read_name => ApiReadName
      case R.string.api_read_age => ApiReadAge
      case _ => ""
    }
  }

}

object MockedDependencies extends MockedDependencies

class UserServiceTestSupport
  extends Scope
  with MockedDependencies
  with MockedDependencies.MockApiServiceComponent
  with MockedDependencies.MockContextUtils
  with UserServiceComponentImpl {

  val user = User(NameData, AgeData)

}
