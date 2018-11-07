package com.zyh.service.operator;

import com.zyh.entity.operator.ZyhOperatorRecord;
import com.zyh.entity.operator.ZyhOperatorRecordExample;

public interface IOperatorService {

	public void addOperator(ZyhOperatorRecord zyhOperatorRecord)throws Exception;
	
	public long countByExam(ZyhOperatorRecordExample zyhOperatorRecordExample)throws Exception;
}
