package net.larntech.prestamospersonales

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Cliente::class],version = 1)
abstract class PrestamosDatabase : RoomDatabase() {

    abstract  fun clientesDao() : ClientesDao

    companion object{

        @Volatile
        private  var INSTANCE: PrestamosDatabase? = null
        fun getDatabase(context: Context) : PrestamosDatabase{
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,PrestamosDatabase::class.java, "PrestamosDatabase").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}