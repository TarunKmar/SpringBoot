package in.ashokIt;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GREET-API")
public interface GreeClient {

	@GetMapping("/greet")
	public String invokeGreetApi();
	
}
