package com.example.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserSearchRequest implements Serializable {
	private Long id;
	 private String GUIDE_ID;
	 private String GUIDE_NAME;
	 private String CAR_NUM;
	 private String CAR_NAME;
	 private String START_PLACE;
	 private String CHECK_TYPE;
	 private Boolean ENOUGH_SLEEP;
	 private String DEPARTURE_DETECTOR;
	 private String DEPARTURE_CHECKNAME;
	 private String END_PLACE;
}