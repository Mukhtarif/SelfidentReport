package letme.mukhtarif.selfident_report.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mukhtarif-PC on 26/02/2018.
 */

public class DataSekolahModel {
    @SerializedName("namasekolah")
    private String namasekolah;

    public String getNamasekolah() {
        return namasekolah;
    }

    public void setNamasekolah(String namasekolah) {
        this.namasekolah = namasekolah;
    }
}
