package rifoxide.urlsmol.controller;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import rifoxide.urlsmol.service.UrlEntryService;

@Controller
public class RedirectController {
    @Autowired
    private UrlEntryService urlEntryService;

    // @GetMapping(value = "{shortUrl}")
    // public ResponseEntity<?> getAndRedirect(@PathVariable String shortUrl) {
    //     Optional<String> url = urlEntryService.getOriginalUrl(shortUrl);
    //     if (url.isPresent()) {
    //         return ResponseEntity.status(HttpStatus.FOUND)
    //                 .location(URI.create(url.get()))
    //                 .build();
    //     } else if (shortUrl.equals("index.html")) {
    //         String htmlContent = "ERROR";
    //         try {
    //             htmlContent = loadHTMLFromFile("/static/x.html");
    //         } catch (Exception e) {
    //         }
    //         return new ResponseEntity<String>(htmlContent, HttpStatus.OK);

    //     } else {
    //         return new ResponseEntity<String>("<h1>404 not found! [no short url named '" + shortUrl + "' ]</h1>",
    //                 HttpStatus.NOT_FOUND);
    //     }

    // }

    // private String loadHTMLFromFile(String fileName) throws IOException {
    //     // Read HTML content from the file
    //     ClassPathResource resource = new ClassPathResource(fileName);
    //     byte[] bytes = Files.readAllBytes(Paths.get(resource.getURI()));
    //     return new String(bytes);
    // }

    // @GetMapping("/index.html")
    // public String showHtml() {
    // return "x.html"; // Return the name of the HTML file
    // }

    @GetMapping(value = "{shortUrl}")
    public String redirectToOriginalUrl(@PathVariable("shortUrl") String shortUrl) {
        System.out.println(shortUrl);

        Optional<String> url = urlEntryService.getOriginalUrl(shortUrl);
        if (url.isPresent()) {
            return "redirect:" + url.get();
        } else if (shortUrl.equals("index.html")) {
            return "/static/index.html";
        } else {
            return "/public/error/404.html";
            // throw new ResponseStatusException(
            //         HttpStatus.NOT_FOUND, "entity not found");
        }

    }

}