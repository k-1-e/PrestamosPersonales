package net.larntech.prestamospersonales

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "clientes")
class Cliente(
    val nombre:String,
    val cantidadprestada: Double,
    val direccion: String,
    val telefono: Int,
    val fechaInicio : String,
    val fehaFin : String,
    @PrimaryKey(autoGenerate = true)
    var idCliente: Int = 0
) : Serializable