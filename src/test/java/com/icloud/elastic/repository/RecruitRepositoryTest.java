package com.icloud.elastic.repository;

import com.icloud.elastic.model.Recruit;
import com.icloud.elastic.model.Saramin;
import org.elasticsearch.search.sort.SortBuilders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

@SpringBootTest
class RecruitRepositoryTest {

    @Autowired
    RecruitRepository repository;

    @Autowired
    SaraminRepository saraminRepository;

    @ParameterizedTest(name = "코드 : {0}")
    @ValueSource(strings = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11"})
    void 동의어_처리_테스트(String mainCode) throws Exception {
        repository.findByMainName(mainCode)
                .stream()
                .map(Recruit::getMainName)
                .distinct()
                .forEach(System.err::println);
    }

    @Test
    void save_test() throws Exception {
        Saramin saramin = Saramin.builder()
                .id("saramin_41149694")
                .categoryBusiness("test")
                .build();

        saraminRepository.save(saramin);
    }

    @Test
    void search_test() throws Exception {
        NativeSearchQueryBuilder query = new NativeSearchQueryBuilder()
                .withQuery(
                        termQuery("source", "saramin")
                )
                .withSort(SortBuilders.scoreSort());


    }


}