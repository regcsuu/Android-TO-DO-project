package hu.reginatoth.beadando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import hu.reginatoth.beadando.Helper.DataBaseHelper;
import hu.reginatoth.beadando.Model.todoModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //reference to buttons and other controls
    Button btn_add;
    ListView lw_items;

    DataBaseHelper dataBaseHelper;
    ArrayAdapter todoArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        lw_items = findViewById(R.id.lw_items);

        dataBaseHelper=new DataBaseHelper(MainActivity.this);

        todoArrayAdapter = new ArrayAdapter<todoModel>(MainActivity.this, android.R.layout.simple_list_item_1,dataBaseHelper.getAllitem());
        lw_items.setAdapter( todoArrayAdapter);


        //button listeners for the add button
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateTodoItem();
            }
        });

        lw_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                todoModel chosenitem = (todoModel) parent.getItemAtPosition(position);
                todoModel item = dataBaseHelper.getTodoItem(chosenitem);
                openEdittodo(item);
            }
        });
    }

    public void openEdittodo(todoModel item){
        todoModel oitem = item;

        Intent intent=new Intent(this, EditTodoItem.class);
        intent.putExtra("ONETODOITEM",item);
        startActivity(intent);
    }


    public void openCreateTodoItem(){
        Intent intent=new Intent(this, CreateTodoItem.class);
        startActivity(intent);
    }
}