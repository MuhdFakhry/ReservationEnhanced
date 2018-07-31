package sg.edu.rp.c346.reservation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView displayName;
    EditText inputName;
    TextView displayPhone;
    EditText inputPhone;
    TextView displayPax;
    EditText inputPax;
    TextView tvDay;
    EditText etDay;
    TextView tvTime;
    EditText etTime;
    RadioButton smokeArea;
    RadioButton nonSmokeArea;
    Button btnConfirm;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayName = findViewById(R.id.nameDisplay);
        inputName = findViewById(R.id.nameInput);
        displayPhone = findViewById(R.id.phoneDisplay);
        inputPhone = findViewById(R.id.phoneInput);
        displayPax = findViewById(R.id.paxDisplay);
        inputPax = findViewById(R.id.paxInput);
        tvDay = findViewById(R.id.textViewDay);
        etDay = findViewById(R.id.editTextDay);
        tvTime = findViewById(R.id.textViewTime);
        etTime = findViewById(R.id.editTextTime);
        smokeArea = findViewById(R.id.areaOne);
        nonSmokeArea = findViewById(R.id.areaTwo);
        btnConfirm = findViewById(R.id.buttonConfirm);
        btnReset = findViewById(R.id.buttonReset);


        etDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        etDay.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, 2014, 11, 31);
                myDateDialog.show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etTime.setText(hourOfDay + ":" + minute);
                    }
                };

                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, 20, 00, true);
                myTimeDialog.show();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "";

                if(smokeArea.isChecked()) {
                    text = "Smoking Area";
                }
                else if(nonSmokeArea.isChecked()){
                    text = "Non-smoking Area";
                }

                String confirmReservation = "Name: " + inputName.getText() + "\nPhone Number: " + inputPhone.getText()
                        + "\nPax: " + inputPax.getText() + "\nDate reservation: " + etDay.getText().toString()
                        + "\nTime reservation: " + etTime.getText().toString() + "\nTable Type: " + text;
                Toast.makeText(MainActivity.this,confirmReservation,Toast.LENGTH_LONG).show();
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputName.setText(null);
                inputPhone.setText(null);
                inputPax.setText(null);
                etDay.setText(null);
                etTime.setText(null);
                smokeArea.setChecked(false);
                nonSmokeArea.setChecked(false);

            }
        });
    }
}
