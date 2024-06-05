package rifoxide.urlsmol.request;

public class DeleteUrlRequest {
    private String secret_key;
    private String url_suffix;

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public String getUrl_suffix() {
        return url_suffix;
    }

    public void setUrl_suffix(String url_suffix) {
        this.url_suffix = url_suffix;
    }
}
