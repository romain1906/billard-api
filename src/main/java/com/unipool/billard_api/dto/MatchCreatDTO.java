package com.unipool.billard_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchCreatDTO {
    private Long player1Id;
    private Long player2Id;
    private Long createBy;


}
