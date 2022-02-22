package com.elmessiry.room_db


import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


inline fun <reified T : RoomDatabase> createRoomDB(
    context: Context,
    name: String,
    callback: RoomDatabase.Callback
): T {

    return Room.databaseBuilder(
        context,
        T::class.java,
        name
    ).fallbackToDestructiveMigration()
        .addCallback(callback).build()
}
