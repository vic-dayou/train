package com.yhn.train.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryDto {
  
  private String userName;
  private Integer age;
  private Date startDate;
  private Date endDate;
  private Integer pageNum;
  private Integer pageSize;
  
}
