package com.progbm.Moogle.nation;

import com.progbm.Moogle.tmdb.TmdbService;
import com.progbm.Moogle.tmdb.response.NationResponse;
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

    public void insertNations() {
        List<NationResponse> nationResponses = tmdbService.getNations();
        List<Nation> nations = nationResponses.stream()
                .map(nationResponse -> Nation.builder().nationCode((nationResponse.getIso_3166_1())).nation(nationResponse.getNative_name()).build())
                .collect(Collectors.toList());
        nationRepository.saveAll(nations);
    }

    public List<Nation> getNations() { return nationRepository.findAll(); }
}
