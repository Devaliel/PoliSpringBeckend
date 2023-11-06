package com.darkzill.springbeckendpoli;

import java.util.List;
import java.util.Map;

public interface RawatJlDrRepository {
    List<Map<String, Object>> findRawatJlDrByParameters(String startDate, String endDate, String kdDokter);
}
