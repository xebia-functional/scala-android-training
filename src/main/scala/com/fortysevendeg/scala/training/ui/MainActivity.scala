package com.fortysevendeg.scala.training.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.{View, MenuItem, Menu}
import com.fortysevendeg.scala.training.service.ComponentRegistryImpl
import com.fortysevendeg.scala.training.service.user.User
import com.fortysevendeg.scala.training.utils.ContextUtils
import com.fortysevendeg.scala.training.{TypedFindView, R, TR}

import scala.concurrent.ExecutionContext.Implicits.global

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

  override def onCreateOptionsMenu(menu: Menu): Boolean = {
    getMenuInflater.inflate(R.menu.app_menu, menu)
    super.onCreateOptionsMenu(menu)
  }

  override def onOptionsItemSelected(item: MenuItem): Boolean = item.getItemId match {
    case R.id.action_add_item =>
      addItem()
      true
    case _ => super.onOptionsItemSelected(item)
  }

  private[this] def addItem() = {
    downloading.setVisibility(View.VISIBLE)
    userService.addUser map {
      user =>
        runOnUiThread(new Runnable {
          override def run(): Unit = addUserToList(user)
        })
    } recover {
      case _ => showErrorMessage()
    }
  }

  private[this] def addUserToList(user: User) = {
    downloading.setVisibility(View.GONE)
    val maybeAdapter = recyclerView.getAdapter match {
      case adapter: UserAdapter => Some(adapter)
      case _ => None
    }
    maybeAdapter foreach {
      adapter =>
        val newAdapter = adapter.copy(user +: adapter.users)
        recyclerView.swapAdapter(newAdapter, false)
    }
  }

  private[this] def showErrorMessage() = {
    downloading.setVisibility(View.GONE)
    message.setText(R.string.error)
    message.setVisibility(View.VISIBLE)
    recyclerView.setVisibility(View.GONE)
  }

}
