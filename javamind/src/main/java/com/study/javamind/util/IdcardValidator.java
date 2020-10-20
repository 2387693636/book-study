package com.study.javamind.util;


import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <p>
 * 类说明:身份证合法性校验
 * </p>
 * <p>
 * --15位身份证号码：第7、8位为出生年份(两位数)，第9、10位为出生月份，第11、12位代表出生日期，第15位代表性别，奇数为男，偶数为女。
 * --18位身份证号码
 * ：第7、8、9、10位为出生年份(四位数)，第11、第12位为出生月份，第13、14位代表出生日期，第17位代表性别，奇数为男，偶数为女。
 * </p>
 */
public class IdcardValidator
{
    /**
     * 省，直辖市代码表： { 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",
     * 21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
     * 33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",
     * 42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
     * 51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",
     * 63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}
     */
    protected static String[][] codeAndCity = { { "11", "北京" }, { "12", "天津" }, { "13", "河北" }, { "14", "山西" }, { "15", "内蒙古" },
            { "21", "辽宁" }, { "22", "吉林" }, { "23", "黑龙江" }, { "31", "上海" }, { "32", "江苏" }, { "33", "浙江" }, { "34", "安徽" },
            { "35", "福建" }, { "36", "江西" }, { "37", "山东" }, { "41", "河南" }, { "42", "湖北" }, { "43", "湖南" }, { "44", "广东" },
            { "45", "广西" }, { "46", "海南" }, { "50", "重庆" }, { "51", "四川" }, { "52", "贵州" }, { "53", "云南" }, { "54", "西藏" },
            { "61", "陕西" }, { "62", "甘肃" }, { "63", "青海" }, { "64", "宁夏" }, { "65", "新疆" }, { "71", "台湾" }, { "81", "香港" },
            { "82", "澳门" }, { "91", "国外" } };

    private static String[] cityCode = { "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37",
            "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71", "81", "82",
            "91" };

    // 每位加权因子
    private static int[] power = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

    public static final Map<Integer, String> idCheckCodeMap = MapTool.getMap(Integer.class, String.class, 
            10,"2",
            9,"3",
            8,"4",
            7,"5",
            6,"6",
            5,"7",
            4,"8",
            3,"9",
            2,"x",
            1,"0",
            0,"1"
            );
    // 第18位校检码
    // private static String verifyCode[] = { "1", "0", "X", "9", "8", "7", "6",
    // "5", "4", "3", "2" };

    /**
     * 验证所有的身份证的合法性
     * 
     * @param idcard
     * @return
     * @throws Exception 
     */
    public static boolean isValidatedAllIdcard(String idcard) throws Exception {
        if (idcard.length() == 15) {
            return false;
        }
        return isValidate18Idcard(idcard);
    }

