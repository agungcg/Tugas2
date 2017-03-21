package ptk111.com.tugas2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ptk111 on 3/21/2017.
 */

public class CustomListAdapter extends ArrayAdapter {
    //data untuk listview
    private ArrayList<String> arrJudulBaris;

    private Context context;



    public CustomListAdapter(Context context, int resource, ArrayList<String> arrJudulBaris) {
        super(context, resource);
        //passing data berupa text yang akan ditampilkan di baris
        //String bisa diganti class lain, misal ArrayList<Mahasiswa>
        this.arrJudulBaris = arrJudulBaris;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(this.context);
        View rowView = li.inflate(R.layout.layoutlistview, null, true);

        CheckBox ckJudul = (CheckBox) rowView.findViewById(R.id.ckJudul);
        //TextView tvJudul = (TextView) rowView.findViewById(R.id.tvJudul);

        ckJudul.setText(arrJudulBaris.get(position));
        //tvJudul.setText(arrJudulBaris.get(position));

        return rowView;
    }

    @Override
    public int getCount() {
        //jumlah total baris
        return arrJudulBaris.size();
    }

}
