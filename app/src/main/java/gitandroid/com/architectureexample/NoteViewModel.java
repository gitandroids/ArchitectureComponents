package gitandroid.com.architectureexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {  // AndroidViewModel is a subclass of ViewModel
    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {  // In AndroidViewModel we can use application as context. Which came from super class.
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
        // Our Activity will have reference to the VİewModel. Not the repository so that we need to have get methods here.
    }

    public void insert(Note note) {
        repository.insert(note);
    }

    public void update(Note note) {
        repository.update(note);
    }

    public void delete(Note note) {
        repository.delete(note);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

}
