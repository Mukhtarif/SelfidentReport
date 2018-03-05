package letme.mukhtarif.selfident_report.Services;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import letme.mukhtarif.selfident_report.Model.dataSiswaModel;

/**
 * Created by Mukhtarif-PC on 15/02/2018.
 */

public class ResponseService<T> {
    @SerializedName("error")
    String error;
    @SerializedName("datalists")
    List<T> dataList;
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
