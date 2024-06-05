package rifoxide.urlsmol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import rifoxide.urlsmol.request.CreateSmolUrlRequest;
import rifoxide.urlsmol.response.CreateSmolUrlResponse;
import rifoxide.urlsmol.service.UrlEntryService;

@RestController
@RequestMapping("/api/add")
public class UriEntryController {

    @Autowired
    private UrlEntryService urlEntryService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public CreateSmolUrlResponse createSmolUrl(@RequestBody CreateSmolUrlRequest createSmolUrlRequest) {
        return urlEntryService.createUrlEntry(createSmolUrlRequest);

    }

    

    // @GetMapping(produces = "application/json")
    // public UrlEntry getUrlEntry() {
    // // Return a sample user for demonstration purposes
    // return new UrlEntry();
    // }
}
