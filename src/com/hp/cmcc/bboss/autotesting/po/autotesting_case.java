package com.hp.cmcc.bboss.autotesting.po;

public class autotesting_case {
	/**
	 * 测试案例编号
	 */
	private Long test_case_id;
	/**
	 * 测试案例名称
	 */
	private String test_case_name;
	/**
	 * 执行步骤编号
	 */
	private Long step_id;
	/**
	 * 报文编号
	 */
	private Long xml_file_id;
	/**
	 * 是否需要对输出结果进行检查：0-不检查/1-检查
	 */
	private int check_status;
	/**
	 * 处理标记
	 */
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getTest_case_id() {
		return test_case_id;
	}

	public void setTest_case_id(Long test_case_id) {
		this.test_case_id = test_case_id;
	}

	public String getTest_case_name() {
		return test_case_name;
	}

	public void setTest_case_name(String test_case_name) {
		this.test_case_name = test_case_name;
	}

	public Long getStep_id() {
		return step_id;
	}

	public void setStep_id(Long step_id) {
		this.step_id = step_id;
	}

	public Long getXml_file_id() {
		return xml_file_id;
	}

	public void setXml_file_id(Long xml_file_id) {
		this.xml_file_id = xml_file_id;
	}

	public int getCheck_status() {
		return check_status;
	}

	public void setCheck_status(int check_status) {
		this.check_status = check_status;
	}

}
