package com.tg.UAkino.Club.DateBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Анотація яка показує Sping Boot що це БД
public interface MoviesRepository extends CrudRepository<Movies, Long> { //Інтерфейс для взаємодії з БД
}
