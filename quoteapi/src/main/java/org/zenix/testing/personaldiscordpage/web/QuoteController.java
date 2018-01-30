package org.zenix.testing.personaldiscordpage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zenix.testing.personaldiscordpage.domain.Quote;
import org.zenix.testing.personaldiscordpage.domain.QuoteRepository;

@RestController
@Validated
public class QuoteController {

    @Autowired
    public QuoteRepository repo;

    @GetMapping
    public ResponseEntity<Iterable<Quote>> GetAllQuotes() {
        return ResponseEntity.ok(repo.findAll());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Quote> PostQuote(@RequestBody Quote quote) {
        try {
            Quote savedQuote = repo.save(quote);
            return ResponseEntity.ok(savedQuote);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
