package com.dbs.common.util;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by aiqbal on 6/24/2016.
 */
public class DateFactory {

        //yyyyMMdd format
        public static final String YYYYMMDD = "yyyyMMdd";

        //ddMMyyyy format
        public static final String DDMMYYYY = "ddMMyyyy";

        //ddMMMyyyy : 02-DEC-2008
        public static final String DD_MMM_YYYY = "dd-MMM-yyyy";

        //ddMMyy : 02/10/16
        public static final String DD_MM_YY_SLASH = "dd/MM/yy";

        //ddMMyy : 2016/10/16
        public static final String YYYY_MM_DD_SLASH = "yyyy/MM/dd";

        //H:mm:ss format
        public static final String HMMSS = "H:mm:ss";

        //yyyyMMddHHmmss format
        public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

        //yyyyMMddHHmmssSS format
        public static final String YYYYMMDDHHMMSSSS = "yyyyMMddHHmmssSS";

        //ddMMyyyy : 02-12-2008
        public static final String DD_MM_YYYY = "dd-MM-yyyy";

        //Month name
        public static final String MMMM = "MMMM";

        //Synergize filename format
        public static final String MMDDYYYYHHMMSSSS = "MMddYYYYHHmmssSS";

        //PGA HS Excel format
        public static final String MMDDYYYY = "MM/dd/YYYY";

        /**
         * Get current time.
         *
         * @return
         * @author Asif Iqbal
         */
        public static Date getCurrentTime() {

                return Calendar.getInstance().getTime();
        }

        /**
         * Get current time.
         *
         * @return
         * @author Asif Iqbal
         */
        public static long getCurrentTimeInMilliSeconds() {

                return new Date().getTime();
        }

        /**
         * Number of days between dates.
         *
         * @param fromDate
         * @param toDate
         * @return
         * @author Asif Iqbal
         */
        public static int getNumberOfDays(final LocalDate fromDate, final LocalDate toDate) {

                return Period.between(fromDate, toDate).getDays();
        }

        /**
         * Get current local date.
         *
         * @return
         * @author Asif Iqbal
         */
        public static LocalDate getCurrentLocalDate() {

                return LocalDate.now();
        }

        /**
         * Get current local date.
         *
         * @return
         * @author Asif Iqbal
         */
        public static Date getCurrentDate() {

                return new Date();
        }

        /**
         * Get current sql date.
         *
         * @return
         * @author Asif Iqbal
         */
        public static java.sql.Date getCurrentSqlDate() {

                return new java.sql.Date(getCurrentDate().getTime());
        }

        /**
         * Get current local date.
         *
         * @return
         * @author Asif Iqbal
         */
        public static LocalDate asLocalDate(Date date) {

                Instant instant = Instant.ofEpochMilli(date.getTime());
                return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                    .toLocalDate();
        }

        /**
        * @author aiqbal
        * @param localDate
        * @return
        */
        public static Date asDate(LocalDate localDate) {

                return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        }

        public static java.sql.Date convertUtilToSqlDate(final Date utilDate){

                return new java.sql.Date(utilDate.getTime());
        }

        public static java.sql.Date convertLocalDateToSqlDate(final LocalDate localDate){

                return java.sql.Date.valueOf(localDate);
        }

        public static LocalDate addDaysToLocalDate(final LocalDate localDate, final Long numberOfDays) {

                return localDate.plusDays(numberOfDays);
        }

        public static LocalDate minusDaysToLocalDate(final LocalDate localDate, final Long numberOfDays) {

                return localDate.minusDays(numberOfDays);
        }

        public static LocalDateTime getLocalDateTime(){

                return LocalDateTime.now();
        }

        public static long numberOfWeekdaysBetween(final Date start, final Date end) {

                final Calendar c1 = GregorianCalendar.getInstance();
                c1.setTime(start);
                int w1 = c1.get(Calendar.DAY_OF_WEEK);
                c1.add(Calendar.DAY_OF_WEEK, -w1 + 1);

                final Calendar c2 = GregorianCalendar.getInstance();
                c2.setTime(end);
                int w2 = c2.get(Calendar.DAY_OF_WEEK);
                c2.add(Calendar.DAY_OF_WEEK, -w2 + 1);

                //end Saturday to start Saturday
                final long days = (c2.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 * 60 * 24);
                final long daysWithoutSunday = days - (days * 2 / 7);

                if (w1 == Calendar.SUNDAY) {
                    w1 = Calendar.MONDAY;
                }
                if (w2 == Calendar.SUNDAY) {
                    w2 = Calendar.MONDAY;
                }
                return daysWithoutSunday - w1 + w2;
       }

        public static int getCurrentYear(){
                final Calendar calendar = GregorianCalendar.getInstance();
                return calendar.get(Calendar.YEAR);
        }
}
