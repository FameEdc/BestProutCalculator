package fr.wildcodeschool.apprenti.bestproutcalculator;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private EditText editLat;
    private EditText editLong;
    private Button submit;

    private String temp_key, lat, lon, smell;
    private DatabaseReference rootCoords = FirebaseDatabase.getInstance().getReference().child("coordonnées");
    private DatabaseReference rootCoord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button)findViewById(R.id.btnSubmit) ;
        editLat = (EditText) findViewById(R.id.editLat);
        editLong = (EditText) findViewById(R.id.editLong);

        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar3Smell);
        final TextView date_Text = (TextView)findViewById(R.id.date_text);
        final TextView seekBarValue = (TextView)findViewById(R.id.value_seekbar);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat = editLat.getText().toString();
                lon = editLong.getText().toString();
                smell = seekBarValue.getText().toString();
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                date_Text.setText(date);

                Map<String, Object> map = new HashMap<String, Object>();
                temp_key = rootCoords.push().getKey().toString();
                rootCoords.updateChildren(map);

                Coordinates mesCoords = new Coordinates(lat, lon, smell, date);
                rootCoord = rootCoords.child(temp_key);
                rootCoord.setValue(mesCoords);

            }
        });

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    // TODO Auto-generated method stub
                    seekBarValue.setText(String.valueOf(progress));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub
                }
            });

        }

    }