package com.fortysevendeg.scala.training.ui

import android.support.v7.widget.RecyclerView
import android.view.{LayoutInflater, View, ViewGroup}
import com.fortysevendeg.scala.training.service.user.User
import com.fortysevendeg.scala.training.{TypedFindView, TR, R}

case class UserAdapter(users: Seq[User])
  extends RecyclerView.Adapter[UserViewHolder] {

  override def getItemCount: Int = users.length

  override def onBindViewHolder(viewHolder: UserViewHolder, position: Int): Unit = {
    import R.drawable._

    val user = users(position)
    viewHolder.name.setText(user.name)
    viewHolder.age.setText(user.age.toString)

    val res = user.age match {
      case age if age < 18 => background_age_less_18
      case age if age < 30 => background_age_less_30
      case age if age < 50 => background_age_less_50
      case age if age < 80 => background_age_less_80
      case _ => background_age_others
    }
    viewHolder.age.setBackgroundResource(res)
  }

  override def onCreateViewHolder(parent: ViewGroup, position: Int): UserViewHolder =
    new UserViewHolder(
      LayoutInflater
        .from(parent.getContext)
        .inflate(R.layout.list_item, parent, false))

}

class UserViewHolder(parent: View)
  extends RecyclerView.ViewHolder(parent)
  with TypedFindView {

  val age = findView(TR.age)

  val name = findView(TR.name)

  override def findViewById(id: Int): View = parent.findViewById(id)
}