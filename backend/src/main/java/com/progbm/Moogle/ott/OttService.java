package com.progbm.Moogle.ott;

import com.progbm.Moogle.tmdb.TmdbService;
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
    private final TmdbService tmdbService;
    private final String IMAGE_URL = "https://image.tmdb.org/t/p/original";

    public void saveOtts() {
        Set<Integer> savedOttTmdbIds = ottRepository.findAll().stream().map(Ott::getProviderId).collect(Collectors.toSet());

        OttResponse ottResponses = tmdbService.getOtts();
        // TODO : 필터 기능 추가
        List<Ott> ottList = ottResponses.getResults().stream().map(
                ottResponse -> Ott.builder().ott((ottResponse.getProviderName())).providerId(ottResponse.getProviderId()).thumbnailUrl(IMAGE_URL + ottResponse.getLogoPath()).build())
                .collect(Collectors.toList());
        ottList = ottList.stream().filter(ott -> !savedOttTmdbIds.contains(ott.getProviderId())).collect(Collectors.toList());
        ottRepository.saveAll(ottList);
    }

    @Transactional(readOnly = true)
    public List<Ott> getOtts() {
        return ottRepository.findAll();
    }
}
