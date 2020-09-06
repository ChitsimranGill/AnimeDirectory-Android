package com.example.animedirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView Animes;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Anime> Animes = initAnimes();

        this.Animes = (RecyclerView) findViewById(R.id.animes);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.Animes.setLayoutManager(mLayoutManager);

        adapter = new AnimeAdapter(Animes);
        this.Animes.setAdapter(adapter);
    }

    private ArrayList<Anime> initAnimes() {
        ArrayList<Anime> list = new ArrayList<>();

        list.add(new Anime("One Piece","https://cdn.myanimelist.net/images/anime/6/73245.jpg"));
        list.add(new Anime("Hunter x Hunter",  "https://cdn.myanimelist.net/images/anime/11/33657.jpg"));
        list.add(new Anime("Haikyuu!!",  "https://cdn.myanimelist.net/images/anime/7/76014.jpg"));
        list.add(new Anime("Kimi no na wa", "https://cdn.myanimelist.net/images/anime/5/87048.jpg"));
        list.add(new Anime("Boku no hero academia", "https://cdn.myanimelist.net/images/anime/10/78745.jpg"));
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            sendDelete();
            return true;
        }
        if (id == R.id.action_information) {
            sendInformation();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendInformation() {
        Intent intent = new Intent(MainActivity.this, activity_information.class);
        startActivity(intent);
    }

    public void sendDelete() {
        Intent del = new Intent(Intent.ACTION_DELETE);
        Uri packageName = Uri.parse("package:"+ "com.example.animedirectory");
        del.setData(packageName);
        startActivity(del);
    }
}
