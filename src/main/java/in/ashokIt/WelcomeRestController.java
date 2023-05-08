package in.ashokIt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractFileResolvingResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private GreeClient client;

	@GetMapping("/welcome")
	public WelcomeResponse getWelcomeMsg() {
		//InterService Communication
		String welcomeMsg="Welcome to Ashok It....";
		String greetMsg = client.invokeGreetApi();
		
		
		//External Service Communication
		RestTemplate rt=new RestTemplate();
		String endPoingUrl="https://l1mhlq8687.execute-api.ap-northeast-1.amazonaws.com/dev/pets/1";
		
		ResponseEntity<Pet> entity = rt.getForEntity(endPoingUrl, Pet.class);
		
		Pet body = entity.getBody();
		WelcomeResponse finalResponse=new WelcomeResponse();
		finalResponse.setGreetMsg(greetMsg);
		finalResponse.setPet(body);
		finalResponse.setWelcomeMsg(welcomeMsg);
		
		return finalResponse;
	}
}
