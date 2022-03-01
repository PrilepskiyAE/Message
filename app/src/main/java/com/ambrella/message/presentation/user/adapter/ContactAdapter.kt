package com.ambrella.message.presentation.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ambrella.message.R
import com.ambrella.message.domain.entity.User

//class ContactListAdapter : RecyclerView.Adapter<UserViewHolder>() {
class ContactListAdapter : ListAdapter<User, UserViewHolder>(ContactItemDiffCallback()) {
    //  val count=0
    // private var users: List<User> = listOf()
    //set(value) {
    //val callback=ContactListDiffCallback(users,value)
    //  val diffResult=DiffUtil.calculateDiff(callback)
    //   diffResult.dispatchUpdatesTo(this)
    //   field=value
    //    notifyDataSetChanged()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)

        holder.itemView.setOnClickListener {
            onUserClickLisener?.invoke(user)

        }
        holder.init(user)
    }
    //var onUserClickLisener: OnUserClickLisener? = null
    var onUserClickLisener: ((User) -> Unit)? = null
//    interface OnUserClickLisener {
//        fun onUserClick(user: User)
//    }
    companion object{
    const val MAX_POOL_SIZE = 30
    }
}


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
//        return UserViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
//        val quote = getItem(position)
//        holder.init(quote)
//        holder.itemView.setOnClickListener {
//            onUserClickLisener?.onUserClick(quote)
//        }
//    }
//
//    fun setUser(t: List<User>) {
//        this.users = t
//    }
//
//    fun isEmpty(): Boolean {
//        return users.isEmpty()
//    }
//
//    fun getUser(pos: Int): User {
//        return users[pos]
//    }
//
//    override fun getItemCount(): Int {
//        return users.size
//    }



class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var mTitle: TextView? = null
    private var mText: TextView? = null
    private var mImg: ImageView?=null

    init {

        mTitle = itemView.findViewById(R.id.tvname)
        mText = itemView.findViewById(R.id.tvStaus)
        mImg = itemView.findViewById(R.id.imgAvatar)
    }

    fun init(currentUser: User) {
        mTitle?.text = currentUser.username
        //TODO модифицировать бд добавить поле статус
        mText?.text = "Тут будет статус"
        if (currentUser.resIdAvatars.equals("empty"))
            mImg?.setImageResource(R.drawable.ic_emoji_24)
        else
            loadImage(mImg!!,currentUser.resIdAvatars)
    }
}
