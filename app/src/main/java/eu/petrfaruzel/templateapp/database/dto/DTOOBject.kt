package eu.petrfaruzel.templateapp.database.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class DTOOBject(
    @PrimaryKey(autoGenerate = true) var id : Int,
    var name : String
    ) {
}