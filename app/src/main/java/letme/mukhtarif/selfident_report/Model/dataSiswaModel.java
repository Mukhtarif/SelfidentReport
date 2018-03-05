package letme.mukhtarif.selfident_report.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Mukhtarif-PC on 23/01/2018.
 */

public class dataSiswaModel{
    @SerializedName("nisn")
    private String nisn;
    @SerializedName("namasiswa")
    private String namasiswa;
    @SerializedName("namasekolah")
    private String namasekolah;
    @SerializedName("namakelas")
    private String namakelas;
    @SerializedName("hasilgayabelajar")
    private String hasilgayabelajar;
    @SerializedName("hasilminatbakat")
    private String hasilminatbakat;
    @SerializedName("hasilpekerjaan")
    private String hasilpekerjaan;


    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNamasiswa() {
        return namasiswa;
    }

    public void setNamasiswa(String namasiswa) {
        this.namasiswa = namasiswa;
    }

    public String getNamasekolah() {
        return namasekolah;
    }

    public void setNamasekolah(String namasekolah) {
        this.namasekolah = namasekolah;
    }

    public String getNamakelas() {
        return namakelas;
    }

    public void setNamakelas(String namakelas) {
        this.namakelas = namakelas;
    }

    public String getHasilgayabelajar() {
        return hasilgayabelajar;
    }

    public void setHasilgayabelajar(String hasilgayabelajar) {
        this.hasilgayabelajar = hasilgayabelajar;
    }

    public String getHasilminatbakat() {
        return hasilminatbakat;
    }

    public void setHasilminatbakat(String hasilminatbakat) {
        this.hasilminatbakat = hasilminatbakat;
    }

    public String getHasilpekerjaan() {
        return hasilpekerjaan;
    }

    public void setHasilpekerjaan(String hasilpekerjaan) {
        this.hasilpekerjaan = hasilpekerjaan;
    }

}
