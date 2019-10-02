package com.creativestoreid.arf.holidayinsukabumi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Holiday> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_holiday);
        rvHeroes.setHasFixedSize(true);

        list.addAll(HolidayData.getListData());
        showRecycleList();
    }

    private void showRecycleList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        final ListHolidayAdapter listHolidayAdapter = new ListHolidayAdapter(list);
        rvHeroes.setAdapter(listHolidayAdapter);

        listHolidayAdapter.setOnItemClickCallback(new ListHolidayAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Holiday data) {
                showSelectedHoliday(data);
            }
        });
    }

    //Menu About
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId){
            case R.id.action_about:
                Intent intent = new Intent(this, AboutProfile.class);
                startActivity(intent);
                break;
        }
    }

    private void showSelectedHoliday(Holiday holiday){
        Intent intent = new Intent(this, DetailHoliday.class);
        intent.putExtra("AmbilPhoto", holiday.getPhoto());
        intent.putExtra("AmbilLokasi", holiday.getFrom());
        intent.putExtra("AmbilNama", holiday.getName());
        intent.putExtra("AmbilDeskripsi", holiday.getDeskripsi());
        intent.putExtra("AmbilJam", holiday.getJambuka());
        intent.putExtra("AmbilHarga", holiday.getHargatiket());
        intent.putExtra("AmbilFasilitas", holiday.getFasilitas());
        startActivity(intent);
    }

}