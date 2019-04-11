package com.example.multiactivityf1d016060;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EditActivity extends AppCompatActivity {

    String member1, member2, member3, member4, member5, teamName, tempDPC;
    int index, teamDPC;
    ImageView teamlogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        index=intent.getIntExtra("index", 0);
        teamlogo = findViewById(R.id.teamLogo);
        teamlogo.setImageResource(intent.getIntExtra("logo",0));

        EditText editName = (EditText) findViewById(R.id.teamName);
        EditText editDPC = (EditText) findViewById(R.id.teamDPC);
        EditText editMember1 = (EditText) findViewById(R.id.member1);
        EditText editMember2 = (EditText) findViewById(R.id.member2);
        EditText editMember3 = (EditText) findViewById(R.id.member3);
        EditText editMember4 = (EditText) findViewById(R.id.member4);
        EditText editMember5 = (EditText) findViewById(R.id.member5);

        teamName = editName.getText().toString();
        tempDPC = editDPC.getText().toString();
        //teamDPC = Integer.parseInt(tempDPC);
        member1 = editMember1.getText().toString();
        member2 = editMember2.getText().toString();
        member3 = editMember3.getText().toString();
        member4 = editMember4.getText().toString();
        member5 = editMember5.getText().toString();

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                saveData(index, teamName, member1, member2, member3, member4, member5);
            }
        });

        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gotoMenu = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(gotoMenu);
            }
        });

    }
    private void saveData(int index, String name, String member1, String member2, String member3, String member4, String member5) {
        Intent saveData = new Intent(getApplicationContext(), MainActivity.class);
        saveData.putExtra("newName", name);
        saveData.putExtra("index", index);
        startActivity(saveData);
    }

}
