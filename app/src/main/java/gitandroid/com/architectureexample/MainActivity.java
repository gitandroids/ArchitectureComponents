package gitandroid.com.architectureexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NoteAdaptor adapter = new NoteAdaptor();
        recyclerView.setAdapter(adapter);
        //* We might need to use these two instead of ViewModelProviders in androidx .
        //ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        // noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        // This way ViewModel knows which lifecycle it scoped to..
        // Android will destroy ViewModel when this activity finished.
        // observe is LiveData Method--LiveData is Lifecycle aware. It only updates when the owner is on foreground
        // When the activity destroyed it will automatically clean up the referance . TO AVOID MEMORY LEAKAGE..
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {  // This will only called when our activity is on foreground.
                //update RecyclerView
                adapter.setNotes(notes);
            }
        });
    }
}
