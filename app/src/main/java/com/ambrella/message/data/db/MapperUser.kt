package com.ambrella.message.data.db

import com.ambrella.message.data.entity.UserDB
import com.ambrella.message.domain.entity.User

class MapperUser {
    fun mapEntityToDbModel(user: User) = UserDB(
        id = user.id,
        username = user.username,
        password = user.password,
        resIdAvatars = user.resIdAvatars
    )
    fun mapListDbModelToListEntity(list: List<UserDB>) = list.map {
        mapDbModelToEntity(it)
    }

    fun mapDbModelToEntity(userDB: UserDB) = User(
        id = userDB.id,
        username = userDB.username,
        password = userDB.password,
        resIdAvatars = userDB.resIdAvatars
    )
}