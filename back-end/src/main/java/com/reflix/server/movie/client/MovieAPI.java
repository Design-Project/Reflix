package com.reflix.server.movie.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import com.reflix.server.movie.MoviesService;
import com.reflix.server.movie.dto.MoviesResponseDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieAPI {

    private final MoviesService moviesService;

    @Value("${kobis.key}")
    private String AUTH_KEY;

    private final String REQUEST_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

    private final SimpleDateFormat DATE_FMT = new SimpleDateFormat("yyyyMMdd");

    public String makeQueryString(Map<String, String> paramMap) {
        final StringBuilder sb = new StringBuilder();

        paramMap.entrySet().forEach(( entry )->{
            if( sb.length() > 0 ) {
                sb.append('&');
            }
            sb.append(entry.getKey()).append('=').append(entry.getValue());
        });

        return sb.toString();
    }


    public List<MoviesResponseDto.Item> requestAPI() {

        List<MoviesResponseDto.Item> list = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1);

        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("key", AUTH_KEY);
        paramMap.put("targetDt" , DATE_FMT.format(cal.getTime()));
        paramMap.put("itemPerPage" , "9");

        try {

            URL requestURL = new URL(REQUEST_URL+"?"+makeQueryString(paramMap));
            HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();


            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String readline = null;
            StringBuffer response = new StringBuffer();
            while ((readline = br.readLine()) != null) {
                response.append(readline);
            }

            JSONObject responseBody = new JSONObject(response.toString());

            JSONObject boxOfficeResult = responseBody.getJSONObject("boxOfficeResult");

            JSONArray dailyBoxOfficeList = boxOfficeResult.getJSONArray("dailyBoxOfficeList");
            Iterator<Object> iter = dailyBoxOfficeList.iterator();
            while(iter.hasNext()) {
                JSONObject boxOffice = (JSONObject) iter.next();
                list.add(moviesService.findByKeyword(boxOffice.get("movieNm").toString()).getItems()[0]);
                list.get(list.size()-1).setRank(Integer.parseInt(boxOffice.get("rnum").toString()));
                String title = list.get(list.size() - 1).getTitle();
                title = title.replaceAll("<b>", "");
                title = title.replaceAll("</b>", "");
                list.get(list.size() - 1).setTitle(title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public MoviesResponseDto.Item getMovieByTitle(String title) {
        MoviesResponseDto.Item item = moviesService.findByKeyword(title).getItems()[0];
        String movieTitle = item.getTitle();
        movieTitle = movieTitle.replaceAll("<b>", "");
        movieTitle = movieTitle.replaceAll("</b>", "");
        item.setTitle(movieTitle);
        return item;
    }
}