package com.tamimquiz.android.moroccoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the reset button is clicked.
     */
    public void DoItAgain(View view) {

        EditText Name = (EditText) findViewById(R.id.name);
        Name.setText(null);

        EditText Continent = (EditText) findViewById(R.id.continent);
        Continent.setText(null);

        RadioGroup CapitalGroup = (RadioGroup) findViewById(R.id.capital);
        CapitalGroup.clearCheck();

        CheckBox Tanger = (CheckBox) findViewById(R.id.tangier);
        Tanger.setChecked(false);

        CheckBox Dakhla = (CheckBox) findViewById(R.id.dakhla);
        Dakhla.setChecked(false);

        CheckBox Oujda = (CheckBox) findViewById(R.id.oujda);
        Oujda.setChecked(false);

        CheckBox Melilia = (CheckBox) findViewById(R.id.melilia);
        Melilia.setChecked(false);

        RadioGroup King = (RadioGroup) findViewById(R.id.king);
        King.clearCheck();

        ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_view);
        scrollView.fullScroll(ScrollView.FOCUS_UP);
    }

    /**
     * This method is called when the "submit" button is clicked.
     */
    int points = 0 ;
    public void DisplayScore(View view) {

        RadioButton capital = (RadioButton) findViewById(R.id.rabat);
        boolean isRabatChecked = capital.isChecked();

        CheckBox TangerBox = (CheckBox) findViewById(R.id.tangier);
        boolean isTangerChecked = TangerBox.isChecked();

        CheckBox DakhlaBox = (CheckBox) findViewById(R.id.dakhla);
        boolean isDakhlaChecked = DakhlaBox.isChecked();

        CheckBox MeliliaBox = (CheckBox) findViewById(R.id.melilia);
        boolean isMeliliaChecked = MeliliaBox.isChecked();

        CheckBox OujdaBox = (CheckBox) findViewById(R.id.oujda);
        boolean isOujdaChecked = OujdaBox.isChecked();

        RadioButton KingButton = (RadioButton) findViewById(R.id.six);
        boolean isSixChecked = KingButton.isChecked();

        EditText ContinentName = (EditText) findViewById(R.id.continent);
        String Continent = ContinentName.getText().toString();

        EditText UserName = (EditText) findViewById(R.id.name);
        String User = UserName.getText().toString();




        points = calculateScore(isRabatChecked, isTangerChecked, isDakhlaChecked, isOujdaChecked, isMeliliaChecked, isSixChecked, isAfrica(Continent));

        if (points == 6) {
            Toast.makeText(this, getString(R.string.result4, User,points), Toast.LENGTH_SHORT).show();
        } else if (points < 2) {
            Toast.makeText(this, getString(R.string.result1, User, points), Toast.LENGTH_LONG).show();
        } else if (points < 4) {
            Toast.makeText(this, getString(R.string.result2, User, points), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.result3, User, points), Toast.LENGTH_LONG).show();
        }
        points = 0 ;

    }

    /** thos to declare the input varaibles
     */
    private boolean isAfrica(String Continent) {
        return (Continent.contains("AFRICA"));
    }

    /**
     * @param isRabatChecked /
     * @param isTangerChecked /
     * @param isDakhlaChecked /
     * @param isOujdaChecked /
     * @param isMeliliaChecked /
     * @param isSixChecked /
     * @param isAfrica /
     */
    public int calculateScore( boolean isRabatChecked, boolean isTangerChecked, boolean isDakhlaChecked, boolean isOujdaChecked, boolean isMeliliaChecked, boolean isSixChecked, boolean isAfrica) {

        if (isRabatChecked) {
            points += 1;
        }
        if (isTangerChecked) {
            points += 1;
        }
        if (isDakhlaChecked) {
            points += 1;
        }
        if (isOujdaChecked) {
            points += 1;
        }
        if (isMeliliaChecked) {
            points += -3;
        }
        if (isSixChecked) {
            points += 1;
        }
        if (isAfrica) {
            points += 1;
        }
        if (points < 0) {
            points = 0;
        }
        return points; }
    }