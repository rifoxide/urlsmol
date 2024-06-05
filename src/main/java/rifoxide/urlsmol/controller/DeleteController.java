
package rifoxide.urlsmol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import rifoxide.urlsmol.request.DeleteUrlRequest;
import rifoxide.urlsmol.service.DeleteUrlResponse;
import rifoxide.urlsmol.service.UrlEntryService;

@RestController
@RequestMapping("/api/delete")
public class DeleteController {

    @Autowired
    private UrlEntryService urlEntryService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public DeleteUrlResponse createSmolUrl(@RequestBody DeleteUrlRequest deleteUrlRequest) {
        return urlEntryService.deleteUrlEntry(deleteUrlRequest);
    }

}
