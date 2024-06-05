package rifoxide.urlsmol.response;

import rifoxide.urlsmol.model.UrlEntry;
import rifoxide.urlsmol.request.CreateSmolUrlRequest;

public class CreateSmolUrlResponse {
    private ResponseStatus status_msg;
    private String main_url;
    private String url_suffix;
    private String secret_key;

    public CreateSmolUrlResponse(ResponseStatus status, UrlEntry urlEntry) {
        this.status_msg = status;
        this.main_url = urlEntry.getUrl();
        this.url_suffix = urlEntry.getSmolurl();
        this.secret_key = urlEntry.getSecretkey();
    }

    public CreateSmolUrlResponse(ResponseStatus status, CreateSmolUrlRequest createSmolUrlRequest) {
        this.status_msg = status;
        this.main_url = createSmolUrlRequest.getMain_url();
        this.url_suffix = createSmolUrlRequest.getUrl_suffix();
    }

    public ResponseStatus getStatus_msg() {
        return status_msg;
    }

    public void setStatus_msg(ResponseStatus status) {
        this.status_msg = status;
    }

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

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secretkey) {
        this.secret_key = secretkey;
    }
}
