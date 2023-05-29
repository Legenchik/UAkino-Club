package com.tg.UAkino.Club.DateBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesPopularyRepository extends CrudRepository<MoviesPopulary, Long> {
}
