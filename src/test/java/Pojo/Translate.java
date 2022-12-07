package Pojo;

public class Translate {

    private String lang;
    private String data;

    private String defaultLang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDefaultLang() {
        return defaultLang;
    }

    public void setDefaultLang(String defaultLang) {
        this.defaultLang = defaultLang;
    }

    public Translate(String lang, String data) {
        setLang(lang);
//        setDefaultLang(defaultLang);
        setData(data);



    }
}
