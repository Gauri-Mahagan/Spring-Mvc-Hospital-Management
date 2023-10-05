package dao;

import domain.SearchDoctors;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
//this is dao layer

public class SearchDoctorsDao {
    JdbcTemplate jdbcTemplate;

    public void setTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public SearchDoctors getDoctorsByName(String doctorsName) throws SQLException {

        String sql = "select * from DoctorsDetails Where  doctorName=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{doctorsName},
                new BeanPropertyRowMapper<SearchDoctors>(SearchDoctors.class));
    }
    public SearchDoctors getDoctorByRegistrationNumber(String doctorRegistrationNumber) throws SQLException {

        String sql = "select * from DoctorsDetails Where  doctorRegistrationNumber=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{doctorRegistrationNumber},
                new BeanPropertyRowMapper<SearchDoctors>(SearchDoctors.class));
    }

    public SearchDoctors getDoctorByQualification(String qualification) throws SQLException {

        String sql = "select * from DoctorsDetails Where  qualification=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{qualification},
                new BeanPropertyRowMapper<SearchDoctors>(SearchDoctors.class));
    }

    public SearchDoctors getDoctorByGender(String gender) throws SQLException {

        String sql = "select * from DoctorsDetails Where  gender=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{gender},
                new BeanPropertyRowMapper<SearchDoctors>(SearchDoctors.class));
    }

}
