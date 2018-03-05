package letme.mukhtarif.selfident_report.Services;

import letme.mukhtarif.selfident_report.Model.dataSekolahModel;
import letme.mukhtarif.selfident_report.Model.dataSiswaModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Mukhtarif-PC on 20/01/2018.
 */

public interface BaseApiService {
    @FormUrlEncoded
    @POST("lihathasil.php")
    Call<ResponseService<dataSiswaModel>> lihatHasil(@Field("namasekolah") String namasekolah,
                                    @Field("namakelas") String namakelas);

    @GET("lihathasil.php")
    Call<ResponseService<dataSekolahModel>> lihatSekolah();
}
