package sia.tacocloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

	@Bean
	CustomRepository customRepository() {
		Map<Integer, MemberProto.Student> customers = new ConcurrentHashMap<>();

		Arrays.asList(
				student("jean", "calm", 1, "a79007714@gmail.com"),
				student("lite", "hot", 2, "syn1341@gmail.com"),
				student("david", "cold", 3, "syn7714@gmail.com")
		).forEach(c -> customers.put(c.getId(), c));

		return customers::get;
	}

	interface CustomRepository {
		MemberProto.Student findById(int id);
	}

	private MemberProto.Student student(String firstName, String lastName
			, int id, String email) {
		return MemberProto.Student.newBuilder()
				.setFirstName(firstName)
				.setLastName(lastName)
				.setId(id)
				.setEmail(email)
				.build();
	}

	@RestController
	class CustomRestController {

		@Autowired
		private CustomRepository customRepository;

		@RequestMapping("/customer/{id}")
		MemberProto.Student student(@PathVariable Integer id) {
			return this.customRepository.findById(id);
		}
	}
}
