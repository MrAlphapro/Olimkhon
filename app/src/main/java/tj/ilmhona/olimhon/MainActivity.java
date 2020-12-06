package tj.ilmhona.olimhon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements ContactAdapter.OnItemClickListener {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    ContactAdapter adapter;
    static int a;

    static String[] name = {
            "Себ",
            "Банан",
            "Киви",
            "Олу",
            "Анор",
            "Олуча",
            "Нок",
            "Ананас",
            "Шафтолу",
            "Лиму",
            "Ангур",
            "Тарбуз",
            "Ҳандалак",
            "Помидор"

    };


    static int[] image = {
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.a9,
            R.drawable.a10,
            R.drawable.a11,
            R.drawable.a12,
            R.drawable.a13,
            R.drawable.a14,

    };

    // Массив с данными о контактах
    static Contact[] contacts = new Contact[14];


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

        // Заполняем массив
        setContactsArray();

        // Инициализируем recyclerView список
        initRecyclerView();
    }

    private void setContactsArray() {

        contacts[0] = new Contact (1, R.drawable.a1,"Себ");
        contacts[1] = new Contact(2, R.drawable.a2,"Банан");
        contacts[2] = new Contact(3, R.drawable.a3,"Киви");
        contacts[3] = new Contact(4, R.drawable.a4,"Олу");
        contacts[4] = new Contact(5, R.drawable.a5,"Анор");
        contacts[5] = new Contact(6, R.drawable.a6,"Олуча");
        contacts[6] = new Contact(7, R.drawable.a7,"Нок");
        contacts[7] = new Contact(8, R.drawable.a8,"Ананас");
        contacts[8] = new Contact(9, R.drawable.a9,"Шафтолу");
        contacts[9] = new Contact(10, R.drawable.a10,"Лиму");
        contacts[10] = new Contact(11, R.drawable.a11,"Ангур");
        contacts[11] = new Contact(12, R.drawable.a12,"Тарбуз");
        contacts[12] = new Contact(13, R.drawable.a13,"Ҳандалак");
        contacts[13] = new Contact(14, R.drawable.a14,"Помидор");
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);




        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        adapter = new ContactAdapter(contacts, this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }


    @Override
    public void onItemClick(int position) {
        a = position;
        Intent intent = new Intent(this,InfoActivity.class) ;
        startActivity(intent);
        //Toast.makeText(this, "Some text", Toast.LENGTH_SHORT).show();
    }
}