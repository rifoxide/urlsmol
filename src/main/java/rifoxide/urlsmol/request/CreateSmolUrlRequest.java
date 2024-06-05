package rifoxide.urlsmol.request;

public class CreateSmolUrlRequest {
    private String main_url;
    private String url_suffix;

    public String getMain_url() {
        return main_url;
    }

    public void setMain_url(String url) {
        this.main_url = url;
    }

    public String getUrl_suffix() {
        return url_suffix;
    }

    public void setUrl_suffix(String smolurl) {
        this.url_suffix = smolurl;
    }

}
