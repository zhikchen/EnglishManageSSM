package cn.edu.jxufe.czk.exception;

import cn.edu.jxufe.czk.enums.ErrorEnum;

/**
 * 
 * @author chenz
 *这里自定义异常有个小技巧，那就是继承RuntimeException，而不是Exception
 * 原因是：
 * 1、使用RuntimeException我们不用手动标注throws，省事
 * 2、使用RuntimeException在Spring事务中无需特殊指定也会回滚，这点Excption不行
 * 3、使用RuntimeException本身也继承了Exception。
 */
public class SBMException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer code;

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public SBMException(String message) {
		super(message);
	}
	public SBMException(Integer code,String message) {
		super(message);
		this.code = code;
	}
	public SBMException(ErrorEnum errorEnum) {
		super(errorEnum.getMsg());
		this.code = errorEnum.getCode();
	}
	
	
	
}
