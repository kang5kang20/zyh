package com.zyh.entity.resume;

import java.util.ArrayList;
import java.util.List;

public class ZyhResumeEducationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZyhResumeEducationExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
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

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andEdtimeIsNull() {
            addCriterion("edtime is null");
            return (Criteria) this;
        }

        public Criteria andEdtimeIsNotNull() {
            addCriterion("edtime is not null");
            return (Criteria) this;
        }

        public Criteria andEdtimeEqualTo(String value) {
            addCriterion("edtime =", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeNotEqualTo(String value) {
            addCriterion("edtime <>", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeGreaterThan(String value) {
            addCriterion("edtime >", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeGreaterThanOrEqualTo(String value) {
            addCriterion("edtime >=", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeLessThan(String value) {
            addCriterion("edtime <", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeLessThanOrEqualTo(String value) {
            addCriterion("edtime <=", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeLike(String value) {
            addCriterion("edtime like", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeNotLike(String value) {
            addCriterion("edtime not like", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeIn(List<String> values) {
            addCriterion("edtime in", values, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeNotIn(List<String> values) {
            addCriterion("edtime not in", values, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeBetween(String value1, String value2) {
            addCriterion("edtime between", value1, value2, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeNotBetween(String value1, String value2) {
            addCriterion("edtime not between", value1, value2, "edtime");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andEdstateIsNull() {
            addCriterion("edstate is null");
            return (Criteria) this;
        }

        public Criteria andEdstateIsNotNull() {
            addCriterion("edstate is not null");
            return (Criteria) this;
        }

        public Criteria andEdstateEqualTo(String value) {
            addCriterion("edstate =", value, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateNotEqualTo(String value) {
            addCriterion("edstate <>", value, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateGreaterThan(String value) {
            addCriterion("edstate >", value, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateGreaterThanOrEqualTo(String value) {
            addCriterion("edstate >=", value, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateLessThan(String value) {
            addCriterion("edstate <", value, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateLessThanOrEqualTo(String value) {
            addCriterion("edstate <=", value, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateLike(String value) {
            addCriterion("edstate like", value, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateNotLike(String value) {
            addCriterion("edstate not like", value, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateIn(List<String> values) {
            addCriterion("edstate in", values, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateNotIn(List<String> values) {
            addCriterion("edstate not in", values, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateBetween(String value1, String value2) {
            addCriterion("edstate between", value1, value2, "edstate");
            return (Criteria) this;
        }

        public Criteria andEdstateNotBetween(String value1, String value2) {
            addCriterion("edstate not between", value1, value2, "edstate");
            return (Criteria) this;
        }

        public Criteria andDesctIsNull() {
            addCriterion("desct is null");
            return (Criteria) this;
        }

        public Criteria andDesctIsNotNull() {
            addCriterion("desct is not null");
            return (Criteria) this;
        }

        public Criteria andDesctEqualTo(String value) {
            addCriterion("desct =", value, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctNotEqualTo(String value) {
            addCriterion("desct <>", value, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctGreaterThan(String value) {
            addCriterion("desct >", value, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctGreaterThanOrEqualTo(String value) {
            addCriterion("desct >=", value, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctLessThan(String value) {
            addCriterion("desct <", value, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctLessThanOrEqualTo(String value) {
            addCriterion("desct <=", value, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctLike(String value) {
            addCriterion("desct like", value, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctNotLike(String value) {
            addCriterion("desct not like", value, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctIn(List<String> values) {
            addCriterion("desct in", values, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctNotIn(List<String> values) {
            addCriterion("desct not in", values, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctBetween(String value1, String value2) {
            addCriterion("desct between", value1, value2, "desct");
            return (Criteria) this;
        }

        public Criteria andDesctNotBetween(String value1, String value2) {
            addCriterion("desct not between", value1, value2, "desct");
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