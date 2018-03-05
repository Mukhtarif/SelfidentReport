package letme.mukhtarif.selfident_report.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import letme.mukhtarif.selfident_report.Adapter.DataSekolahAdapter;
import letme.mukhtarif.selfident_report.Model.dataSekolahModel;
import letme.mukhtarif.selfident_report.Model.dataSiswaModel;
import letme.mukhtarif.selfident_report.R;
import letme.mukhtarif.selfident_report.Services.BaseApiService;
import letme.mukhtarif.selfident_report.Services.ResponseService;
import letme.mukhtarif.selfident_report.Services.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    List<dataSiswaModel> dataSiswa;
    List<dataSekolahModel> dataSekolah;

    EditText edNamaKelas, edNamaSekolah;
    Button btnMasuk;
    Spinner spinnerNamaSekolah;

    Context mContext;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edNamaSekolah = findViewById(R.id.edNamaSekolah);
        edNamaKelas = findViewById(R.id.edNamaKelas);
        btnMasuk = findViewById(R.id.btnMasuk);
        spinnerNamaSekolah = findViewById(R.id.SpinnerNamaSekolah);



        mContext = this;
        mApiService = UtilsApi.getAPIService();

        addSpinnerSekolahItem();

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lihatHasil();
            }
        });
    }

    private void addSpinnerSekolahItem() {
        Call<ResponseService<dataSekolahModel>> dataSekolahCall = mApiService.lihatSekolah();
        dataSekolahCall.enqueue(new Callback<ResponseService<dataSekolahModel>>() {
            @Override
            public void onResponse(Call<ResponseService<dataSekolahModel>> call, Response<ResponseService<dataSekolahModel>> response) {
                dataSekolah = response.body().getDataList();
                Log.d("Retrofit Get ", "Total Data = " + String.valueOf(dataSekolah.size()));
                Toast.makeText(mContext, "Berhasil", Toast.LENGTH_LONG).show();
                DataSekolahAdapter dataSekolahAdapter = new DataSekolahAdapter(LoginActivity.this, R.layout.data_sekolah_item, R.id.txtHasilNamaSekolah, dataSekolah);
                spinnerNamaSekolah.setAdapter(dataSekolahAdapter);

                spinnerNamaSekolah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        dataSekolahModel dataSekolah;
                        dataSekolah = (dataSekolahModel) adapterView.getSelectedItem();
                        Toast.makeText(mContext, dataSekolah.getNamasekolah(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onFailure(Call<ResponseService<dataSekolahModel>> call, Throwable t) {
                Log.e("Retrofit Get ", t.toString());
                Toast.makeText(mContext, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void lihatHasil() {
            Call<ResponseService<dataSiswaModel>> dataSiswaCall = mApiService.lihatHasil(edNamaSekolah.getText().toString(), edNamaKelas.getText().toString());
            dataSiswaCall.enqueue(new Callback<ResponseService<dataSiswaModel>>() {
                @Override
                public void onResponse(Call<ResponseService<dataSiswaModel>> call, Response<ResponseService<dataSiswaModel>> response) {
                    dataSiswa = response.body().getDataList();
                    Log.d("Retrofit Get ","Total Data = " + String.valueOf(dataSiswa.size()));
                    Toast.makeText(mContext, "Berhasil", Toast.LENGTH_SHORT).show();
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<dataSiswaModel>>() {}.getType();
                    String json = gson.toJson(dataSiswa, type);
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra("DATA_SISWA", json);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<ResponseService<dataSiswaModel>> call, Throwable t) {
                    Log.e("debug", "onFailure: ERROR > " + t.toString());
                    Toast.makeText(mContext,"Error : "+toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
        /*mApiService.lihatHasil(edNamaKelas.getText().toString(),
                edNamaSekolah.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {

                        } else {
                            Log.i("debug", "onResponse: GA BERHASIL");
                        }
                    }

                    @Override
                    public void onFailure(Call <ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });*/
}

