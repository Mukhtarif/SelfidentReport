package letme.mukhtarif.selfident_report.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import letme.mukhtarif.selfident_report.Model.DataSekolahModel;
import letme.mukhtarif.selfident_report.R;

/**
 * Created by Mukhtarif-PC on 01/03/2018.
 */

public class DataSekolahAdapter extends ArrayAdapter<DataSekolahModel> {
    Context mContext;
    List<DataSekolahModel> dataSekolah;
    LayoutInflater inflater;

    public DataSekolahAdapter(Activity mContext, int resourceId, int textViewId, List<DataSekolahModel> dataSekolah) {
        super(mContext, resourceId, textViewId, dataSekolah);
        inflater = mContext.getLayoutInflater();
    }

    private View rowview(View convertView , int position){

        DataSekolahModel dataSekolah = (DataSekolahModel) getItem(position);
        String namaSekolah = dataSekolah.getNamasekolah();

        viewHolder holder;
        View rowview = convertView;
        if (rowview==null) {

            holder = new viewHolder();
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = inflater.inflate(R.layout.data_sekolah_item, null, false);

            holder.txtHasilNamaSekolah = (TextView) rowview.findViewById(R.id.txtHasilNamaSekolah);

            rowview.setTag(holder);
        }else{
            holder = (viewHolder) rowview.getTag();
        }
        holder.txtHasilNamaSekolah.setText(namaSekolah);

        return rowview;
    }

    private class viewHolder{
        TextView txtHasilNamaSekolah;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return rowview(convertView,position);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return rowview(convertView,position);
    }




}
