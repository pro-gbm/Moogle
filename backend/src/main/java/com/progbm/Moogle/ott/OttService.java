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

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OttService {
    private final OttRepository ottRepository;
    private final TmdbService tmdbService;

    public void insertOtts() {
    }
}
