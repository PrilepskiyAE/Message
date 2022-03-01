package com.ambrella.message.presentation.login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
class ResetPassHelperCallback(
    val userName: String,
    val resetAction: @RawValue (newPassword: String) -> Unit
) : Parcelable