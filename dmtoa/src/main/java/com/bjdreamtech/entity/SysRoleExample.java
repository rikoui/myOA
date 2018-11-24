package com.bjdreamtech.entity;

import java.util.ArrayList;
import java.util.List;

public class SysRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("ROLE_ID like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("ROLE_ID not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("ROLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("ROLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("ROLE_NAME =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("ROLE_NAME <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("ROLE_NAME >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("ROLE_NAME <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("ROLE_NAME like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("ROLE_NAME not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("ROLE_NAME in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("ROLE_NAME not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("ROLE_NAME between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("ROLE_NAME not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionIsNull() {
            addCriterion("ROLE_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionIsNotNull() {
            addCriterion("ROLE_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionEqualTo(String value) {
            addCriterion("ROLE_DESCRIPTION =", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionNotEqualTo(String value) {
            addCriterion("ROLE_DESCRIPTION <>", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionGreaterThan(String value) {
            addCriterion("ROLE_DESCRIPTION >", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_DESCRIPTION >=", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionLessThan(String value) {
            addCriterion("ROLE_DESCRIPTION <", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionLessThanOrEqualTo(String value) {
            addCriterion("ROLE_DESCRIPTION <=", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionLike(String value) {
            addCriterion("ROLE_DESCRIPTION like", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionNotLike(String value) {
            addCriterion("ROLE_DESCRIPTION not like", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionIn(List<String> values) {
            addCriterion("ROLE_DESCRIPTION in", values, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionNotIn(List<String> values) {
            addCriterion("ROLE_DESCRIPTION not in", values, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionBetween(String value1, String value2) {
            addCriterion("ROLE_DESCRIPTION between", value1, value2, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionNotBetween(String value1, String value2) {
            addCriterion("ROLE_DESCRIPTION not between", value1, value2, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleStatusIsNull() {
            addCriterion("ROLE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andRoleStatusIsNotNull() {
            addCriterion("ROLE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRoleStatusEqualTo(String value) {
            addCriterion("ROLE_STATUS =", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusNotEqualTo(String value) {
            addCriterion("ROLE_STATUS <>", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusGreaterThan(String value) {
            addCriterion("ROLE_STATUS >", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_STATUS >=", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusLessThan(String value) {
            addCriterion("ROLE_STATUS <", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusLessThanOrEqualTo(String value) {
            addCriterion("ROLE_STATUS <=", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusLike(String value) {
            addCriterion("ROLE_STATUS like", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusNotLike(String value) {
            addCriterion("ROLE_STATUS not like", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusIn(List<String> values) {
            addCriterion("ROLE_STATUS in", values, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusNotIn(List<String> values) {
            addCriterion("ROLE_STATUS not in", values, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusBetween(String value1, String value2) {
            addCriterion("ROLE_STATUS between", value1, value2, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusNotBetween(String value1, String value2) {
            addCriterion("ROLE_STATUS not between", value1, value2, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeIsNull() {
            addCriterion("ROLE_CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeIsNotNull() {
            addCriterion("ROLE_CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeEqualTo(String value) {
            addCriterion("ROLE_CREATETIME =", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeNotEqualTo(String value) {
            addCriterion("ROLE_CREATETIME <>", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeGreaterThan(String value) {
            addCriterion("ROLE_CREATETIME >", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_CREATETIME >=", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeLessThan(String value) {
            addCriterion("ROLE_CREATETIME <", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("ROLE_CREATETIME <=", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeLike(String value) {
            addCriterion("ROLE_CREATETIME like", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeNotLike(String value) {
            addCriterion("ROLE_CREATETIME not like", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeIn(List<String> values) {
            addCriterion("ROLE_CREATETIME in", values, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeNotIn(List<String> values) {
            addCriterion("ROLE_CREATETIME not in", values, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeBetween(String value1, String value2) {
            addCriterion("ROLE_CREATETIME between", value1, value2, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeNotBetween(String value1, String value2) {
            addCriterion("ROLE_CREATETIME not between", value1, value2, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserIsNull() {
            addCriterion("ROLE_CREATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserIsNotNull() {
            addCriterion("ROLE_CREATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserEqualTo(String value) {
            addCriterion("ROLE_CREATEUSER =", value, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserNotEqualTo(String value) {
            addCriterion("ROLE_CREATEUSER <>", value, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserGreaterThan(String value) {
            addCriterion("ROLE_CREATEUSER >", value, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_CREATEUSER >=", value, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserLessThan(String value) {
            addCriterion("ROLE_CREATEUSER <", value, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserLessThanOrEqualTo(String value) {
            addCriterion("ROLE_CREATEUSER <=", value, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserLike(String value) {
            addCriterion("ROLE_CREATEUSER like", value, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserNotLike(String value) {
            addCriterion("ROLE_CREATEUSER not like", value, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserIn(List<String> values) {
            addCriterion("ROLE_CREATEUSER in", values, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserNotIn(List<String> values) {
            addCriterion("ROLE_CREATEUSER not in", values, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserBetween(String value1, String value2) {
            addCriterion("ROLE_CREATEUSER between", value1, value2, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateuserNotBetween(String value1, String value2) {
            addCriterion("ROLE_CREATEUSER not between", value1, value2, "roleCreateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeIsNull() {
            addCriterion("ROLE_UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeIsNotNull() {
            addCriterion("ROLE_UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeEqualTo(String value) {
            addCriterion("ROLE_UPDATETIME =", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotEqualTo(String value) {
            addCriterion("ROLE_UPDATETIME <>", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeGreaterThan(String value) {
            addCriterion("ROLE_UPDATETIME >", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_UPDATETIME >=", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeLessThan(String value) {
            addCriterion("ROLE_UPDATETIME <", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("ROLE_UPDATETIME <=", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeLike(String value) {
            addCriterion("ROLE_UPDATETIME like", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotLike(String value) {
            addCriterion("ROLE_UPDATETIME not like", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeIn(List<String> values) {
            addCriterion("ROLE_UPDATETIME in", values, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotIn(List<String> values) {
            addCriterion("ROLE_UPDATETIME not in", values, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeBetween(String value1, String value2) {
            addCriterion("ROLE_UPDATETIME between", value1, value2, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("ROLE_UPDATETIME not between", value1, value2, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserIsNull() {
            addCriterion("ROLE_UPDATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserIsNotNull() {
            addCriterion("ROLE_UPDATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserEqualTo(String value) {
            addCriterion("ROLE_UPDATEUSER =", value, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserNotEqualTo(String value) {
            addCriterion("ROLE_UPDATEUSER <>", value, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserGreaterThan(String value) {
            addCriterion("ROLE_UPDATEUSER >", value, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_UPDATEUSER >=", value, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserLessThan(String value) {
            addCriterion("ROLE_UPDATEUSER <", value, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("ROLE_UPDATEUSER <=", value, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserLike(String value) {
            addCriterion("ROLE_UPDATEUSER like", value, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserNotLike(String value) {
            addCriterion("ROLE_UPDATEUSER not like", value, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserIn(List<String> values) {
            addCriterion("ROLE_UPDATEUSER in", values, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserNotIn(List<String> values) {
            addCriterion("ROLE_UPDATEUSER not in", values, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserBetween(String value1, String value2) {
            addCriterion("ROLE_UPDATEUSER between", value1, value2, "roleUpdateuser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateuserNotBetween(String value1, String value2) {
            addCriterion("ROLE_UPDATEUSER not between", value1, value2, "roleUpdateuser");
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