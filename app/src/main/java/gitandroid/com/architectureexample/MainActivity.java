package gitandroid.com.architectureexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        //ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();   // This way ViewModel knows which lifecycle it scoped to..
        // noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class); // Android will destroy ViewModel when this activity finished.
        // observe is LiveData Method--LiveData is Lifecycle aware. It only updates when the owner is on foreground
        // When the activity destroyed it will automatically clean up the referance . TO AVOID MEMORY LEAKAGE..
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {  // This will only called when our activity is on foreground.
                //update RecyclerView
                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
