package rifoxide.urlsmol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rifoxide.urlsmol.model.UrlEntry;

import java.util.Optional;

@Repository
public interface UrlEntryRepository extends JpaRepository<UrlEntry, Long> {
  Optional<UrlEntry> findBySmolurl(String smolurl);
}
