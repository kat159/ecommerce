package com.ecommerce.common.constant;

import com.ecommerce.common.validation.annotation.StringEnum;

/**
 * constant
 */
public interface Constant {
    int SUCCESS = 1;
    int FAIL = 0;
    String ASC = "asc";
    String DESC = "desc";
    String CREATE_DATE = "create_date";
    String SQL_FILTER = "sqlFilter";
    /**
     * Received page variable name from font-end
     */
    String PAGE = "current";
    /**
     * Received limit variable name from font-end
     */
    String LIMIT = "pageSize";
    /**
     * field name to be sorted
     */
    String ORDER_FIELD = "orderField";
    /**
     * order method (asc or desc)
     */
    String ORDER = "order";
    /**
     * used to store list of element into a column
     */
    String STRING_SEPARATOR = "<----->";
    String TOKEN_HEADER = "token";
    String CLOUD_STORAGE_CONFIG_KEY = "CLOUD_STORAGE_CONFIG_KEY";


    enum ScheduleStatus {
        PAUSE(0),
        NORMAL(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    enum CloudService {
        AWS(1),
        AZURE(2),
        GOOGLE(3),
        ORACLE(4);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}