package ptk111.com.tugas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void klikButton(View v){
        EditText etNamaItem = (EditText) findViewById(R.id.namaItem);
        String xnamaItem = etNamaItem.getText().toString();

        Intent intent2 = getIntent();
        intent2.putExtra("strings", xnamaItem);
        setResult(RESULT_OK, intent2);
        finish();
    }
}
