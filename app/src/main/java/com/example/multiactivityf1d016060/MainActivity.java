package com.example.multiactivityf1d016060;

import android.content.Intent;
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

    GridView gridView;

    private String[] teamNames = {
            "Team Liquid",
            "Evil Geniuses",
            "Virtus Pro",
            "Team Secret",
            "Team OG"
    };

    private String[][] teamMembers = {
            {"Matumbaman", "Miracle-", "MinD_ContRoL", "GH", "KuroKy"},
            {"Arteezy", "SumaiL", "s4", "Cr1t-", "Fly"},
            {"RAMZES666", "No[o]ne", "9pasha", "RodjER", "Solo"},
            {"Nisha", "MidOne", "zai", "YapzOr", "Puppey"},
            {"ana", "Tompson", "7ckngMad", "JerAx", "N0tail"}
    };

    private int[] teamImages = {
            R.drawable.liquid,
            R.drawable.evilgeniuses,
            R.drawable.virtuspro,
            R.drawable.secret,
            R.drawable.teamog
    };

    private int[] teamDPC = {
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
                startActivity(intent);
            }
        });

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
