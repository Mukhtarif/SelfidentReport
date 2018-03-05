package letme.mukhtarif.selfident_report.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import letme.mukhtarif.selfident_report.Model.dataSekolahModel;
import letme.mukhtarif.selfident_report.R;

/**
 * Created by Mukhtarif-PC on 01/03/2018.
 */

public class DataSekolahAdapter extends ArrayAdapter<dataSekolahModel> {
    Context mContext;
    List<dataSekolahModel> dataSekolah;
    LayoutInflater inflater;

    public DataSekolahAdapter(Activity mContext, int resourceId, int textViewId, List<dataSekolahModel> dataSekolah) {
        super(mContext, resourceId, textViewId, dataSekolah);
        inflater = mContext.getLayoutInflater();
    }

    private View rowview(View convertView , int position){

        dataSekolahModel dataSekolah = getItem(position);

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
        holder.txtHasilNamaSekolah.setText(dataSekolah.getNamasekolah());

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
