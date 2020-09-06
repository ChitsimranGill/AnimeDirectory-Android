package com.example.animedirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class activity_anime_detail extends AppCompatActivity {

    private ImageView bigImage;
    private TextView title;
    private TextView details;
    ArrayList<String> detls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);
        this.bigImage = (ImageView) findViewById(R.id.bigImage);
        this.title = (TextView) findViewById(R.id.title);
        this.details = (TextView) findViewById(R.id.details);
        ArrayList<Anime> Animes = initAnimes();
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("name");
        String url = "";

        detls.add("Gol D. Roger, a man referred to as the \"Pirate King,\" is set to be executed by the World Government. But just before his demise, he confirms the existence of a great treasure, One Piece, located somewhere within the vast ocean known as the Grand Line. Announcing that One Piece can be claimed by anyone worthy enough to reach it, the Pirate King is executed and the Great Age of Pirates begins.\n" +
                "\n" +
                "Twenty-two years later, a young man by the name of Monkey D. Luffy is ready to embark on his own adventure, searching for One Piece and striving to become the new Pirate King. Armed with just a straw hat, a small boat, and an elastic body, he sets out on a fantastic journey to gather his own crew and a worthy ship.");
        detls.add("Hunter x Hunter is set in a world where Hunters exist to perform all manner of dangerous tasks like capturing criminals and bravely searching for lost treasures in uncharted territories. Twelve-year-old Gon Freecss is determined to become the best Hunter possible in hopes of finding his father, who was a Hunter himself and had long ago abandoned his young son. However, Gon soon realizes the path to achieving his goals is far more challenging than he could have ever imagined.");
        detls.add("Inspired after watching a volleyball ace nicknamed \"Little Giant\" in action, small-statured Shouyou Hinata revives the volleyball club at his middle school. The newly-formed team even makes it to a tournament; however, their first match turns out to be their last when they are brutally squashed by the \"King of the Court,\" Tobio Kageyama. Hinata vows to surpass Kageyama, and so after graduating from middle school, he joins Karasuno High School's volleyball team—only to find that his sworn rival, Kageyama, is now his teammate.");
        detls.add("Mitsuha Miyamizu, a high school girl, yearns to live the life of a boy in the bustling city of Tokyo—a dream that stands in stark contrast to her present life in the countryside. Meanwhile in the city, Taki Tachibana lives a busy life as a high school student while juggling his part-time job and hopes for a future in architecture.\n" +
                "\n" +
                "One day, Mitsuha awakens in a room that is not her own and suddenly finds herself living the dream life in Tokyo—but in Taki's body! Elsewhere, Taki finds himself living Mitsuha's life in the humble countryside. In pursuit of an answer to this strange phenomenon, they begin to search for one another.");
        detls.add("\n" +
                "My Hero Academia (僕ぼくのヒーローアカデミア Boku no Hīrō Akademia?) is a Manga series serialized by Shonen Jump and written by Kohei Horikoshi. The series has been adapted into an Anime series and an Anime Movie, as well as spawning the Spinoff series My Hero Academia Vigilantes.\n" +
                "The story is set in the modern-day, except people with special powers called \"Quirks\" have become commonplace throughout the world. In a world of chaos and confusion, Pro Heroes have now risen as the new profession to fight off powerful super villains.");
        int count = 0;
        for(Anime a: Animes)
        {
            if(a.getName().equals(message))
            {
                url = a.getImageURL();
                break;
            }
            count++;
        }
        Picasso.get().load(url).into(bigImage);
        title.setText(message);
        details.setText(detls.get(count));
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
        Intent intent = new Intent(this, activity_information.class);
        startActivity(intent);
    }

    public void sendDelete() {
        Intent del = new Intent(Intent.ACTION_DELETE);
        Uri packageName = Uri.parse("package:"+ "com.example.animedirectory");
        del.setData(packageName);
        startActivity(del);
    }



}
