package com.sunsugar.android.algometer;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LightsActivity extends AppCompatActivity {

    private static final String LOG_TAG = "LightsActivity";

    //public arraylist for solutions made by user
    public ArrayList<String> solution = new ArrayList<>();

    public static int[] images = {R.drawable.ic_radio_button_unchecked_black_24dp,
            R.drawable.ic_radio_button_unchecked_red_24dp};

    //click counter
    public int clicks = 0;

    //String Array for one line of csv file
    public String[] oneLine = {",", ",", ",", ",", ",", ",", ",", ","};

    //String for a line of solution
    public String solLine = "";

    //ImageViews of lights
    @BindView(R.id.light_one)
    public ImageView lightOne;
    @BindView(R.id.light_two)
    public ImageView lightTwo;
    @BindView(R.id.light_three)
    public ImageView lightThree;
    @BindView(R.id.light_four)
    public ImageView lightFour;
    @BindView(R.id.light_five)
    public ImageView lightFive;
    @BindView(R.id.light_six)
    public ImageView lightSix;
    @BindView(R.id.light_seven)
    public ImageView lightSeven;
    @BindView(R.id.light_eight)
    public ImageView lightEight;
    @BindView(R.id.light_nine)
    public ImageView lightNine;
    @BindView(R.id.light_ten)
    public ImageView lightTen;
    @BindView(R.id.light_eleven)
    public ImageView lightEleven;
    @BindView(R.id.light_twelve)
    public ImageView lightTwelve;
    @BindView(R.id.light_thirteen)
    public ImageView lightThirteen;
    @BindView(R.id.light_fourteen)
    public ImageView lightFourteen;
    @BindView(R.id.light_fifteen)
    public ImageView lightFifteen;
    @BindView(R.id.light_sixteen)
    public ImageView lightSixteen;

    //Light objects
    public Light light1;
    public Light light2;
    public Light light3;
    public Light light4;
    public Light light5;
    public Light light6;
    public Light light7;
    public Light light8;
    public Light light9;
    public Light light10;
    public Light light11;
    public Light light12;
    public Light light13;
    public Light light14;
    public Light light15;
    public Light light16;

    //data from MainActivity;

    String name = "";
    int exNum = 0;
    ArrayList<String> exercise = new ArrayList<>();

    //arraylist of timestamps
    ArrayList<Long> timestamps = new ArrayList<>();

    //global handler for images
    int i;
    Handler preHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

                int j = 0;

                if (j < exercise.get(1).length()) {
                    if (exercise.get(i).charAt(j) == '*') {
                        lightOne.setImageResource(images[1]);
                        Log.i("Char at 1:", Character.toString(exercise.get(i).charAt(j)));
                    } else if (exercise.get(i).charAt(j) == '-') {
                        lightOne.setImageResource(images[0]);
                        Log.i("Char at 1:", Character.toString(exercise.get(i).charAt(j)));
                    }
                    j++;
                }

                if (j < exercise.get(1).length() && j > 0) {
                    if (exercise.get(i).charAt(j) == '*') {
                        lightTwo.setImageResource(images[1]);
                        Log.i("Char at 2:", Character.toString(exercise.get(i).charAt(j)));
                    } else if (exercise.get(i).charAt(j) == '-') {
                        lightTwo.setImageResource(images[0]);
                        Log.i("Char at 2:", Character.toString(exercise.get(i).charAt(j)));
                    }
                    j++;
                }

                if (j < exercise.get(1).length() && j > 1) {
                    if (exercise.get(i).charAt(j) == '*') {
                        lightThree.setImageResource(images[1]);
                    } else if (exercise.get(i).charAt(j) == '-') {
                        lightThree.setImageResource(images[0]);
                    }
                    j++;
                }

            if (j < exercise.get(1).length() && j > 2) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightFour.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightFour.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 3) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightFive.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightFive.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 4) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightSix.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightSix.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 5) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightSeven.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightSeven.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 6) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightEight.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightEight.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 7) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightNine.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightNine.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 8) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightTen.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightTen.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 9) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightEleven.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightEleven.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 10) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightTwelve.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightTwelve.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 11) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightThirteen.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightThirteen.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 12) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightFourteen.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightFourteen.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 13) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightFifteen.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightFifteen.setImageResource(images[0]);
                }
                j++;
            }
            if (j < exercise.get(1).length() && j > 14) {
                if (exercise.get(i).charAt(j) == '*') {
                    lightSixteen.setImageResource(images[1]);
                } else if (exercise.get(i).charAt(j) == '-') {
                    lightSixteen.setImageResource(images[0]);
                }
                j++;
            }
            }
       // }
    };

    Handler postHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            final int[] images = {R.drawable.ic_radio_button_unchecked_black_24dp,
                    R.drawable.ic_radio_button_unchecked_red_24dp};
            if(lightOne.getVisibility() == View.VISIBLE){
                lightOne.setImageResource(images[0]);
            }
            if(lightTwo.getVisibility() == View.VISIBLE){
                lightTwo.setImageResource(images[0]);
            }
            if(lightThree.getVisibility() == View.VISIBLE){
                lightThree.setImageResource(images[0]);
            }
            if(lightFour.getVisibility() == View.VISIBLE){
                lightFour.setImageResource(images[0]);
            }
            if(lightFive.getVisibility() == View.VISIBLE){
                lightFive.setImageResource(images[0]);
            }
            if(lightSix.getVisibility() == View.VISIBLE){
                lightSix.setImageResource(images[0]);
            }
            if(lightSeven.getVisibility() == View.VISIBLE){
                lightSeven.setImageResource(images[0]);
            }
            if(lightEight.getVisibility() == View.VISIBLE){
                lightEight.setImageResource(images[0]);
            }
            if(lightNine.getVisibility() == View.VISIBLE){
                lightNine.setImageResource(images[0]);
            }
            if(lightTen.getVisibility() == View.VISIBLE){
                lightTen.setImageResource(images[0]);
            }
            if(lightEleven.getVisibility() == View.VISIBLE){
                lightEleven.setImageResource(images[0]);
            }
            if(lightTwelve.getVisibility() == View.VISIBLE){
                lightTwelve.setImageResource(images[0]);
            }
            if(lightThirteen.getVisibility() == View.VISIBLE){
                lightThirteen.setImageResource(images[0]);
            }
            if(lightFourteen.getVisibility() == View.VISIBLE){
                lightFourteen.setImageResource(images[0]);
            }
            if(lightFifteen.getVisibility() == View.VISIBLE){
                lightFifteen.setImageResource(images[0]);
            }
            if(lightSixteen.getVisibility() == View.VISIBLE){
                lightSixteen.setImageResource(images[0]);
            }
        }
    };

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);
        ButterKnife.bind(this);

        //getting data from intent
        Bundle i = getIntent().getExtras();
        if (i != null) {
            name = i.getString("name");
            exNum = i.getInt("exNum");
            exercise = i.getStringArrayList("exercise");
        }
        // Toast.makeText(this, exercise.get(1), Toast.LENGTH_SHORT).show();

        boolean oneCheck = true;

        //removing the first line of array
        exercise.remove(0);

        //setting the empty string for solution line
        for ( int d = 0; d< exercise.get(1).length(); d++) {
            solLine += "-";
        }

        //setting the circles for lights
        setcircles(exercise);
        lightOne.setOnClickListener(new View.OnClickListener() {
            private boolean oneCheck = true;

            @Override
            public void onClick(View view) {
                oneCheck= clicker(lightOne, 0, oneCheck);
            }
        });

        lightTwo.setOnClickListener(new View.OnClickListener() {
            private boolean twoCheck = true;

            @Override
            public void onClick(View view) {
                twoCheck = clicker(lightTwo, 1, twoCheck);
            }
        });

        lightThree.setOnClickListener(new View.OnClickListener() {
            private boolean threeCheck = true;

            @Override
            public void onClick(View view) {
               threeCheck = clicker(lightThree, 2, threeCheck);
            }
        });

        lightFour.setOnClickListener(new View.OnClickListener() {
            private boolean fourCheck = true;

            @Override
            public void onClick(View view) {
                fourCheck = clicker(lightFour, 3, fourCheck);
            }
        });
        lightFive.setOnClickListener(new View.OnClickListener() {
            private boolean fiveCheck = true;

            @Override
            public void onClick(View view) {
                fiveCheck = clicker(lightFive, 4, fiveCheck);
            }
        });
        lightSix.setOnClickListener(new View.OnClickListener() {
            private boolean sixCheck = true;

            @Override
            public void onClick(View view) {
                sixCheck = clicker(lightSix, 5, sixCheck);
            }
        });
        lightSeven.setOnClickListener(new View.OnClickListener() {
            private boolean sevenCheck = true;

            @Override
            public void onClick(View view) {
                sevenCheck = clicker(lightSeven, 6, sevenCheck);
            }
        });
        lightEight.setOnClickListener(new View.OnClickListener() {
            private boolean eightCheck = true;

            @Override
            public void onClick(View view) {
                eightCheck = clicker(lightEight, 7, eightCheck);
            }
        });
        lightNine.setOnClickListener(new View.OnClickListener() {
            private boolean nineCheck = true;

            @Override
            public void onClick(View view) {
                nineCheck = clicker(lightNine, 8, nineCheck);
            }
        });

        lightTen.setOnClickListener(new View.OnClickListener() {
            private boolean tenCheck = true;

            @Override
            public void onClick(View view) {
                tenCheck = clicker(lightTen, 9, tenCheck);
            }
        });

        lightEleven.setOnClickListener(new View.OnClickListener() {
            private boolean elevenCheck = true;

            @Override
            public void onClick(View view) {
                elevenCheck = clicker(lightEleven, 10, elevenCheck);
            }
        });

        lightTwelve.setOnClickListener(new View.OnClickListener() {
            private boolean twelveCheck = true;

            @Override
            public void onClick(View view) {
                twelveCheck = clicker(lightTwelve, 11, twelveCheck);
            }
        });

        lightThirteen.setOnClickListener(new View.OnClickListener() {
            private boolean thirteenCheck = true;

            @Override
            public void onClick(View view) {
                thirteenCheck = clicker(lightThirteen, 12, thirteenCheck);
            }
        });

        lightFourteen.setOnClickListener(new View.OnClickListener() {
            private boolean fourteenCheck = true;

            @Override
            public void onClick(View view) {
                fourteenCheck = clicker(lightFourteen, 13, fourteenCheck);
            }
        });

        lightFifteen.setOnClickListener(new View.OnClickListener() {
            private boolean fifteenCheck = true;

            @Override
            public void onClick(View view) {
                fifteenCheck = clicker(lightFifteen, 14, fifteenCheck);
            }
        });

        lightSixteen.setOnClickListener(new View.OnClickListener() {
            private boolean sixteenCheck = true;

            @Override
            public void onClick(View view) {
                sixteenCheck = clicker(lightSixteen, 15, sixteenCheck);
            }
        });
    }

    //adding a new line to the global arraylist
        @OnClick(R.id.line_entry_button)
        public void newLineClicked() {
            //Log.i("solline: ", solLine);
            solution.add(solLine);
        }

    //saving data to a csv file
        @OnClick(R.id.final_enter)
        public void finalEntryClicked() {

            if(exercise.size() != solution.size()){
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.not_equal_lines),
                        Toast.LENGTH_SHORT).show();
                if (exercise.size() < solution.size()){
                    solution.clear();
                }
                playOfLights(exercise);
                return;
            }

            //number of mistakes
            int mistakes = solChecker();

            //time spent on one exercise
            timestamps.add(System.currentTimeMillis());
            long fullTime = fullTimeCounter(timestamps);

            //average time between clicks
            long aveTime = aveTimeCounter(timestamps);

            //setting oneLine
            oneLine[0] = name;
            oneLine[1] = String.valueOf(exNum+1);
            oneLine[2] = String.valueOf(exercise.get(0).length());
            oneLine[3] = String.valueOf(exercise.size());
            oneLine[4] = String.valueOf(mistakes);
            oneLine[5] = String.valueOf(clicks);
            oneLine[6] = String.valueOf(fullTime);
            oneLine[7] = String.valueOf(aveTime);
            dataWriter(oneLine);

            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.data_added),Toast.LENGTH_SHORT).show();
        }

