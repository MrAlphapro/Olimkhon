package tj.ilmhona.olimhon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ContactAdapter adapter;

    FloatingActionButton fab;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        });



        // Инициализируем recyclerView список
        initRecyclerView();
    }

    private List<Contact> setContactsArray() {
        List<Contact> listBook = new ArrayList<>();
        listBook.add(new Contact (1, R.drawable.a1,"Себ"));
        listBook.add(new Contact(2, R.drawable.a2,"Банан"));
        listBook.add(new Contact(3, R.drawable.a3,"Киви"));
        listBook.add(new Contact(4, R.drawable.a4,"Олу"));
        listBook.add(new Contact(5, R.drawable.a5,"Анор"));
        listBook.add(new Contact(6, R.drawable.a6,"Олуча"));
        listBook.add(new Contact(7, R.drawable.a7,"Нок"));
        listBook.add(new Contact(8, R.drawable.a8,"Ананас"));
        listBook.add(new Contact(9, R.drawable.a9,"Шафтолу"));
        listBook.add(new Contact(10, R.drawable.a10,"Лиму"));
        listBook.add(new Contact(11, R.drawable.a11,"Ангур"));
        listBook.add(new Contact(12, R.drawable.a12,"Тарбуз"));
        listBook.add(new Contact(13, R.drawable.a13,"Ҳандалак"));
        listBook.add(new Contact(14, R.drawable.a14,"Помидор"));
        return listBook;
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);




        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        adapter = new ContactAdapter(this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.setData(setContactsArray());
    }


}