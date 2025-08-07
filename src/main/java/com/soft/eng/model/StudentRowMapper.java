package com.soft.eng.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    /**
     * @param rs Database resultset
     * @param rowNum Database row number
     * @return student object mapped with database
     */


    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student student = new Student();
        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        return student;
    }
}
