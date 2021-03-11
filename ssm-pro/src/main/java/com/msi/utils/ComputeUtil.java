package com.msi.utils;


import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author zyh
 * @Date 2020/12/30
 * @Description 计算工具类
 */
public class ComputeUtil {

    private static final BigDecimal ONE = new BigDecimal("1");

    /**
     * 比较 num1 与 num2
     * @param num1
     * @param num2
     * @return 0 - 等于   -1 - 小于   1 - 大于
     */
    public static int compare(Double num1, Double num2){
        if(num1 - num2 > 0.00000001){
            return 1;
        }else if(num2 - num1 > 0.00000001){
            return -1;
        }
        return 0;
    }

    /**
     * 计算add
     * @param v1
     * @param v2
     * @return
     */
    public  static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        BigDecimal addSum = b1.add(b2);
        return addSum.doubleValue();
    }

    public static double round(double value, int scale) {
        BigDecimal b = new BigDecimal(Double.toString(value));
        return b.divide(ONE, scale, 4).doubleValue();
    }

    /**
     * 百分比计算
     * @param detailTotalNumber  销售量
     * @param totalNumber  限量库存
     * @return  百分比
     */
    public static String percentInstance(Integer detailTotalNumber, Integer totalNumber) {
        Double bfTotalNumber = Double.valueOf(detailTotalNumber);
        Double zcTotalNumber = Double.valueOf(totalNumber);
        double percent = bfTotalNumber/zcTotalNumber;
        //获取格式化对象
        NumberFormat nt = NumberFormat.getPercentInstance();
        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(2);
        return nt.format(percent);
    }

    /**
     * 百分比计算
     * @param detailTotalNumber  销售量
     * @param totalNumber  限量库存
     * @return  百分比
     */
    public static int percentInstanceIntVal(Integer detailTotalNumber, Integer totalNumber) {
        Double bfTotalNumber = Double.valueOf(detailTotalNumber);
        Double zcTotalNumber = Double.valueOf(totalNumber);
        double percent = bfTotalNumber/zcTotalNumber;
        double pec = percent * 100;
        return (int)pec;
    }
}
