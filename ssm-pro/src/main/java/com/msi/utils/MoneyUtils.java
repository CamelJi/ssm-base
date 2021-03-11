package com.msi.utils;

import java.text.DecimalFormat;

public class MoneyUtils {
    private static final String DOLLARS = "DOLLARS";
    private static final String DOLLAR = "DOLLAR";
    private static final String CENTS = "CENTS";
    private static final String CENT = "CENT";
    private static final String BILLION = "BILLION";
    private static final String MILLION = "MILLION";
    private static final String THOUSAND = "THOUSAND";
    private static final String HUNDRED = "HUNDRED";
    private static final String ZERO = "ZERO";
    private static final String ONLY = "ONLY";
    private static final int ONE_BILLION = 1000000000;
    private static final int ONE_MILLION = 1000000;
    private static final int ONE_THOUSAND = 1000;

    private MoneyUtils() {
    }

    public static String toChinese(int iFee, String iCurrency) {
        return toChinese((double)iFee, iCurrency);
    }

    public static String toChinese(long iFee, String iCurrency) {
        return toChinese((double)iFee, iCurrency);
    }

    public static String toChinese(double iFee, String iCurrency) {
        String strChineseMoney = "";
        String strNumber = "              ";
        String strFee = "";
        String strThat = "";
        boolean intLength = false;
        boolean i = false;
        boolean j = false;
        if(iCurrency == null || iCurrency.length() == 0) {
            iCurrency = "CNY";
        }

        if(iFee < 0.0D) {
            throw new IllegalArgumentException("金额不能为负");
        } else if(iFee == 0.0D) {
            return strChineseMoney;
        } else {
            strFee = (new DecimalFormat("0")).format(iFee * 100.0D);
            int var10 = strFee.length();
            if(var10 > 14) {
                throw new IllegalArgumentException("金额超出范围");
            } else {
                strNumber = strNumber.substring(0, 14 - var10) + strFee;

                for(int var11 = 14 - var10; var11 < 14; ++var11) {
                    int var12 = (new Integer(strNumber.substring(var11, var11 + 1))).intValue();
                    if(var12 > 0) {
                        strChineseMoney = strChineseMoney.trim() + strThat.trim() + getUpperChineseDigit(var12).trim() + getUpperChineseUnit(var11, iCurrency);
                        strThat = "";
                    } else if(strChineseMoney.length() != 0) {
                        if(var11 == 11) {
                            strChineseMoney = strChineseMoney + getUpperChineseUnit(11, iCurrency);
                        } else if(var11 == 7 && !strNumber.substring(4, 8).equals("0000")) {
                            strChineseMoney = strChineseMoney + "万";
                        } else if(var11 == 3 && !strNumber.substring(0, 4).equals("0000")) {
                            strChineseMoney = strChineseMoney + "亿";
                        }

                        if(var11 < 11 || var11 == 12) {
                            strThat = getUpperChineseDigit(0);
                        }
                    }
                }

                if(strChineseMoney.endsWith("拾")) {
                    strChineseMoney = strChineseMoney + "分";
                }

                if(strChineseMoney.endsWith("圆")) {
                    strChineseMoney = strChineseMoney + "整";
                }

                if(strChineseMoney.endsWith("角")) {
                    strChineseMoney = strChineseMoney + "整";
                }

                return strChineseMoney;
            }
        }
    }

    public static String getUpperChineseDigit(int iDigit) {
        String strUpperChineseDigit = "";
        String strUpperChineseChar = "零壹贰叁肆伍陆柒捌玖";
        if(iDigit > 9) {
            throw new IllegalArgumentException("金额超出范围");
        } else if(iDigit < 0) {
            throw new IllegalArgumentException("金额不能为负");
        } else {
            strUpperChineseDigit = strUpperChineseChar.substring(iDigit, iDigit + 1);
            return strUpperChineseDigit;
        }
    }

    private static String getUpperChineseUnit(int iPoint, String iCurrency) {
        String strUpperChineseUnit = "";
        String strUpperChineseUnitChar = "";
        if(iPoint > 13) {
            throw new IllegalArgumentException("金额超出范围");
        } else if(iPoint < 0) {
            throw new IllegalArgumentException("金额不能为负");
        } else {
            iCurrency = iCurrency.trim();
            if(iCurrency.equals("CNY")) {
                strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾圆角分";
            } else if(iCurrency.equals("HKD")) {
                strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾圆角分";
            } else if(iCurrency.equals("JPY")) {
                strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾圆角分";
            } else if(iCurrency.equals("GBP")) {
                strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾镑先令便士";
            } else {
                strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾圆拾分";
            }

            strUpperChineseUnit = strUpperChineseUnitChar.substring(iPoint, iPoint + 1);
            return strUpperChineseUnit;
        }
    }

