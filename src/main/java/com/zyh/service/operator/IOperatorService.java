package com.zyh.service.operator;

import java.util.List;

import com.zyh.controller.statis.vo.OperatorStatisVO;
import com.zyh.entity.operator.ZyhOperatorRecord;
import com.zyh.entity.operator.ZyhOperatorRecordExample;

public interface IOperatorService {

	public void addOperator(ZyhOperatorRecord zyhOperatorRecord)throws Exception;
	
	public long countByExam(ZyhOperatorRecordExample zyhOperatorRecordExample)throws Exception;
	
	public List<OperatorStatisVO> selectOperatorStatisByDay(String startDate,String endDate)throws Exception;
}
