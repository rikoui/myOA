package com.bjdreamtech.entity;

import java.util.ArrayList;
import java.util.List;

public class SysLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysLogExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(String value) {
            addCriterion("LOG_ID =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(String value) {
            addCriterion("LOG_ID <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(String value) {
            addCriterion("LOG_ID >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_ID >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(String value) {
            addCriterion("LOG_ID <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(String value) {
            addCriterion("LOG_ID <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLike(String value) {
            addCriterion("LOG_ID like", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotLike(String value) {
            addCriterion("LOG_ID not like", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<String> values) {
            addCriterion("LOG_ID in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<String> values) {
            addCriterion("LOG_ID not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(String value1, String value2) {
            addCriterion("LOG_ID between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(String value1, String value2) {
            addCriterion("LOG_ID not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogSystemIsNull() {
            addCriterion("LOG_SYSTEM is null");
            return (Criteria) this;
        }

        public Criteria andLogSystemIsNotNull() {
            addCriterion("LOG_SYSTEM is not null");
            return (Criteria) this;
        }

        public Criteria andLogSystemEqualTo(String value) {
            addCriterion("LOG_SYSTEM =", value, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemNotEqualTo(String value) {
            addCriterion("LOG_SYSTEM <>", value, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemGreaterThan(String value) {
            addCriterion("LOG_SYSTEM >", value, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_SYSTEM >=", value, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemLessThan(String value) {
            addCriterion("LOG_SYSTEM <", value, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemLessThanOrEqualTo(String value) {
            addCriterion("LOG_SYSTEM <=", value, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemLike(String value) {
            addCriterion("LOG_SYSTEM like", value, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemNotLike(String value) {
            addCriterion("LOG_SYSTEM not like", value, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemIn(List<String> values) {
            addCriterion("LOG_SYSTEM in", values, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemNotIn(List<String> values) {
            addCriterion("LOG_SYSTEM not in", values, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemBetween(String value1, String value2) {
            addCriterion("LOG_SYSTEM between", value1, value2, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogSystemNotBetween(String value1, String value2) {
            addCriterion("LOG_SYSTEM not between", value1, value2, "logSystem");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("LOG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("LOG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(String value) {
            addCriterion("LOG_TIME =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(String value) {
            addCriterion("LOG_TIME <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(String value) {
            addCriterion("LOG_TIME >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_TIME >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(String value) {
            addCriterion("LOG_TIME <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(String value) {
            addCriterion("LOG_TIME <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLike(String value) {
            addCriterion("LOG_TIME like", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotLike(String value) {
            addCriterion("LOG_TIME not like", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<String> values) {
            addCriterion("LOG_TIME in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<String> values) {
            addCriterion("LOG_TIME not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(String value1, String value2) {
            addCriterion("LOG_TIME between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(String value1, String value2) {
            addCriterion("LOG_TIME not between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogUserIsNull() {
            addCriterion("LOG_USER is null");
            return (Criteria) this;
        }

        public Criteria andLogUserIsNotNull() {
            addCriterion("LOG_USER is not null");
            return (Criteria) this;
        }

        public Criteria andLogUserEqualTo(String value) {
            addCriterion("LOG_USER =", value, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserNotEqualTo(String value) {
            addCriterion("LOG_USER <>", value, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserGreaterThan(String value) {
            addCriterion("LOG_USER >", value, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_USER >=", value, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserLessThan(String value) {
            addCriterion("LOG_USER <", value, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserLessThanOrEqualTo(String value) {
            addCriterion("LOG_USER <=", value, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserLike(String value) {
            addCriterion("LOG_USER like", value, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserNotLike(String value) {
            addCriterion("LOG_USER not like", value, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserIn(List<String> values) {
            addCriterion("LOG_USER in", values, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserNotIn(List<String> values) {
            addCriterion("LOG_USER not in", values, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserBetween(String value1, String value2) {
            addCriterion("LOG_USER between", value1, value2, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogUserNotBetween(String value1, String value2) {
            addCriterion("LOG_USER not between", value1, value2, "logUser");
            return (Criteria) this;
        }

        public Criteria andLogContentIsNull() {
            addCriterion("LOG_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andLogContentIsNotNull() {
            addCriterion("LOG_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andLogContentEqualTo(String value) {
            addCriterion("LOG_CONTENT =", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotEqualTo(String value) {
            addCriterion("LOG_CONTENT <>", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentGreaterThan(String value) {
            addCriterion("LOG_CONTENT >", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_CONTENT >=", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLessThan(String value) {
            addCriterion("LOG_CONTENT <", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLessThanOrEqualTo(String value) {
            addCriterion("LOG_CONTENT <=", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLike(String value) {
            addCriterion("LOG_CONTENT like", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotLike(String value) {
            addCriterion("LOG_CONTENT not like", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentIn(List<String> values) {
            addCriterion("LOG_CONTENT in", values, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotIn(List<String> values) {
            addCriterion("LOG_CONTENT not in", values, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentBetween(String value1, String value2) {
            addCriterion("LOG_CONTENT between", value1, value2, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotBetween(String value1, String value2) {
            addCriterion("LOG_CONTENT not between", value1, value2, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogRemarkIsNull() {
            addCriterion("LOG_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andLogRemarkIsNotNull() {
            addCriterion("LOG_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andLogRemarkEqualTo(String value) {
            addCriterion("LOG_REMARK =", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkNotEqualTo(String value) {
            addCriterion("LOG_REMARK <>", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkGreaterThan(String value) {
            addCriterion("LOG_REMARK >", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_REMARK >=", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkLessThan(String value) {
            addCriterion("LOG_REMARK <", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkLessThanOrEqualTo(String value) {
            addCriterion("LOG_REMARK <=", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkLike(String value) {
            addCriterion("LOG_REMARK like", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkNotLike(String value) {
            addCriterion("LOG_REMARK not like", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkIn(List<String> values) {
            addCriterion("LOG_REMARK in", values, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkNotIn(List<String> values) {
            addCriterion("LOG_REMARK not in", values, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkBetween(String value1, String value2) {
            addCriterion("LOG_REMARK between", value1, value2, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkNotBetween(String value1, String value2) {
            addCriterion("LOG_REMARK not between", value1, value2, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogIpIsNull() {
            addCriterion("LOG_IP is null");
            return (Criteria) this;
        }

        public Criteria andLogIpIsNotNull() {
            addCriterion("LOG_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLogIpEqualTo(String value) {
            addCriterion("LOG_IP =", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotEqualTo(String value) {
            addCriterion("LOG_IP <>", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpGreaterThan(String value) {
            addCriterion("LOG_IP >", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_IP >=", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpLessThan(String value) {
            addCriterion("LOG_IP <", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpLessThanOrEqualTo(String value) {
            addCriterion("LOG_IP <=", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpLike(String value) {
            addCriterion("LOG_IP like", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotLike(String value) {
            addCriterion("LOG_IP not like", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpIn(List<String> values) {
            addCriterion("LOG_IP in", values, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotIn(List<String> values) {
            addCriterion("LOG_IP not in", values, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpBetween(String value1, String value2) {
            addCriterion("LOG_IP between", value1, value2, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotBetween(String value1, String value2) {
            addCriterion("LOG_IP not between", value1, value2, "logIp");
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