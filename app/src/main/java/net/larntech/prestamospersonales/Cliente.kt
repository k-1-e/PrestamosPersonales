package net.larntech.prestamospersonales

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "clientes")
class Cliente(val nombre:String,
              val cantidadprestada: Double,
              val descripcion: String,
              @PrimaryKey(autoGenerate = true)
              val uid: Int = 0
) : Serializable