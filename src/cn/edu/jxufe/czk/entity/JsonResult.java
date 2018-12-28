package cn.edu.jxufe.czk.entity;

import java.util.List;

import com.github.pagehelper.PageInfo;


public class JsonResult<T>{
    public static final int SUCCESS=0;
    
    private int state;
    private String message = "";
    private T data;
    private List<T> datas;
    //改造：适配PageHelper
    private PageInfo<T> pagedatas;   
    //改造：适配bootstrap-table ：下面连个属性只需要get方法
    private long total;  //总记录数   
    private List<T> rows;  //数据 
    
    public JsonResult(String message) {
        this.state = SUCCESS;
        this.message = message;
    }
    
    public JsonResult(T data) {
    	this.state = SUCCESS;
		this.data = data;
	}
    
    public JsonResult(List<T> datas) {
    	this.state = SUCCESS;
		this.datas = datas;
	}
    
    public JsonResult(PageInfo<T> pagedatas) {
    	this.state = SUCCESS;
		this.pagedatas = pagedatas;
	}

	public JsonResult(int state, String message) {
		this.state = state;
		this.message = message;
	}

	public JsonResult(int state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }
    
	public JsonResult(int state, String message, List<T> datas) {
		this.state = state;
		this.message = message;
		this.datas = datas;
	} 
	
    public JsonResult(int state, String message, PageInfo<T> pagedatas) {
		this.state = state;
		this.message = message;
		this.pagedatas = pagedatas;
	} 

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public PageInfo<T> getPagedatas() {
		return pagedatas;
	}

	public void setPagedatas(PageInfo<T> pagedatas) {
		this.pagedatas = pagedatas;
	}

	//适配bootstrap-table
	public long getTotal() {
		return pagedatas!=null?pagedatas.getTotal():0;
	}

	public List<T> getRows() {
		return pagedatas!=null?pagedatas.getList():null;
	}

	
    
}
