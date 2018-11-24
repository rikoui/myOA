package com.bjdreamtech.entity;

import java.util.ArrayList;
import java.util.List;

public class SysAdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAdminExample() {
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

        public Criteria andAdminIdIsNull() {
            addCriterion("ADMIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("ADMIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(String value) {
            addCriterion("ADMIN_ID =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(String value) {
            addCriterion("ADMIN_ID <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(String value) {
            addCriterion("ADMIN_ID >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_ID >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(String value) {
            addCriterion("ADMIN_ID <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_ID <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLike(String value) {
            addCriterion("ADMIN_ID like", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotLike(String value) {
            addCriterion("ADMIN_ID not like", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<String> values) {
            addCriterion("ADMIN_ID in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<String> values) {
            addCriterion("ADMIN_ID not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(String value1, String value2) {
            addCriterion("ADMIN_ID between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(String value1, String value2) {
            addCriterion("ADMIN_ID not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoIsNull() {
            addCriterion("ADMIN_STAFF_NO is null");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoIsNotNull() {
            addCriterion("ADMIN_STAFF_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoEqualTo(String value) {
            addCriterion("ADMIN_STAFF_NO =", value, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoNotEqualTo(String value) {
            addCriterion("ADMIN_STAFF_NO <>", value, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoGreaterThan(String value) {
            addCriterion("ADMIN_STAFF_NO >", value, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_STAFF_NO >=", value, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoLessThan(String value) {
            addCriterion("ADMIN_STAFF_NO <", value, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_STAFF_NO <=", value, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoLike(String value) {
            addCriterion("ADMIN_STAFF_NO like", value, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoNotLike(String value) {
            addCriterion("ADMIN_STAFF_NO not like", value, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoIn(List<String> values) {
            addCriterion("ADMIN_STAFF_NO in", values, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoNotIn(List<String> values) {
            addCriterion("ADMIN_STAFF_NO not in", values, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoBetween(String value1, String value2) {
            addCriterion("ADMIN_STAFF_NO between", value1, value2, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminStaffNoNotBetween(String value1, String value2) {
            addCriterion("ADMIN_STAFF_NO not between", value1, value2, "adminStaffNo");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdIsNull() {
            addCriterion("ADMIN_ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdIsNotNull() {
            addCriterion("ADMIN_ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdEqualTo(String value) {
            addCriterion("ADMIN_ROLE_ID =", value, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdNotEqualTo(String value) {
            addCriterion("ADMIN_ROLE_ID <>", value, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdGreaterThan(String value) {
            addCriterion("ADMIN_ROLE_ID >", value, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_ROLE_ID >=", value, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdLessThan(String value) {
            addCriterion("ADMIN_ROLE_ID <", value, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_ROLE_ID <=", value, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdLike(String value) {
            addCriterion("ADMIN_ROLE_ID like", value, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdNotLike(String value) {
            addCriterion("ADMIN_ROLE_ID not like", value, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdIn(List<String> values) {
            addCriterion("ADMIN_ROLE_ID in", values, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdNotIn(List<String> values) {
            addCriterion("ADMIN_ROLE_ID not in", values, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdBetween(String value1, String value2) {
            addCriterion("ADMIN_ROLE_ID between", value1, value2, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIdNotBetween(String value1, String value2) {
            addCriterion("ADMIN_ROLE_ID not between", value1, value2, "adminRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdIsNull() {
            addCriterion("ADMIN_BRANCH_ID is null");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdIsNotNull() {
            addCriterion("ADMIN_BRANCH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdEqualTo(String value) {
            addCriterion("ADMIN_BRANCH_ID =", value, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdNotEqualTo(String value) {
            addCriterion("ADMIN_BRANCH_ID <>", value, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdGreaterThan(String value) {
            addCriterion("ADMIN_BRANCH_ID >", value, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_BRANCH_ID >=", value, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdLessThan(String value) {
            addCriterion("ADMIN_BRANCH_ID <", value, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_BRANCH_ID <=", value, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdLike(String value) {
            addCriterion("ADMIN_BRANCH_ID like", value, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdNotLike(String value) {
            addCriterion("ADMIN_BRANCH_ID not like", value, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdIn(List<String> values) {
            addCriterion("ADMIN_BRANCH_ID in", values, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdNotIn(List<String> values) {
            addCriterion("ADMIN_BRANCH_ID not in", values, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdBetween(String value1, String value2) {
            addCriterion("ADMIN_BRANCH_ID between", value1, value2, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminBranchIdNotBetween(String value1, String value2) {
            addCriterion("ADMIN_BRANCH_ID not between", value1, value2, "adminBranchId");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameIsNull() {
            addCriterion("ADMIN_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameIsNotNull() {
            addCriterion("ADMIN_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameEqualTo(String value) {
            addCriterion("ADMIN_USERNAME =", value, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameNotEqualTo(String value) {
            addCriterion("ADMIN_USERNAME <>", value, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameGreaterThan(String value) {
            addCriterion("ADMIN_USERNAME >", value, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_USERNAME >=", value, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameLessThan(String value) {
            addCriterion("ADMIN_USERNAME <", value, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_USERNAME <=", value, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameLike(String value) {
            addCriterion("ADMIN_USERNAME like", value, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameNotLike(String value) {
            addCriterion("ADMIN_USERNAME not like", value, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameIn(List<String> values) {
            addCriterion("ADMIN_USERNAME in", values, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameNotIn(List<String> values) {
            addCriterion("ADMIN_USERNAME not in", values, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameBetween(String value1, String value2) {
            addCriterion("ADMIN_USERNAME between", value1, value2, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminUsernameNotBetween(String value1, String value2) {
            addCriterion("ADMIN_USERNAME not between", value1, value2, "adminUsername");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIsNull() {
            addCriterion("ADMIN_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIsNotNull() {
            addCriterion("ADMIN_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordEqualTo(String value) {
            addCriterion("ADMIN_PASSWORD =", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotEqualTo(String value) {
            addCriterion("ADMIN_PASSWORD <>", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordGreaterThan(String value) {
            addCriterion("ADMIN_PASSWORD >", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_PASSWORD >=", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLessThan(String value) {
            addCriterion("ADMIN_PASSWORD <", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_PASSWORD <=", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLike(String value) {
            addCriterion("ADMIN_PASSWORD like", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotLike(String value) {
            addCriterion("ADMIN_PASSWORD not like", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIn(List<String> values) {
            addCriterion("ADMIN_PASSWORD in", values, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotIn(List<String> values) {
            addCriterion("ADMIN_PASSWORD not in", values, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordBetween(String value1, String value2) {
            addCriterion("ADMIN_PASSWORD between", value1, value2, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotBetween(String value1, String value2) {
            addCriterion("ADMIN_PASSWORD not between", value1, value2, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameIsNull() {
            addCriterion("ADMIN_REALNAME is null");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameIsNotNull() {
            addCriterion("ADMIN_REALNAME is not null");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameEqualTo(String value) {
            addCriterion("ADMIN_REALNAME =", value, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameNotEqualTo(String value) {
            addCriterion("ADMIN_REALNAME <>", value, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameGreaterThan(String value) {
            addCriterion("ADMIN_REALNAME >", value, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_REALNAME >=", value, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameLessThan(String value) {
            addCriterion("ADMIN_REALNAME <", value, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_REALNAME <=", value, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameLike(String value) {
            addCriterion("ADMIN_REALNAME like", value, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameNotLike(String value) {
            addCriterion("ADMIN_REALNAME not like", value, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameIn(List<String> values) {
            addCriterion("ADMIN_REALNAME in", values, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameNotIn(List<String> values) {
            addCriterion("ADMIN_REALNAME not in", values, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameBetween(String value1, String value2) {
            addCriterion("ADMIN_REALNAME between", value1, value2, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminRealnameNotBetween(String value1, String value2) {
            addCriterion("ADMIN_REALNAME not between", value1, value2, "adminRealname");
            return (Criteria) this;
        }

        public Criteria andAdminStatusIsNull() {
            addCriterion("ADMIN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAdminStatusIsNotNull() {
            addCriterion("ADMIN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAdminStatusEqualTo(String value) {
            addCriterion("ADMIN_STATUS =", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusNotEqualTo(String value) {
            addCriterion("ADMIN_STATUS <>", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusGreaterThan(String value) {
            addCriterion("ADMIN_STATUS >", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_STATUS >=", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusLessThan(String value) {
            addCriterion("ADMIN_STATUS <", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_STATUS <=", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusLike(String value) {
            addCriterion("ADMIN_STATUS like", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusNotLike(String value) {
            addCriterion("ADMIN_STATUS not like", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusIn(List<String> values) {
            addCriterion("ADMIN_STATUS in", values, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusNotIn(List<String> values) {
            addCriterion("ADMIN_STATUS not in", values, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusBetween(String value1, String value2) {
            addCriterion("ADMIN_STATUS between", value1, value2, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusNotBetween(String value1, String value2) {
            addCriterion("ADMIN_STATUS not between", value1, value2, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminMarkIsNull() {
            addCriterion("ADMIN_MARK is null");
            return (Criteria) this;
        }

        public Criteria andAdminMarkIsNotNull() {
            addCriterion("ADMIN_MARK is not null");
            return (Criteria) this;
        }

        public Criteria andAdminMarkEqualTo(String value) {
            addCriterion("ADMIN_MARK =", value, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkNotEqualTo(String value) {
            addCriterion("ADMIN_MARK <>", value, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkGreaterThan(String value) {
            addCriterion("ADMIN_MARK >", value, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_MARK >=", value, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkLessThan(String value) {
            addCriterion("ADMIN_MARK <", value, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_MARK <=", value, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkLike(String value) {
            addCriterion("ADMIN_MARK like", value, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkNotLike(String value) {
            addCriterion("ADMIN_MARK not like", value, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkIn(List<String> values) {
            addCriterion("ADMIN_MARK in", values, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkNotIn(List<String> values) {
            addCriterion("ADMIN_MARK not in", values, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkBetween(String value1, String value2) {
            addCriterion("ADMIN_MARK between", value1, value2, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminMarkNotBetween(String value1, String value2) {
            addCriterion("ADMIN_MARK not between", value1, value2, "adminMark");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIsNull() {
            addCriterion("ADMIN_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIsNotNull() {
            addCriterion("ADMIN_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneEqualTo(String value) {
            addCriterion("ADMIN_PHONE =", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotEqualTo(String value) {
            addCriterion("ADMIN_PHONE <>", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneGreaterThan(String value) {
            addCriterion("ADMIN_PHONE >", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_PHONE >=", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLessThan(String value) {
            addCriterion("ADMIN_PHONE <", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_PHONE <=", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLike(String value) {
            addCriterion("ADMIN_PHONE like", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotLike(String value) {
            addCriterion("ADMIN_PHONE not like", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIn(List<String> values) {
            addCriterion("ADMIN_PHONE in", values, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotIn(List<String> values) {
            addCriterion("ADMIN_PHONE not in", values, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneBetween(String value1, String value2) {
            addCriterion("ADMIN_PHONE between", value1, value2, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotBetween(String value1, String value2) {
            addCriterion("ADMIN_PHONE not between", value1, value2, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminEmailIsNull() {
            addCriterion("ADMIN_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andAdminEmailIsNotNull() {
            addCriterion("ADMIN_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andAdminEmailEqualTo(String value) {
            addCriterion("ADMIN_EMAIL =", value, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailNotEqualTo(String value) {
            addCriterion("ADMIN_EMAIL <>", value, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailGreaterThan(String value) {
            addCriterion("ADMIN_EMAIL >", value, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_EMAIL >=", value, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailLessThan(String value) {
            addCriterion("ADMIN_EMAIL <", value, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_EMAIL <=", value, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailLike(String value) {
            addCriterion("ADMIN_EMAIL like", value, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailNotLike(String value) {
            addCriterion("ADMIN_EMAIL not like", value, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailIn(List<String> values) {
            addCriterion("ADMIN_EMAIL in", values, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailNotIn(List<String> values) {
            addCriterion("ADMIN_EMAIL not in", values, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailBetween(String value1, String value2) {
            addCriterion("ADMIN_EMAIL between", value1, value2, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminEmailNotBetween(String value1, String value2) {
            addCriterion("ADMIN_EMAIL not between", value1, value2, "adminEmail");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesIsNull() {
            addCriterion("ADMIN_ERRORTIMES is null");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesIsNotNull() {
            addCriterion("ADMIN_ERRORTIMES is not null");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesEqualTo(Integer value) {
            addCriterion("ADMIN_ERRORTIMES =", value, "adminErrortimes");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesNotEqualTo(Integer value) {
            addCriterion("ADMIN_ERRORTIMES <>", value, "adminErrortimes");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesGreaterThan(Integer value) {
            addCriterion("ADMIN_ERRORTIMES >", value, "adminErrortimes");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("ADMIN_ERRORTIMES >=", value, "adminErrortimes");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesLessThan(Integer value) {
            addCriterion("ADMIN_ERRORTIMES <", value, "adminErrortimes");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesLessThanOrEqualTo(Integer value) {
            addCriterion("ADMIN_ERRORTIMES <=", value, "adminErrortimes");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesIn(List<Integer> values) {
            addCriterion("ADMIN_ERRORTIMES in", values, "adminErrortimes");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesNotIn(List<Integer> values) {
            addCriterion("ADMIN_ERRORTIMES not in", values, "adminErrortimes");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesBetween(Integer value1, Integer value2) {
            addCriterion("ADMIN_ERRORTIMES between", value1, value2, "adminErrortimes");
            return (Criteria) this;
        }

        public Criteria andAdminErrortimesNotBetween(Integer value1, Integer value2) {
            addCriterion("ADMIN_ERRORTIMES not between", value1, value2, "adminErrortimes");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeIsNull() {
            addCriterion("ADMIN_CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeIsNotNull() {
            addCriterion("ADMIN_CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeEqualTo(String value) {
            addCriterion("ADMIN_CREATETIME =", value, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeNotEqualTo(String value) {
            addCriterion("ADMIN_CREATETIME <>", value, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeGreaterThan(String value) {
            addCriterion("ADMIN_CREATETIME >", value, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_CREATETIME >=", value, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeLessThan(String value) {
            addCriterion("ADMIN_CREATETIME <", value, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_CREATETIME <=", value, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeLike(String value) {
            addCriterion("ADMIN_CREATETIME like", value, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeNotLike(String value) {
            addCriterion("ADMIN_CREATETIME not like", value, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeIn(List<String> values) {
            addCriterion("ADMIN_CREATETIME in", values, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeNotIn(List<String> values) {
            addCriterion("ADMIN_CREATETIME not in", values, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeBetween(String value1, String value2) {
            addCriterion("ADMIN_CREATETIME between", value1, value2, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreatetimeNotBetween(String value1, String value2) {
            addCriterion("ADMIN_CREATETIME not between", value1, value2, "adminCreatetime");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserIsNull() {
            addCriterion("ADMIN_CREATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserIsNotNull() {
            addCriterion("ADMIN_CREATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserEqualTo(String value) {
            addCriterion("ADMIN_CREATEUSER =", value, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserNotEqualTo(String value) {
            addCriterion("ADMIN_CREATEUSER <>", value, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserGreaterThan(String value) {
            addCriterion("ADMIN_CREATEUSER >", value, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_CREATEUSER >=", value, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserLessThan(String value) {
            addCriterion("ADMIN_CREATEUSER <", value, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_CREATEUSER <=", value, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserLike(String value) {
            addCriterion("ADMIN_CREATEUSER like", value, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserNotLike(String value) {
            addCriterion("ADMIN_CREATEUSER not like", value, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserIn(List<String> values) {
            addCriterion("ADMIN_CREATEUSER in", values, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserNotIn(List<String> values) {
            addCriterion("ADMIN_CREATEUSER not in", values, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserBetween(String value1, String value2) {
            addCriterion("ADMIN_CREATEUSER between", value1, value2, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCreateuserNotBetween(String value1, String value2) {
            addCriterion("ADMIN_CREATEUSER not between", value1, value2, "adminCreateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeIsNull() {
            addCriterion("ADMIN_UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeIsNotNull() {
            addCriterion("ADMIN_UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeEqualTo(String value) {
            addCriterion("ADMIN_UPDATETIME =", value, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeNotEqualTo(String value) {
            addCriterion("ADMIN_UPDATETIME <>", value, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeGreaterThan(String value) {
            addCriterion("ADMIN_UPDATETIME >", value, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_UPDATETIME >=", value, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeLessThan(String value) {
            addCriterion("ADMIN_UPDATETIME <", value, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_UPDATETIME <=", value, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeLike(String value) {
            addCriterion("ADMIN_UPDATETIME like", value, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeNotLike(String value) {
            addCriterion("ADMIN_UPDATETIME not like", value, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeIn(List<String> values) {
            addCriterion("ADMIN_UPDATETIME in", values, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeNotIn(List<String> values) {
            addCriterion("ADMIN_UPDATETIME not in", values, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeBetween(String value1, String value2) {
            addCriterion("ADMIN_UPDATETIME between", value1, value2, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("ADMIN_UPDATETIME not between", value1, value2, "adminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserIsNull() {
            addCriterion("ADMIN_UPDATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserIsNotNull() {
            addCriterion("ADMIN_UPDATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserEqualTo(String value) {
            addCriterion("ADMIN_UPDATEUSER =", value, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserNotEqualTo(String value) {
            addCriterion("ADMIN_UPDATEUSER <>", value, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserGreaterThan(String value) {
            addCriterion("ADMIN_UPDATEUSER >", value, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_UPDATEUSER >=", value, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserLessThan(String value) {
            addCriterion("ADMIN_UPDATEUSER <", value, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_UPDATEUSER <=", value, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserLike(String value) {
            addCriterion("ADMIN_UPDATEUSER like", value, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserNotLike(String value) {
            addCriterion("ADMIN_UPDATEUSER not like", value, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserIn(List<String> values) {
            addCriterion("ADMIN_UPDATEUSER in", values, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserNotIn(List<String> values) {
            addCriterion("ADMIN_UPDATEUSER not in", values, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserBetween(String value1, String value2) {
            addCriterion("ADMIN_UPDATEUSER between", value1, value2, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateuserNotBetween(String value1, String value2) {
            addCriterion("ADMIN_UPDATEUSER not between", value1, value2, "adminUpdateuser");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayIsNull() {
            addCriterion("ADMIN_COUNTDAY is null");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayIsNotNull() {
            addCriterion("ADMIN_COUNTDAY is not null");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayEqualTo(String value) {
            addCriterion("ADMIN_COUNTDAY =", value, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayNotEqualTo(String value) {
            addCriterion("ADMIN_COUNTDAY <>", value, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayGreaterThan(String value) {
            addCriterion("ADMIN_COUNTDAY >", value, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_COUNTDAY >=", value, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayLessThan(String value) {
            addCriterion("ADMIN_COUNTDAY <", value, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_COUNTDAY <=", value, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayLike(String value) {
            addCriterion("ADMIN_COUNTDAY like", value, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayNotLike(String value) {
            addCriterion("ADMIN_COUNTDAY not like", value, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayIn(List<String> values) {
            addCriterion("ADMIN_COUNTDAY in", values, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayNotIn(List<String> values) {
            addCriterion("ADMIN_COUNTDAY not in", values, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayBetween(String value1, String value2) {
            addCriterion("ADMIN_COUNTDAY between", value1, value2, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminCountdayNotBetween(String value1, String value2) {
            addCriterion("ADMIN_COUNTDAY not between", value1, value2, "adminCountday");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayIsNull() {
            addCriterion("admin_lieu_day is null");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayIsNotNull() {
            addCriterion("admin_lieu_day is not null");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayEqualTo(Float value) {
            addCriterion("admin_lieu_day =", value, "adminLieuDay");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayNotEqualTo(Float value) {
            addCriterion("admin_lieu_day <>", value, "adminLieuDay");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayGreaterThan(Float value) {
            addCriterion("admin_lieu_day >", value, "adminLieuDay");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayGreaterThanOrEqualTo(Float value) {
            addCriterion("admin_lieu_day >=", value, "adminLieuDay");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayLessThan(Float value) {
            addCriterion("admin_lieu_day <", value, "adminLieuDay");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayLessThanOrEqualTo(Float value) {
            addCriterion("admin_lieu_day <=", value, "adminLieuDay");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayIn(List<Float> values) {
            addCriterion("admin_lieu_day in", values, "adminLieuDay");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayNotIn(List<Float> values) {
            addCriterion("admin_lieu_day not in", values, "adminLieuDay");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayBetween(Float value1, Float value2) {
            addCriterion("admin_lieu_day between", value1, value2, "adminLieuDay");
            return (Criteria) this;
        }

        public Criteria andAdminLieuDayNotBetween(Float value1, Float value2) {
            addCriterion("admin_lieu_day not between", value1, value2, "adminLieuDay");
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