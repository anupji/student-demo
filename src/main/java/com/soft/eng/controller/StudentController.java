package com.soft.eng.controller;

import com.soft.eng.model.Student;
import com.soft.eng.model.StudentRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    /**
     * @Controller StudentController as RestController
     *
     */

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public StudentController(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello student";
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = jdbcTemplate.query("SELECT * FROM STUDENT", new StudentRowMapper());
        return ResponseEntity.ok().body(students);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        int updated = jdbcTemplate.update("DELETE FROM student WHERE id= :id",
                new MapSqlParameterSource().addValue("id", id)
        );
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        try {
            Student student = jdbcTemplate.queryForObject("SELECT * FROM student WHERE id= :id",
                    new MapSqlParameterSource()
                            .addValue("id", id),
                    new StudentRowMapper()
            );

            if (student == null) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok().body(student);

        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/students")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
        int updated = jdbcTemplate.update("UPDATE student SET name = :name WHERE id= :id",
                new MapSqlParameterSource()
                        .addValue("id", student.getId())
                        .addValue("name", student.getName())
        );
        return ResponseEntity.ok().build();
    }

    @PostMapping("/students")
    public ResponseEntity<Void> createStudent(@RequestBody Student student){
        int updated = jdbcTemplate.update("INSERT INTO STUDENT(id, name) VALUES(:id, :name)",
                new MapSqlParameterSource()
                        .addValue("id", student.getId())
                        .addValue("name", student.getName())
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
