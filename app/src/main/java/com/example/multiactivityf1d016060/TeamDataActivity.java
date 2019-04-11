package com.example.multiactivityf1d016060;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TeamDataActivity extends AppCompatActivity {

    TextView teamName;
    ImageView teamLogo;
    TextView teamDPC;
    TextView allTeamMember;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teamdata);

        teamName = findViewById(R.id.teamName);
        teamLogo = findViewById(R.id.teamLogo);
        allTeamMember = findViewById(R.id.memberList);
        teamDPC = findViewById(R.id.teamDPC);
        Intent intent = getIntent();
        String[] teamMember = intent.getStringArrayExtra("teamMember");
        String memberNames = "";
        for (int index=0; index<teamMember.length; index++)
        {
            memberNames=memberNames+teamMember[index]+"\n";
        }
        teamName.setText(intent.getStringExtra("teamName"));
        teamLogo.setImageResource(intent.getIntExtra("teamLogo", 0));
        String dpcPoints = Integer.toString(intent.getIntExtra("teamDPC", 0));
        teamDPC.setText("DPC Points: "+ dpcPoints);
        allTeamMember.setText(memberNames   );
        index = intent.getIntExtra("index", 0);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void editData(View view) {
        Intent newIntent = new Intent()
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
