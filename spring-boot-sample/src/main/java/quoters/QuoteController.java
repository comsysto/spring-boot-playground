package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    @Autowired
    @Qualifier("quoteRepository")
	private final QuoteRepository repository;

	private final static Quote NONE = new Quote("None");

	@Autowired
	public QuoteController(QuoteRepository repository) {
		this.repository = repository;
	}

    @Secured("USER")
	@RequestMapping (value = "/api", method = RequestMethod.GET)
	public Iterable<Quote> getAll() {
		return repository.findAll();
	}

    @Secured("USER")
	@RequestMapping (value = "/api/{id}", method = RequestMethod.GET)
	public Quote getOne(@PathVariable Long id)
    {
		if (repository.exists(id))
        {
			return repository.findOne(id);
		}
        else
        {
			return NONE;
		}
	}
}
