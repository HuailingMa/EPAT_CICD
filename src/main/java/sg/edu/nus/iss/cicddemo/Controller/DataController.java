package sg.edu.nus.iss.cicddemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.javafaker.Faker;
import java.util.*;

@RestController
public class DataController {

	@GetMapping("/")
	public String healthCheck() {
		return "HEALTH CHECK OK!";
	}

	@GetMapping("/version")
	public String version() {
		return "The actual version is 1.0.0";
	}

	@GetMapping("/nations")
	public List<Map<String, String>> getRandomNations() {
		var faker = new Faker();
		List<Map<String, String>> nations = new ArrayList<>();
		for (var i = 0; i < 10; i++) {
			var nation = faker.nation();
			Map<String, String> map = new LinkedHashMap<>();
			map.put("nationality", nation.nationality());
			map.put("capitalCity", nation.capitalCity());
			map.put("flag", nation.flag());
			map.put("language", nation.language());
			nations.add(map);
		}
		return nations;
	}

	@GetMapping("/currencies")
	public List<Map<String, String>> getRandomCurrencies() {
		var faker = new Faker();
		List<Map<String, String>> currencies = new ArrayList<>();
		for (var i = 0; i < 20; i++) {
			var currency = faker.currency();
			Map<String, String> map = new LinkedHashMap<>();
			map.put("name", currency.name());
			map.put("code", currency.code());
			currencies.add(map);
		}
		return currencies;
	}
}
