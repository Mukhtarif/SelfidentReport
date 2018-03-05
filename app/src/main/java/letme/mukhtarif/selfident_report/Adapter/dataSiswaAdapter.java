package letme.mukhtarif.selfident_report.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import letme.mukhtarif.selfident_report.Model.dataSiswaModel;
import letme.mukhtarif.selfident_report.R;

/**
 * Created by Mukhtarif-PC on 31/01/2018.
 */

public class dataSiswaAdapter extends RecyclerView.Adapter<dataSiswaAdapter.DataSiswaViewHolder>{
    List<dataSiswaModel> dataSiswa;

    public dataSiswaAdapter(List<dataSiswaModel> dataSiswa) {
        this.dataSiswa = dataSiswa;
    }


    @Override
    public DataSiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_datahasil, parent, false);
        DataSiswaViewHolder dataSiswaViewHolder = new DataSiswaViewHolder(layoutView);
        return dataSiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(DataSiswaViewHolder holder, int position) {
        holder.nisn.setText(dataSiswa.get(position).getNisn());
        holder.namaSiswa.setText(dataSiswa.get(position).getNamasiswa());
        holder.namaSekolah.setText(dataSiswa.get(position).getNamasekolah());
        holder.namaKelas.setText(dataSiswa.get(position).getNamakelas());
        holder.hasilGayaBelajar.setText(dataSiswa.get(position).getHasilgayabelajar());
        holder.hasilMinatBakat.setText(dataSiswa.get(position).getHasilminatbakat());
        holder.hasilPekerjaan.setText(dataSiswa.get(position).getHasilpekerjaan());
    }

    @Override
    public int getItemCount() {
        return dataSiswa.size();
    }

    public class DataSiswaViewHolder extends RecyclerView.ViewHolder {
        TextView nisn, namaSiswa, namaSekolah, namaKelas, hasilGayaBelajar, hasilMinatBakat, hasilPekerjaan;

        public DataSiswaViewHolder(View itemView) {
            super(itemView);

            nisn = itemView.findViewById(R.id.txtNISN);
            namaSiswa = itemView.findViewById(R.id.txtNamaSiswa);
            namaSekolah = itemView.findViewById(R.id.txtNamaSekolah);
            namaKelas = itemView.findViewById(R.id.txtNamaKelas);
            hasilGayaBelajar = itemView.findViewById(R.id.txtHasilGayaBelajar);
            hasilMinatBakat = itemView.findViewById(R.id.txtHasilMinatBakat);
            hasilPekerjaan = itemView.findViewById(R.id.txtHasilPekerjaan);
        }
    }
}
