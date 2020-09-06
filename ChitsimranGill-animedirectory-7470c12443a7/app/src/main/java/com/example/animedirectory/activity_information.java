package com.example.animedirectory;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class activity_information extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        this.button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String num = "tel:2095979164";
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse(num));
                startActivity(call);
            }
        });
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
