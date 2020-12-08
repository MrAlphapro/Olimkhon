package tj.ilmhona.olimhon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;






    static int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textView = findViewById(R.id.textviewId);
        imageView = findViewById(R.id.imgviewID);

        String tv = getIntent().getStringExtra("data");

        int image = getIntent().getIntExtra("image",0);


        textView.setText(tv);
        imageView.setImageResource(image);




    }
}