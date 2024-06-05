package rifoxide.urlsmol.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import rifoxide.urlsmol.Helpers;
import rifoxide.urlsmol.request.CreateSmolUrlRequest;

@Entity
@Table(name = "url_entry")
public class UrlEntry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String url;
  private String smolurl;
  private String secretkey;

  // Constructors, getters, and setters
  public UrlEntry() {
    this.url = "<UNKNOWN>";
    this.smolurl = "<UNKNOWN>";
    this.secretkey = "<UNKNOWN>";
  }

  // public UrlEntry(String url, String smolurl) {
  // this.url = url;
  // this.smolurl = smolurl;
  // this.secretkey = secretkey;
  // }

  public UrlEntry(CreateSmolUrlRequest req) {
    this.url = req.getMain_url().toLowerCase();
    this.smolurl = req.getUrl_suffix().toLowerCase();
    this.secretkey = Helpers.generateRandomString(25);
    // this.secretkey = req.getSecretkey();
  }

  // public Long getId() {
  // return id;
  // }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getSmolurl() {
    return smolurl;
  }

  public void setSmolurl(String smolurl) {
    this.smolurl = smolurl;
  }

  public String getSecretkey() {
    return secretkey;
  }

  public void setSecretkey(String secretkey) {
    this.secretkey = secretkey;
  }

  public Long getId() {
    return id;
  }

}
