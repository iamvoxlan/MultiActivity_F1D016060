package com.example.multiactivityf1d016060;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sfLogin;
    GridView gridView;

    public boolean firstTry=true;
    public String[] teamNames = {
            "Team Liquid",
            "Evil Geniuses",
            "Virtus Pro",
            "Team Secret",
            "Team OG"
    };

    public String[][] teamMembers = {
            {"Matumbaman", "Miracle-", "MinD_ContRoL", "GH", "KuroKy"},
            {"Arteezy", "SumaiL", "s4", "Cr1t-", "Fly"},
            {"RAMZES666", "No[o]ne", "9pasha", "RodjER", "Solo"},
            {"Nisha", "MidOne", "zai", "YapzOr", "Puppey"},
            {"ana", "Tompson", "7ckngMad", "JerAx", "N0tail"}
    };

    public int[] teamImages = {
            R.drawable.liquid,
            R.drawable.evilgeniuses,
            R.drawable.virtuspro,
            R.drawable.secret,
            R.drawable.teamog
    };

    public int[] teamDPC = {
            525,
            5850,
            10950,
            9300,
            0
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sfLogin = getSharedPreferences("loginData", MODE_PRIVATE);

        if (!firstTry)
        {
            Intent intent = new Intent(getApplicationContext(), TeamDataActivity.class);
            startActivity(intent);
            Intent getData  = getIntent();
            int index = getData.getIntExtra("index", 0);
            String newName = getData.getStringExtra("newName");
            int newDPC = getData.getIntExtra("newDPC", 0);
            String member1 = getData.getStringExtra("member1");
            String member2 = getData.getStringExtra("member2");
            String member3 = getData.getStringExtra("member3");
            String member4 = getData.getStringExtra("member4");
            String member5 = getData.getStringExtra("member5");

            if (newName!=null || !newName.equals(""))
            {
                teamNames[index] = newName;
            }
            if (newDPC!=0)
            {
                teamDPC[index] = newDPC;
            }
            if (member1!=null || !member1.equals(""))
            {
                teamMembers[index][0] = member1;
            }
            if (member2!=null || !member2.equals(""))
            {
                teamMembers[index][1] = member2;
            }
            if (member3!=null || !member3.equals(""))
            {
                teamMembers[index][2] = member3;
            }
            if (member4!=null || !member4.equals(""))
            {
                teamMembers[index][3] = member4;
            }
            if (member5!=null || !member5.equals(""))
            {
                teamMembers[index][4] = member5;
            }
        }
        gridView = findViewById(R.id.gridviewgan);
        gridView.setAdapter(new GridAdapter());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), TeamDataActivity.class);
                intent.putExtra("teamName", teamNames[position]);
                intent.putExtra("teamLogo", teamImages[position]);
                intent.putExtra("teamMember", teamMembers[position]);
                intent.putExtra("teamDPC", teamDPC[position]);
                intent.putExtra("index", position);
                firstTry=false;
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        Boolean isLoggedIn = sfLogin.getBoolean("isLogin", false);
        if (isLoggedIn){
            Intent intent = new Intent(this, EditActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sfLogin.edit();
        editor.clear();
        editor.apply();
    }

    public void doLogin (View view){
        SharedPreferences.Editor editor = sfLogin.edit();
        editor.putString("username", "TeamLIQULIQUID");
        editor.putBoolean("isLogin", true);
        editor.apply();
        Intent intent = new Intent (this, EditActivity.class);
        startActivity(intent);
    }

    private class GridAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return teamNames.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View gridViewData = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView teamName = gridViewData.findViewById(R.id.gridDataTeamName);
            ImageView teamLogo = gridViewData.findViewById(R.id.gridDataTeamLogo);

            teamName.setText(teamNames[position]);
            teamLogo.setImageResource(teamImages[position]);
            return gridViewData;
        }
    }
}
