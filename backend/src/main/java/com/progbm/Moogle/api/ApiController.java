package com.progbm.Moogle.api;

import com.progbm.Moogle.actor.Actor;
import com.progbm.Moogle.director.Director;
import com.progbm.Moogle.genre.Genre;
import com.progbm.Moogle.genre.GenreService;
import com.progbm.Moogle.movie.Movie;
import com.progbm.Moogle.movie.MovieService;
import com.progbm.Moogle.person.PersonService;
import com.progbm.Moogle.request.AnswerRequest;
import com.progbm.Moogle.response.ResponseService;
import com.progbm.Moogle.response.dto.DataResponse;
import com.progbm.Moogle.util.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final ResponseService responseService;
    private final GenreService genreService;
    private final MovieService movieService;
    private final PersonService personService;

    /**
     * 1. 선호하는 장르는? (19개) Action(28), Adventure(12), Animation(16), Comedy(35), Crime(80), Documentary(99), Drama(18), Family(10751), Fantasy(14), History(36), Horror(27), Music(10402), Mystery(9648), Romance(10749), Science Fiction(878), TV Movie(10770), Thriller(53), War(10752), Western(37)
     */
    @GetMapping("/question/1")
    public ResponseEntity question1() {
        List<Genre> genres = genreService.getGenres();

        DataResponse response = responseService.getDataResponse(genres, HttpStatus.OK);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    /**
     * 2. 관심있는 영화는(최소 3개 최대 5개)? 인기있는 영화 무한 스크롤로 보여줌
     */
    @GetMapping("/question/2")
    public ResponseEntity question2() {
        List<Movie> movies = movieService.getMovies();

        DataResponse response = responseService.getDataResponse(movies, HttpStatus.OK);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    /**
     * 3. 더 선호하는 감독이 있나요 (최소 0개 최대 5개)? 무한 스크롤로 보여줌 (건너뛰기 가능)
     */
    @GetMapping("/question/3")
    public ResponseEntity question3() {
        List<Director> directors = personService.getDirectors();

        DataResponse response = responseService.getDataResponse(directors, HttpStatus.OK);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    /**
     * 4. 좋아하는 배우는 (최소 0개 최대 5개)? 무한 스크롤로 보여줌 (건너뛰기 가능)
     */
    @GetMapping("/question/4")
    public ResponseEntity question4() {
        List<Actor> actors = personService.getActors();

        DataResponse response = responseService.getDataResponse(actors, HttpStatus.OK);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    /**
     * 전체 질문에 대한 응답을 받고, 추천 OTT 를 반환하는 API
     */
    @PostMapping("/answer")
    public ResponseEntity allResponseFromClient(@RequestParam AnswerRequest request) {
        Map<Provider, Integer> map = new EnumMap<>(Provider.class);

        // 1. 영화 목록에서 OTT 갯수 추가
        movieService.countMovieOtt(map, request.getMovies());

        // 2. 배우, 감독 목록에서 OTT 갯수 추가
        personService.countPeopleOtt(map, request.getActors(), request.getDirectors());

        // 3. 맵을 순회하면서 가장 많은 갯수를 가지는 ott 를 불러온다
        String result = Provider.NETFLIX.toString();
        int count = map.get(Provider.NETFLIX);
        for (Map.Entry<Provider, Integer> entry : map.entrySet()) {
            String key = entry.getKey().toString();
            int value = entry.getValue();

            if (value > count) {
                result = key;
                count = value;
            }
        }

        DataResponse response = responseService.getDataResponse(result, HttpStatus.OK);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
