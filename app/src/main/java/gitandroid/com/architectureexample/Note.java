package gitandroid.com.architectureexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {  // By default the table name will be Note but we changed it to note_table.
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;   // Room will automatically generate columns for these fields.
    private String description;
    //@ColumnInfo(name = "priority_column") // You can make the name different other than field here.
    private int priority;

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {   // Room will use it to generate primary key.
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
