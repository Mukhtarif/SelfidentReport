package letme.mukhtarif.selfident_report.Services;

/**
 * Created by Mukhtarif-PC on 20/01/2018.
 */

public class UtilsApi {
    public static final String BASE_URL_API = "https://selfident-id.000webhostapp.com/selfident/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
