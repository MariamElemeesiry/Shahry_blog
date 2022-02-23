package com.example.shahry_blog.data.data_source.local.database.dao

import androidx.room.*
import io.reactivex.Completable

@Dao
interface BaseDao<T> {
    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: T): Completable

    /**
     * Insert an array of objects in the database.
     *
     * @param obj the objects to be inserted.
     * @return The SQLite row ids
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: List<T>): Completable

    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    fun update(obj: T): Completable

    /**
     * Update an array of objects from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    fun update(obj: List<T>): Completable

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     */
    @Delete
    fun delete(obj: T): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(obj: T): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateAll(obj: List<T>): Completable

}