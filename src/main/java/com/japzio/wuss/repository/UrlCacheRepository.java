package com.japzio.wuss.repository;

import com.japzio.wuss.url.v1.dto.UrlDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlCacheRepository extends CrudRepository<UrlDto, String> {

}
