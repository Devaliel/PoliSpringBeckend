package com.darkzill.springbeckendpoli;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RawatJlDrServiceImpl implements RawatJlDrService {
    private final RawatJlDrRepository rawatJlDrRepository;

    public RawatJlDrServiceImpl(RawatJlDrRepository rawatJlDrRepository) {
        this.rawatJlDrRepository = rawatJlDrRepository;
    }

    @Override
    public List<Map<String, Object>> findRawatJlDrByParameters(String startDate, String endDate, String kdDokter) {
        return rawatJlDrRepository.findRawatJlDrByParameters(startDate, endDate, kdDokter);
    }
}
