package letme.mukhtarif.selfident_report.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import letme.mukhtarif.selfident_report.Adapter.dataSiswaAdapter;
import letme.mukhtarif.selfident_report.Model.dataSiswaModel;
import letme.mukhtarif.selfident_report.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    List<dataSiswaModel> siswaList;

    String dataSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new Gson();
        Type type = new TypeToken<List<dataSiswaModel>>() {}.getType();

        mRecyclerView = findViewById(R.id.rv_datahasil);

        dataSiswa = getIntent().getStringExtra("DATA_SISWA");

        siswaList = gson.fromJson(dataSiswa, type);

        showRecylerList();
    }

    private void showRecylerList() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataSiswaAdapter mDataSiswaAdapter = new dataSiswaAdapter(siswaList);
        mRecyclerView.setAdapter(mDataSiswaAdapter);
    }
}
