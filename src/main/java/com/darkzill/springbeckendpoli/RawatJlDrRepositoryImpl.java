package com.darkzill.springbeckendpoli;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RawatJlDrRepositoryImpl implements RawatJlDrRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    public RawatJlDrRepositoryImpl(JdbcTemplate jdbcTemplate, ObjectMapper objectMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Map<String, Object>> findRawatJlDrByParameters(String startDate, String endDate, String kdDokter) {
        String query = "SELECT reg_periksa.no_reg, reg_periksa.no_rawat, reg_periksa.tgl_registrasi, reg_periksa.jam_reg, " +
                "reg_periksa.kd_dokter, dokter.nm_dokter, reg_periksa.no_rkm_medis, pasien.nm_pasien, poliklinik.nm_poli, " +
                "reg_periksa.p_jawab, reg_periksa.almt_pj, reg_periksa.hubunganpj, reg_periksa.biaya_reg, reg_periksa.stts, " +
                "penjab.png_jawab, CONCAT(reg_periksa.umurdaftar, ' ', reg_periksa.sttsumur) AS umur, " +
                "reg_periksa.status_bayar, reg_periksa.status_poli, reg_periksa.kd_pj, reg_periksa.kd_poli, pasien.no_tlp " +
                "FROM reg_periksa " +
                "INNER JOIN dokter ON reg_periksa.kd_dokter = dokter.kd_dokter " +
                "INNER JOIN pasien ON reg_periksa.no_rkm_medis = pasien.no_rkm_medis " +
                "INNER JOIN poliklinik ON reg_periksa.kd_poli = poliklinik.kd_poli " +
                "INNER JOIN penjab ON reg_periksa.kd_pj = penjab.kd_pj " +
                "WHERE reg_periksa.tgl_registrasi BETWEEN ? AND ? " +
                "AND reg_periksa.status_lanjut = 'Ralan' " +
                "AND reg_periksa.kd_dokter = ? " +
                "ORDER BY reg_periksa.no_rawat DESC";

        return jdbcTemplate.queryForList(query, startDate, endDate, kdDokter);
    }


}
