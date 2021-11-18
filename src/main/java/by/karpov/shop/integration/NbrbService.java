package by.karpov.shop.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NbrbService {
private final NbrbClient nbrbClient;

    public NbrbRate getRate(Long id){
        NbrbResponse rate = nbrbClient.getRate(id);
        return NbrbRate.builder()
                .curName(rate.getCurName())
                .curOfficialRate(rate.getCurOfficialRate())
                .curNameEng(rate.getCurNameEng())
                .build();
    }
}