    public static String getUpperEnglishDigit(int iFee) {
        String[] strTemp = new String[]{"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};
        if(iFee <= 27 && iFee >= 0) {
            return strTemp[iFee];
        } else {
            throw new IllegalArgumentException("Array index overflow!");
        }
    }

    private static double getInt(double iFee, int iLen) {
        String strFee = "";
        boolean index = false;
        strFee = (new DecimalFormat("0.00")).format(iFee);
        int index1 = strFee.indexOf(".");
        strFee = strFee.substring(0, index1 - iLen);
        return Double.parseDouble(strFee);
    }

    private static double getDecimal(double iFee, int iLen) {
        String strFee = "";
        boolean index = false;
        strFee = (new DecimalFormat("0.00")).format(iFee);
        int index1 = strFee.indexOf(".");
        strFee = strFee.substring(index1 - iLen);
        return Double.parseDouble(strFee);
    }

    private static String format_99(int iFee) {
        String strOutFee = "";
        boolean i = false;
        boolean j = false;
        if(iFee > 0 && iFee < 100) {
            if(iFee <= 20) {
                strOutFee = getUpperEnglishDigit(iFee);
            } else {
                int j1 = (new Double((double)(iFee / 10))).intValue();
                strOutFee = getUpperEnglishDigit(j1 + 18);
                int i1 = iFee - 10 * j1;
                if(i1 != 0) {
                    strOutFee = strOutFee + " " + getUpperEnglishDigit(i1);
                }
            }
        } else {
            strOutFee = "";
        }

        return strOutFee;
    }

    private static String format_999(double iFee) {
        String strOutFee = "";
        boolean i = false;
        boolean j = false;
        if(iFee >= 0.0D && iFee < 1000.0D) {
            int i1 = (new Double(iFee / 100.0D)).intValue();
            int j1 = (new Double(iFee)).intValue() % 100;
            strOutFee = format_99(j1);
            if(i1 != 0) {
                if(strOutFee.length() > 0 && !strOutFee.substring(0, 1).equals(" ")) {
                    strOutFee = " AND " + strOutFee;
                }

                strOutFee = getUpperEnglishDigit(i1) + " " + "HUNDRED" + strOutFee;
            }
        } else {
            strOutFee = "";
        }

        return strOutFee;
    }

    private static String formatToEnglish(double iFee) {
        String strOutFee = "";
        String strTmpFee = "";
        if(iFee < 0.0D) {
            strOutFee = formatToEnglish(-iFee);
            strOutFee = "MINUS " + strOutFee;
            return strOutFee;
        } else if(iFee < 1.0D) {
            strOutFee = "ZERO";
            return strOutFee;
        } else {
            if(iFee >= 1.0E9D) {
                strOutFee = formatToEnglish(getInt(iFee, 9));
                strTmpFee = formatToEnglish(getDecimal(iFee, 9));
                if(!strTmpFee.equals("ZERO")) {
                    strTmpFee = " " + strTmpFee;
                }

                if(strTmpFee.indexOf("MILLION") > -1) {
                    strOutFee = strOutFee + " " + "BILLION" + strTmpFee;
                } else {
                    strOutFee = strOutFee + " " + "BILLION" + " AND " + strTmpFee;
                }
            } else if(iFee >= 1000000.0D && iFee < 1.0E9D) {
                strOutFee = format_999(getInt(iFee, 6));
                strTmpFee = formatToEnglish(getDecimal(iFee, 6));
                if(!strTmpFee.equals("ZERO")) {
                    strTmpFee = " " + strTmpFee;
                }

                if(strTmpFee.indexOf("THOUSAND") > -1) {
                    strOutFee = strOutFee + " " + "MILLION" + strTmpFee;
                } else {
                    strOutFee = strOutFee + " " + "MILLION" + " AND " + strTmpFee;
                }
            } else if(iFee >= 1000.0D && iFee < 1000000.0D) {
                strOutFee = format_999(getInt(iFee, 3));
                strTmpFee = formatToEnglish(getDecimal(iFee, 3));
                if(!strTmpFee.equals("ZERO")) {
                    strTmpFee = " " + strTmpFee;
                }

                if(strTmpFee.indexOf("HUNDRED") > -1) {
                    strOutFee = strOutFee + " " + "THOUSAND" + strTmpFee;
                } else {
                    strOutFee = strOutFee + " " + "THOUSAND" + " AND " + strTmpFee;
                }
            } else if(iFee >= 1.0D && iFee < 1000.0D) {
                strOutFee = format_999(iFee);
            }

            return strOutFee;
        }
    }

    public static String toEnglish(double iFee) {
        String strOutFee = "";
        String strFee = "";
        String strCent = "";
        String strTmpFee = "";
        boolean i = false;
        if(iFee < 0.0D) {
            throw new IllegalArgumentException("Money can not be negative!");
        } else {
            strFee = (new DecimalFormat("0")).format(iFee * 100.0D);
            int i1 = strFee.length();
            if(i1 > 14) {
                throw new IllegalArgumentException("Money exceeds its range(fourteen digits)!");
            } else {
                if(iFee == 0.0D) {
                    strOutFee = "ZERO";
                }

                strCent = "CENTS";
                strOutFee = formatToEnglish(getInt(iFee, 0));
                strTmpFee = formatToEnglish(ComputeUtil.round(getDecimal(iFee, 0) * 100.0D, 0));
                if(strTmpFee.equals(getUpperEnglishDigit(1))) {
                    strCent = "CENT";
                }

                if(!strTmpFee.equals("ZERO")) {
                    if(strOutFee.equals("ZERO")) {
                        strOutFee = strTmpFee + " " + strCent;
                    } else {
                        strOutFee = strOutFee + " AND " + strCent + " " + strTmpFee;
                    }
                }

                strOutFee = strOutFee + " ONLY";
                return strOutFee;
            }
        }
    }

    public static String toEnglish(int iFee) {
        return toEnglish((double)iFee);
    }

    public static String toEnglish(long iFee) {
        return toEnglish((double)iFee);
    }

    public static String toAccount(String strMoney) {
        String formatMoney = "";
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        formatMoney = decimalFormat.format(ComputeUtil.round(Double.valueOf(strMoney).doubleValue(), 2));
        return formatMoney;
    }
}
