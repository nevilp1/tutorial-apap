package apap.tutorial.traveloke.service;


import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.net.URI;

@Service
@Transactional
public class HotelRestService2 {

    private final WebClient webClient;
    public HotelRestService2(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.urlSuggest).build();
    }
   /* public Mono<String> getSuggest(String city) {
        return this.webClient.get().uri(uriBuilder -> uriBuilder
                .path("/json")
                .queryParam("query", city)
                .queryParam("locale", "en_US")
                .build()
        )
                .header("x-rapidapi-key","ec376973ccmsh51fe5aac51a0f98p115187jsn3bd87305d0d2")
                .header("x-rapidapi-host", "http://hotels-com-free.p.rapidapi.com/")
                .retrieve()
                .bodyToMono(String.class);
    }*/

    public Mono<String> getSuggest(String cityName) {
        String[] temp = cityName.split(" ");
        String newString = "";
        for(String s : temp){
            newString += s;
            newString += "%20";
        }
        return this.webClient.get()
                .uri(URI.create(
                        "https://hotels-com-free.p.rapidapi.com/suggest/v1.7/json?query="+newString+"&locale=en_US"))
                .header("x-rapidapi-key", "1e18da819emsh5ae17cf7ffec2bap11dc91jsn33da48343a9f")
                .header("x-rapidapi-host", "hotels-com-free.p.rapidapi.com").retrieve().bodyToMono(String.class);

    }

}
