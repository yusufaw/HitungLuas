package apps.crevion.com.hitungluas;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editPanjang, editLebar;
    private Button btnHitung;
    private TextView txtLuas;

    double p = 0;
    double l = 0;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        editPanjang = (EditText) findViewById(R.id.edt_panjang);
        editLebar = (EditText) findViewById(R.id.edt_lebar);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        txtLuas = (TextView) findViewById(R.id.txt_luas);

        setSupportActionBar(toolbar);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


        btnHitung.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String panjang = editPanjang.getText().toString().trim();
                String lebar = editLebar.getText().toString().trim();
                try {
                    p = Double.parseDouble(panjang);
                } catch (NumberFormatException e){
                    editPanjang.requestFocus();
                    imm.showSoftInput(editPanjang, InputMethodManager.SHOW_IMPLICIT);
                    return;
                }

                try {
                    l = Double.parseDouble(lebar);
                } catch (NumberFormatException e){
                    editLebar.requestFocus();
                    imm.showSoftInput(editLebar, InputMethodManager.SHOW_IMPLICIT);
                    return;
                }

                double luas = p * l;

                txtLuas.setText("Luas = "+luas);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
