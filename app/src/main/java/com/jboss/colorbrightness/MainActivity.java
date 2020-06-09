package com.jboss.colorbrightness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.core.graphics.ColorUtils;

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
    private int steadyCount = 0;
    private int blinkCount = 0;
    private String finalOperation = "";
    private ArrayList<Integer> colors = new ArrayList<>();

    private LinearLayout screen;
    private MaterialButton btn;
    private Button steady, blink;
    private ImageView im, err1, err2, err3, err4, err5;
    private CardView card1, card2, card3, card4, card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        // Get the widgets reference from XML layout
        screen = (LinearLayout) findViewById(R.id.screen);
        btn = (MaterialButton) findViewById(R.id.btnColorSelection);
        steady = (Button) findViewById(R.id.steady);
        blink = (Button) findViewById(R.id.blink);
        im = (ImageView) findViewById(R.id.add_btn);
        err1 = (ImageView) findViewById(R.id.c1);
        err2 = (ImageView) findViewById(R.id.c2);
        err3 = (ImageView) findViewById(R.id.c3);
        err4 = (ImageView) findViewById(R.id.c4);
        err5 = (ImageView) findViewById(R.id.c5);

        card1 = (CardView) findViewById(R.id.cl1);
        card2 = (CardView) findViewById(R.id.cl2);
        card3 = (CardView) findViewById(R.id.cl3);
        card4 = (CardView) findViewById(R.id.cl4);
        card5 = (CardView) findViewById(R.id.cl5);

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
        btn.setVisibility(View.INVISIBLE);
        im.setVisibility(View.INVISIBLE);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                steady.setVisibility(View.INVISIBLE);
                blink.setVisibility(View.INVISIBLE);
                if (finalOperation.equals("steady")) {
                    if (counter < 6) {
                        final ColorPicker colorPicker = new ColorPicker(MainActivity.this);
                        ArrayList<String> cols = new ArrayList<>();
                        cols.add("#00FFFF");
                        cols.add("#000000");
                        cols.add("#0000FF");
                        cols.add("#FF00FF");
                        cols.add("#808080");
                        cols.add("#008000");
                        cols.add("#00FF00");
                        cols.add("#800000");
                        cols.add("#000080");
                        cols.add("#808000");
                        cols.add("#800080");
                        cols.add("#FF0000");
                        cols.add("#008080");
                        cols.add("#FFFF00");
                        cols.add("#FFFFFF");
                        colorPicker.setColors(cols);
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
                                            steady.setVisibility(View.INVISIBLE);
                                            blink.setVisibility(View.INVISIBLE);
                                            btn.setVisibility(View.VISIBLE);
                                        }
                                        //Toast.makeText(MainActivity.this,position + "HIIIII",Toast.LENGTH_SHORT);
                                    }
                                })
                                .disableDefaultButtons(true)
                                .setColumns(5)
                                .show();
                    } else {

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
                if (finalOperation.equals("blink")) {
                    if (counter < 2) {
                        final ColorPicker colorPicker = new ColorPicker(MainActivity.this);
                        ArrayList<String> cols = new ArrayList<>();
                        cols.add("#00FFFF");
                        cols.add("#000000");
                        cols.add("#0000FF");
                        cols.add("#FF00FF");
                        cols.add("#808080");
                        cols.add("#008000");
                        cols.add("#00FF00");
                        cols.add("#800000");
                        cols.add("#000080");
                        cols.add("#808000");
                        cols.add("#800080");
                        cols.add("#FF0000");
                        cols.add("#008080");
                        cols.add("#FFFF00");
                        cols.add("#FFFFFF");
                        colorPicker.setColors(cols);
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
                                            steady.setVisibility(View.INVISIBLE);
                                            blink.setVisibility(View.INVISIBLE);
                                            btn.setVisibility(View.VISIBLE);
                                        }
                                        //Toast.makeText(MainActivity.this,position + "HIIIII",Toast.LENGTH_SHORT);
                                    }
                                })
                                .disableDefaultButtons(true)
                                .setColumns(5)
                                .show();
                    } else {

                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                        // Setting Alert Dialog Title
                        alertDialogBuilder.setTitle("Error Update!");
                        alertDialogBuilder.setIcon(R.drawable.info);
                        // Setting Alert Dialog Message
                        alertDialogBuilder.setMessage("Hey, you can only select one color for blink option");
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

        steady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                steadyCount++;
                im.setVisibility(View.VISIBLE);
                finalOperation = "steady";

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                // Setting Alert Dialog Title
                alertDialogBuilder.setTitle("Option Update!");
                alertDialogBuilder.setIcon(R.drawable.info);
                // Setting Alert Dialog Message
                alertDialogBuilder.setMessage("Hey, you have selected STEADY option, click OK and hit the icon at the upper right to continue");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                //steady.setEnabled(false);
            }
        });

        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blinkCount++;
                im.setVisibility(View.VISIBLE);
                finalOperation = "blink";
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                // Setting Alert Dialog Title
                alertDialogBuilder.setTitle("Option Update!");
                alertDialogBuilder.setIcon(R.drawable.info);
                // Setting Alert Dialog Message
                alertDialogBuilder.setMessage("Hey, you have selected BLINK option, click OK and hit the icon at the upper right to continue");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                //blink.setEnabled(false);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Operation", finalOperation);
                btn.setVisibility(View.INVISIBLE);
                steady.setVisibility(View.INVISIBLE);
                blink.setVisibility(View.INVISIBLE);
                im.setVisibility(View.INVISIBLE);
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

                Log.e("Total Size", colors.size() + "");

                if (finalOperation.equals("steady")) {
                    new Thread(new Runnable() {
                        public void run() {
                            while (stateCount < colors.size()) {
                                try {
                                    Log.e("Color @ " + stateCount, colors.get(stateCount) + "");
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            screen.setBackgroundColor(colors.get(stateCount));
                                        }
                                    });
                                    Thread.sleep(2000);
                                } catch (Exception e) {
                                    Log.e("Latest", e + "");
                                }
                                stateCount = stateCount + 1;
                                if (stateCount == colors.size()) {
                                    stateCount = 0;
                                }
                            }
                        }
                    }).start();
                } else if (finalOperation.equals("blink")) {

                    btn.setVisibility(View.INVISIBLE);
                    steady.setVisibility(View.INVISIBLE);
                    blink.setVisibility(View.INVISIBLE);
                    im.setVisibility(View.INVISIBLE);
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

                    ObjectAnimator a = ObjectAnimator.ofInt(screen, "backgroundColor", colors.get(stateCount));
                    a.setInterpolator(new LinearInterpolator());
                    a.setDuration(300);
                    a.setRepeatCount(ValueAnimator.INFINITE);
                    a.setRepeatMode(ValueAnimator.REVERSE);
                    a.setEvaluator(new ArgbEvaluator());
                    AnimatorSet t = new AnimatorSet();
                    t.play(a);
                    t.start();

//                    Animation anim = new AlphaAnimation(0.0f, 1.0f);
//                    anim.setDuration(50); //You can manage the blinking time with this parameter
//                    anim.setStartOffset(20);
//                    anim.setRepeatMode(Animation.REVERSE);
//                    anim.setRepeatCount(Animation.INFINITE);
//                    screen.setBackgroundColor(colors.get(stateCount));
//                    screen.startAnimation(anim);
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onBackPressed() {
        finish();
        if (steady.getVisibility() == View.VISIBLE && blink.getVisibility() == View.VISIBLE) {
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
        }
        if (steady.getVisibility() == View.INVISIBLE && blink.getVisibility() == View.INVISIBLE) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
