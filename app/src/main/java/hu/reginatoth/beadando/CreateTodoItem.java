package hu.reginatoth.beadando;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import hu.reginatoth.beadando.Helper.DataBaseHelper;
import hu.reginatoth.beadando.Model.todoModel;

public class CreateTodoItem extends AppCompatActivity {

    private Button btn_save_create,btn_cancel_create;
    private TextView et_title,et_desc,et_due;

    ArrayAdapter todoArrayAdapter;
    DataBaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todoitem);

        btn_save_create = findViewById(R.id.btn_save_create);
        btn_cancel_create = findViewById(R.id.btn_cancel_create);
        et_title = findViewById(R.id.et_title);
        et_desc = findViewById(R.id.et_desc);
        et_due = findViewById(R.id.et_due);

        databaseHelper =new DataBaseHelper(CreateTodoItem.this);



        btn_save_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoModel todoitem;

                try {
                    todoitem = new todoModel(-1,
                            et_title.getText().toString(),
                            et_desc.getText().toString(),
                            et_due.getText().toString());

                    databaseHelper.addTodoItem(todoitem);
                    Toast.makeText(CreateTodoItem.this, "TO-DO item "+todoitem.getTitle()+" was added!", Toast.LENGTH_SHORT).show();

                    goBackToMain();
                }
                catch (Exception e){
                    Toast.makeText(CreateTodoItem.this, "No new TO-DO was added! Try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Cancel button
        btn_cancel_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToMain();
            }
        });
    }

    public void goBackToMain(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
