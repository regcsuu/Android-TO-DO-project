package hu.reginatoth.beadando;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hu.reginatoth.beadando.Helper.DataBaseHelper;
import hu.reginatoth.beadando.Model.todoModel;

public class EditTodoItem extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText et_title,et_desc,et_due;
        Button btn_cancel_edit,btn_delete_edit,btn_save_edit;

        et_title = findViewById(R.id.et_title);
        et_desc = findViewById(R.id.et_desc);
        et_due = findViewById(R.id.et_due);
        btn_cancel_edit = findViewById(R.id.btn_cancel_edit);
        btn_save_edit = findViewById(R.id.btn_save_edit);
        btn_delete_edit = findViewById(R.id.btn_delete_edit);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_todoitem);


        DataBaseHelper databaseHelper=new DataBaseHelper(EditTodoItem.this);
        todoModel todo = (todoModel) getIntent().getSerializableExtra("ONETODOITEM");

        //Set the TextBoxes "Text" attribute to the boardgames attribute.
        et_title.setText(todo.getTitle());
        et_desc.setText(todo.getDesc());
        et_due.setText(String.valueOf(todo.getDueto()));


        //Button OnClickListeners
        //Cancel button
        btn_cancel_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivityPage();
            }
        });

        //Delete button
        btn_delete_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDeleted = databaseHelper.deleteTodoItem(todo);

                openMainActivityPage();
            }
        });

        //Save button
        btn_save_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    todo.setTitle(et_title.getText().toString());
                    todo.setDesc(et_desc.getText().toString());
                    todo.setDueto(et_due.getText().toString());


                    databaseHelper.updateTodoItem(todo);

                    Toast.makeText(EditTodoItem.this, "TO-DO item was updated!", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(EditTodoItem.this, "Update failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void openMainActivityPage(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
