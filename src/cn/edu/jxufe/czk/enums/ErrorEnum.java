package cn.edu.jxufe.czk.enums;

public enum ErrorEnum {
	
	//异常列表
	UNKNOWN_ERROR(1,"未知错误"),
	FIND_NULL(0,"未查到任何数�?"),
	FIND_ERROR(101,"查询异常"),
	ADD_FAIL(102,"添加失败"),
	DELETE_FAIL(103,"删除失败"),
	EDIT_FAIL(104,"修改失败"),
	CHECK_FAIL(105);    //单独用错误码构构造是为了适配错误消息会变化的情况
	
	
	//1、自定义枚举属类型
	private Integer code;
	private String msg;
	
	private ErrorEnum(Integer code) {
		this.code = code;
	}
	private ErrorEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	
	
}
