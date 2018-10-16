package com.zyh.entity.company;

import java.util.ArrayList;
import java.util.List;

public class ZyhCompanyTrainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZyhCompanyTrainExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLabelIsNull() {
            addCriterion("label is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("label is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("label =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("label <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("label >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("label >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("label <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("label <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("label like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("label not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("label in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("label not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("label between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("label not between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabeltxtIsNull() {
            addCriterion("labeltxt is null");
            return (Criteria) this;
        }

        public Criteria andLabeltxtIsNotNull() {
            addCriterion("labeltxt is not null");
            return (Criteria) this;
        }

        public Criteria andLabeltxtEqualTo(String value) {
            addCriterion("labeltxt =", value, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtNotEqualTo(String value) {
            addCriterion("labeltxt <>", value, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtGreaterThan(String value) {
            addCriterion("labeltxt >", value, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtGreaterThanOrEqualTo(String value) {
            addCriterion("labeltxt >=", value, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtLessThan(String value) {
            addCriterion("labeltxt <", value, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtLessThanOrEqualTo(String value) {
            addCriterion("labeltxt <=", value, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtLike(String value) {
            addCriterion("labeltxt like", value, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtNotLike(String value) {
            addCriterion("labeltxt not like", value, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtIn(List<String> values) {
            addCriterion("labeltxt in", values, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtNotIn(List<String> values) {
            addCriterion("labeltxt not in", values, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtBetween(String value1, String value2) {
            addCriterion("labeltxt between", value1, value2, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andLabeltxtNotBetween(String value1, String value2) {
            addCriterion("labeltxt not between", value1, value2, "labeltxt");
            return (Criteria) this;
        }

        public Criteria andClassdescIsNull() {
            addCriterion("classdesc is null");
            return (Criteria) this;
        }

        public Criteria andClassdescIsNotNull() {
            addCriterion("classdesc is not null");
            return (Criteria) this;
        }

        public Criteria andClassdescEqualTo(String value) {
            addCriterion("classdesc =", value, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescNotEqualTo(String value) {
            addCriterion("classdesc <>", value, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescGreaterThan(String value) {
            addCriterion("classdesc >", value, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescGreaterThanOrEqualTo(String value) {
            addCriterion("classdesc >=", value, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescLessThan(String value) {
            addCriterion("classdesc <", value, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescLessThanOrEqualTo(String value) {
            addCriterion("classdesc <=", value, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescLike(String value) {
            addCriterion("classdesc like", value, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescNotLike(String value) {
            addCriterion("classdesc not like", value, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescIn(List<String> values) {
            addCriterion("classdesc in", values, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescNotIn(List<String> values) {
            addCriterion("classdesc not in", values, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescBetween(String value1, String value2) {
            addCriterion("classdesc between", value1, value2, "classdesc");
            return (Criteria) this;
        }

        public Criteria andClassdescNotBetween(String value1, String value2) {
            addCriterion("classdesc not between", value1, value2, "classdesc");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNull() {
            addCriterion("companyid is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyid is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(String value) {
            addCriterion("companyid =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(String value) {
            addCriterion("companyid <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(String value) {
            addCriterion("companyid >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(String value) {
            addCriterion("companyid >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(String value) {
            addCriterion("companyid <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(String value) {
            addCriterion("companyid <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLike(String value) {
            addCriterion("companyid like", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotLike(String value) {
            addCriterion("companyid not like", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<String> values) {
            addCriterion("companyid in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<String> values) {
            addCriterion("companyid not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(String value1, String value2) {
            addCriterion("companyid between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(String value1, String value2) {
            addCriterion("companyid not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andWeburlIsNull() {
            addCriterion("weburl is null");
            return (Criteria) this;
        }

        public Criteria andWeburlIsNotNull() {
            addCriterion("weburl is not null");
            return (Criteria) this;
        }

        public Criteria andWeburlEqualTo(String value) {
            addCriterion("weburl =", value, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlNotEqualTo(String value) {
            addCriterion("weburl <>", value, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlGreaterThan(String value) {
            addCriterion("weburl >", value, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlGreaterThanOrEqualTo(String value) {
            addCriterion("weburl >=", value, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlLessThan(String value) {
            addCriterion("weburl <", value, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlLessThanOrEqualTo(String value) {
            addCriterion("weburl <=", value, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlLike(String value) {
            addCriterion("weburl like", value, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlNotLike(String value) {
            addCriterion("weburl not like", value, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlIn(List<String> values) {
            addCriterion("weburl in", values, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlNotIn(List<String> values) {
            addCriterion("weburl not in", values, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlBetween(String value1, String value2) {
            addCriterion("weburl between", value1, value2, "weburl");
            return (Criteria) this;
        }

        public Criteria andWeburlNotBetween(String value1, String value2) {
            addCriterion("weburl not between", value1, value2, "weburl");
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