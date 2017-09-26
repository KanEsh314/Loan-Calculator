package my.com.itrain.simpleloancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText property = (EditText) findViewById(R.id.property);
        final EditText down = (EditText) findViewById(R.id.down);
        final EditText interest = (EditText) findViewById(R.id.interest);
        final EditText year = (EditText) findViewById(R.id.year);

        final TextView monthly = (TextView) findViewById(R.id.monthly);

        Button calculate = (Button) findViewById(R.id.loan);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Property = Double.parseDouble(property.getText().toString());
                double Down = Double.parseDouble(down.getText().toString());
                double Interest = Double.parseDouble(interest.getText().toString());
                double Year = Double.parseDouble(year.getText().toString());

                //Loan Calculation

                double annualInterest = (Interest/100) / 12;
                double month = Year * 12;

                double amount = Property - Down;
                double precommon = 1 + annualInterest;
                double commonoperation = Math.pow(precommon,month);
                double leftoperation = commonoperation - 1;
                double rightoperation = annualInterest * commonoperation;
                double discount = leftoperation / rightoperation;
                double monthlypay = amount / discount;

                monthly.setText(String.valueOf(monthlypay));
            }
        });
    }
}
