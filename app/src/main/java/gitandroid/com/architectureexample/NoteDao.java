package gitandroid.com.architectureexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao    // It say room that it is a dao
public interface NoteDao {
    @Insert    // We just define the method name return type and the arguments and Room adds necessary code.
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table ")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC") // At compile time Room will check if the columns of note_table object fits the Note java object..
    LiveData<List<Note>> getAllNotes(); // Table is observable with livedata.
    //List<Note> getAllNotes();

}
