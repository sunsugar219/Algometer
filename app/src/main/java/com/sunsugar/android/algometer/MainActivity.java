package com.sunsugar.android.algometer;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Spinner secSpinner;
    public ArrayList<String> exNames = new ArrayList<>();
    public ArrayList<String[]> exercises = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = findViewById(R.id.name_field);

        //getting the list of exercise numbers
        exNames = readPatterns();
        exercises = makeExercises();
        addItemsOnSecSpinner();

        Button okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LightsActivity.class);
                String nameString = name.getText().toString();
                int pos = secSpinner.getSelectedItemPosition();
                ArrayList<String> exercisesList = new ArrayList<String>(Arrays.asList(exercises.get(pos)));

                i.putExtra("name", nameString);
                i.putExtra("exNum", pos);
                i.putStringArrayListExtra("exercise", exercisesList);
                //Log.i("1st line of pattern: ", exercisesList.get(1));
                startActivity(i);
            }
        });

        //for debugging
       /* TextView testText = (TextView)findViewById(R.id.test_text);
        StringBuilder builder = new StringBuilder();
        ArrayList<String[]> exerciseList = makeExercises();
        for (String s : exerciseList.get(0)){
            builder.append(s);
        }
        String testStr = builder.toString();
        testText.setText(exerciseList.get(0)[2]);*/

        /*//to check exNames
        StringBuilder builder = new StringBuilder();
        for (String s : exNames){
            builder.append(s);
            builder.append("\t");
        }
        testText.setText(builder.toString());*/
        String[] spinnerArray = getResources().getStringArray(R.array.spinner_nums);
        List<String> spinnerList = new ArrayList<String>();
        spinnerList = Arrays.asList(spinnerArray);
        ArrayList<String> listSpin = new ArrayList<String>(spinnerList);
        for (int j = 1; j < exNames.size(); j++){
            listSpin.add(exNames.get(j));
        }
        spinnerArray = listSpin.toArray(new String[spinnerList.size()]);
    }



    //reading minta.txt and giving back the exercise numbers for the spinner
    public ArrayList<String> readPatterns(){

        ArrayList<String[]> exerciseList = makeExercises();


        //arraylist for exercise names
        ArrayList<String> exNames = new ArrayList<>();

        for (int i = 0; i < exerciseList.size(); i++) {

            exNames.add(exerciseList.get(i)[0]);
        }

        return exNames;
    }

    //adding items to spinner dynamically and setting an itemSelectedListener
    public void addItemsOnSecSpinner(){
        secSpinner = (Spinner) findViewById(R.id.sec_spinner);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, exNames);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        secSpinner.setAdapter(spinnerAdapter);}

    //reading minta.txt and splitting it into exercises
    public ArrayList<String[]> makeExercises() {
        //filepath on sdcard
        File path = Environment.getExternalStorageDirectory();

        //getting the text file minta.txt
        File patterns = new File(path, "minta.txt");

        //reading text from patterns
        StringBuilder text = new StringBuilder();
        String line;

        if(patterns.exists()){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(patterns));

                while ((line = reader.readLine()) != null) {
                    text.append(line);
                    text.append('\n');
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            InputStream inputStream = getResources().openRawResource(R.raw.minta);
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputReader);
            try {
                while ((line = reader.readLine()) != null) {
                    Log.i("in else clause", "else made it till here");
                    text.append(line);
                    text.append('\n');
                    Log.i("read text", text.toString());

                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //making a String[] of the patterns/exercises
        Log.i("read text", text.toString());
        String exStr = text.toString();
        String[] exercises = exStr.split("Ex ");
        //array for exercises
        ArrayList<String[]> exerciseList = new ArrayList<>();

        for (int i = 1; i < exercises.length; i++) {
            exerciseList.add(exercises[i].split("\n"));
        }

        return exerciseList;
    }

}
