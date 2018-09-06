package com.olehmesh.nyt_tasktest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.olehmesh.nyt_tasktest.database.App;
import com.olehmesh.nyt_tasktest.database.DaoMethods;
import com.olehmesh.nyt_tasktest.models.EntityDatabase;
import com.olehmesh.nyt_tasktest.database.DatabaseManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.date)
    TextView date;

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        ButterKnife.bind(this);

        title.setText(getIntent().getStringExtra(String.valueOf(R.string.TITLE)));
        date.setText(getIntent().getStringExtra(String.valueOf(R.string.DATE)));
        text.setText(getIntent().getStringExtra(String.valueOf(R.string.DESCRIPTION)));

        }

    @OnClick(R.id.button)
    void onButtonClick() {

        DatabaseManager db = App.getInstance().getDatabase();
        DaoMethods daoMethods = db.daoMethods();

        EntityDatabase entityDatabase = new EntityDatabase();

        entityDatabase.setTitle(title.getText().toString());
        entityDatabase.setDate(date.getText().toString());
        entityDatabase.setDescription(text.getText().toString());

        daoMethods.insert(entityDatabase);

        Toast.makeText(getApplicationContext(), "Successfully added", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorites_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
                startActivity(new Intent(this, SavedActivity.class));
                break;
            }
        }
        return false;
    }

    }