package com.hansandroid.grospasswd.model

import com.hansandroid.grospasswd.utils.toMD5

class PasswordProvider {

    fun providePassword(password: String): String {
        return password.toMD5()
    }

}