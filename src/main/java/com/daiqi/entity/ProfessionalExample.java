package com.daiqi.entity;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProfessionalExample() {
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

        public Criteria andProfessionalidIsNull() {
            addCriterion("professionalId is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalidIsNotNull() {
            addCriterion("professionalId is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalidEqualTo(Integer value) {
            addCriterion("professionalId =", value, "professionalid");
            return (Criteria) this;
        }

        public Criteria andProfessionalidNotEqualTo(Integer value) {
            addCriterion("professionalId <>", value, "professionalid");
            return (Criteria) this;
        }

        public Criteria andProfessionalidGreaterThan(Integer value) {
            addCriterion("professionalId >", value, "professionalid");
            return (Criteria) this;
        }

        public Criteria andProfessionalidGreaterThanOrEqualTo(Integer value) {
            addCriterion("professionalId >=", value, "professionalid");
            return (Criteria) this;
        }

        public Criteria andProfessionalidLessThan(Integer value) {
            addCriterion("professionalId <", value, "professionalid");
            return (Criteria) this;
        }

        public Criteria andProfessionalidLessThanOrEqualTo(Integer value) {
            addCriterion("professionalId <=", value, "professionalid");
            return (Criteria) this;
        }

        public Criteria andProfessionalidIn(List<Integer> values) {
            addCriterion("professionalId in", values, "professionalid");
            return (Criteria) this;
        }

        public Criteria andProfessionalidNotIn(List<Integer> values) {
            addCriterion("professionalId not in", values, "professionalid");
            return (Criteria) this;
        }

        public Criteria andProfessionalidBetween(Integer value1, Integer value2) {
            addCriterion("professionalId between", value1, value2, "professionalid");
            return (Criteria) this;
        }

        public Criteria andProfessionalidNotBetween(Integer value1, Integer value2) {
            addCriterion("professionalId not between", value1, value2, "professionalid");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameIsNull() {
            addCriterion("professionalName is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameIsNotNull() {
            addCriterion("professionalName is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameEqualTo(String value) {
            addCriterion("professionalName =", value, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameNotEqualTo(String value) {
            addCriterion("professionalName <>", value, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameGreaterThan(String value) {
            addCriterion("professionalName >", value, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameGreaterThanOrEqualTo(String value) {
            addCriterion("professionalName >=", value, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameLessThan(String value) {
            addCriterion("professionalName <", value, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameLessThanOrEqualTo(String value) {
            addCriterion("professionalName <=", value, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameLike(String value) {
            addCriterion("professionalName like", value, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameNotLike(String value) {
            addCriterion("professionalName not like", value, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameIn(List<String> values) {
            addCriterion("professionalName in", values, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameNotIn(List<String> values) {
            addCriterion("professionalName not in", values, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameBetween(String value1, String value2) {
            addCriterion("professionalName between", value1, value2, "professionalname");
            return (Criteria) this;
        }

        public Criteria andProfessionalnameNotBetween(String value1, String value2) {
            addCriterion("professionalName not between", value1, value2, "professionalname");
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