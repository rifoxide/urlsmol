package rifoxide.urlsmol.service;

import rifoxide.urlsmol.Helpers;
import rifoxide.urlsmol.model.UrlEntry;
import rifoxide.urlsmol.repository.UrlEntryRepository;
import rifoxide.urlsmol.request.CreateSmolUrlRequest;
import rifoxide.urlsmol.request.DeleteUrlRequest;
import rifoxide.urlsmol.response.CreateSmolUrlResponse;
import rifoxide.urlsmol.response.DeleteUrlResponse;
import rifoxide.urlsmol.response.ResponseStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlEntryService {

    @Autowired
    private UrlEntryRepository urlEntryRepository;

    public CreateSmolUrlResponse createUrlEntry(CreateSmolUrlRequest request) {
        Optional<UrlEntry> existingUserOpt = urlEntryRepository.findBySmolurl(request.getUrl_suffix());
        if (existingUserOpt.isPresent()) {
            System.out.println("Entry already exist");
            return new CreateSmolUrlResponse(ResponseStatus.URL_SUFFIX_EXISTS, request);
        }
        if (!Helpers.isValidUrl(request.getMain_url())) {
            return new CreateSmolUrlResponse(ResponseStatus.URL_GEN_FAILED, request);
        }
        if (request.getUrl_suffix().strip() == "") {
            while (true) {
                String randomString = Helpers.generateRandomString(6);
                Optional<UrlEntry> existingEntry = urlEntryRepository.findBySmolurl(request.getUrl_suffix());
                if (existingEntry.isEmpty()) {
                    request.setUrl_suffix(randomString);
                    break;
                }
            }
        } else if (Helpers.containsInvaidChars(request.getUrl_suffix())) {
            return new CreateSmolUrlResponse(ResponseStatus.INVALID_SHORT_URL, request);
        }

        UrlEntry newentry = new UrlEntry(request);
        urlEntryRepository.save(newentry);
        return new CreateSmolUrlResponse(ResponseStatus.URL_GEN_SUCCESS, newentry);

    }

    public Optional<String> getOriginalUrl(String smolurl) {
        Optional<UrlEntry> existingUserOpt = urlEntryRepository.findBySmolurl(smolurl);
        if (existingUserOpt.isPresent()) {
            return Optional.of(existingUserOpt.get().getUrl());
        } else {
            return Optional.empty();
        }
    }

    public DeleteUrlResponse deleteUrlEntry(DeleteUrlRequest request) {
        Optional<UrlEntry> existingUserOpt = urlEntryRepository.findBySmolurl(request.getUrl_suffix());
        if (existingUserOpt.isPresent()) {
            if (request.getSecret_key().equals(existingUserOpt.get().getSecretkey())) {
                urlEntryRepository.deleteById(existingUserOpt.get().getId());
                return new DeleteUrlResponse(ResponseStatus.URL_DEL_SUCCESS);
            } else {
                return new DeleteUrlResponse(ResponseStatus.WRONG_SECRET_KEY);
            }
        } else {
            return new DeleteUrlResponse(ResponseStatus.URL_DEL_FAILED);
        }
    }
}
