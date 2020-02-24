package com.hfad.todolistprojectiml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import static android.os.Build.VERSION_CODES.O;

public class MainActivity extends AppCompatActivity {
    //creating the UI objects 
    Button button;
    Button button2;
    EditText editText;
    ListView listView;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    String isZero;
    Toast toast;
    Button deleteButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        button2 = findViewById(R.id.button2);
        //adapting entries to list to the listview
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        View.OnClickListener onClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                isZero = editText.getText().toString();
                if (isZero.isEmpty()) {
                    toast.makeText(
                            getApplicationContext(),
                            R.string.empty_string,
                            toast.LENGTH_SHORT
                    ).show();
                } else {
                    list.add(isZero);
                    editText.setText("");
                    adapter.notifyDataSetChanged();
                }}};
        View.OnClickListener onClickListenerRefresh = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                isZero = editText.getText().toString();
                if (isZero.isEmpty()) {
                    toast.makeText(
                            getApplicationContext(),
                            R.string.empty_string2,
                            toast.LENGTH_LONG
                    ).show();
                } else {
                    list.clear();
                    editText.setText("");
                    adapter.notifyDataSetChanged();
                }}};

        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListenerRefresh);
        listView.setAdapter(adapter);
        };
}