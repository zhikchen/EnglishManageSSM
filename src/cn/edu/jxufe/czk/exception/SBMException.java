package cn.edu.jxufe.czk.exception;

import cn.edu.jxufe.czk.enums.ErrorEnum;

/**
 * 
 * @author chenz
 *�����Զ����쳣�и�С���ɣ��Ǿ��Ǽ̳�RuntimeException��������Exception
 * ԭ���ǣ�
 * 1��ʹ��RuntimeException���ǲ����ֶ���עthrows��ʡ��
 * 2��ʹ��RuntimeException��Spring��������������ָ��Ҳ��ع������Excption����
 * 3��ʹ��RuntimeException����Ҳ�̳���Exception��
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
