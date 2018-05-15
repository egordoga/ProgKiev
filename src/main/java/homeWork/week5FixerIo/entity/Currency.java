package homeWork.week5FixerIo.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Currency {
    private boolean success;
    private long timestamp;
    private String base;
    private String date;
    private Rates rates;

    public Currency() {
    }

    public Currency getEntity(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, Currency.class);
    }

    public boolean isSuccess() {
        return success;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Rates getRates() {
        return rates;
    }
}
