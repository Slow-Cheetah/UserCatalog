package com.example.usercatalog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbarMain;
    EditText nameET;
    EditText ageET;
    Button saveBTN;
    ListView catalogLV;

    ArrayList<User> catalogList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        unitUI();
//        onButtonsClick();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, catalogList);
        catalogLV.setAdapter(adapter);

        saveBTN.setOnClickListener(v -> {
            User user = new User(nameET.getText().toString(), ageET.getText().toString());
            catalogList.add(user);
            adapter.notifyDataSetChanged();
            nameET.getText().clear();
            ageET.getText().clear();
        });

//        catalogLV.setOnItemClickListener((parent, view, position, id) -> {
//            catalogList.remove(position);
//            adapter.notifyDataSetChanged();
//            Toast.makeText(this, "Пользователь удален", Toast.LENGTH_SHORT).show();
//        });
        catalogLV.setOnItemClickListener((parent, view, position, id) -> {
            MyDialog.openDialog(MainActivity.this, position, adapter, catalogList);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exitMenuMain) {
            finish();
            Toast.makeText(this, "Приложение закрыто", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void unitUI() {
        toolbarMain = findViewById(R.id.toolbarMain);

        nameET = findViewById(R.id.nameET);
        ageET = findViewById(R.id.ageET);

        saveBTN = findViewById(R.id.saveBTN);

        catalogLV = findViewById(R.id.catalogLV);

        setSupportActionBar(toolbarMain);
    }
}