package com.jboss.colorbrightness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private int stateCount = 0;
    private ArrayList<Integer> colors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        // Get the widgets reference from XML layout
        final LinearLayout screen = (LinearLayout) findViewById(R.id.screen);
        final MaterialButton btn = (MaterialButton) findViewById(R.id.btnColorSelection);
        final ImageView im = (ImageView)findViewById(R.id.add_btn);
        final EditText textInterval = (EditText) findViewById(R.id.txtInterval);
        final ImageView err1 = (ImageView)findViewById(R.id.c1);
        final ImageView err2 = (ImageView)findViewById(R.id.c2);
        final ImageView err3 = (ImageView)findViewById(R.id.c3);
        final ImageView err4 = (ImageView)findViewById(R.id.c4);
        final ImageView err5 = (ImageView)findViewById(R.id.c5);
        textInterval.setBackgroundColor(Color.parseColor("#ffffff"));

        final CardView card1 = (CardView)findViewById(R.id.cl1);
        final CardView card2 = (CardView)findViewById(R.id.cl2);
        final CardView card3 = (CardView)findViewById(R.id.cl3);
        final CardView card4 = (CardView)findViewById(R.id.cl4);
        final CardView card5 = (CardView)findViewById(R.id.cl5);

        card1.setVisibility(View.INVISIBLE); err1.setVisibility(View.INVISIBLE);
        card2.setVisibility(View.INVISIBLE); err2.setVisibility(View.INVISIBLE);
        card3.setVisibility(View.INVISIBLE); err3.setVisibility(View.INVISIBLE);
        card4.setVisibility(View.INVISIBLE); err4.setVisibility(View.INVISIBLE);
        card5.setVisibility(View.INVISIBLE); err5.setVisibility(View.INVISIBLE);
        textInterval.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if (counter < 6) {
                final ColorPicker colorPicker = new ColorPicker(MainActivity.this);
                colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                        // put code
                        Log.e("Happening why", color + "");
                        //ll.setBackgroundColor(position);
                    }

                    @Override
                    public void onCancel() {
                        // put code
                    }
                })
                        .addListenerButton("PREVIEW", new ColorPicker.OnButtonListener() {
                            @Override
                            public void onClick(View v, int position, int color) {
                                // put code
                                if (counter == 1) {
                                    card1.setVisibility(View.VISIBLE);
                                    err1.setVisibility(View.VISIBLE);
                                    card1.setCardBackgroundColor(color);
                                    colors.add(color);
                                    colorPicker.dismissDialog();
                                }
                                if (counter == 2) {
                                    card2.setVisibility(View.VISIBLE);
                                    err2.setVisibility(View.VISIBLE);
                                    card2.setCardBackgroundColor(color);
                                    colors.add(color);
                                    colorPicker.dismissDialog();
                                }
                                if (counter == 3) {
                                    card3.setVisibility(View.VISIBLE);
                                    err3.setVisibility(View.VISIBLE);
                                    card3.setCardBackgroundColor(color);
                                    colors.add(color);
                                    colorPicker.dismissDialog();
                                }
                                if (counter == 4) {
                                    card4.setVisibility(View.VISIBLE);
                                    err4.setVisibility(View.VISIBLE);
                                    card4.setCardBackgroundColor(color);
                                    colors.add(color);
                                    colorPicker.dismissDialog();
                                }
                                if (counter == 5) {
                                    card5.setVisibility(View.VISIBLE);
                                    err5.setVisibility(View.VISIBLE);
                                    card5.setCardBackgroundColor(color);
                                    colors.add(color);
                                    colorPicker.dismissDialog();
                                }
                                if (counter >= 1) {
                                    textInterval.setVisibility(View.VISIBLE);
                                    btn.setVisibility(View.VISIBLE);
                                }
                                //Toast.makeText(MainActivity.this,position + "HIIIII",Toast.LENGTH_SHORT);
                            }
                        })
                        .disableDefaultButtons(true)
                        .setColumns(5)
                        .show();
            }else{

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    // Setting Alert Dialog Title
                    alertDialogBuilder.setTitle("Error Update!");
                    alertDialogBuilder.setIcon(R.drawable.info);
                    // Setting Alert Dialog Message
                    alertDialogBuilder.setMessage("Hey, you have exceeded the limit of color you can choose");
                    alertDialogBuilder.setCancelable(false);

                    alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                }
            }
        });
        err1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card1.setVisibility(View.INVISIBLE);
                colors.remove(0);
            }
            });
        err2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card2.setVisibility(View.INVISIBLE);
                colors.remove(1);
            }
        });
        err3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card3.setVisibility(View.INVISIBLE);
                colors.remove(2);
            }
        });
        err4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card4.setVisibility(View.INVISIBLE);
                colors.remove(3);
            }
        });
        err5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card5.setVisibility(View.INVISIBLE);
                colors.remove(4);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valSupplied = Integer.parseInt(textInterval.getText().toString());
                final int total_seconds = 1000 * valSupplied;
                btn.setVisibility(View.INVISIBLE);
                im.setVisibility(View.INVISIBLE);
                textInterval.setVisibility(View.INVISIBLE);
                card1.setVisibility(View.INVISIBLE);
                err1.setVisibility(View.INVISIBLE);
                card2.setVisibility(View.INVISIBLE);
                err2.setVisibility(View.INVISIBLE);
                card3.setVisibility(View.INVISIBLE);
                err3.setVisibility(View.INVISIBLE);
                card4.setVisibility(View.INVISIBLE);
                err4.setVisibility(View.INVISIBLE);
                card5.setVisibility(View.INVISIBLE);
                err5.setVisibility(View.INVISIBLE);

               /* ArrayList<String> cols = new ArrayList<>();
                cols.add("#82B926");
                cols.add("#a276eb");
                cols.add("#6a3ab2");
                cols.add("#666666");
                cols.add("#FFFF00");
                cols.add("#3C8D2F");*/

                Log.e("Total Size", colors.size()+"");
                new Thread(new Runnable() {
                    public void run() {
                        while (stateCount < colors.size()) {
                            try {
                                Log.e("Color @ " + stateCount, colors.get(stateCount)+"");
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        screen.setBackgroundColor(colors.get(stateCount));
                                    }
                                });
                                Thread.sleep(total_seconds);
                            } catch (Exception e) {
                                Log.e("Latest", e + "");
                            }
                            stateCount = stateCount + 1;
                        }
                        finish();
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }).start();
            }


            // Check to know the visible cards
                /*if(card1.getVisibility() == View.VISIBLE){

                }
                if(card2.getVisibility() == View.VISIBLE){

                }
                if(card3.getVisibility() == View.VISIBLE){

                }
                if(card4.getVisibility() == View.VISIBLE){

                }
                if(card5.getVisibility() == View.VISIBLE){

                }*/
        });
    }
}
