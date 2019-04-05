package com.example.assignment10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPlanetActivity extends AppCompatActivity {
    public static final String EXTRA_PANETNAME= "css.edu.planetname";
    public static final String EXTRA_PANETGRAVITY= "css.edu.planetgravity";
    private EditText mEditPlanetNameView;
    private EditText mEditPlanetGravityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        mEditPlanetNameView = findViewById(R.id.editTextPlanetName);
        mEditPlanetGravityView = findViewById(R.id.editTextPlanetGravity);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditPlanetNameView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String planetName = mEditPlanetNameView.getText().toString();
                    String gravity = mEditPlanetGravityView.getText().toString();
                    replyIntent.putExtra(EXTRA_PANETNAME, planetName);
                    replyIntent.putExtra(EXTRA_PANETGRAVITY, gravity);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }}
