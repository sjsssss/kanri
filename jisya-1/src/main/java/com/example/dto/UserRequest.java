package com.example.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {
	@NotEmpty(message = "名前を入力してください")
	  @Size(max = 255, message = "社員番号は255桁以内で入力してください")
	  private String GUIDE_ID;
	
	  @Size(max = 255, message = "名前は255桁以内で入力してください")
	  private String GUIDE_NAME;

	  @Size(max = 255, message = "番号は255桁以内で入力してください")
	  private String CAR_NUM;
	  
	  @Size(max = 255, message = "車は255桁以内で入力してください")
	  private String CAR_NAME;
	  
	  @Size(max = 255, message = "始発駅は255桁以内で入力してください")
	  private String START_PLACE;
	  
	  @Size(max = 255, message = "確認方法は255桁以内で入力してください")
	  private String CHECK_TYPE;
	  
	  
	  private Boolean ENOUGH_SLEEP;
	  
	  @Size(max = 255, message = "出発確認は255桁以内で入力してください")
	  private String DEPARTURE_DETECTOR;
	  
	
	  @Size(max = 255, message = "出発確認の名前は255桁以内で入力してください")
	  private String DEPARTURE_CHECKNAME;
	  
	  @Size(max = 255, message = "到着地域は255桁以内で入力してください")
	  private String END_PLACE;
	  
}