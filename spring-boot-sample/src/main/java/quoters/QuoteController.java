package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class QuoteController {

	private final QuoteRepository repository;

	private final static Quote NONE = new Quote("None");

	private final static Random RANDOMIZER = new Random();

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
	public QuoteResource getOne(@PathVariable Long id) {
		if (repository.exists(id)) {
			return new QuoteResource(repository.findOne(id), "success");
		} else {
			return new QuoteResource(NONE, "Quote " + id + " does not exist");
		}
	}

    @Secured("USER")
	@RequestMapping (value = "/api/random", method = RequestMethod.GET)
	public QuoteResource getRandomOne() {
		final QuoteResource quoteResource = getOne(nextLong(1, repository.count() + 1));
		System.out.println("Returning " + quoteResource);
		return quoteResource;
	}


	private long nextLong(long lowerRange, long upperRange) {
		return (long)(RANDOMIZER.nextDouble() * (upperRange - lowerRange)) + lowerRange;
	}

}
