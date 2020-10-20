package com.study.javamind.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author 刘忠奇
 *
 */
public class DateTool
{
    private static final String[] WEEK_DAYS = new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
    private static final String[] SIMPLE_WEEK_DAYS = new String[] { "日", "一", "二", "三", "四", "五", "六" };
    
    private static ThreadLocal<SimpleDateFormat> fullDateTimeSss = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
    };
    private static ThreadLocal<SimpleDateFormat> fullDateTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    private static ThreadLocal<SimpleDateFormat> fullDate = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    private static ThreadLocal<SimpleDateFormat> fullTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss");
        }
    };
    private static ThreadLocal<SimpleDateFormat> simpleDateTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmss");
        }
    };
    private static ThreadLocal<SimpleDateFormat> simpleDate = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
    private static ThreadLocal<SimpleDateFormat> simpleTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HHmmss");
        }
    };

    private static ThreadLocal<SimpleDateFormat> otherFormatFullDateTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        }
    };
    private static ThreadLocal<SimpleDateFormat> otherFormatDate = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd");
        }
    };
    private static ThreadLocal<SimpleDateFormat> otherFormatTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss");
        }
    };

    private static ThreadLocal<SimpleDateFormat> chineseFullDateTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        }
    };
    private static ThreadLocal<SimpleDateFormat> chineseFullDate = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy年MM月dd日");
        }
    };
    private static ThreadLocal<SimpleDateFormat> chineseFullTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss");
        }
    };

    /**
     * 时间格式如："2016-09-06 12:06:06.123"
     * 
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat getFullDateTimeSss() {
        return fullDateTimeSss.get();
    }

    /**
     * 时间格式如："2016-09-06 12:06:06"
     * 
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat getFullDateTime() {
        return fullDateTime.get();
    }

    /**
     * 时间格式如："2016-09-06"
     * 
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat getFullDate() {
        return fullDate.get();
    }

    /**
     * 时间格式如："12:06:06"
     * 
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat getFullTime() {
        return fullTime.get();
    }

    /**
     * 时间格式如："20160906120606"
     * 
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat getSimpleDateTime() {
        return simpleDateTime.get();
    }

    /**
     * 时间格式如："20160906"
     * 
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat getSimpleDate() {
        return simpleDate.get();
    }

    /**
     * 时间格式如："120606"
     * 
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat getSimpleTime() {
        return simpleTime.get();
    }

    /**
     * 
     * 带斜杠的日期格式. <br/>
     * 
     * @author liujingcheng
     * @date: 2017年1月3日 下午4:51:24
     * @version 1.0
     *
     * @return 2017/01/01 12:00:00
     */
    public static SimpleDateFormat getOtherFormatDateTime() {
        return otherFormatFullDateTime.get();
    }

    /**
     * 
     * 带斜杠的日期格式. <br/>
     * 
     * @author liujingcheng
     * @date: 2017年1月3日 下午4:51:24
     * @version 1.0
     *
     * @return 2017/01/01
     */
    public static SimpleDateFormat getOtherFormatDate() {
        return otherFormatDate.get();
    }

    /**
     * 
     * 带斜杠的日期格式. <br/>
     * 
     * @author liujingcheng
     * @date: 2017年1月3日 下午4:51:24
     * @version 1.0
     *
     * @return 12:00:00
     */
    public static SimpleDateFormat getOtherFormatTime() {
        return otherFormatTime.get();
    }

    /**
     * 
     * 带斜杠的日期格式. <br/>
     * 
     * @author liujingcheng
     * @date: 2017年1月3日 下午4:51:24
     * @version 1.0
     *
     * @return 2017年01月01日 12:00:00
     */
    public static SimpleDateFormat getChinesetDateTime() {
        return chineseFullDateTime.get();
    }

    /**
     * 
     * 带斜杠的日期格式. <br/>
     * 
     * @author liujingcheng
     * @date: 2017年1月3日 下午4:51:24
     * @version 1.0
     *
     * @return 2017年01月01日
     */
    public static SimpleDateFormat getChinesetDate() {
        return chineseFullDate.get();
    }

    /**
     * 
     * 带斜杠的日期格式. <br/>
     * 
     * @author liujingcheng
     * @date: 2017年1月3日 下午4:51:24
     * @version 1.0
     *
     * @return 12:00:00
     */
    public static SimpleDateFormat getChineseTime() {
        return chineseFullTime.get();
    }

    /**
     * 
     * 获取指定日期是星期几. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年10月19日 上午10:29:54
     * @version 1.0
     *
     * @param date
     * @return
     */
    public static String getWeekName(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int num = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (num < 0) {
            num = 0;
        }
        return WEEK_DAYS[num];
    }

    /**
     * 
     * 获取星期的简称. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年11月2日 上午11:42:13
     * @version 1.0
     *
     * @param date
     * @return
     */
    public static String getSimpleWeekName(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int num = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (num < 0) {
            num = 0;
        }
        return SIMPLE_WEEK_DAYS[num];
    }

    /**
     * 
     * 获取当前日期为多少号. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年11月1日 下午3:33:30
     * @version 1.0
     *
     * @param date
     * @return
     */
    public static Integer getMonthDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 判断是否是今天
     * 
     * @author liuzhongqi
     * @date: 2016年11月16日 下午2:52:22
     * @version 1.0
     *
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        return getSimpleDate().format(new Date()).equals(getSimpleDate().format(date));
    }

    /**
     * 
     * 获取date日，n天的时间. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年12月2日 上午11:33:45
     * @version 1.0
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextDate(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, n);
        return c.getTime();
    }
    

	/**
	 * 获取下n天0点整
	 * @param date
	 * @return
	 */
    public static  Date getNextDateZero(Date date,int n) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		if(n!=0)
			cal.add(Calendar.DAY_OF_MONTH, n);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

    /**
     * 
     * 获取n小时后的时间. <br/>
     * 
     * @author liujingcheng
     * @date: 2017年3月28日 下午10:05:13
     * @version 1.0
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextHour(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, n);
        return c.getTime();
    }

    /**
     * 
     * 获取n分钟后的时间. <br/>
     * 
     * @author liujingcheng
     * @date: 2017年3月28日 下午10:06:00
     * @version 1.0
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextMini(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, n);
        return c.getTime();
    }

    /**
     * 
     * 获取n秒后的数据. <br/>
     * 
     * @author liujingcheng
     * @date: 2017年3月28日 下午10:07:16
     * @version 1.0
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextSecond(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, n);
        return c.getTime();
    }


    public static Date getBeginTime(String timeStr) {
        if (StringUtils.isEmpty(timeStr)) {
            return null;
        }

        try {
            Date date = DateUtils.parseDate(timeStr + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
            return date;
        } catch (Exception e) {
            return null;
        }
    }


    public static Date getEndTime(String timeStr) {
        if (StringUtils.isEmpty(timeStr)) {
            return null;
        }

        try {
            Date date = DateUtils.parseDate(timeStr + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
            return date;
        } catch (Exception e) {
            return null;
        }
    }


    public static Date parseDate(String dateStr,String ... patterns)
    {
        try {
            return  DateUtils.parseDate(dateStr,patterns);
        } catch (ParseException e) {
           throw new IllegalArgumentException("时间格式错误");
        }
    }


    public static Date parseDateNoException(String dateStr,String ... patterns)
    {
        try {
            return  DateUtils.parseDate(dateStr,patterns);
        } catch (Exception e) {
           //
        }
        return  null;

    }

    public static Date parseDateNoException(String dateStr,Date defaultDate,String ... patterns)
    {
        try {
            return  DateUtils.parseDate(dateStr,patterns);
        } catch (Exception e) {
            //
        }
        return  defaultDate;

    }


    public static String getBeginTimeToStr(String beginTime) {
        if(StringUtils.isNotEmpty(beginTime))
        {
            return beginTime;
        }
        try
        {
           Date date= DateUtils.parseDate(beginTime,"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss");

           return DateFormatUtils.format(date,"yyyy-MM-dd 00:00:00");
        }
        catch (Exception e)
        {
            return null;
        }
    }


    public static String getEndTimeToStr(String endTime) {
        if (StringUtils.isNotEmpty(endTime)) {
            return endTime;
        }
        try {
            Date date = DateUtils.parseDate(endTime, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss");

            return DateFormatUtils.format(date, "yyyy-MM-dd 00:00:00");
        } catch (Exception e) {
            return null;
        }
    }
}