package helloworld.lin.com.databasetest.ZhangFourteen.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by W50V on 2018/8/9.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;
    public class More{
        @SerializedName("txt")
        public String info;
    }
}
