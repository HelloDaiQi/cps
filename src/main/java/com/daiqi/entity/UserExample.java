package com.daiqi.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickName is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickName is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickName =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickName <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickName >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickName >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickName <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickName <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickName like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickName not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickName in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickName not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickName between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickName not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andUserimageIsNull() {
            addCriterion("userImage is null");
            return (Criteria) this;
        }

        public Criteria andUserimageIsNotNull() {
            addCriterion("userImage is not null");
            return (Criteria) this;
        }

        public Criteria andUserimageEqualTo(String value) {
            addCriterion("userImage =", value, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageNotEqualTo(String value) {
            addCriterion("userImage <>", value, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageGreaterThan(String value) {
            addCriterion("userImage >", value, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageGreaterThanOrEqualTo(String value) {
            addCriterion("userImage >=", value, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageLessThan(String value) {
            addCriterion("userImage <", value, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageLessThanOrEqualTo(String value) {
            addCriterion("userImage <=", value, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageLike(String value) {
            addCriterion("userImage like", value, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageNotLike(String value) {
            addCriterion("userImage not like", value, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageIn(List<String> values) {
            addCriterion("userImage in", values, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageNotIn(List<String> values) {
            addCriterion("userImage not in", values, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageBetween(String value1, String value2) {
            addCriterion("userImage between", value1, value2, "userimage");
            return (Criteria) this;
        }

        public Criteria andUserimageNotBetween(String value1, String value2) {
            addCriterion("userImage not between", value1, value2, "userimage");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(Integer value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(Integer value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(Integer value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(Integer value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(Integer value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(Integer value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<Integer> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<Integer> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(Integer value1, Integer value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(Integer value1, Integer value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Integer value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Integer value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Integer value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Integer value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Integer value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Integer> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Integer> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Integer value1, Integer value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNull() {
            addCriterion("professional is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNotNull() {
            addCriterion("professional is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalEqualTo(Integer value) {
            addCriterion("professional =", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotEqualTo(Integer value) {
            addCriterion("professional <>", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThan(Integer value) {
            addCriterion("professional >", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThanOrEqualTo(Integer value) {
            addCriterion("professional >=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThan(Integer value) {
            addCriterion("professional <", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThanOrEqualTo(Integer value) {
            addCriterion("professional <=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalIn(List<Integer> values) {
            addCriterion("professional in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotIn(List<Integer> values) {
            addCriterion("professional not in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalBetween(Integer value1, Integer value2) {
            addCriterion("professional between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotBetween(Integer value1, Integer value2) {
            addCriterion("professional not between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNull() {
            addCriterion("experience is null");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNotNull() {
            addCriterion("experience is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceEqualTo(Integer value) {
            addCriterion("experience =", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotEqualTo(Integer value) {
            addCriterion("experience <>", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThan(Integer value) {
            addCriterion("experience >", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("experience >=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThan(Integer value) {
            addCriterion("experience <", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThanOrEqualTo(Integer value) {
            addCriterion("experience <=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceIn(List<Integer> values) {
            addCriterion("experience in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotIn(List<Integer> values) {
            addCriterion("experience not in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceBetween(Integer value1, Integer value2) {
            addCriterion("experience between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotBetween(Integer value1, Integer value2) {
            addCriterion("experience not between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andMajorskillIsNull() {
            addCriterion("majorSkill is null");
            return (Criteria) this;
        }

        public Criteria andMajorskillIsNotNull() {
            addCriterion("majorSkill is not null");
            return (Criteria) this;
        }

        public Criteria andMajorskillEqualTo(Integer value) {
            addCriterion("majorSkill =", value, "majorskill");
            return (Criteria) this;
        }

        public Criteria andMajorskillNotEqualTo(Integer value) {
            addCriterion("majorSkill <>", value, "majorskill");
            return (Criteria) this;
        }

        public Criteria andMajorskillGreaterThan(Integer value) {
            addCriterion("majorSkill >", value, "majorskill");
            return (Criteria) this;
        }

        public Criteria andMajorskillGreaterThanOrEqualTo(Integer value) {
            addCriterion("majorSkill >=", value, "majorskill");
            return (Criteria) this;
        }

        public Criteria andMajorskillLessThan(Integer value) {
            addCriterion("majorSkill <", value, "majorskill");
            return (Criteria) this;
        }

        public Criteria andMajorskillLessThanOrEqualTo(Integer value) {
            addCriterion("majorSkill <=", value, "majorskill");
            return (Criteria) this;
        }

        public Criteria andMajorskillIn(List<Integer> values) {
            addCriterion("majorSkill in", values, "majorskill");
            return (Criteria) this;
        }

        public Criteria andMajorskillNotIn(List<Integer> values) {
            addCriterion("majorSkill not in", values, "majorskill");
            return (Criteria) this;
        }

        public Criteria andMajorskillBetween(Integer value1, Integer value2) {
            addCriterion("majorSkill between", value1, value2, "majorskill");
            return (Criteria) this;
        }

        public Criteria andMajorskillNotBetween(Integer value1, Integer value2) {
            addCriterion("majorSkill not between", value1, value2, "majorskill");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyIsNull() {
            addCriterion("majorSkillProficiency is null");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyIsNotNull() {
            addCriterion("majorSkillProficiency is not null");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyEqualTo(Integer value) {
            addCriterion("majorSkillProficiency =", value, "majorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyNotEqualTo(Integer value) {
            addCriterion("majorSkillProficiency <>", value, "majorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyGreaterThan(Integer value) {
            addCriterion("majorSkillProficiency >", value, "majorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("majorSkillProficiency >=", value, "majorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyLessThan(Integer value) {
            addCriterion("majorSkillProficiency <", value, "majorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyLessThanOrEqualTo(Integer value) {
            addCriterion("majorSkillProficiency <=", value, "majorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyIn(List<Integer> values) {
            addCriterion("majorSkillProficiency in", values, "majorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyNotIn(List<Integer> values) {
            addCriterion("majorSkillProficiency not in", values, "majorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyBetween(Integer value1, Integer value2) {
            addCriterion("majorSkillProficiency between", value1, value2, "majorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMajorskillproficiencyNotBetween(Integer value1, Integer value2) {
            addCriterion("majorSkillProficiency not between", value1, value2, "majorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMinorskillIsNull() {
            addCriterion("minorSkill is null");
            return (Criteria) this;
        }

        public Criteria andMinorskillIsNotNull() {
            addCriterion("minorSkill is not null");
            return (Criteria) this;
        }

        public Criteria andMinorskillEqualTo(Integer value) {
            addCriterion("minorSkill =", value, "minorskill");
            return (Criteria) this;
        }

        public Criteria andMinorskillNotEqualTo(Integer value) {
            addCriterion("minorSkill <>", value, "minorskill");
            return (Criteria) this;
        }

        public Criteria andMinorskillGreaterThan(Integer value) {
            addCriterion("minorSkill >", value, "minorskill");
            return (Criteria) this;
        }

        public Criteria andMinorskillGreaterThanOrEqualTo(Integer value) {
            addCriterion("minorSkill >=", value, "minorskill");
            return (Criteria) this;
        }

        public Criteria andMinorskillLessThan(Integer value) {
            addCriterion("minorSkill <", value, "minorskill");
            return (Criteria) this;
        }

        public Criteria andMinorskillLessThanOrEqualTo(Integer value) {
            addCriterion("minorSkill <=", value, "minorskill");
            return (Criteria) this;
        }

        public Criteria andMinorskillIn(List<Integer> values) {
            addCriterion("minorSkill in", values, "minorskill");
            return (Criteria) this;
        }

        public Criteria andMinorskillNotIn(List<Integer> values) {
            addCriterion("minorSkill not in", values, "minorskill");
            return (Criteria) this;
        }

        public Criteria andMinorskillBetween(Integer value1, Integer value2) {
            addCriterion("minorSkill between", value1, value2, "minorskill");
            return (Criteria) this;
        }

        public Criteria andMinorskillNotBetween(Integer value1, Integer value2) {
            addCriterion("minorSkill not between", value1, value2, "minorskill");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyIsNull() {
            addCriterion("minorSkillProficiency is null");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyIsNotNull() {
            addCriterion("minorSkillProficiency is not null");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyEqualTo(Integer value) {
            addCriterion("minorSkillProficiency =", value, "minorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyNotEqualTo(Integer value) {
            addCriterion("minorSkillProficiency <>", value, "minorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyGreaterThan(Integer value) {
            addCriterion("minorSkillProficiency >", value, "minorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("minorSkillProficiency >=", value, "minorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyLessThan(Integer value) {
            addCriterion("minorSkillProficiency <", value, "minorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyLessThanOrEqualTo(Integer value) {
            addCriterion("minorSkillProficiency <=", value, "minorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyIn(List<Integer> values) {
            addCriterion("minorSkillProficiency in", values, "minorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyNotIn(List<Integer> values) {
            addCriterion("minorSkillProficiency not in", values, "minorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyBetween(Integer value1, Integer value2) {
            addCriterion("minorSkillProficiency between", value1, value2, "minorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andMinorskillproficiencyNotBetween(Integer value1, Integer value2) {
            addCriterion("minorSkillProficiency not between", value1, value2, "minorskillproficiency");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phoneNumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phoneNumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phoneNumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phoneNumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phoneNumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phoneNumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phoneNumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phoneNumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phoneNumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phoneNumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phoneNumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberIsNull() {
            addCriterion("qqNumber is null");
            return (Criteria) this;
        }

        public Criteria andQqnumberIsNotNull() {
            addCriterion("qqNumber is not null");
            return (Criteria) this;
        }

        public Criteria andQqnumberEqualTo(String value) {
            addCriterion("qqNumber =", value, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberNotEqualTo(String value) {
            addCriterion("qqNumber <>", value, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberGreaterThan(String value) {
            addCriterion("qqNumber >", value, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberGreaterThanOrEqualTo(String value) {
            addCriterion("qqNumber >=", value, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberLessThan(String value) {
            addCriterion("qqNumber <", value, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberLessThanOrEqualTo(String value) {
            addCriterion("qqNumber <=", value, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberLike(String value) {
            addCriterion("qqNumber like", value, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberNotLike(String value) {
            addCriterion("qqNumber not like", value, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberIn(List<String> values) {
            addCriterion("qqNumber in", values, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberNotIn(List<String> values) {
            addCriterion("qqNumber not in", values, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberBetween(String value1, String value2) {
            addCriterion("qqNumber between", value1, value2, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andQqnumberNotBetween(String value1, String value2) {
            addCriterion("qqNumber not between", value1, value2, "qqnumber");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNull() {
            addCriterion("registerTime is null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNotNull() {
            addCriterion("registerTime is not null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeEqualTo(Date value) {
            addCriterionForJDBCDate("registerTime =", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("registerTime <>", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThan(Date value) {
            addCriterionForJDBCDate("registerTime >", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("registerTime >=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThan(Date value) {
            addCriterionForJDBCDate("registerTime <", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("registerTime <=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIn(List<Date> values) {
            addCriterionForJDBCDate("registerTime in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("registerTime not in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("registerTime between", value1, value2, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("registerTime not between", value1, value2, "registertime");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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