package com.bjdreamtech.entity;

import java.util.ArrayList;
import java.util.List;

public class TableTicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TableTicketExample() {
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

        public Criteria andTicketIdIsNull() {
            addCriterion("ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNotNull() {
            addCriterion("ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketIdEqualTo(String value) {
            addCriterion("ticket_id =", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotEqualTo(String value) {
            addCriterion("ticket_id <>", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThan(String value) {
            addCriterion("ticket_id >", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_id >=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThan(String value) {
            addCriterion("ticket_id <", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThanOrEqualTo(String value) {
            addCriterion("ticket_id <=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLike(String value) {
            addCriterion("ticket_id like", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotLike(String value) {
            addCriterion("ticket_id not like", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdIn(List<String> values) {
            addCriterion("ticket_id in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotIn(List<String> values) {
            addCriterion("ticket_id not in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdBetween(String value1, String value2) {
            addCriterion("ticket_id between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotBetween(String value1, String value2) {
            addCriterion("ticket_id not between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketTimeIsNull() {
            addCriterion("ticket_time is null");
            return (Criteria) this;
        }

        public Criteria andTicketTimeIsNotNull() {
            addCriterion("ticket_time is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTimeEqualTo(String value) {
            addCriterion("ticket_time =", value, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeNotEqualTo(String value) {
            addCriterion("ticket_time <>", value, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeGreaterThan(String value) {
            addCriterion("ticket_time >", value, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_time >=", value, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeLessThan(String value) {
            addCriterion("ticket_time <", value, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeLessThanOrEqualTo(String value) {
            addCriterion("ticket_time <=", value, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeLike(String value) {
            addCriterion("ticket_time like", value, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeNotLike(String value) {
            addCriterion("ticket_time not like", value, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeIn(List<String> values) {
            addCriterion("ticket_time in", values, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeNotIn(List<String> values) {
            addCriterion("ticket_time not in", values, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeBetween(String value1, String value2) {
            addCriterion("ticket_time between", value1, value2, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketTimeNotBetween(String value1, String value2) {
            addCriterion("ticket_time not between", value1, value2, "ticketTime");
            return (Criteria) this;
        }

        public Criteria andTicketItemIsNull() {
            addCriterion("ticket_item is null");
            return (Criteria) this;
        }

        public Criteria andTicketItemIsNotNull() {
            addCriterion("ticket_item is not null");
            return (Criteria) this;
        }

        public Criteria andTicketItemEqualTo(String value) {
            addCriterion("ticket_item =", value, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemNotEqualTo(String value) {
            addCriterion("ticket_item <>", value, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemGreaterThan(String value) {
            addCriterion("ticket_item >", value, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_item >=", value, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemLessThan(String value) {
            addCriterion("ticket_item <", value, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemLessThanOrEqualTo(String value) {
            addCriterion("ticket_item <=", value, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemLike(String value) {
            addCriterion("ticket_item like", value, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemNotLike(String value) {
            addCriterion("ticket_item not like", value, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemIn(List<String> values) {
            addCriterion("ticket_item in", values, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemNotIn(List<String> values) {
            addCriterion("ticket_item not in", values, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemBetween(String value1, String value2) {
            addCriterion("ticket_item between", value1, value2, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketItemNotBetween(String value1, String value2) {
            addCriterion("ticket_item not between", value1, value2, "ticketItem");
            return (Criteria) this;
        }

        public Criteria andTicketUseIsNull() {
            addCriterion("ticket_use is null");
            return (Criteria) this;
        }

        public Criteria andTicketUseIsNotNull() {
            addCriterion("ticket_use is not null");
            return (Criteria) this;
        }

        public Criteria andTicketUseEqualTo(String value) {
            addCriterion("ticket_use =", value, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseNotEqualTo(String value) {
            addCriterion("ticket_use <>", value, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseGreaterThan(String value) {
            addCriterion("ticket_use >", value, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_use >=", value, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseLessThan(String value) {
            addCriterion("ticket_use <", value, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseLessThanOrEqualTo(String value) {
            addCriterion("ticket_use <=", value, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseLike(String value) {
            addCriterion("ticket_use like", value, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseNotLike(String value) {
            addCriterion("ticket_use not like", value, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseIn(List<String> values) {
            addCriterion("ticket_use in", values, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseNotIn(List<String> values) {
            addCriterion("ticket_use not in", values, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseBetween(String value1, String value2) {
            addCriterion("ticket_use between", value1, value2, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketUseNotBetween(String value1, String value2) {
            addCriterion("ticket_use not between", value1, value2, "ticketUse");
            return (Criteria) this;
        }

        public Criteria andTicketPayIsNull() {
            addCriterion("ticket_pay is null");
            return (Criteria) this;
        }

        public Criteria andTicketPayIsNotNull() {
            addCriterion("ticket_pay is not null");
            return (Criteria) this;
        }

        public Criteria andTicketPayEqualTo(Double value) {
            addCriterion("ticket_pay =", value, "ticketPay");
            return (Criteria) this;
        }

        public Criteria andTicketPayNotEqualTo(Double value) {
            addCriterion("ticket_pay <>", value, "ticketPay");
            return (Criteria) this;
        }

        public Criteria andTicketPayGreaterThan(Double value) {
            addCriterion("ticket_pay >", value, "ticketPay");
            return (Criteria) this;
        }

        public Criteria andTicketPayGreaterThanOrEqualTo(Double value) {
            addCriterion("ticket_pay >=", value, "ticketPay");
            return (Criteria) this;
        }

        public Criteria andTicketPayLessThan(Double value) {
            addCriterion("ticket_pay <", value, "ticketPay");
            return (Criteria) this;
        }

        public Criteria andTicketPayLessThanOrEqualTo(Double value) {
            addCriterion("ticket_pay <=", value, "ticketPay");
            return (Criteria) this;
        }

        public Criteria andTicketPayIn(List<Double> values) {
            addCriterion("ticket_pay in", values, "ticketPay");
            return (Criteria) this;
        }

        public Criteria andTicketPayNotIn(List<Double> values) {
            addCriterion("ticket_pay not in", values, "ticketPay");
            return (Criteria) this;
        }

        public Criteria andTicketPayBetween(Double value1, Double value2) {
            addCriterion("ticket_pay between", value1, value2, "ticketPay");
            return (Criteria) this;
        }

        public Criteria andTicketPayNotBetween(Double value1, Double value2) {
            addCriterion("ticket_pay not between", value1, value2, "ticketPay");
            return (Criteria) this;
        }

        public Criteria andTicketPersonIsNull() {
            addCriterion("ticket_person is null");
            return (Criteria) this;
        }

        public Criteria andTicketPersonIsNotNull() {
            addCriterion("ticket_person is not null");
            return (Criteria) this;
        }

        public Criteria andTicketPersonEqualTo(String value) {
            addCriterion("ticket_person =", value, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonNotEqualTo(String value) {
            addCriterion("ticket_person <>", value, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonGreaterThan(String value) {
            addCriterion("ticket_person >", value, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_person >=", value, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonLessThan(String value) {
            addCriterion("ticket_person <", value, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonLessThanOrEqualTo(String value) {
            addCriterion("ticket_person <=", value, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonLike(String value) {
            addCriterion("ticket_person like", value, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonNotLike(String value) {
            addCriterion("ticket_person not like", value, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonIn(List<String> values) {
            addCriterion("ticket_person in", values, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonNotIn(List<String> values) {
            addCriterion("ticket_person not in", values, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonBetween(String value1, String value2) {
            addCriterion("ticket_person between", value1, value2, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketPersonNotBetween(String value1, String value2) {
            addCriterion("ticket_person not between", value1, value2, "ticketPerson");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIsNull() {
            addCriterion("ticket_type is null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIsNotNull() {
            addCriterion("ticket_type is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeEqualTo(String value) {
            addCriterion("ticket_type =", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNotEqualTo(String value) {
            addCriterion("ticket_type <>", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeGreaterThan(String value) {
            addCriterion("ticket_type >", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_type >=", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeLessThan(String value) {
            addCriterion("ticket_type <", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeLessThanOrEqualTo(String value) {
            addCriterion("ticket_type <=", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeLike(String value) {
            addCriterion("ticket_type like", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNotLike(String value) {
            addCriterion("ticket_type not like", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIn(List<String> values) {
            addCriterion("ticket_type in", values, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNotIn(List<String> values) {
            addCriterion("ticket_type not in", values, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeBetween(String value1, String value2) {
            addCriterion("ticket_type between", value1, value2, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNotBetween(String value1, String value2) {
            addCriterion("ticket_type not between", value1, value2, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerIsNull() {
            addCriterion("ticket_remaker is null");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerIsNotNull() {
            addCriterion("ticket_remaker is not null");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerEqualTo(String value) {
            addCriterion("ticket_remaker =", value, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerNotEqualTo(String value) {
            addCriterion("ticket_remaker <>", value, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerGreaterThan(String value) {
            addCriterion("ticket_remaker >", value, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_remaker >=", value, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerLessThan(String value) {
            addCriterion("ticket_remaker <", value, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerLessThanOrEqualTo(String value) {
            addCriterion("ticket_remaker <=", value, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerLike(String value) {
            addCriterion("ticket_remaker like", value, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerNotLike(String value) {
            addCriterion("ticket_remaker not like", value, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerIn(List<String> values) {
            addCriterion("ticket_remaker in", values, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerNotIn(List<String> values) {
            addCriterion("ticket_remaker not in", values, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerBetween(String value1, String value2) {
            addCriterion("ticket_remaker between", value1, value2, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketRemakerNotBetween(String value1, String value2) {
            addCriterion("ticket_remaker not between", value1, value2, "ticketRemaker");
            return (Criteria) this;
        }

        public Criteria andTicketCreateIsNull() {
            addCriterion("ticket_create is null");
            return (Criteria) this;
        }

        public Criteria andTicketCreateIsNotNull() {
            addCriterion("ticket_create is not null");
            return (Criteria) this;
        }

        public Criteria andTicketCreateEqualTo(String value) {
            addCriterion("ticket_create =", value, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateNotEqualTo(String value) {
            addCriterion("ticket_create <>", value, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateGreaterThan(String value) {
            addCriterion("ticket_create >", value, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_create >=", value, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateLessThan(String value) {
            addCriterion("ticket_create <", value, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateLessThanOrEqualTo(String value) {
            addCriterion("ticket_create <=", value, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateLike(String value) {
            addCriterion("ticket_create like", value, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateNotLike(String value) {
            addCriterion("ticket_create not like", value, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateIn(List<String> values) {
            addCriterion("ticket_create in", values, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateNotIn(List<String> values) {
            addCriterion("ticket_create not in", values, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateBetween(String value1, String value2) {
            addCriterion("ticket_create between", value1, value2, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketCreateNotBetween(String value1, String value2) {
            addCriterion("ticket_create not between", value1, value2, "ticketCreate");
            return (Criteria) this;
        }

        public Criteria andTicketMonthIsNull() {
            addCriterion("ticket_month is null");
            return (Criteria) this;
        }

        public Criteria andTicketMonthIsNotNull() {
            addCriterion("ticket_month is not null");
            return (Criteria) this;
        }

        public Criteria andTicketMonthEqualTo(String value) {
            addCriterion("ticket_month =", value, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthNotEqualTo(String value) {
            addCriterion("ticket_month <>", value, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthGreaterThan(String value) {
            addCriterion("ticket_month >", value, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_month >=", value, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthLessThan(String value) {
            addCriterion("ticket_month <", value, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthLessThanOrEqualTo(String value) {
            addCriterion("ticket_month <=", value, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthLike(String value) {
            addCriterion("ticket_month like", value, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthNotLike(String value) {
            addCriterion("ticket_month not like", value, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthIn(List<String> values) {
            addCriterion("ticket_month in", values, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthNotIn(List<String> values) {
            addCriterion("ticket_month not in", values, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthBetween(String value1, String value2) {
            addCriterion("ticket_month between", value1, value2, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketMonthNotBetween(String value1, String value2) {
            addCriterion("ticket_month not between", value1, value2, "ticketMonth");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminIsNull() {
            addCriterion("ticket_create_admin is null");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminIsNotNull() {
            addCriterion("ticket_create_admin is not null");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminEqualTo(String value) {
            addCriterion("ticket_create_admin =", value, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminNotEqualTo(String value) {
            addCriterion("ticket_create_admin <>", value, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminGreaterThan(String value) {
            addCriterion("ticket_create_admin >", value, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_create_admin >=", value, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminLessThan(String value) {
            addCriterion("ticket_create_admin <", value, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminLessThanOrEqualTo(String value) {
            addCriterion("ticket_create_admin <=", value, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminLike(String value) {
            addCriterion("ticket_create_admin like", value, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminNotLike(String value) {
            addCriterion("ticket_create_admin not like", value, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminIn(List<String> values) {
            addCriterion("ticket_create_admin in", values, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminNotIn(List<String> values) {
            addCriterion("ticket_create_admin not in", values, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminBetween(String value1, String value2) {
            addCriterion("ticket_create_admin between", value1, value2, "ticketCreateAdmin");
            return (Criteria) this;
        }

        public Criteria andTicketCreateAdminNotBetween(String value1, String value2) {
            addCriterion("ticket_create_admin not between", value1, value2, "ticketCreateAdmin");
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