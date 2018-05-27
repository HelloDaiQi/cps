package com.daiqi.entity;

import java.util.ArrayList;
import java.util.List;

public class ProficiencyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProficiencyExample() {
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

        public Criteria andProficiencyidIsNull() {
            addCriterion("proficiencyId is null");
            return (Criteria) this;
        }

        public Criteria andProficiencyidIsNotNull() {
            addCriterion("proficiencyId is not null");
            return (Criteria) this;
        }

        public Criteria andProficiencyidEqualTo(Integer value) {
            addCriterion("proficiencyId =", value, "proficiencyid");
            return (Criteria) this;
        }

        public Criteria andProficiencyidNotEqualTo(Integer value) {
            addCriterion("proficiencyId <>", value, "proficiencyid");
            return (Criteria) this;
        }

        public Criteria andProficiencyidGreaterThan(Integer value) {
            addCriterion("proficiencyId >", value, "proficiencyid");
            return (Criteria) this;
        }

        public Criteria andProficiencyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("proficiencyId >=", value, "proficiencyid");
            return (Criteria) this;
        }

        public Criteria andProficiencyidLessThan(Integer value) {
            addCriterion("proficiencyId <", value, "proficiencyid");
            return (Criteria) this;
        }

        public Criteria andProficiencyidLessThanOrEqualTo(Integer value) {
            addCriterion("proficiencyId <=", value, "proficiencyid");
            return (Criteria) this;
        }

        public Criteria andProficiencyidIn(List<Integer> values) {
            addCriterion("proficiencyId in", values, "proficiencyid");
            return (Criteria) this;
        }

        public Criteria andProficiencyidNotIn(List<Integer> values) {
            addCriterion("proficiencyId not in", values, "proficiencyid");
            return (Criteria) this;
        }

        public Criteria andProficiencyidBetween(Integer value1, Integer value2) {
            addCriterion("proficiencyId between", value1, value2, "proficiencyid");
            return (Criteria) this;
        }

        public Criteria andProficiencyidNotBetween(Integer value1, Integer value2) {
            addCriterion("proficiencyId not between", value1, value2, "proficiencyid");
            return (Criteria) this;
        }

        public Criteria andProficiencynameIsNull() {
            addCriterion("proficiencyName is null");
            return (Criteria) this;
        }

        public Criteria andProficiencynameIsNotNull() {
            addCriterion("proficiencyName is not null");
            return (Criteria) this;
        }

        public Criteria andProficiencynameEqualTo(String value) {
            addCriterion("proficiencyName =", value, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameNotEqualTo(String value) {
            addCriterion("proficiencyName <>", value, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameGreaterThan(String value) {
            addCriterion("proficiencyName >", value, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameGreaterThanOrEqualTo(String value) {
            addCriterion("proficiencyName >=", value, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameLessThan(String value) {
            addCriterion("proficiencyName <", value, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameLessThanOrEqualTo(String value) {
            addCriterion("proficiencyName <=", value, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameLike(String value) {
            addCriterion("proficiencyName like", value, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameNotLike(String value) {
            addCriterion("proficiencyName not like", value, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameIn(List<String> values) {
            addCriterion("proficiencyName in", values, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameNotIn(List<String> values) {
            addCriterion("proficiencyName not in", values, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameBetween(String value1, String value2) {
            addCriterion("proficiencyName between", value1, value2, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andProficiencynameNotBetween(String value1, String value2) {
            addCriterion("proficiencyName not between", value1, value2, "proficiencyname");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
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