package com.jimmie.test.fastjson;

import java.util.Date;

public class ReturnItemInfo {

	/**原料ID**/
	private Integer material_id;

	/**单位**/
	private String unit;

	/**数量**/
	private Integer quantity;
	
	/**生产日期**/
	private String manufacturing_date;
	
	public ReturnItemInfo(){
		
	}

	
	public ReturnItemInfo(Integer material_id, String unit, Integer quantity,
			String manufacturing_date) {
		super();
		this.material_id = material_id;
		this.unit = unit;
		this.quantity = quantity;
		this.manufacturing_date = manufacturing_date;
	}

	public Integer getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(Integer material_id) {
		this.material_id = material_id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getManufacturing_date() {
		return manufacturing_date;
	}

	public void setManufacturing_date(String manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}

}
