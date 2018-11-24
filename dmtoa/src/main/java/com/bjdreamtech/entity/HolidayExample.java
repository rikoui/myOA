package com.bjdreamtech.entity;

import java.util.ArrayList;
import java.util.List;

public class HolidayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HolidayExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andHolidayIdIsNull() {
            addCriterion("HOLIDAY_ID is null");
            return (Criteria) this;
        }

        public Criteria andHolidayIdIsNotNull() {
            addCriterion("HOLIDAY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayIdEqualTo(String value) {
            addCriterion("HOLIDAY_ID =", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdNotEqualTo(String value) {
            addCriterion("HOLIDAY_ID <>", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdGreaterThan(String value) {
            addCriterion("HOLIDAY_ID >", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdGreaterThanOrEqualTo(String value) {
            addCriterion("HOLIDAY_ID >=", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdLessThan(String value) {
            addCriterion("HOLIDAY_ID <", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdLessThanOrEqualTo(String value) {
            addCriterion("HOLIDAY_ID <=", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdLike(String value) {
            addCriterion("HOLIDAY_ID like", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdNotLike(String value) {
            addCriterion("HOLIDAY_ID not like", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdIn(List<String> values) {
            addCriterion("HOLIDAY_ID in", values, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdNotIn(List<String> values) {
            addCriterion("HOLIDAY_ID not in", values, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdBetween(String value1, String value2) {
            addCriterion("HOLIDAY_ID between", value1, value2, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdNotBetween(String value1, String value2) {
            addCriterion("HOLIDAY_ID not between", value1, value2, "holidayId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}