package com.darkzill.springbeckendpoli;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RawatJlDrService {
    List<Map<String, Object>> findRawatJlDrByParameters(String startDate, String endDate, String kdDokter);
}
