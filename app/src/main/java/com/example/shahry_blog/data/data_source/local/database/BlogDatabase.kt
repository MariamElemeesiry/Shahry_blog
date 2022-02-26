package com.example.shahry_blog.data.data_source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.elmessiry.room_db.createRoomDB
import com.example.shahry_blog.data.data_source.local.database.dao.AuthorsDao
import com.example.shahry_blog.data.data_source.local.database.dao.CommentsDao
import com.example.shahry_blog.data.data_source.local.database.dao.PostsDao
import com.example.shahry_blog.data.entities.AuthorEntity
import com.example.shahry_blog.data.entities.CommentsEntity
import com.example.shahry_blog.data.entities.PostsEntity
import com.example.shahry_blog.data.type_converters.OffsetDateTimeTypeConverter

@Database(
    entities = [
        AuthorEntity::class,
        PostsEntity::class,
        CommentsEntity::class,

    ], version = 1
)
@TypeConverters(OffsetDateTimeTypeConverter::class, OffsetDateTimeTypeConverter::class)
abstract class BlogDatabase : RoomDatabase() {
    abstract fun postsDao():PostsDao
    abstract fun commentsDao():CommentsDao
    abstract fun authorsDao():AuthorsDao

    companion object {
        private var DB_INSTANCE: BlogDatabase? = null
        const val DB_NAME = "BLOG_DB"
        val callbacks: Callback = object : Callback() {}
        fun getDatabaseInstance(context: Context): BlogDatabase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE = createRoomDB(
                    context = context.applicationContext,
                    name = DB_NAME,
                    callback = callbacks
                )
            }
            return DB_INSTANCE!!
        }
    }
}