package helloworld.lin.com.databasetest.ZhangFourteen.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by W50V on 2018/8/9.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;

    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
