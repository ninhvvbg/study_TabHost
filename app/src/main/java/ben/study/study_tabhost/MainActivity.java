package ben.study.study_tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //manhinh1
    EditText edt1,edt2;
    Button btnCong;
    //manhinh2
    ArrayList<String> listHistory;
    ArrayAdapter<String> adapterHistory;
    ListView lvHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyPhepCong();
            }
        });
    }

    private void xuLyPhepCong() {
        int a = Integer.parseInt(edt1.getText().toString());
        int b = Integer.parseInt(edt2.getText().toString());
        String c = a + " + " + b + " = " + (a+b);
        listHistory.add(c);
        adapterHistory.notifyDataSetChanged();
        edt1.setText("");
        edt2.setText("");

    }

    private void addControls() {
        TabHost tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabb1 = tabHost.newTabSpec("Name1");
//        tabb1.setIndicator("phép cộng");
        tabb1.setIndicator("",getResources().getDrawable(R.drawable.plus));
        tabb1.setContent(R.id.tab1);
        tabHost.addTab(tabb1);

        TabHost.TabSpec tabb2 = tabHost.newTabSpec("Name2");
        tabb2.setIndicator("History");
        tabb2.setContent(R.id.tab2);
        tabHost.addTab(tabb2);

        TabHost.TabSpec tabb3 = tabHost.newTabSpec("Name3");
        tabb3.setIndicator("manhinh3");

        tabb3.setContent(R.id.tab3);
        tabHost.addTab(tabb3);


        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btnCong = findViewById(R.id.btnCong);

        listHistory = new ArrayList<>();
        adapterHistory = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,listHistory);
        lvHistory = findViewById(R.id.lvHistory);
        lvHistory.setAdapter(adapterHistory);
    }
}
