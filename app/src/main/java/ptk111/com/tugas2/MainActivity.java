package ptk111.com.tugas2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import static android.R.attr.data;
import static ptk111.com.tugas2.R.id.lvCustom;
import static ptk111.com.tugas2.R.id.parent;
import static ptk111.com.tugas2.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    static final int ACT2_REQUEST = 99; //request code
    static final int ACT3_REQUEST = 69;
    private CustomListAdapter adapter;
    ArrayList<String> items = new ArrayList<>();
    ListView listV;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        listV = (ListView) findViewById(lvCustom);
        adapter = new CustomListAdapter(this, R.layout.layoutlistview, items);
        listV.setAdapter(adapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                view.setSelected(true);
                String agung = String.valueOf(position);
                ;
                Log.d("MyApp", agung);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent3 = new Intent(this, Main2Activity.class);
        Intent intent5 = new Intent(this, Main2Activity.class);
        switch (item.getItemId()) {
            case R.id.mInsert:
                //Toast.makeText(getApplicationContext(), "Insert", Toast.LENGTH_LONG).show();
                startActivityForResult(intent3, ACT2_REQUEST);
                return true;
            case R.id.mUpdate:
                //Toast.makeText(getApplicationContext(), "Update", Toast.LENGTH_LONG).show();
                //Intent intent3 = new Intent(this, Main2Activity.class);
                position = listV.getCheckedItemPosition();
                startActivityForResult(intent5, ACT3_REQUEST);
                return true;
            case R.id.mDelete:
                //Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_LONG).show();
                //position = listV.getCheckedItemPosition();
                //items.remove(position);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        // /cek request code
        if (requestCode == ACT2_REQUEST) {

            String terima = data.getStringExtra("strings");

            items.add(terima);

            //JANGAN LUPA refresh listview, agar layar terupdate
            adapter.notifyDataSetChanged();
        } else if (requestCode == ACT3_REQUEST) {

            String terima = data.getStringExtra("strings");

           // items.set(position,terima);
            //adapter.notifyDataSetChanged();
        }
    }
}
