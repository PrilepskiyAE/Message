package com.ambrella.message.domain.entity

data class User (
    val id:Int=0,
    val username:String,
    val password:String,
    val resIdAvatars:String="empty"
)