package eu.petrfaruzel.templateapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import eu.petrfaruzel.templateapp.database.dto.DTOOBject

@Dao
interface DaoObject {

    @Query("SELECT * FROM dtoobject")
    fun getAll(): List<DTOOBject>

    @Query("SELECT * FROM dtoobject WHERE name = :name LIMIT 1")
    fun findByHash(name : String): DTOOBject

    @Insert
    fun insertAll(vararg activities: DTOOBject)

    @Delete
    fun delete(activity : DTOOBject)

    @Query("DELETE FROM dtoobject WHERE name = :name")
    fun deleteByHash(name : String)
}