    /**
     * <p>
     * 判断18位身份证的合法性
     * </p>
     * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
     * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
     * <p>
     * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
     * </p>
     * <p>
     * 1.前1、2位数字表示：所在省份的代码； 2.第3、4位数字表示：所在城市的代码； 3.第5、6位数字表示：所在区县的代码；
     * 4.第7~14位数字表示：出生年、月、日； 5.第15、16位数字表示：所在地的派出所的代码；
     * 6.第17位数字表示性别：奇数表示男性，偶数表示女性；
     * 7.第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
     * </p>
     * <p>
     * 第十八位数字(校验码)的计算方法为： 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4
     * 2 1 6 3 7 9 10 5 8 4 2
     * </p>
     * <p>
     * 2.将这17位数字和系数相乘的结果相加。
     * </p>
     * <p>
     * 3.用加出来和除以11，看余数是多少？
     * </p>
     * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3
     * 2。
     * <p>
     * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
     * </p>
     * 
     * @param idcard
     * @return
     * @throws Exception 
     */
    public static boolean isValidate18Idcard(String idcard) throws Exception {
        // 非18位为假
        if (idcard.length() != 18) {
            return false;
        }
        // 获取前17位
        String idcard17 = idcard.substring(0, 17);
        // 获取第18位
        String idcard18Code = idcard.substring(17, 18);
        char[] c = null;
        String checkCode = "";
        // 是否都为数字
        if (isDigital(idcard17)) {
            c = idcard17.toCharArray();
        } else {
            return false;
        }

        // 获取生日
        String birthday = idcard17.substring(6, 14);
        String provinceid = idcard.substring(0, 2);
        // 判断是否为合法的省份
        boolean flag = false;
        for (String id : cityCode) {
            if (id.equals(provinceid)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return false;
        }
        // 该身份证生出日期在当前日期之后时为假
        Date birthdate = null;
        try {
            birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
        } catch (ParseException e) {
        }
        if (birthdate == null || new Date().before(birthdate)) {
            throw new Exception("身份证出生日期不能晚于当前日期");
        }

        if (null != c) {
            int[] bit = converCharToInt(c);
            int sum17 = getPowerSum(bit);

            // 将和值与11取模得到余数进行校验码判断
            checkCode = getCheckCodeBySum(sum17);
            // 将身份证的第18位与算出来的校码进行匹配，不相等就为假
            if (null == checkCode || !idcard18Code.equalsIgnoreCase(idcard18Code.toUpperCase())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证15位身份证的合法性,该方法验证不准确，最好是将15转为18位后再判断，该类中已提供。
     * 
     * @param idcard
     * @return
     */
    public boolean isValidate15Idcard(String idcard) {
        // 非15位为假
        if (idcard.length() != 15) {
            return false;
        }

        // 是否全都为数字
        if (isDigital(idcard)) {
            String provinceid = idcard.substring(0, 2);
            String birthday = "19" + idcard.substring(6, 12);
            // int year = Integer.parseInt(idcard.substring(6, 8));
            int month = Integer.parseInt(idcard.substring(8, 10));
            int day = Integer.parseInt(idcard.substring(10, 12));
            // 判断是否为合法的省份
            boolean flag = false;
            for (String id : cityCode) {
                if (id.equals(provinceid)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
            Date birthdate = null;
            try {
                birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
            } catch (ParseException e) {
            	System.out.println(e);
            }
            if (birthdate == null || new Date().before(birthdate) || month < 1 || month > 12) {
                return false;
            }

            // 判断是否为合法的年份
            GregorianCalendar curDay = new GregorianCalendar();

            // 判断是否为合法的日期
            boolean mflag = false;
            curDay.setTime(birthdate); // 将该身份证的出生日期赋于对象curDay
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    mflag = (day >= 1 && day <= 31);
                    break;
                case 2: // 公历的2月非闰年有28天,闰年的2月是29天。
                    mflag = curDay.isLeapYear(curDay.get(Calendar.YEAR)) ? (day >= 1 && day <= 29) : (day >= 1 && day <= 28);
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    mflag = (day >= 1 && day <= 30);
                    break;
                default:
            }
            if (!mflag) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 将15位的身份证转成18位身份证
     * 
     * @param idcard
     * @return
     * @throws Exception 
     */
    public String convertIdcarBy15bit(String idcard) throws Exception {
        String idcard17 = null;
        // 非15位身份证
        if (idcard.length() != 15) {
            return null;
        }

        if (isDigital(idcard)) {
            // 获取出生年月日
            String birthday = "19" + idcard.substring(6, 12);
            Date birthdate = null;
            try {
                birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
            } catch (ParseException e) {
                throw new Exception("出生日期非法");
            }
            Calendar cday = Calendar.getInstance();
            cday.setTime(birthdate);
            String year = String.valueOf(cday.get(Calendar.YEAR));

            idcard17 = idcard.substring(0, 6) + year + idcard.substring(8);

            char[] c = idcard17.toCharArray();
            String checkCode = "";

            if (null != c) {
                int[] bit = null;
                // new int[idcard17.length()];

                // 将字符数组转为整型数组
                bit = converCharToInt(c);
                int sum17 = 0;
                sum17 = getPowerSum(bit);

                // 获取和值与11取模得到余数进行校验码
                checkCode = getCheckCodeBySum(sum17);
                // 获取不到校验位
                if (null == checkCode) {
                    return null;
                }

                // 将前17位与第18位校验码拼接
                idcard17 += checkCode;
            }
        } else { // 身份证包含数字
            return null;
        }
        return idcard17;
    }

    /**
     * 15位和18位身份证号码的基本数字和位数验校
     * 
     * @param idcard
     * @return
     */
    public boolean isIdcard(String idcard) {
        return idcard == null || "".equals(idcard) ? false : Pattern.matches("(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)", idcard);
    }

    /**
     * 15位身份证号码的基本数字和位数验校
     * 
     * @param idcard
     * @return
     */
    public boolean is15Idcard(String idcard) {
        return idcard == null || "".equals(idcard) ? false
                : Pattern.matches("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$", idcard);
    }

    /**
     * 18位身份证号码的基本数字和位数验校
     * 
     * @param idcard
     * @return
     */
    public boolean is18Idcard(String idcard) {
        return Pattern.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$", idcard);
    }

    /**
     * 数字验证
     * 
     * @param str
     * @return
     */
    public static boolean isDigital(String str) {
        return str == null || "".equals(str) ? false : str.matches("^[0-9]*$");
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     * 
     * @param bit
     * @return
     */
    public static int getPowerSum(int[] bit) {

        int sum = 0;

        if (power.length != bit.length) {
            return sum;
        }

        for (int i = 0; i < bit.length; i++) {
            for (int j = 0; j < power.length; j++) {
                if (i == j) {
                    sum = sum + bit[i] * power[j];
                }
            }
        }
        return sum;
    }
  
    /**
     * 将和值与11取模得到余数进行校验码判断
     * 
     * @param checkCode
     * @param sum17
     * @return 校验位
     */
    public static String getCheckCodeBySum(int sum17) {
        return idCheckCodeMap.get(sum17 % 11);
    }

    /**
     * 将字符数组转为整型数组
     * 
     * @param c
     * @return
     * @throws NumberFormatException
     */
    public static int[] converCharToInt(char[] c){
        int[] a = new int[c.length];
        int k = 0;
        for (char temp : c) {
            a[k++] = Integer.parseInt(String.valueOf(temp));
        }
        return a;
    }

    /**
     * 
     * 根据身份证号获取实际年龄. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年11月21日 下午2:49:14
     * @version 1.0
     *
     * @param idCard
     * @return
     */
    public static Integer getAgeByIdCard(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return 0;
        }
        Integer age = 0;
        try {
            Integer year = Integer.parseInt(idCard.substring(6, 10));
            Integer month = Integer.parseInt(idCard.substring(10, 12));
            Integer day = Integer.parseInt(idCard.substring(12, 14));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            Integer currYear = calendar.get(Calendar.YEAR);
            Integer currMonth = calendar.get(Calendar.MONTH) + 1;
            Integer currDay = calendar.get(Calendar.DAY_OF_MONTH);
            age = currYear - year;
            if ((currMonth - month < 0) || (currMonth - month == 0 && currDay - day < 0)) {
                age -= 1;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

        return age < 0 ? 0 : age;
    }

    /**
     * 
     * 通过身份证获取出生日期. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年11月21日 下午5:39:10
     * @version 1.0
     *
     * @param idCard
     * @return
     * @throws ParseException
     */
    public static Date getBirthdayByIdCard(String idCard) {
        try {
            if (idCard == null || !isValidatedAllIdcard(idCard)) {
                return null;
            }
            idCard = idCard.toUpperCase();
            String birthDate = idCard.substring(6, 14);
            return DateTool.getSimpleDate().parse(birthDate);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * 
     * 根据身份证获取性别. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年11月29日 上午11:29:13
     * @version 1.0
     *
     * @param idCard
     * @return
     */
    public static String getSexByIdCard(String idCard) {
        if (StringUtils.isBlank(idCard) || idCard.length() != 18) {
            return null;
        }
        String ss = idCard.substring(16, 17);
        if (!StringUtils.isNumeric(ss)) {
            return null;
        }
        if (Integer.parseInt(ss) == 0 || Integer.parseInt(ss) % 2 == 0) {
            return "F";
        } else {
            return "M";
        }
    }
}
