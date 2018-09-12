package com.zyh.utils;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * 用于数据计算精度处理
 * 
 * @author yhuang
 * 
 */
@Component(value = "dataAccuracyUtil")
public class DataAccuracyUtil {

	/**
	 * double数据类型相加
	 * 
	 * @param augend
	 * @param addend
	 * @param precision
	 * @return
	 * @throws Exception
	 */
	public Double doubleAdd(Double _augend, Double _addend, Integer precision)
			throws Exception {
		BigDecimal augend = new BigDecimal(_augend);
		BigDecimal addend = new BigDecimal(_addend);

		return augend.add(addend).setScale(precision, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	/**
	 * 不固定个数的double相加
	 * 
	 * @param precision
	 * @param doubles
	 * @return
	 * @throws Exception
	 */
	public Double doubleAdd(Integer precision, Double... doubles)
			throws Exception {
		BigDecimal augend = new BigDecimal(0.00);
		for (Double _addend : doubles) {
			BigDecimal addend = new BigDecimal(_addend);
			augend = augend.add(addend);
		}
		return augend.setScale(precision, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	/**
	 * double相减
	 * 
	 * @param _minuend
	 * @param _reduc
	 * @param precision
	 * @return
	 * @throws Exception
	 */
	public Double doubleSub(Double _minuend, Double _reduc, Integer precision)
			throws Exception {
		BigDecimal minuend = new BigDecimal(_minuend);
		BigDecimal reduc = new BigDecimal(_reduc);
		return minuend.subtract(reduc)
				.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * double乘法
	 * 
	 * @param _multiplicand
	 * @param _multiplier
	 * @param precision
	 * @return
	 * @throws Exception
	 */
	public Double doubleMul(Double _multiplicand, Double _multiplier,
			Integer precision) throws Exception {
		BigDecimal multiplicand = new BigDecimal(_multiplicand);
		BigDecimal multiplier = new BigDecimal(_multiplier);
		return multiplicand.multiply(multiplier)
				.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * double除法
	 * 
	 * @param _dividend
	 * @param _divisor
	 * @param precision
	 * @return
	 * @throws Exception
	 */
	public Double doubleDiv(Double _dividend, Double _divisor, Integer precision)
			throws Exception {
		BigDecimal dividend = new BigDecimal(_dividend);
		BigDecimal divisor = new BigDecimal(_divisor);
		return dividend.divide(divisor)
				.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 格式化double类型的数据为指定精度
	 * 
	 * @param _value
	 * @param precision
	 * @return
	 * @throws Exception
	 */
	public Double doubleFormat(Double _value, Integer precision)
			throws Exception {
		BigDecimal value = new BigDecimal(_value);
		return value.setScale(precision, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}
	
	public Double String2Double(String str) {
		Double a = Double.parseDouble(str);
		BigDecimal  value   =   new   BigDecimal(a);  
		return value.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}
}
