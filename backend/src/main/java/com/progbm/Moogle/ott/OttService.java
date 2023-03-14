package com.progbm.Moogle.ott;

import com.progbm.Moogle.movie.Movie;
import com.progbm.Moogle.movie.MovieOtt;
import com.progbm.Moogle.movie.MovieOttRepository;
import com.progbm.Moogle.movie.MovieRepository;
import com.progbm.Moogle.tmdb.TmdbService;
import com.progbm.Moogle.tmdb.response.MovieProviderResponse;
import com.progbm.Moogle.tmdb.response.OttResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OttService {
    private final OttRepository ottRepository;
    private final MovieRepository movieRepository;
    private final MovieOttRepository movieOttRepository;
    private final TmdbService tmdbService;
    private final String IMAGE_URL = "https://image.tmdb.org/t/p/original";

    public void saveOtts() {
        Set<Integer> savedOttTmdbIds = ottRepository.findAll().stream().map(Ott::getProviderId).collect(Collectors.toSet());

        OttResponse ottResponses = tmdbService.getOtts();
        // TODO : 필터 기능 추가
        List<Ott> ottList = ottResponses.getResults().stream().map(
                ottResponse -> Ott.builder().ott((ottResponse.getProvider_name())).providerId(ottResponse.getProvider_id()).thumbnailUrl(IMAGE_URL + ottResponse.getLogo_path()).build())
                .collect(Collectors.toList());
        ottList = ottList.stream().filter(ott -> !savedOttTmdbIds.contains(ott.getProviderId())).collect(Collectors.toList());
        ottRepository.saveAll(ottList);
    }

    @Transactional(readOnly = true)
    public List<Ott> getOtts() {
        return ottRepository.findAll();
    }

    //TODO : 추가 예정
    public void addMovieProvider(int movieId) {
        MovieProviderResponse movieProviderResponse = tmdbService.getMovieProviders(movieId);
        Movie movie = movieRepository.findByTmdbId(movieId).orElse(null);
        System.out.println("movie : " + movie);

        List<Ott> otts = movieProviderResponse.getResults()
                .getCountry()
                .getFlatrate()
                .stream()
                .map(flatrate -> ottRepository.findByProviderId(flatrate.getProviderId()).orElse(null))
                .toList();
        System.out.println("otts : " + otts);

        otts.forEach(ott -> {
            MovieOtt movieOtt = MovieOtt
                    .builder()
                    .movie(movie)
                    .ott(ott)
                    .build();
            movieOttRepository.save(movieOtt);
        });
    }
}