//playing the exercise
        @OnClick(R.id.play_button)
        public void playClicked() {
            playOfLights(exercise);
        }

    /**
     * Function to use in OnClickListeners on lights.
      * @param light the ImageView, of which we change the image resource
     * @param serialNr the character position in solution line
     * @param check tells if the light has been on or off
     * @return the changed boolean that tells if the light is currently on or off
     */
    public boolean clicker (ImageView light, int serialNr, boolean check){

        timestamps.add(System.currentTimeMillis());
        Log.i(LOG_TAG, "on/off: " + check);
        if(check){
            light.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
            check = false;
            char[] solLineChars = solLine.toCharArray();
            solLineChars[serialNr] = '*';
            solLine = String.valueOf(solLineChars);
            clicks++;
        } else {
            light.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp);
            check = true;
            char[] solLineChars = solLine.toCharArray();
            solLineChars[serialNr] = '-';
            solLine = String.valueOf(solLineChars);
            clicks++;
        }
        return check;

    }

    //writing data to csv
    public void dataWriter (String[] data){
        //header line
        String[]header={getResources().getString(R.string.csv_name),
                getResources().getString(R.string.csv_exercise_nr),
                getResources().getString(R.string.csv_nr_of_lights),
                getResources().getString(R.string.csv_lines_of_exercise),
                getResources().getString(R.string.csv_mistakes),
                getResources().getString(R.string.csv_clicks),
                getResources().getString(R.string.csv_full_time),
                getResources().getString(R.string.csv_avg_time)};
        //data needed for csvWriter
        String outputName="tests.csv";
        String outputFile=android.os.Environment.getExternalStorageDirectory().getAbsolutePath();

        //check if the file exists
        boolean alreadyExists=new File(outputFile+"/"+outputName).exists();
        try{
        //new filewriter
        FileWriter file=new FileWriter(outputFile+"/"+outputName,true);
        CSVWriter csvOutput=new CSVWriter(file);
        //adding the header
        if(!alreadyExists){
        csvOutput.writeNext(header);
        }
        csvOutput.writeNext(data);
        csvOutput.flush();
        csvOutput.close();
        }catch(IOException error){
        error.printStackTrace();
        }
    }

        //method to play the pattern of lights
    public void playOfLights(final ArrayList<String> exercise) {

        //number of rows including the exercise number
        final int rows = exercise.size();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (i = 0; i < rows; i++) {
                    preHandler.sendEmptyMessage(0);
                    long futureTime = System.currentTimeMillis() + 1000;
                    while (System.currentTimeMillis() < futureTime) {
                        synchronized (this) {
                            try {
                                wait(futureTime - System.currentTimeMillis());
                            } catch (Exception e) {
                                Log.i(LOG_TAG, "Time handling exception");
                            }
                        }
                    }
                    postHandler.sendEmptyMessage(0);
                }
            }
        };

        Thread thread1 = new Thread(r);
        thread1.start();

        }

    //setting the circles for the lights
    public void setcircles(ArrayList<String> exercise){
        //length of a row of pattern
        int length = exercise.get(1).length();

        //setting visibility to the length of the pattern
        /*for (int i = 0; i < length;i++){
            lightList[i] = new Light(viewList[i], i+1);
            viewList[i].setVisibility(View.VISIBLE);
        }*/
        switch(length){
            case 2:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                break;
            case 3:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                break;
            case 4:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                break;
            case 5:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                break;
            case 6:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                break;
            case 7:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                light7 = new Light(lightSeven, 7);
                break;
            case 8:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                light7 = new Light(lightSeven, 7);
                light8 = new Light(lightEight, 8);
                break;
            case 9:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                light7 = new Light(lightSeven, 7);
                light8 = new Light(lightEight, 8);
                light9 = new Light(lightNine, 9);
                break;
            case 10:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                light7 = new Light(lightSeven, 7);
                light8 = new Light(lightEight, 8);
                light9 = new Light(lightNine, 9);
                light10 = new Light(lightTen, 10);
                break;
            case 11:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                light7 = new Light(lightSeven, 7);
                light8 = new Light(lightEight, 8);
                light9 = new Light(lightNine, 9);
                light10 = new Light(lightTen, 10);
                light11 = new Light(lightEleven, 11);
                break;
            case 12:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                light7 = new Light(lightSeven, 7);
                light8 = new Light(lightEight, 8);
                light9 = new Light(lightNine, 9);
                light10 = new Light(lightTen, 10);
                light11 = new Light(lightEleven, 11);
                light12 = new Light(lightTwelve, 12);
                break;
            case 13:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                light7 = new Light(lightSeven, 7);
                light8 = new Light(lightEight, 8);
                light9 = new Light(lightNine, 9);
                light10 = new Light(lightTen, 10);
                light11 = new Light(lightEleven, 11);
                light12 = new Light(lightTwelve, 12);
                light13 = new Light(lightThirteen, 13);
                break;
            case 14:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                light7 = new Light(lightSeven, 7);
                light8 = new Light(lightEight, 8);
                light9 = new Light(lightNine, 9);
                light10 = new Light(lightTen, 10);
                light11 = new Light(lightEleven, 11);
                light12 = new Light(lightTwelve, 12);
                light13 = new Light(lightThirteen, 13);
                light14 = new Light(lightFourteen, 14);
                break;
            case 15:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                light7 = new Light(lightSeven, 7);
                light8 = new Light(lightEight, 8);
                light9 = new Light(lightNine, 9);
                light10 = new Light(lightTen, 10);
                light11 = new Light(lightEleven, 11);
                light12 = new Light(lightTwelve, 12);
                light13 = new Light(lightThirteen, 13);
                light14 = new Light(lightFourteen, 14);
                light15 = new Light(lightFifteen, 15);
                break;
            case 16:
                light1 = new Light(lightOne, 1);
                light2 = new Light(lightTwo, 2);
                light3 = new Light(lightThree, 3);
                light4 = new Light(lightFour, 4);
                light5 = new Light(lightFive, 5);
                light6 = new Light(lightSix, 6);
                light7 = new Light(lightSeven, 7);
                light8 = new Light(lightEight, 8);
                light9 = new Light(lightNine, 9);
                light10 = new Light(lightTen, 10);
                light11 = new Light(lightEleven, 11);
                light12 = new Light(lightTwelve, 12);
                light13 = new Light(lightThirteen, 13);
                light14 = new Light(lightFourteen, 14);
                light15 = new Light(lightFifteen, 15);
                light16 = new Light(lightSixteen, 16);
                break;
        }
    }

    //method to check how many mistakes were made
    public int solChecker(){
        //for cycles to check character matches
        int rows = exercise.size();
        int length = exercise.get(1).length();
        int mistakeNr=0;

        for (int a = 0; a < rows; a++){
            for (int b = 0; b < length; b++){
                if (exercise.get(a).charAt(b) != solution.get(a).charAt(b)){
                    mistakeNr++;
                }
            }
        }
        Log.i("solution:", solution.get(0)+"\n"+solution.get(1)+"\n");

        return mistakeNr;
    }

    public long fullTimeCounter (ArrayList<Long> timestamps){
        //long fullTime = ;
        return timestamps.get(timestamps.size()-1)-timestamps.get(0);
    }

    public long aveTimeCounter (ArrayList<Long> timestamps){
        int size = timestamps.size();
        long sum = 0;
        long average;
        for(int t = 1; t < size; t++){
           sum += timestamps.get(t)-timestamps.get(t-1);
        }
        average = sum/size;
        return average;

    }

}



