package com.ambrella.message.presentation.user.adapter
import android.widget.ImageView
import com.ambrella.message.R

import com.bumptech.glide.Glide

fun loadImage(image: ImageView, uri: String?) {
    Glide.with(image.context)
        .asDrawable()
        .load(uri)
        .placeholder(R.drawable.ic_emoji_24)
        .error(R.drawable.ic_emoji_24)
        .into(image)
}