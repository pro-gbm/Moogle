package com.progbm.Moogle.nation;

import com.progbm.Moogle.tmdb.NationResponse;
import com.progbm.Moogle.tmdb.TmdbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class NationService {
    private final NationRepository nationRepository;
    private final TmdbService tmdbService;

//    public void insertNations() {
//        NationResponse[] nationResponses = tmdbService.getNations();
//        List<Nation> nations = nationResponses.stream()
//                               .collect(Collectors.toList());
//    }
}
