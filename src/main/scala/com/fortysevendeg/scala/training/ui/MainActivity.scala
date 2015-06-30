package com.fortysevendeg.scala.training.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.fortysevendeg.scala.training.service.ComponentRegistryImpl
import com.fortysevendeg.scala.training.service.user.User
import com.fortysevendeg.scala.training.utils.ContextUtils
import com.fortysevendeg.scala.training.{TypedFindView, R, TR}

class MainActivity
  extends AppCompatActivity
  with ContextUtils
  with TypedFindView
  with ComponentRegistryImpl {

  lazy val recyclerView = findView(TR.recyclerview)

  lazy val message = findView(TR.message)

  lazy val downloading = findView(TR.downloading)

  val users = Seq(
    User("Javier González", 21),
    User("Raúl Pérez", 54),
    User("Jorge Sánchez", 12),
    User("Manuel Rodríguez", 81),
    User("Pablo Benítez", 33))

  override def onCreate(bundle: Bundle) = {
    super.onCreate(bundle)
    setContentView(R.layout.main)
    recyclerView.setHasFixedSize(true)
    recyclerView.setAdapter(UserAdapter(users))
    recyclerView.setLayoutManager(new LinearLayoutManager(this))
  }

}
