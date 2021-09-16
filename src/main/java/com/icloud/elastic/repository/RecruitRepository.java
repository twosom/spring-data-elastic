package com.icloud.elastic.repository;


import com.icloud.elastic.model.Recruit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface RecruitRepository extends ElasticsearchRepository<Recruit, String> {
    List<Recruit> findByMainName(String mainCode);

    Recruit findByPositionId(String positionId);
}
