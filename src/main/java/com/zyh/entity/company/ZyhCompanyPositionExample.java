package com.zyh.entity.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZyhCompanyPositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZyhCompanyPositionExample() {
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

        public Criteria andCompnaynameIsNull() {
            addCriterion("compnayname is null");
            return (Criteria) this;
        }

        public Criteria andCompnaynameIsNotNull() {
            addCriterion("compnayname is not null");
            return (Criteria) this;
        }

        public Criteria andCompnaynameEqualTo(String value) {
            addCriterion("compnayname =", value, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameNotEqualTo(String value) {
            addCriterion("compnayname <>", value, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameGreaterThan(String value) {
            addCriterion("compnayname >", value, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameGreaterThanOrEqualTo(String value) {
            addCriterion("compnayname >=", value, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameLessThan(String value) {
            addCriterion("compnayname <", value, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameLessThanOrEqualTo(String value) {
            addCriterion("compnayname <=", value, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameLike(String value) {
            addCriterion("compnayname like", value, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameNotLike(String value) {
            addCriterion("compnayname not like", value, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameIn(List<String> values) {
            addCriterion("compnayname in", values, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameNotIn(List<String> values) {
            addCriterion("compnayname not in", values, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameBetween(String value1, String value2) {
            addCriterion("compnayname between", value1, value2, "compnayname");
            return (Criteria) this;
        }

        public Criteria andCompnaynameNotBetween(String value1, String value2) {
            addCriterion("compnayname not between", value1, value2, "compnayname");
            return (Criteria) this;
        }

        public Criteria andPositionnameIsNull() {
            addCriterion("positionname is null");
            return (Criteria) this;
        }

        public Criteria andPositionnameIsNotNull() {
            addCriterion("positionname is not null");
            return (Criteria) this;
        }

        public Criteria andPositionnameEqualTo(String value) {
            addCriterion("positionname =", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotEqualTo(String value) {
            addCriterion("positionname <>", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameGreaterThan(String value) {
            addCriterion("positionname >", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameGreaterThanOrEqualTo(String value) {
            addCriterion("positionname >=", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameLessThan(String value) {
            addCriterion("positionname <", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameLessThanOrEqualTo(String value) {
            addCriterion("positionname <=", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameLike(String value) {
            addCriterion("positionname like", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotLike(String value) {
            addCriterion("positionname not like", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameIn(List<String> values) {
            addCriterion("positionname in", values, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotIn(List<String> values) {
            addCriterion("positionname not in", values, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameBetween(String value1, String value2) {
            addCriterion("positionname between", value1, value2, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotBetween(String value1, String value2) {
            addCriterion("positionname not between", value1, value2, "positionname");
            return (Criteria) this;
        }

        public Criteria andWorkcityIsNull() {
            addCriterion("workcity is null");
            return (Criteria) this;
        }

        public Criteria andWorkcityIsNotNull() {
            addCriterion("workcity is not null");
            return (Criteria) this;
        }

        public Criteria andWorkcityEqualTo(String value) {
            addCriterion("workcity =", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityNotEqualTo(String value) {
            addCriterion("workcity <>", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityGreaterThan(String value) {
            addCriterion("workcity >", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityGreaterThanOrEqualTo(String value) {
            addCriterion("workcity >=", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityLessThan(String value) {
            addCriterion("workcity <", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityLessThanOrEqualTo(String value) {
            addCriterion("workcity <=", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityLike(String value) {
            addCriterion("workcity like", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityNotLike(String value) {
            addCriterion("workcity not like", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityIn(List<String> values) {
            addCriterion("workcity in", values, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityNotIn(List<String> values) {
            addCriterion("workcity not in", values, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityBetween(String value1, String value2) {
            addCriterion("workcity between", value1, value2, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityNotBetween(String value1, String value2) {
            addCriterion("workcity not between", value1, value2, "workcity");
            return (Criteria) this;
        }

        public Criteria andFixyearIsNull() {
            addCriterion("fixyear is null");
            return (Criteria) this;
        }

        public Criteria andFixyearIsNotNull() {
            addCriterion("fixyear is not null");
            return (Criteria) this;
        }

        public Criteria andFixyearEqualTo(String value) {
            addCriterion("fixyear =", value, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearNotEqualTo(String value) {
            addCriterion("fixyear <>", value, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearGreaterThan(String value) {
            addCriterion("fixyear >", value, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearGreaterThanOrEqualTo(String value) {
            addCriterion("fixyear >=", value, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearLessThan(String value) {
            addCriterion("fixyear <", value, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearLessThanOrEqualTo(String value) {
            addCriterion("fixyear <=", value, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearLike(String value) {
            addCriterion("fixyear like", value, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearNotLike(String value) {
            addCriterion("fixyear not like", value, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearIn(List<String> values) {
            addCriterion("fixyear in", values, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearNotIn(List<String> values) {
            addCriterion("fixyear not in", values, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearBetween(String value1, String value2) {
            addCriterion("fixyear between", value1, value2, "fixyear");
            return (Criteria) this;
        }

        public Criteria andFixyearNotBetween(String value1, String value2) {
            addCriterion("fixyear not between", value1, value2, "fixyear");
            return (Criteria) this;
        }

        public Criteria andMaxageIsNull() {
            addCriterion("maxage is null");
            return (Criteria) this;
        }

        public Criteria andMaxageIsNotNull() {
            addCriterion("maxage is not null");
            return (Criteria) this;
        }

        public Criteria andMaxageEqualTo(String value) {
            addCriterion("maxage =", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageNotEqualTo(String value) {
            addCriterion("maxage <>", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageGreaterThan(String value) {
            addCriterion("maxage >", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageGreaterThanOrEqualTo(String value) {
            addCriterion("maxage >=", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageLessThan(String value) {
            addCriterion("maxage <", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageLessThanOrEqualTo(String value) {
            addCriterion("maxage <=", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageLike(String value) {
            addCriterion("maxage like", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageNotLike(String value) {
            addCriterion("maxage not like", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageIn(List<String> values) {
            addCriterion("maxage in", values, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageNotIn(List<String> values) {
            addCriterion("maxage not in", values, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageBetween(String value1, String value2) {
            addCriterion("maxage between", value1, value2, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageNotBetween(String value1, String value2) {
            addCriterion("maxage not between", value1, value2, "maxage");
            return (Criteria) this;
        }

        public Criteria andMoneyareaIsNull() {
            addCriterion("moneyarea is null");
            return (Criteria) this;
        }

        public Criteria andMoneyareaIsNotNull() {
            addCriterion("moneyarea is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyareaEqualTo(String value) {
            addCriterion("moneyarea =", value, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaNotEqualTo(String value) {
            addCriterion("moneyarea <>", value, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaGreaterThan(String value) {
            addCriterion("moneyarea >", value, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaGreaterThanOrEqualTo(String value) {
            addCriterion("moneyarea >=", value, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaLessThan(String value) {
            addCriterion("moneyarea <", value, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaLessThanOrEqualTo(String value) {
            addCriterion("moneyarea <=", value, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaLike(String value) {
            addCriterion("moneyarea like", value, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaNotLike(String value) {
            addCriterion("moneyarea not like", value, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaIn(List<String> values) {
            addCriterion("moneyarea in", values, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaNotIn(List<String> values) {
            addCriterion("moneyarea not in", values, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaBetween(String value1, String value2) {
            addCriterion("moneyarea between", value1, value2, "moneyarea");
            return (Criteria) this;
        }

        public Criteria andMoneyareaNotBetween(String value1, String value2) {
            addCriterion("moneyarea not between", value1, value2, "moneyarea");
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

        public Criteria andRequiredIsNull() {
            addCriterion("required is null");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNotNull() {
            addCriterion("required is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredEqualTo(String value) {
            addCriterion("required =", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotEqualTo(String value) {
            addCriterion("required <>", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThan(String value) {
            addCriterion("required >", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThanOrEqualTo(String value) {
            addCriterion("required >=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThan(String value) {
            addCriterion("required <", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThanOrEqualTo(String value) {
            addCriterion("required <=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLike(String value) {
            addCriterion("required like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotLike(String value) {
            addCriterion("required not like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredIn(List<String> values) {
            addCriterion("required in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotIn(List<String> values) {
            addCriterion("required not in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredBetween(String value1, String value2) {
            addCriterion("required between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotBetween(String value1, String value2) {
            addCriterion("required not between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andOptimeIsNull() {
            addCriterion("optime is null");
            return (Criteria) this;
        }

        public Criteria andOptimeIsNotNull() {
            addCriterion("optime is not null");
            return (Criteria) this;
        }

        public Criteria andOptimeEqualTo(Date value) {
            addCriterion("optime =", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeNotEqualTo(Date value) {
            addCriterion("optime <>", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeGreaterThan(Date value) {
            addCriterion("optime >", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("optime >=", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeLessThan(Date value) {
            addCriterion("optime <", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeLessThanOrEqualTo(Date value) {
            addCriterion("optime <=", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeIn(List<Date> values) {
            addCriterion("optime in", values, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeNotIn(List<Date> values) {
            addCriterion("optime not in", values, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeBetween(Date value1, Date value2) {
            addCriterion("optime between", value1, value2, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeNotBetween(Date value1, Date value2) {
            addCriterion("optime not between", value1, value2, "optime");
            return (Criteria) this;
        }

        public Criteria andMinmoneyIsNull() {
            addCriterion("minmoney is null");
            return (Criteria) this;
        }

        public Criteria andMinmoneyIsNotNull() {
            addCriterion("minmoney is not null");
            return (Criteria) this;
        }

        public Criteria andMinmoneyEqualTo(Float value) {
            addCriterion("minmoney =", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyNotEqualTo(Float value) {
            addCriterion("minmoney <>", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyGreaterThan(Float value) {
            addCriterion("minmoney >", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("minmoney >=", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyLessThan(Float value) {
            addCriterion("minmoney <", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyLessThanOrEqualTo(Float value) {
            addCriterion("minmoney <=", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyIn(List<Float> values) {
            addCriterion("minmoney in", values, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyNotIn(List<Float> values) {
            addCriterion("minmoney not in", values, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyBetween(Float value1, Float value2) {
            addCriterion("minmoney between", value1, value2, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyNotBetween(Float value1, Float value2) {
            addCriterion("minmoney not between", value1, value2, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyIsNull() {
            addCriterion("maxmoney is null");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyIsNotNull() {
            addCriterion("maxmoney is not null");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyEqualTo(Float value) {
            addCriterion("maxmoney =", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyNotEqualTo(Float value) {
            addCriterion("maxmoney <>", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyGreaterThan(Float value) {
            addCriterion("maxmoney >", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("maxmoney >=", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyLessThan(Float value) {
            addCriterion("maxmoney <", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyLessThanOrEqualTo(Float value) {
            addCriterion("maxmoney <=", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyIn(List<Float> values) {
            addCriterion("maxmoney in", values, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyNotIn(List<Float> values) {
            addCriterion("maxmoney not in", values, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyBetween(Float value1, Float value2) {
            addCriterion("maxmoney between", value1, value2, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyNotBetween(Float value1, Float value2) {
            addCriterion("maxmoney not between", value1, value2, "maxmoney");
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