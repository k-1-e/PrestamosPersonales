package net.larntech.prestamospersonales

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ClientesDao {

    @Query ("SELECT * FROM clientes")
    fun getAll() : LiveData<List<Cliente>>

    @Insert
    fun InsertAll(vararg cliente: Cliente)

    @Update
    fun update(cliente: Cliente)

    @Delete
    fun Delete(cliente: Cliente)

}