package net.larntech.prestamospersonales

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Update
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao

@Dao
interface ClientesDao {
    @Query ("SELECT * FROM clientes")
    fun getAll() : LiveData<List<Cliente>>

    @Query("SELECT * FROM clientes WHERE idCliente = :id")
    fun get(id:Int):LiveData<Cliente>

    @Insert
    fun insertAll(vararg cliente: Cliente)

    @Update
    fun update(cliente: Cliente)

    @Delete
    fun delete(cliente: Cliente)


}