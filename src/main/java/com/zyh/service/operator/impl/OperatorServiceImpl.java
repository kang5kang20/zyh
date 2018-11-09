package com.zyh.service.operator.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.controller.statis.vo.OperatorStatisVO;
import com.zyh.dao.operator.ZyhOperatorRecordMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.operator.ZyhOperatorRecord;
import com.zyh.entity.operator.ZyhOperatorRecordExample;
import com.zyh.service.operator.IOperatorService;

@Service("operatorServiceImpl")
public class OperatorServiceImpl implements IOperatorService{

	@Autowired
	private ZyhOperatorRecordMapper zyhOperatorRecordMapper;
	
	@Override
	public void addOperator(ZyhOperatorRecord zyhOperatorRecord) throws Exception {
		if (null==zyhOperatorRecord.getId()||"".equals(zyhOperatorRecord.getId())) {
			String id = UUidUtil.getUUid();
			zyhOperatorRecord.setId(id);
		}
		zyhOperatorRecordMapper.insertSelective(zyhOperatorRecord);
	}

	@Override
	public long countByExam(ZyhOperatorRecordExample zyhOperatorRecordExample) throws Exception {
		return zyhOperatorRecordMapper.countByExample(zyhOperatorRecordExample);
	}

	@Override
	public List<OperatorStatisVO> selectOperatorStatisByDay(String startDate, String endDate) throws Exception {
		return zyhOperatorRecordMapper.selectOperatorStatisByDay(startDate, endDate);
	}

	
}
