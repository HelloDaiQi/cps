package com.daiqi.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FocusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FocusExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andFocusidIsNull() {
            addCriterion("focusId is null");
            return (Criteria) this;
        }

        public Criteria andFocusidIsNotNull() {
            addCriterion("focusId is not null");
            return (Criteria) this;
        }

        public Criteria andFocusidEqualTo(Integer value) {
            addCriterion("focusId =", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidNotEqualTo(Integer value) {
            addCriterion("focusId <>", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidGreaterThan(Integer value) {
            addCriterion("focusId >", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("focusId >=", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidLessThan(Integer value) {
            addCriterion("focusId <", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidLessThanOrEqualTo(Integer value) {
            addCriterion("focusId <=", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidIn(List<Integer> values) {
            addCriterion("focusId in", values, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidNotIn(List<Integer> values) {
            addCriterion("focusId not in", values, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidBetween(Integer value1, Integer value2) {
            addCriterion("focusId between", value1, value2, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidNotBetween(Integer value1, Integer value2) {
            addCriterion("focusId not between", value1, value2, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocuserIsNull() {
            addCriterion("focuser is null");
            return (Criteria) this;
        }

        public Criteria andFocuserIsNotNull() {
            addCriterion("focuser is not null");
            return (Criteria) this;
        }

        public Criteria andFocuserEqualTo(Integer value) {
            addCriterion("focuser =", value, "focuser");
            return (Criteria) this;
        }

        public Criteria andFocuserNotEqualTo(Integer value) {
            addCriterion("focuser <>", value, "focuser");
            return (Criteria) this;
        }

        public Criteria andFocuserGreaterThan(Integer value) {
            addCriterion("focuser >", value, "focuser");
            return (Criteria) this;
        }

        public Criteria andFocuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("focuser >=", value, "focuser");
            return (Criteria) this;
        }

        public Criteria andFocuserLessThan(Integer value) {
            addCriterion("focuser <", value, "focuser");
            return (Criteria) this;
        }

        public Criteria andFocuserLessThanOrEqualTo(Integer value) {
            addCriterion("focuser <=", value, "focuser");
            return (Criteria) this;
        }

        public Criteria andFocuserIn(List<Integer> values) {
            addCriterion("focuser in", values, "focuser");
            return (Criteria) this;
        }

        public Criteria andFocuserNotIn(List<Integer> values) {
            addCriterion("focuser not in", values, "focuser");
            return (Criteria) this;
        }

        public Criteria andFocuserBetween(Integer value1, Integer value2) {
            addCriterion("focuser between", value1, value2, "focuser");
            return (Criteria) this;
        }

        public Criteria andFocuserNotBetween(Integer value1, Integer value2) {
            addCriterion("focuser not between", value1, value2, "focuser");
            return (Criteria) this;
        }

        public Criteria andBefocuserIsNull() {
            addCriterion("beFocuser is null");
            return (Criteria) this;
        }

        public Criteria andBefocuserIsNotNull() {
            addCriterion("beFocuser is not null");
            return (Criteria) this;
        }

        public Criteria andBefocuserEqualTo(Integer value) {
            addCriterion("beFocuser =", value, "befocuser");
            return (Criteria) this;
        }

        public Criteria andBefocuserNotEqualTo(Integer value) {
            addCriterion("beFocuser <>", value, "befocuser");
            return (Criteria) this;
        }

        public Criteria andBefocuserGreaterThan(Integer value) {
            addCriterion("beFocuser >", value, "befocuser");
            return (Criteria) this;
        }

        public Criteria andBefocuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("beFocuser >=", value, "befocuser");
            return (Criteria) this;
        }

        public Criteria andBefocuserLessThan(Integer value) {
            addCriterion("beFocuser <", value, "befocuser");
            return (Criteria) this;
        }

        public Criteria andBefocuserLessThanOrEqualTo(Integer value) {
            addCriterion("beFocuser <=", value, "befocuser");
            return (Criteria) this;
        }

        public Criteria andBefocuserIn(List<Integer> values) {
            addCriterion("beFocuser in", values, "befocuser");
            return (Criteria) this;
        }

        public Criteria andBefocuserNotIn(List<Integer> values) {
            addCriterion("beFocuser not in", values, "befocuser");
            return (Criteria) this;
        }

        public Criteria andBefocuserBetween(Integer value1, Integer value2) {
            addCriterion("beFocuser between", value1, value2, "befocuser");
            return (Criteria) this;
        }

        public Criteria andBefocuserNotBetween(Integer value1, Integer value2) {
            addCriterion("beFocuser not between", value1, value2, "befocuser");
            return (Criteria) this;
        }

        public Criteria andFocustimeIsNull() {
            addCriterion("focusTime is null");
            return (Criteria) this;
        }

        public Criteria andFocustimeIsNotNull() {
            addCriterion("focusTime is not null");
            return (Criteria) this;
        }

        public Criteria andFocustimeEqualTo(Date value) {
            addCriterionForJDBCDate("focusTime =", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("focusTime <>", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeGreaterThan(Date value) {
            addCriterionForJDBCDate("focusTime >", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("focusTime >=", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeLessThan(Date value) {
            addCriterionForJDBCDate("focusTime <", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("focusTime <=", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeIn(List<Date> values) {
            addCriterionForJDBCDate("focusTime in", values, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("focusTime not in", values, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("focusTime between", value1, value2, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("focusTime not between", value1, value2, "focustime");
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