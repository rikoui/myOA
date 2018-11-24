package com.bjdreamtech.entity;

import java.util.ArrayList;
import java.util.List;

public class SysAuthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAuthExample() {
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

        public Criteria andAuthIdIsNull() {
            addCriterion("AUTH_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthIdIsNotNull() {
            addCriterion("AUTH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthIdEqualTo(String value) {
            addCriterion("AUTH_ID =", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotEqualTo(String value) {
            addCriterion("AUTH_ID <>", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThan(String value) {
            addCriterion("AUTH_ID >", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_ID >=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThan(String value) {
            addCriterion("AUTH_ID <", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThanOrEqualTo(String value) {
            addCriterion("AUTH_ID <=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLike(String value) {
            addCriterion("AUTH_ID like", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotLike(String value) {
            addCriterion("AUTH_ID not like", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdIn(List<String> values) {
            addCriterion("AUTH_ID in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotIn(List<String> values) {
            addCriterion("AUTH_ID not in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdBetween(String value1, String value2) {
            addCriterion("AUTH_ID between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotBetween(String value1, String value2) {
            addCriterion("AUTH_ID not between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdIsNull() {
            addCriterion("AUTH_ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdIsNotNull() {
            addCriterion("AUTH_ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdEqualTo(String value) {
            addCriterion("AUTH_ROLE_ID =", value, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdNotEqualTo(String value) {
            addCriterion("AUTH_ROLE_ID <>", value, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdGreaterThan(String value) {
            addCriterion("AUTH_ROLE_ID >", value, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_ROLE_ID >=", value, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdLessThan(String value) {
            addCriterion("AUTH_ROLE_ID <", value, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdLessThanOrEqualTo(String value) {
            addCriterion("AUTH_ROLE_ID <=", value, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdLike(String value) {
            addCriterion("AUTH_ROLE_ID like", value, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdNotLike(String value) {
            addCriterion("AUTH_ROLE_ID not like", value, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdIn(List<String> values) {
            addCriterion("AUTH_ROLE_ID in", values, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdNotIn(List<String> values) {
            addCriterion("AUTH_ROLE_ID not in", values, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdBetween(String value1, String value2) {
            addCriterion("AUTH_ROLE_ID between", value1, value2, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleIdNotBetween(String value1, String value2) {
            addCriterion("AUTH_ROLE_ID not between", value1, value2, "authRoleId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdIsNull() {
            addCriterion("AUTH_MENU_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdIsNotNull() {
            addCriterion("AUTH_MENU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdEqualTo(String value) {
            addCriterion("AUTH_MENU_ID =", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdNotEqualTo(String value) {
            addCriterion("AUTH_MENU_ID <>", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdGreaterThan(String value) {
            addCriterion("AUTH_MENU_ID >", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_MENU_ID >=", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdLessThan(String value) {
            addCriterion("AUTH_MENU_ID <", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdLessThanOrEqualTo(String value) {
            addCriterion("AUTH_MENU_ID <=", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdLike(String value) {
            addCriterion("AUTH_MENU_ID like", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdNotLike(String value) {
            addCriterion("AUTH_MENU_ID not like", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdIn(List<String> values) {
            addCriterion("AUTH_MENU_ID in", values, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdNotIn(List<String> values) {
            addCriterion("AUTH_MENU_ID not in", values, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdBetween(String value1, String value2) {
            addCriterion("AUTH_MENU_ID between", value1, value2, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdNotBetween(String value1, String value2) {
            addCriterion("AUTH_MENU_ID not between", value1, value2, "authMenuId");
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