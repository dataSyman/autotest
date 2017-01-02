package com.hp.cmcc.bboss.autotesting.po;

public class autotesting_checkgroup {
	/**
	 * 输出检查编号（Autotesting_Case表中标记为1的需要关联该表）
	 */
	private Long check_group_id;
	/**
	 * 测试案例编号
	 */
	private Long test_case_id;
	/**
	 * 执行步骤编号
	 */
	private Long step_id;
	/**
	 * 检查信息编号
	 */
	private Long operation_id;

	public Long getOperation_id() {
		return operation_id;
	}

	public void setOperation_id(Long operation_id) {
		this.operation_id = operation_id;
	}

	public Long getCheck_group_id() {
		return check_group_id;
	}

	public void setCheck_group_id(Long check_group_id) {
		this.check_group_id = check_group_id;
	}

	public Long getTest_case_id() {
		return test_case_id;
	}

	public void setTest_case_id(Long test_case_id) {
		this.test_case_id = test_case_id;
	}

	public Long getStep_id() {
		return step_id;
	}

	public void setStep_id(Long step_id) {
		this.step_id = step_id;
	}


}
