package com.bjdreamtech.entity;

import java.util.ArrayList;
import java.util.List;

public class SysFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysFileExample() {
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

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(String value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(String value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(String value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(String value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(String value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLike(String value) {
            addCriterion("file_id like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotLike(String value) {
            addCriterion("file_id not like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<String> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<String> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(String value1, String value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(String value1, String value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameIsNull() {
            addCriterion("file_original_name is null");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameIsNotNull() {
            addCriterion("file_original_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameEqualTo(String value) {
            addCriterion("file_original_name =", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameNotEqualTo(String value) {
            addCriterion("file_original_name <>", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameGreaterThan(String value) {
            addCriterion("file_original_name >", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_original_name >=", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameLessThan(String value) {
            addCriterion("file_original_name <", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameLessThanOrEqualTo(String value) {
            addCriterion("file_original_name <=", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameLike(String value) {
            addCriterion("file_original_name like", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameNotLike(String value) {
            addCriterion("file_original_name not like", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameIn(List<String> values) {
            addCriterion("file_original_name in", values, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameNotIn(List<String> values) {
            addCriterion("file_original_name not in", values, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameBetween(String value1, String value2) {
            addCriterion("file_original_name between", value1, value2, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameNotBetween(String value1, String value2) {
            addCriterion("file_original_name not between", value1, value2, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminIsNull() {
            addCriterion("file_create_admin is null");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminIsNotNull() {
            addCriterion("file_create_admin is not null");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminEqualTo(String value) {
            addCriterion("file_create_admin =", value, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminNotEqualTo(String value) {
            addCriterion("file_create_admin <>", value, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminGreaterThan(String value) {
            addCriterion("file_create_admin >", value, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminGreaterThanOrEqualTo(String value) {
            addCriterion("file_create_admin >=", value, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminLessThan(String value) {
            addCriterion("file_create_admin <", value, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminLessThanOrEqualTo(String value) {
            addCriterion("file_create_admin <=", value, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminLike(String value) {
            addCriterion("file_create_admin like", value, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminNotLike(String value) {
            addCriterion("file_create_admin not like", value, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminIn(List<String> values) {
            addCriterion("file_create_admin in", values, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminNotIn(List<String> values) {
            addCriterion("file_create_admin not in", values, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminBetween(String value1, String value2) {
            addCriterion("file_create_admin between", value1, value2, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreateAdminNotBetween(String value1, String value2) {
            addCriterion("file_create_admin not between", value1, value2, "fileCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeIsNull() {
            addCriterion("file_createtime is null");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeIsNotNull() {
            addCriterion("file_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeEqualTo(String value) {
            addCriterion("file_createtime =", value, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeNotEqualTo(String value) {
            addCriterion("file_createtime <>", value, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeGreaterThan(String value) {
            addCriterion("file_createtime >", value, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("file_createtime >=", value, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeLessThan(String value) {
            addCriterion("file_createtime <", value, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("file_createtime <=", value, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeLike(String value) {
            addCriterion("file_createtime like", value, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeNotLike(String value) {
            addCriterion("file_createtime not like", value, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeIn(List<String> values) {
            addCriterion("file_createtime in", values, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeNotIn(List<String> values) {
            addCriterion("file_createtime not in", values, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeBetween(String value1, String value2) {
            addCriterion("file_createtime between", value1, value2, "fileCreatetime");
            return (Criteria) this;
        }

        public Criteria andFileCreatetimeNotBetween(String value1, String value2) {
            addCriterion("file_createtime not between", value1, value2, "fileCreatetime");
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