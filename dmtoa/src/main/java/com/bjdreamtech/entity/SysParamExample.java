package com.bjdreamtech.entity;

import java.util.ArrayList;
import java.util.List;

public class SysParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysParamExample() {
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

        public Criteria andParamIdIsNull() {
            addCriterion("PARAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andParamIdIsNotNull() {
            addCriterion("PARAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParamIdEqualTo(String value) {
            addCriterion("PARAM_ID =", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotEqualTo(String value) {
            addCriterion("PARAM_ID <>", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdGreaterThan(String value) {
            addCriterion("PARAM_ID >", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_ID >=", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdLessThan(String value) {
            addCriterion("PARAM_ID <", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdLessThanOrEqualTo(String value) {
            addCriterion("PARAM_ID <=", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdLike(String value) {
            addCriterion("PARAM_ID like", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotLike(String value) {
            addCriterion("PARAM_ID not like", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdIn(List<String> values) {
            addCriterion("PARAM_ID in", values, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotIn(List<String> values) {
            addCriterion("PARAM_ID not in", values, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdBetween(String value1, String value2) {
            addCriterion("PARAM_ID between", value1, value2, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotBetween(String value1, String value2) {
            addCriterion("PARAM_ID not between", value1, value2, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNull() {
            addCriterion("PARAM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNotNull() {
            addCriterion("PARAM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andParamCodeEqualTo(String value) {
            addCriterion("PARAM_CODE =", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotEqualTo(String value) {
            addCriterion("PARAM_CODE <>", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThan(String value) {
            addCriterion("PARAM_CODE >", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_CODE >=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThan(String value) {
            addCriterion("PARAM_CODE <", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThanOrEqualTo(String value) {
            addCriterion("PARAM_CODE <=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLike(String value) {
            addCriterion("PARAM_CODE like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotLike(String value) {
            addCriterion("PARAM_CODE not like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeIn(List<String> values) {
            addCriterion("PARAM_CODE in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotIn(List<String> values) {
            addCriterion("PARAM_CODE not in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeBetween(String value1, String value2) {
            addCriterion("PARAM_CODE between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotBetween(String value1, String value2) {
            addCriterion("PARAM_CODE not between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNull() {
            addCriterion("PARAM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNotNull() {
            addCriterion("PARAM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameEqualTo(String value) {
            addCriterion("PARAM_NAME =", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotEqualTo(String value) {
            addCriterion("PARAM_NAME <>", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThan(String value) {
            addCriterion("PARAM_NAME >", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_NAME >=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThan(String value) {
            addCriterion("PARAM_NAME <", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThanOrEqualTo(String value) {
            addCriterion("PARAM_NAME <=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLike(String value) {
            addCriterion("PARAM_NAME like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotLike(String value) {
            addCriterion("PARAM_NAME not like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameIn(List<String> values) {
            addCriterion("PARAM_NAME in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotIn(List<String> values) {
            addCriterion("PARAM_NAME not in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameBetween(String value1, String value2) {
            addCriterion("PARAM_NAME between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotBetween(String value1, String value2) {
            addCriterion("PARAM_NAME not between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamKeyIsNull() {
            addCriterion("PARAM_KEY is null");
            return (Criteria) this;
        }

        public Criteria andParamKeyIsNotNull() {
            addCriterion("PARAM_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andParamKeyEqualTo(String value) {
            addCriterion("PARAM_KEY =", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotEqualTo(String value) {
            addCriterion("PARAM_KEY <>", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyGreaterThan(String value) {
            addCriterion("PARAM_KEY >", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_KEY >=", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyLessThan(String value) {
            addCriterion("PARAM_KEY <", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyLessThanOrEqualTo(String value) {
            addCriterion("PARAM_KEY <=", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyLike(String value) {
            addCriterion("PARAM_KEY like", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotLike(String value) {
            addCriterion("PARAM_KEY not like", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyIn(List<String> values) {
            addCriterion("PARAM_KEY in", values, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotIn(List<String> values) {
            addCriterion("PARAM_KEY not in", values, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyBetween(String value1, String value2) {
            addCriterion("PARAM_KEY between", value1, value2, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotBetween(String value1, String value2) {
            addCriterion("PARAM_KEY not between", value1, value2, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamValueIsNull() {
            addCriterion("PARAM_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andParamValueIsNotNull() {
            addCriterion("PARAM_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andParamValueEqualTo(String value) {
            addCriterion("PARAM_VALUE =", value, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueNotEqualTo(String value) {
            addCriterion("PARAM_VALUE <>", value, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueGreaterThan(String value) {
            addCriterion("PARAM_VALUE >", value, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_VALUE >=", value, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueLessThan(String value) {
            addCriterion("PARAM_VALUE <", value, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueLessThanOrEqualTo(String value) {
            addCriterion("PARAM_VALUE <=", value, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueLike(String value) {
            addCriterion("PARAM_VALUE like", value, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueNotLike(String value) {
            addCriterion("PARAM_VALUE not like", value, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueIn(List<String> values) {
            addCriterion("PARAM_VALUE in", values, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueNotIn(List<String> values) {
            addCriterion("PARAM_VALUE not in", values, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueBetween(String value1, String value2) {
            addCriterion("PARAM_VALUE between", value1, value2, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamValueNotBetween(String value1, String value2) {
            addCriterion("PARAM_VALUE not between", value1, value2, "paramValue");
            return (Criteria) this;
        }

        public Criteria andParamStatusIsNull() {
            addCriterion("PARAM_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andParamStatusIsNotNull() {
            addCriterion("PARAM_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andParamStatusEqualTo(String value) {
            addCriterion("PARAM_STATUS =", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusNotEqualTo(String value) {
            addCriterion("PARAM_STATUS <>", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusGreaterThan(String value) {
            addCriterion("PARAM_STATUS >", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_STATUS >=", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusLessThan(String value) {
            addCriterion("PARAM_STATUS <", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusLessThanOrEqualTo(String value) {
            addCriterion("PARAM_STATUS <=", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusLike(String value) {
            addCriterion("PARAM_STATUS like", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusNotLike(String value) {
            addCriterion("PARAM_STATUS not like", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusIn(List<String> values) {
            addCriterion("PARAM_STATUS in", values, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusNotIn(List<String> values) {
            addCriterion("PARAM_STATUS not in", values, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusBetween(String value1, String value2) {
            addCriterion("PARAM_STATUS between", value1, value2, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusNotBetween(String value1, String value2) {
            addCriterion("PARAM_STATUS not between", value1, value2, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionIsNull() {
            addCriterion("PARAM_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionIsNotNull() {
            addCriterion("PARAM_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionEqualTo(String value) {
            addCriterion("PARAM_DESCRIPTION =", value, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionNotEqualTo(String value) {
            addCriterion("PARAM_DESCRIPTION <>", value, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionGreaterThan(String value) {
            addCriterion("PARAM_DESCRIPTION >", value, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_DESCRIPTION >=", value, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionLessThan(String value) {
            addCriterion("PARAM_DESCRIPTION <", value, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionLessThanOrEqualTo(String value) {
            addCriterion("PARAM_DESCRIPTION <=", value, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionLike(String value) {
            addCriterion("PARAM_DESCRIPTION like", value, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionNotLike(String value) {
            addCriterion("PARAM_DESCRIPTION not like", value, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionIn(List<String> values) {
            addCriterion("PARAM_DESCRIPTION in", values, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionNotIn(List<String> values) {
            addCriterion("PARAM_DESCRIPTION not in", values, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionBetween(String value1, String value2) {
            addCriterion("PARAM_DESCRIPTION between", value1, value2, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamDescriptionNotBetween(String value1, String value2) {
            addCriterion("PARAM_DESCRIPTION not between", value1, value2, "paramDescription");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeIsNull() {
            addCriterion("PARAM_CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeIsNotNull() {
            addCriterion("PARAM_CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeEqualTo(String value) {
            addCriterion("PARAM_CREATETIME =", value, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeNotEqualTo(String value) {
            addCriterion("PARAM_CREATETIME <>", value, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeGreaterThan(String value) {
            addCriterion("PARAM_CREATETIME >", value, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_CREATETIME >=", value, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeLessThan(String value) {
            addCriterion("PARAM_CREATETIME <", value, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("PARAM_CREATETIME <=", value, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeLike(String value) {
            addCriterion("PARAM_CREATETIME like", value, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeNotLike(String value) {
            addCriterion("PARAM_CREATETIME not like", value, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeIn(List<String> values) {
            addCriterion("PARAM_CREATETIME in", values, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeNotIn(List<String> values) {
            addCriterion("PARAM_CREATETIME not in", values, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeBetween(String value1, String value2) {
            addCriterion("PARAM_CREATETIME between", value1, value2, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreatetimeNotBetween(String value1, String value2) {
            addCriterion("PARAM_CREATETIME not between", value1, value2, "paramCreatetime");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserIsNull() {
            addCriterion("PARAM_CREATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserIsNotNull() {
            addCriterion("PARAM_CREATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserEqualTo(String value) {
            addCriterion("PARAM_CREATEUSER =", value, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserNotEqualTo(String value) {
            addCriterion("PARAM_CREATEUSER <>", value, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserGreaterThan(String value) {
            addCriterion("PARAM_CREATEUSER >", value, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_CREATEUSER >=", value, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserLessThan(String value) {
            addCriterion("PARAM_CREATEUSER <", value, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserLessThanOrEqualTo(String value) {
            addCriterion("PARAM_CREATEUSER <=", value, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserLike(String value) {
            addCriterion("PARAM_CREATEUSER like", value, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserNotLike(String value) {
            addCriterion("PARAM_CREATEUSER not like", value, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserIn(List<String> values) {
            addCriterion("PARAM_CREATEUSER in", values, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserNotIn(List<String> values) {
            addCriterion("PARAM_CREATEUSER not in", values, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserBetween(String value1, String value2) {
            addCriterion("PARAM_CREATEUSER between", value1, value2, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamCreateuserNotBetween(String value1, String value2) {
            addCriterion("PARAM_CREATEUSER not between", value1, value2, "paramCreateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeIsNull() {
            addCriterion("PARAM_UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeIsNotNull() {
            addCriterion("PARAM_UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeEqualTo(String value) {
            addCriterion("PARAM_UPDATETIME =", value, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeNotEqualTo(String value) {
            addCriterion("PARAM_UPDATETIME <>", value, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeGreaterThan(String value) {
            addCriterion("PARAM_UPDATETIME >", value, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_UPDATETIME >=", value, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeLessThan(String value) {
            addCriterion("PARAM_UPDATETIME <", value, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("PARAM_UPDATETIME <=", value, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeLike(String value) {
            addCriterion("PARAM_UPDATETIME like", value, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeNotLike(String value) {
            addCriterion("PARAM_UPDATETIME not like", value, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeIn(List<String> values) {
            addCriterion("PARAM_UPDATETIME in", values, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeNotIn(List<String> values) {
            addCriterion("PARAM_UPDATETIME not in", values, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeBetween(String value1, String value2) {
            addCriterion("PARAM_UPDATETIME between", value1, value2, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("PARAM_UPDATETIME not between", value1, value2, "paramUpdatetime");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserIsNull() {
            addCriterion("PARAM_UPDATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserIsNotNull() {
            addCriterion("PARAM_UPDATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserEqualTo(String value) {
            addCriterion("PARAM_UPDATEUSER =", value, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserNotEqualTo(String value) {
            addCriterion("PARAM_UPDATEUSER <>", value, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserGreaterThan(String value) {
            addCriterion("PARAM_UPDATEUSER >", value, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_UPDATEUSER >=", value, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserLessThan(String value) {
            addCriterion("PARAM_UPDATEUSER <", value, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("PARAM_UPDATEUSER <=", value, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserLike(String value) {
            addCriterion("PARAM_UPDATEUSER like", value, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserNotLike(String value) {
            addCriterion("PARAM_UPDATEUSER not like", value, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserIn(List<String> values) {
            addCriterion("PARAM_UPDATEUSER in", values, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserNotIn(List<String> values) {
            addCriterion("PARAM_UPDATEUSER not in", values, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserBetween(String value1, String value2) {
            addCriterion("PARAM_UPDATEUSER between", value1, value2, "paramUpdateuser");
            return (Criteria) this;
        }

        public Criteria andParamUpdateuserNotBetween(String value1, String value2) {
            addCriterion("PARAM_UPDATEUSER not between", value1, value2, "paramUpdateuser");
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