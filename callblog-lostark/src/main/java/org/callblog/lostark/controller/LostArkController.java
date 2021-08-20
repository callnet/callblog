package org.callblog.lostark.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class LostArkController {

    static String GET_AUCTIONLIST = "https://lostark.game.onstove.com/Auction/GetAuctionListV2";

    public String getAuctionList() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("request[firstCategory]","200000");
        multiValueMap.add("request[secondCategory]","200010");
        multiValueMap.add("request[classNo]","104");
        multiValueMap.add("request[itemTier]","3");
        multiValueMap.add("request[itemGrade]","5");
        multiValueMap.add("request[itemLevelMin]","0");
        multiValueMap.add("request[itemLevelMax]","1600");
        multiValueMap.add("request[itemName]","");
        multiValueMap.add("request[gradeQuality]","");
        multiValueMap.add("request[skillOptionList][0][firstOption]","");
        multiValueMap.add("request[skillOptionList][0][secondOption]","");
        multiValueMap.add("request[skillOptionList][0][minValue]","");
        multiValueMap.add("request[skillOptionList][0][maxValue]","");
        multiValueMap.add("request[skillOptionList][1][firstOption]","");
        multiValueMap.add("request[skillOptionList][1][secondOption]","");
        multiValueMap.add("request[skillOptionList][1][minValue]","");
        multiValueMap.add("request[skillOptionList][1][maxValue]","");
        multiValueMap.add("request[skillOptionList][2][firstOption]","");
        multiValueMap.add("request[skillOptionList][2][secondOption]","");
        multiValueMap.add("request[skillOptionList][2][minValue]","");
        multiValueMap.add("request[skillOptionList][2][maxValue]","");
        multiValueMap.add("request[etcOptionList][0][firstOption]","2");
        multiValueMap.add("request[etcOptionList][0][secondOption]","16");
        multiValueMap.add("request[etcOptionList][0][minValue]","");
        multiValueMap.add("request[etcOptionList][0][maxValue]","");
        multiValueMap.add("request[etcOptionList][1][firstOption]","2");
        multiValueMap.add("request[etcOptionList][1][secondOption]","15");
        multiValueMap.add("request[etcOptionList][1][minValue]","");
        multiValueMap.add("request[etcOptionList][1][maxValue]","");
        multiValueMap.add("request[etcOptionList][2][firstOption]","3");
        multiValueMap.add("request[etcOptionList][2][secondOption]","118");
        multiValueMap.add("request[etcOptionList][2][minValue]","3");
        multiValueMap.add("request[etcOptionList][2][maxValue]","");
        multiValueMap.add("request[etcOptionList][3][firstOption]","3");
        multiValueMap.add("request[etcOptionList][3][secondOption]","109");
        multiValueMap.add("request[etcOptionList][3][minValue]","5");
        multiValueMap.add("request[etcOptionList][3][maxValue]","");
        multiValueMap.add("request[pageNo]","1");
        multiValueMap.add("request[sortOption][Sort]","BIDSTART_PRICE");
        multiValueMap.add("request[sortOption][IsDesc]","false");
        multiValueMap.add("pushKey","");
        multiValueMap.add("tooltipData","" );

        WebClient webClient = WebClient
                .builder()
                .baseUrl(GET_AUCTIONLIST)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .build();

        String res = webClient.post()
                .body(BodyInserters.fromFormData(multiValueMap))
                .retrieve()
                .bodyToMono(String.class)
                .block();


        System.out.println("LostArkController : " + res);

        return "";
    }

    public static void main(String[] args) {
        LostArkController lostarkcont = new LostArkController();
        lostarkcont.getAuctionList();
    }
    

}
