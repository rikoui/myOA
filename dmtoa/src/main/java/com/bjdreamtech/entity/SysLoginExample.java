package com.bjdreamtech.entity;

import java.util.ArrayList;
import java.util.List;

public class SysLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysLoginExample() {
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

        public Criteria andLoginIdIsNull() {
            addCriterion("LOGIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNotNull() {
            addCriterion("LOGIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIdEqualTo(String value) {
            addCriterion("LOGIN_ID =", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotEqualTo(String value) {
            addCriterion("LOGIN_ID <>", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThan(String value) {
            addCriterion("LOGIN_ID >", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_ID >=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThan(String value) {
            addCriterion("LOGIN_ID <", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_ID <=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLike(String value) {
            addCriterion("LOGIN_ID like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotLike(String value) {
            addCriterion("LOGIN_ID not like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdIn(List<String> values) {
            addCriterion("LOGIN_ID in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotIn(List<String> values) {
            addCriterion("LOGIN_ID not in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdBetween(String value1, String value2) {
            addCriterion("LOGIN_ID between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotBetween(String value1, String value2) {
            addCriterion("LOGIN_ID not between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdIsNull() {
            addCriterion("LOGIN_ADMIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdIsNotNull() {
            addCriterion("LOGIN_ADMIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdEqualTo(String value) {
            addCriterion("LOGIN_ADMIN_ID =", value, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdNotEqualTo(String value) {
            addCriterion("LOGIN_ADMIN_ID <>", value, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdGreaterThan(String value) {
            addCriterion("LOGIN_ADMIN_ID >", value, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_ADMIN_ID >=", value, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdLessThan(String value) {
            addCriterion("LOGIN_ADMIN_ID <", value, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_ADMIN_ID <=", value, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdLike(String value) {
            addCriterion("LOGIN_ADMIN_ID like", value, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdNotLike(String value) {
            addCriterion("LOGIN_ADMIN_ID not like", value, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdIn(List<String> values) {
            addCriterion("LOGIN_ADMIN_ID in", values, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdNotIn(List<String> values) {
            addCriterion("LOGIN_ADMIN_ID not in", values, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdBetween(String value1, String value2) {
            addCriterion("LOGIN_ADMIN_ID between", value1, value2, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginAdminIdNotBetween(String value1, String value2) {
            addCriterion("LOGIN_ADMIN_ID not between", value1, value2, "loginAdminId");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeIsNull() {
            addCriterion("LOGIN_LAST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeIsNotNull() {
            addCriterion("LOGIN_LAST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeEqualTo(String value) {
            addCriterion("LOGIN_LAST_TIME =", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeNotEqualTo(String value) {
            addCriterion("LOGIN_LAST_TIME <>", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeGreaterThan(String value) {
            addCriterion("LOGIN_LAST_TIME >", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_LAST_TIME >=", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeLessThan(String value) {
            addCriterion("LOGIN_LAST_TIME <", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_LAST_TIME <=", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeLike(String value) {
            addCriterion("LOGIN_LAST_TIME like", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeNotLike(String value) {
            addCriterion("LOGIN_LAST_TIME not like", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeIn(List<String> values) {
            addCriterion("LOGIN_LAST_TIME in", values, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeNotIn(List<String> values) {
            addCriterion("LOGIN_LAST_TIME not in", values, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeBetween(String value1, String value2) {
            addCriterion("LOGIN_LAST_TIME between", value1, value2, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeNotBetween(String value1, String value2) {
            addCriterion("LOGIN_LAST_TIME not between", value1, value2, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(String value) {
            addCriterion("LOGIN_TIME =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(String value) {
            addCriterion("LOGIN_TIME <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(String value) {
            addCriterion("LOGIN_TIME >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_TIME >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(String value) {
            addCriterion("LOGIN_TIME <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_TIME <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLike(String value) {
            addCriterion("LOGIN_TIME like", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotLike(String value) {
            addCriterion("LOGIN_TIME not like", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<String> values) {
            addCriterion("LOGIN_TIME in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<String> values) {
            addCriterion("LOGIN_TIME not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(String value1, String value2) {
            addCriterion("LOGIN_TIME between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(String value1, String value2) {
            addCriterion("LOGIN_TIME not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNull() {
            addCriterion("LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(String value) {
            addCriterion("LOGIN_IP =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(String value) {
            addCriterion("LOGIN_IP <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(String value) {
            addCriterion("LOGIN_IP >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(String value) {
            addCriterion("LOGIN_IP <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLike(String value) {
            addCriterion("LOGIN_IP like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotLike(String value) {
            addCriterion("LOGIN_IP not like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<String> values) {
            addCriterion("LOGIN_IP in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<String> values) {
            addCriterion("LOGIN_IP not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(String value1, String value2) {
            addCriterion("LOGIN_IP between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(String value1, String value2) {
            addCriterion("LOGIN_IP not between", value1, value2, "loginIp");
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