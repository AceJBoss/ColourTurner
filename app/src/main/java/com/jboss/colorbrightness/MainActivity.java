package com.jboss.colorbrightness;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the widgets reference from XML layout
        final LinearLayout ll = (LinearLayout) findViewById(R.id.screen);
        final MaterialButton btn = (MaterialButton) findViewById(R.id.btnColorSelection);
        final EditText textInterval = (EditText) findViewById(R.id.txtInterval);
        textInterval.setBackgroundColor(Color.parseColor("#ffffff"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ColorPicker colorPicker = new ColorPicker(MainActivity.this);
                colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position,int color) {
                        // put code
                        //Log.d("Happening", color+"");
                        //ll.setBackgroundColor(position);
                    }

                    @Override
                    public void onCancel(){
                        // put code
                    }
                })
                        .addListenerButton("Proceed >>>", new ColorPicker.OnButtonListener() {
                            @Override
                            public void onClick(View v, int position, int color) {
                                // put code
                                ll.setBackgroundColor(color);
                                colorPicker.dismissDialog();
                                btn.setVisibility(View.INVISIBLE);
                                textInterval.setVisibility(View.INVISIBLE);

                                //Toast.makeText(MainActivity.this,position + "HIIIII",Toast.LENGTH_SHORT);
                            }
                        })
                        .disableDefaultButtons(true)
                        .setColumns(5)
                        .show();
            }
        });
    }
}
