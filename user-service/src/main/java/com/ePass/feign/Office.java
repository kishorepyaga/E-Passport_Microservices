package com.ePass.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {

	private Integer id;
	private String officeName, address;
	private String juridiction;
	private Long phoneNumber;
}
