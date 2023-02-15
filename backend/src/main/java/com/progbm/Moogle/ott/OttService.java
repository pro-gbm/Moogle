package com.progbm.Moogle.ott;

import com.progbm.Moogle.nation.Nation;
import com.progbm.Moogle.nation.NationRepository;
import com.progbm.Moogle.tmdb.TmdbService;
import com.progbm.Moogle.tmdb.response.NationResponse;
import com.progbm.Moogle.tmdb.response.OttResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OttService {
    private final OttRepository ottRepository;
    private final TmdbService tmdbService;
    private final String IMAGE_URL = "https://image.tmdb.org/t/p/original";

    public List<Ott> Otts() {
        OttResponse ottResponses = tmdbService.getOtts();
        List<Ott> ottList = ottResponses.getResults().stream().map(
                ottResponse -> Ott.builder().ott((ottResponse.getProvider_name())).thumbnailUrl(IMAGE_URL + ottResponse.getLogo_path()).build())
                .collect(Collectors.toList());
        for ( var ott: ottList ) {
            System.out.println("saveOtts() = " + ott.getOtt() + " " + ott.getThumbnailUrl());
        }
        return ottList;
    }
}
