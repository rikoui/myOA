package com.bjdreamtech.entity;

import java.util.ArrayList;
import java.util.List;

public class TableDailyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TableDailyExample() {
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

        public Criteria andDailyIdIsNull() {
            addCriterion("daily_id is null");
            return (Criteria) this;
        }

        public Criteria andDailyIdIsNotNull() {
            addCriterion("daily_id is not null");
            return (Criteria) this;
        }

        public Criteria andDailyIdEqualTo(String value) {
            addCriterion("daily_id =", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdNotEqualTo(String value) {
            addCriterion("daily_id <>", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdGreaterThan(String value) {
            addCriterion("daily_id >", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdGreaterThanOrEqualTo(String value) {
            addCriterion("daily_id >=", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdLessThan(String value) {
            addCriterion("daily_id <", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdLessThanOrEqualTo(String value) {
            addCriterion("daily_id <=", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdLike(String value) {
            addCriterion("daily_id like", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdNotLike(String value) {
            addCriterion("daily_id not like", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdIn(List<String> values) {
            addCriterion("daily_id in", values, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdNotIn(List<String> values) {
            addCriterion("daily_id not in", values, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdBetween(String value1, String value2) {
            addCriterion("daily_id between", value1, value2, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdNotBetween(String value1, String value2) {
            addCriterion("daily_id not between", value1, value2, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdIsNull() {
            addCriterion("daily_weekly_id is null");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdIsNotNull() {
            addCriterion("daily_weekly_id is not null");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdEqualTo(String value) {
            addCriterion("daily_weekly_id =", value, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdNotEqualTo(String value) {
            addCriterion("daily_weekly_id <>", value, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdGreaterThan(String value) {
            addCriterion("daily_weekly_id >", value, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdGreaterThanOrEqualTo(String value) {
            addCriterion("daily_weekly_id >=", value, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdLessThan(String value) {
            addCriterion("daily_weekly_id <", value, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdLessThanOrEqualTo(String value) {
            addCriterion("daily_weekly_id <=", value, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdLike(String value) {
            addCriterion("daily_weekly_id like", value, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdNotLike(String value) {
            addCriterion("daily_weekly_id not like", value, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdIn(List<String> values) {
            addCriterion("daily_weekly_id in", values, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdNotIn(List<String> values) {
            addCriterion("daily_weekly_id not in", values, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdBetween(String value1, String value2) {
            addCriterion("daily_weekly_id between", value1, value2, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyWeeklyIdNotBetween(String value1, String value2) {
            addCriterion("daily_weekly_id not between", value1, value2, "dailyWeeklyId");
            return (Criteria) this;
        }

        public Criteria andDailyTimeIsNull() {
            addCriterion("daily_time is null");
            return (Criteria) this;
        }

        public Criteria andDailyTimeIsNotNull() {
            addCriterion("daily_time is not null");
            return (Criteria) this;
        }

        public Criteria andDailyTimeEqualTo(String value) {
            addCriterion("daily_time =", value, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeNotEqualTo(String value) {
            addCriterion("daily_time <>", value, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeGreaterThan(String value) {
            addCriterion("daily_time >", value, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("daily_time >=", value, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeLessThan(String value) {
            addCriterion("daily_time <", value, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeLessThanOrEqualTo(String value) {
            addCriterion("daily_time <=", value, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeLike(String value) {
            addCriterion("daily_time like", value, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeNotLike(String value) {
            addCriterion("daily_time not like", value, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeIn(List<String> values) {
            addCriterion("daily_time in", values, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeNotIn(List<String> values) {
            addCriterion("daily_time not in", values, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeBetween(String value1, String value2) {
            addCriterion("daily_time between", value1, value2, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyTimeNotBetween(String value1, String value2) {
            addCriterion("daily_time not between", value1, value2, "dailyTime");
            return (Criteria) this;
        }

        public Criteria andDailyWeekIsNull() {
            addCriterion("daily_week is null");
            return (Criteria) this;
        }

        public Criteria andDailyWeekIsNotNull() {
            addCriterion("daily_week is not null");
            return (Criteria) this;
        }

        public Criteria andDailyWeekEqualTo(String value) {
            addCriterion("daily_week =", value, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekNotEqualTo(String value) {
            addCriterion("daily_week <>", value, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekGreaterThan(String value) {
            addCriterion("daily_week >", value, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekGreaterThanOrEqualTo(String value) {
            addCriterion("daily_week >=", value, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekLessThan(String value) {
            addCriterion("daily_week <", value, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekLessThanOrEqualTo(String value) {
            addCriterion("daily_week <=", value, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekLike(String value) {
            addCriterion("daily_week like", value, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekNotLike(String value) {
            addCriterion("daily_week not like", value, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekIn(List<String> values) {
            addCriterion("daily_week in", values, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekNotIn(List<String> values) {
            addCriterion("daily_week not in", values, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekBetween(String value1, String value2) {
            addCriterion("daily_week between", value1, value2, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyWeekNotBetween(String value1, String value2) {
            addCriterion("daily_week not between", value1, value2, "dailyWeek");
            return (Criteria) this;
        }

        public Criteria andDailyPartIsNull() {
            addCriterion("daily_part is null");
            return (Criteria) this;
        }

        public Criteria andDailyPartIsNotNull() {
            addCriterion("daily_part is not null");
            return (Criteria) this;
        }

        public Criteria andDailyPartEqualTo(String value) {
            addCriterion("daily_part =", value, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartNotEqualTo(String value) {
            addCriterion("daily_part <>", value, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartGreaterThan(String value) {
            addCriterion("daily_part >", value, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartGreaterThanOrEqualTo(String value) {
            addCriterion("daily_part >=", value, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartLessThan(String value) {
            addCriterion("daily_part <", value, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartLessThanOrEqualTo(String value) {
            addCriterion("daily_part <=", value, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartLike(String value) {
            addCriterion("daily_part like", value, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartNotLike(String value) {
            addCriterion("daily_part not like", value, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartIn(List<String> values) {
            addCriterion("daily_part in", values, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartNotIn(List<String> values) {
            addCriterion("daily_part not in", values, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartBetween(String value1, String value2) {
            addCriterion("daily_part between", value1, value2, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyPartNotBetween(String value1, String value2) {
            addCriterion("daily_part not between", value1, value2, "dailyPart");
            return (Criteria) this;
        }

        public Criteria andDailyContentIsNull() {
            addCriterion("daily_content is null");
            return (Criteria) this;
        }

        public Criteria andDailyContentIsNotNull() {
            addCriterion("daily_content is not null");
            return (Criteria) this;
        }

        public Criteria andDailyContentEqualTo(String value) {
            addCriterion("daily_content =", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentNotEqualTo(String value) {
            addCriterion("daily_content <>", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentGreaterThan(String value) {
            addCriterion("daily_content >", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentGreaterThanOrEqualTo(String value) {
            addCriterion("daily_content >=", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentLessThan(String value) {
            addCriterion("daily_content <", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentLessThanOrEqualTo(String value) {
            addCriterion("daily_content <=", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentLike(String value) {
            addCriterion("daily_content like", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentNotLike(String value) {
            addCriterion("daily_content not like", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentIn(List<String> values) {
            addCriterion("daily_content in", values, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentNotIn(List<String> values) {
            addCriterion("daily_content not in", values, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentBetween(String value1, String value2) {
            addCriterion("daily_content between", value1, value2, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentNotBetween(String value1, String value2) {
            addCriterion("daily_content not between", value1, value2, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionIsNull() {
            addCriterion("daily_question is null");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionIsNotNull() {
            addCriterion("daily_question is not null");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionEqualTo(String value) {
            addCriterion("daily_question =", value, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionNotEqualTo(String value) {
            addCriterion("daily_question <>", value, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionGreaterThan(String value) {
            addCriterion("daily_question >", value, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("daily_question >=", value, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionLessThan(String value) {
            addCriterion("daily_question <", value, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionLessThanOrEqualTo(String value) {
            addCriterion("daily_question <=", value, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionLike(String value) {
            addCriterion("daily_question like", value, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionNotLike(String value) {
            addCriterion("daily_question not like", value, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionIn(List<String> values) {
            addCriterion("daily_question in", values, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionNotIn(List<String> values) {
            addCriterion("daily_question not in", values, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionBetween(String value1, String value2) {
            addCriterion("daily_question between", value1, value2, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyQuestionNotBetween(String value1, String value2) {
            addCriterion("daily_question not between", value1, value2, "dailyQuestion");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerIsNull() {
            addCriterion("daily_answer is null");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerIsNotNull() {
            addCriterion("daily_answer is not null");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerEqualTo(String value) {
            addCriterion("daily_answer =", value, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerNotEqualTo(String value) {
            addCriterion("daily_answer <>", value, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerGreaterThan(String value) {
            addCriterion("daily_answer >", value, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("daily_answer >=", value, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerLessThan(String value) {
            addCriterion("daily_answer <", value, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerLessThanOrEqualTo(String value) {
            addCriterion("daily_answer <=", value, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerLike(String value) {
            addCriterion("daily_answer like", value, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerNotLike(String value) {
            addCriterion("daily_answer not like", value, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerIn(List<String> values) {
            addCriterion("daily_answer in", values, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerNotIn(List<String> values) {
            addCriterion("daily_answer not in", values, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerBetween(String value1, String value2) {
            addCriterion("daily_answer between", value1, value2, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyAnswerNotBetween(String value1, String value2) {
            addCriterion("daily_answer not between", value1, value2, "dailyAnswer");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeIsNull() {
            addCriterion("daily_committime is null");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeIsNotNull() {
            addCriterion("daily_committime is not null");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeEqualTo(String value) {
            addCriterion("daily_committime =", value, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeNotEqualTo(String value) {
            addCriterion("daily_committime <>", value, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeGreaterThan(String value) {
            addCriterion("daily_committime >", value, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeGreaterThanOrEqualTo(String value) {
            addCriterion("daily_committime >=", value, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeLessThan(String value) {
            addCriterion("daily_committime <", value, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeLessThanOrEqualTo(String value) {
            addCriterion("daily_committime <=", value, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeLike(String value) {
            addCriterion("daily_committime like", value, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeNotLike(String value) {
            addCriterion("daily_committime not like", value, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeIn(List<String> values) {
            addCriterion("daily_committime in", values, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeNotIn(List<String> values) {
            addCriterion("daily_committime not in", values, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeBetween(String value1, String value2) {
            addCriterion("daily_committime between", value1, value2, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyCommittimeNotBetween(String value1, String value2) {
            addCriterion("daily_committime not between", value1, value2, "dailyCommittime");
            return (Criteria) this;
        }

        public Criteria andDailyStatusIsNull() {
            addCriterion("daily_status is null");
            return (Criteria) this;
        }

        public Criteria andDailyStatusIsNotNull() {
            addCriterion("daily_status is not null");
            return (Criteria) this;
        }

        public Criteria andDailyStatusEqualTo(String value) {
            addCriterion("daily_status =", value, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusNotEqualTo(String value) {
            addCriterion("daily_status <>", value, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusGreaterThan(String value) {
            addCriterion("daily_status >", value, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("daily_status >=", value, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusLessThan(String value) {
            addCriterion("daily_status <", value, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusLessThanOrEqualTo(String value) {
            addCriterion("daily_status <=", value, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusLike(String value) {
            addCriterion("daily_status like", value, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusNotLike(String value) {
            addCriterion("daily_status not like", value, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusIn(List<String> values) {
            addCriterion("daily_status in", values, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusNotIn(List<String> values) {
            addCriterion("daily_status not in", values, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusBetween(String value1, String value2) {
            addCriterion("daily_status between", value1, value2, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyStatusNotBetween(String value1, String value2) {
            addCriterion("daily_status not between", value1, value2, "dailyStatus");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkIsNull() {
            addCriterion("daily_remark is null");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkIsNotNull() {
            addCriterion("daily_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkEqualTo(String value) {
            addCriterion("daily_remark =", value, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkNotEqualTo(String value) {
            addCriterion("daily_remark <>", value, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkGreaterThan(String value) {
            addCriterion("daily_remark >", value, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("daily_remark >=", value, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkLessThan(String value) {
            addCriterion("daily_remark <", value, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkLessThanOrEqualTo(String value) {
            addCriterion("daily_remark <=", value, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkLike(String value) {
            addCriterion("daily_remark like", value, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkNotLike(String value) {
            addCriterion("daily_remark not like", value, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkIn(List<String> values) {
            addCriterion("daily_remark in", values, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkNotIn(List<String> values) {
            addCriterion("daily_remark not in", values, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkBetween(String value1, String value2) {
            addCriterion("daily_remark between", value1, value2, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRemarkNotBetween(String value1, String value2) {
            addCriterion("daily_remark not between", value1, value2, "dailyRemark");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthIsNull() {
            addCriterion("daily_realyauth is null");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthIsNotNull() {
            addCriterion("daily_realyauth is not null");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthEqualTo(String value) {
            addCriterion("daily_realyauth =", value, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthNotEqualTo(String value) {
            addCriterion("daily_realyauth <>", value, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthGreaterThan(String value) {
            addCriterion("daily_realyauth >", value, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthGreaterThanOrEqualTo(String value) {
            addCriterion("daily_realyauth >=", value, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthLessThan(String value) {
            addCriterion("daily_realyauth <", value, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthLessThanOrEqualTo(String value) {
            addCriterion("daily_realyauth <=", value, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthLike(String value) {
            addCriterion("daily_realyauth like", value, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthNotLike(String value) {
            addCriterion("daily_realyauth not like", value, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthIn(List<String> values) {
            addCriterion("daily_realyauth in", values, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthNotIn(List<String> values) {
            addCriterion("daily_realyauth not in", values, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthBetween(String value1, String value2) {
            addCriterion("daily_realyauth between", value1, value2, "dailyRealyauth");
            return (Criteria) this;
        }

        public Criteria andDailyRealyauthNotBetween(String value1, String value2) {
            addCriterion("daily_realyauth not between", value1, value2, "dailyRealyauth");
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