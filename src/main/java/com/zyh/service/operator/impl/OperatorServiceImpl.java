package com.zyh.service.operator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.operator.ZyhOperatorRecordMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.operator.ZyhOperatorRecord;
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

}
