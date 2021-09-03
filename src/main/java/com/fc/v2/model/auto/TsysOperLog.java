package com.fc.v2.model.auto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.ApiModelProperty;

public class TsysOperLog implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "")
	private String id;
	
	@ApiModelProperty(value = "Title")
	private String title;
	
	@ApiModelProperty(value = "Method")
	private String method;
	
	@ApiModelProperty(value = "Operator Name")
	private String operName;
	
	@ApiModelProperty(value = "URL")
	private String operUrl;
	
	@ApiModelProperty(value = "Parameters")
	private String operParam;
	
	@ApiModelProperty(value = "Error Message")
	private String errorMsg;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "Operation time")
	private Date operTime;
	
	@ApiModelProperty(value = "operator")
	private String operator;
	
	@ApiModelProperty(value = "IP")
	private String ip;
	
	@ApiModelProperty(value = "Action")
	private String action;
	
	@ApiModelProperty(value = "Channel")
	private String channel;
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id =  id;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title =  title;
	}
	@JsonProperty("method")
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method =  method;
	}
	@JsonProperty("operName")
	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName =  operName;
	}
	@JsonProperty("operUrl")
	public String getOperUrl() {
		return operUrl;
	}

	public void setOperUrl(String operUrl) {
		this.operUrl =  operUrl;
	}
	@JsonProperty("operParam")
	public String getOperParam() {
		return operParam;
	}

	public void setOperParam(String operParam) {
		this.operParam =  operParam;
	}
	@JsonProperty("errorMsg")
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg =  errorMsg;
	}
	@JsonProperty("operTime")
	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime =  operTime;
	}
	@JsonProperty("operator")
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator =  operator;
	}
	@JsonProperty("ip")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip =  ip;
	}
	@JsonProperty("action")
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action =  action;
	}
	@JsonProperty("channel")
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel =  channel;
	}

																								
	public TsysOperLog(String id,String title,String method,String operName,String operUrl,String operParam,String errorMsg,Date operTime,String operator,String ip,String action,String channel) {
				
		this.id = id;
				
		this.title = title;
				
		this.method = method;
				
		this.operName = operName;
				
		this.operUrl = operUrl;
				
		this.operParam = operParam;
				
		this.errorMsg = errorMsg;
				
		this.operTime = operTime;
				
		this.operator = operator;
				
		this.ip = ip;
				
		this.action = action;
				
		this.channel = channel;
				
	}

	public TsysOperLog() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}