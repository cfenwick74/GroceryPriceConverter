package fenwick.priceconverter;

import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView poundLabel, kgLabel, result, resultLabel;
    Button convert, reset;
    EditText poundText, kgText;
    Converter converter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convert = (Button) findViewById(R.id.convertBtn);
        convert.setEnabled(false);
        poundLabel = (TextView) findViewById(R.id.poundLabel);
        kgLabel = (TextView) findViewById(R.id.kgLabel);
        poundText = (EditText) findViewById(R.id.poundText);
        poundText.setInputType(InputType.TYPE_CLASS_NUMBER| InputType.TYPE_NUMBER_FLAG_DECIMAL);
        kgText = (EditText) findViewById(R.id.kgText);
        kgText.setInputType(InputType.TYPE_CLASS_NUMBER| InputType.TYPE_NUMBER_FLAG_DECIMAL);
        resultLabel = (TextView) findViewById(R.id.resultLabel);
        result = (TextView) findViewById(R.id.result);
        reset = (Button) findViewById(R.id.resetBtn);
        converter = new Converter();

        kgText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                convert.setEnabled(true);
                poundText.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {
                convert.setEnabled(true);
            }
        });

        poundText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                convert.setEnabled(true);
                kgText.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {
                convert.setEnabled(true);
                kgText.setEnabled(false);
            }
        });
    }


    public void onConvertClicked(View view) {
        Double res = 0.0;
        String kiloText = kgText.getText().toString();
        String lbText = poundText.getText().toString();
        if (!kiloText.isEmpty()) {
            res = converter.convertKilosToPounds(Double.parseDouble(kiloText));
            resultLabel.setText("Price per pound:");
            result.setText(res.toString());
        } else if (!lbText.isEmpty()) {
            res = converter.convertPoundsToKilos(Double.parseDouble(lbText));
            resultLabel.setText("Price per kilo:");
            result.setText(res.toString());
        }
    }

    public void onResetClicked(View view) {
        kgText.setText("");
        poundText.setText("");
        result.setText("");
        convert.setEnabled(false);
        kgText.setEnabled(true);
        poundText.setEnabled(true);
        resultLabel.setText("");
    }
}


/*
on key press listener
create method that takes in 2 views, checks if there's text in one, disables the other
if no text, both enabled
*/

