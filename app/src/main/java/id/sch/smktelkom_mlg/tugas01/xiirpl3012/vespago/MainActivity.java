package id.sch.smktelkom_mlg.tugas01.xiirpl3012.vespago;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    Spinner spKelas;
    RadioGroup rgArah;
    CheckBox cbH, cbM, cbS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        rgArah = (RadioGroup) findViewById(R.id.RadioGroupArah);
        cbH = (CheckBox) findViewById(R.id.checkBoxH);
        cbM = (CheckBox) findViewById(R.id.checkBoxM);
        cbS = (CheckBox) findViewById(R.id.checkBoxSt);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }

            private void doClick() {

                String hasil = null
                if (etNama.getText() == "" && spKelas.getSelectedItem() == "" && rgArah.getCheckedRadioButtonId() != -1 &&
                        cbH.isChecked() == "" && cbM.isChecked() == "" && cbS.isChecked() == "") {
                    hasil += "Anda belum mengisi data pemesanan";
                } else {
                    hasil += "Transaksi Anda sedang di proses";
                }

            }
        });

    }
}