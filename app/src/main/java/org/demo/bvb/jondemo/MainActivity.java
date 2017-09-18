package org.demo.bvb.jondemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buildButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "Action Settings (TBD)", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuAbout:
//TODO get version number from the default configuration
                Toast.makeText(this, "Bingham Rare Book Links v1.0.2", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuLinks:
                String linksUrl = "https://sheets.googleapis.com/v4/spreadsheets/1zBzeYQ7ytMGNC4bSy33Gojcnihj6eYsTgpoYN0FWlHM/values/A1:B4";
                Uri uri = Uri.parse(linksUrl);
                Intent intent = new Intent(ACTION_VIEW, uri);
                startActivity(intent);
//                Toast.makeText(this, linksUrl,Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }

    private void buildButtons() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Feedback (TBD)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Button btnRareBooks = (Button) findViewById(R.id.btnLink01);
        btnRareBooks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnRareBooks");
                Uri uri = Uri.parse("http://lib.utah.edu/collections/rarebooks/");
                Intent intent = new Intent(ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        final Button btnOpenBooks = (Button) findViewById(R.id.btnLink02);
        btnOpenBooks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnOpenBooks");
                Uri uri = Uri.parse("https://openbook.lib.utah.edu/");
                Intent intent = new Intent(ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        final Button btnExhibitions = (Button) findViewById(R.id.btnLink03);
        btnExhibitions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnExhibitions");
                Uri uri = Uri.parse("http://lib.utah.edu/collections/rarebooks/exhibits/past/index.php/");
                Intent intent = new Intent(ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        final Button btnCollections = (Button) findViewById(R.id.btnLink04);
        btnCollections.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnCollections");
                Uri uri = Uri.parse("http://cdmbuntu.lib.utah.edu/cdm/az?page=90/");
                Intent intent = new Intent(ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}
