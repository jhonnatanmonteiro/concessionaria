package com.perguntados.concessionriaapp

import android.provider.BaseColumns

object UserContract {
    object UserEntry : BaseColumns {
        const val ID = "id"
        const val TABLE_NAME = "users"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASSWORD = "password"
    }
}
