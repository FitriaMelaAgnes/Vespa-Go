package id.sch.smktelkom_mlg.tugas01.xiirpl3012.vespago;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    Spinner spKelas;
    RadioGroup rgArah;
    CheckBox cbH, cbM, cbS;
    TextView tvNama, tvKelas, tvArah, tvAlat;
    Button bOk;

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
        tvNama = (TextView) findViewById(R.id.textViewNama);
        tvKelas = (TextView) findViewById(R.id.textViewPc);
        tvArah = (TextView) findViewById(R.id.textViewAt);
        tvAlat = (TextView) findViewById(R.id.textViewPr);
        bOk = (Button) findViewById(R.id.buttonOK);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOk();
                doAlat();
                doArah();
                doKelas();
            }

            private void doKelas() {
                tvKelas.setText("Paket Class Anda " + spKelas.getSelectedItem().toString());
            }

            private void doArah() {
                String hasil = null;
                if (rgArah.getCheckedRadioButtonId() != -1) {
                    RadioButton rb = (RadioButton) findViewById(rgArah.getCheckedRadioButtonId());
                    hasil = rb.getText().toString();
                }
                if (hasil == null) {
                    tvArah.setText("Belum memilih arah tujuan");
                } else {
                    tvArah.setText("Tujuan Anda : " + hasil + "\n");
                }
            }

            private void doAlat() {
                String alat = "Peralatan keamanan yang anda pakai : \n";
                int startlen = alat.length();
                if (cbM.isChecked())
                    alat += cbM.getText() + "\n";
                if (cbH.isChecked())
                    alat += cbH.getText() + "\n";
                if (cbS.isChecked())
                    alat += cbS.getText() + "\n";

                if (alat.length() == startlen)
                    alat += "Tidak ada di pilihan";

                tvAlat.setText(alat);
            }

            private void doOk() {
                if (isValid()) {
                    String namaku = etNama.getText().toString();
                    tvNama.setText("Nama Anda adalah " + namaku + "\n");
                }
            }

            private boolean isValid() {
                boolean valid = true;

                String namaku = etNama.getText().toString();
                if (namaku.isEmpty()) {
                    etNama.setError("Nama belum diisi");
                    valid = false;
                } else {
                    etNama.setError(null);
                }
                return valid;
            }
        });


    }
}