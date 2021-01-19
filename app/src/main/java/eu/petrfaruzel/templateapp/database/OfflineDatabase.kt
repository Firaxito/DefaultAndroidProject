package eu.petrfaruzel.templateapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import eu.petrfaruzel.templateapp.database.dao.DaoObject
import eu.petrfaruzel.templateapp.database.dto.DTOOBject

@Database(entities = [DTOOBject::class], version = 1)
@TypeConverters(RoomConverters::class)
abstract class OfflineDatabase : RoomDatabase() {
    abstract fun objectDao() : DaoObject


    companion object {
        fun getInstance(context : Context) : OfflineDatabase {
            return Room.databaseBuilder(context, OfflineDatabase::class.java, "offline-database").fallbackToDestructiveMigration().build()
        }
    }
}