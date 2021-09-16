package com.icloud.elastic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "saramin")
public class Saramin {

    @Id
    private String id;
    private String recruitUrl;
    private String externalRecruitUrl;
    private List<String> employmentType = new ArrayList<>();
    private String subject;
    private LocalDateTime created;
    private String companyName;
    private List<String> description = new ArrayList<>();
    private String finished;
    private String source;
    private List<String> welfare = new ArrayList<>();
    private String mainCode;
    private String categoryBusiness;
    private String positionId;
    private String subCode;
    private String workArea;
    private String subName;
    private List<String> companyInformation = new ArrayList<>();
    private String companyAddress;
    private String mainName;
    private String position;
    private List<String> hashtag = new ArrayList<>();
    private String homepage;

}
