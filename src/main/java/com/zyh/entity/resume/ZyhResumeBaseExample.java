package com.zyh.entity.resume;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZyhResumeBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZyhResumeBaseExample() {
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andSoldierdateIsNull() {
            addCriterion("soldierdate is null");
            return (Criteria) this;
        }

        public Criteria andSoldierdateIsNotNull() {
            addCriterion("soldierdate is not null");
            return (Criteria) this;
        }

        public Criteria andSoldierdateEqualTo(String value) {
            addCriterion("soldierdate =", value, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateNotEqualTo(String value) {
            addCriterion("soldierdate <>", value, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateGreaterThan(String value) {
            addCriterion("soldierdate >", value, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateGreaterThanOrEqualTo(String value) {
            addCriterion("soldierdate >=", value, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateLessThan(String value) {
            addCriterion("soldierdate <", value, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateLessThanOrEqualTo(String value) {
            addCriterion("soldierdate <=", value, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateLike(String value) {
            addCriterion("soldierdate like", value, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateNotLike(String value) {
            addCriterion("soldierdate not like", value, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateIn(List<String> values) {
            addCriterion("soldierdate in", values, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateNotIn(List<String> values) {
            addCriterion("soldierdate not in", values, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateBetween(String value1, String value2) {
            addCriterion("soldierdate between", value1, value2, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andSoldierdateNotBetween(String value1, String value2) {
            addCriterion("soldierdate not between", value1, value2, "soldierdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateIsNull() {
            addCriterion("workdate is null");
            return (Criteria) this;
        }

        public Criteria andWorkdateIsNotNull() {
            addCriterion("workdate is not null");
            return (Criteria) this;
        }

        public Criteria andWorkdateEqualTo(Date value) {
            addCriterion("workdate =", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotEqualTo(Date value) {
            addCriterion("workdate <>", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateGreaterThan(Date value) {
            addCriterion("workdate >", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateGreaterThanOrEqualTo(Date value) {
            addCriterion("workdate >=", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLessThan(Date value) {
            addCriterion("workdate <", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLessThanOrEqualTo(Date value) {
            addCriterion("workdate <=", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateIn(List<Date> values) {
            addCriterion("workdate in", values, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotIn(List<Date> values) {
            addCriterion("workdate not in", values, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateBetween(Date value1, Date value2) {
            addCriterion("workdate between", value1, value2, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotBetween(Date value1, Date value2) {
            addCriterion("workdate not between", value1, value2, "workdate");
            return (Criteria) this;
        }

        public Criteria andBdzyIsNull() {
            addCriterion("bdzy is null");
            return (Criteria) this;
        }

        public Criteria andBdzyIsNotNull() {
            addCriterion("bdzy is not null");
            return (Criteria) this;
        }

        public Criteria andBdzyEqualTo(String value) {
            addCriterion("bdzy =", value, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyNotEqualTo(String value) {
            addCriterion("bdzy <>", value, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyGreaterThan(String value) {
            addCriterion("bdzy >", value, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyGreaterThanOrEqualTo(String value) {
            addCriterion("bdzy >=", value, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyLessThan(String value) {
            addCriterion("bdzy <", value, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyLessThanOrEqualTo(String value) {
            addCriterion("bdzy <=", value, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyLike(String value) {
            addCriterion("bdzy like", value, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyNotLike(String value) {
            addCriterion("bdzy not like", value, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyIn(List<String> values) {
            addCriterion("bdzy in", values, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyNotIn(List<String> values) {
            addCriterion("bdzy not in", values, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyBetween(String value1, String value2) {
            addCriterion("bdzy between", value1, value2, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzyNotBetween(String value1, String value2) {
            addCriterion("bdzy not between", value1, value2, "bdzy");
            return (Criteria) this;
        }

        public Criteria andBdzwIsNull() {
            addCriterion("bdzw is null");
            return (Criteria) this;
        }

        public Criteria andBdzwIsNotNull() {
            addCriterion("bdzw is not null");
            return (Criteria) this;
        }

        public Criteria andBdzwEqualTo(String value) {
            addCriterion("bdzw =", value, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwNotEqualTo(String value) {
            addCriterion("bdzw <>", value, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwGreaterThan(String value) {
            addCriterion("bdzw >", value, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwGreaterThanOrEqualTo(String value) {
            addCriterion("bdzw >=", value, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwLessThan(String value) {
            addCriterion("bdzw <", value, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwLessThanOrEqualTo(String value) {
            addCriterion("bdzw <=", value, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwLike(String value) {
            addCriterion("bdzw like", value, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwNotLike(String value) {
            addCriterion("bdzw not like", value, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwIn(List<String> values) {
            addCriterion("bdzw in", values, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwNotIn(List<String> values) {
            addCriterion("bdzw not in", values, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwBetween(String value1, String value2) {
            addCriterion("bdzw between", value1, value2, "bdzw");
            return (Criteria) this;
        }

        public Criteria andBdzwNotBetween(String value1, String value2) {
            addCriterion("bdzw not between", value1, value2, "bdzw");
            return (Criteria) this;
        }

        public Criteria andSoldiernoIsNull() {
            addCriterion("soldierno is null");
            return (Criteria) this;
        }

        public Criteria andSoldiernoIsNotNull() {
            addCriterion("soldierno is not null");
            return (Criteria) this;
        }

        public Criteria andSoldiernoEqualTo(String value) {
            addCriterion("soldierno =", value, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoNotEqualTo(String value) {
            addCriterion("soldierno <>", value, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoGreaterThan(String value) {
            addCriterion("soldierno >", value, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoGreaterThanOrEqualTo(String value) {
            addCriterion("soldierno >=", value, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoLessThan(String value) {
            addCriterion("soldierno <", value, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoLessThanOrEqualTo(String value) {
            addCriterion("soldierno <=", value, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoLike(String value) {
            addCriterion("soldierno like", value, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoNotLike(String value) {
            addCriterion("soldierno not like", value, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoIn(List<String> values) {
            addCriterion("soldierno in", values, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoNotIn(List<String> values) {
            addCriterion("soldierno not in", values, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoBetween(String value1, String value2) {
            addCriterion("soldierno between", value1, value2, "soldierno");
            return (Criteria) this;
        }

        public Criteria andSoldiernoNotBetween(String value1, String value2) {
            addCriterion("soldierno not between", value1, value2, "soldierno");
            return (Criteria) this;
        }

        public Criteria andZzmmIsNull() {
            addCriterion("zzmm is null");
            return (Criteria) this;
        }

        public Criteria andZzmmIsNotNull() {
            addCriterion("zzmm is not null");
            return (Criteria) this;
        }

        public Criteria andZzmmEqualTo(String value) {
            addCriterion("zzmm =", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotEqualTo(String value) {
            addCriterion("zzmm <>", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmGreaterThan(String value) {
            addCriterion("zzmm >", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmGreaterThanOrEqualTo(String value) {
            addCriterion("zzmm >=", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLessThan(String value) {
            addCriterion("zzmm <", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLessThanOrEqualTo(String value) {
            addCriterion("zzmm <=", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLike(String value) {
            addCriterion("zzmm like", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotLike(String value) {
            addCriterion("zzmm not like", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmIn(List<String> values) {
            addCriterion("zzmm in", values, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotIn(List<String> values) {
            addCriterion("zzmm not in", values, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmBetween(String value1, String value2) {
            addCriterion("zzmm between", value1, value2, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotBetween(String value1, String value2) {
            addCriterion("zzmm not between", value1, value2, "zzmm");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNull() {
            addCriterion("idno is null");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNotNull() {
            addCriterion("idno is not null");
            return (Criteria) this;
        }

        public Criteria andIdnoEqualTo(String value) {
            addCriterion("idno =", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotEqualTo(String value) {
            addCriterion("idno <>", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThan(String value) {
            addCriterion("idno >", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThanOrEqualTo(String value) {
            addCriterion("idno >=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThan(String value) {
            addCriterion("idno <", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThanOrEqualTo(String value) {
            addCriterion("idno <=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLike(String value) {
            addCriterion("idno like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotLike(String value) {
            addCriterion("idno not like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoIn(List<String> values) {
            addCriterion("idno in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotIn(List<String> values) {
            addCriterion("idno not in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoBetween(String value1, String value2) {
            addCriterion("idno between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotBetween(String value1, String value2) {
            addCriterion("idno not between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNull() {
            addCriterion("cellphone is null");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNotNull() {
            addCriterion("cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andCellphoneEqualTo(String value) {
            addCriterion("cellphone =", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotEqualTo(String value) {
            addCriterion("cellphone <>", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThan(String value) {
            addCriterion("cellphone >", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("cellphone >=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThan(String value) {
            addCriterion("cellphone <", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThanOrEqualTo(String value) {
            addCriterion("cellphone <=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLike(String value) {
            addCriterion("cellphone like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotLike(String value) {
            addCriterion("cellphone not like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneIn(List<String> values) {
            addCriterion("cellphone in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotIn(List<String> values) {
            addCriterion("cellphone not in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneBetween(String value1, String value2) {
            addCriterion("cellphone between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotBetween(String value1, String value2) {
            addCriterion("cellphone not between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andBirthcityIsNull() {
            addCriterion("birthcity is null");
            return (Criteria) this;
        }

        public Criteria andBirthcityIsNotNull() {
            addCriterion("birthcity is not null");
            return (Criteria) this;
        }

        public Criteria andBirthcityEqualTo(String value) {
            addCriterion("birthcity =", value, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityNotEqualTo(String value) {
            addCriterion("birthcity <>", value, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityGreaterThan(String value) {
            addCriterion("birthcity >", value, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityGreaterThanOrEqualTo(String value) {
            addCriterion("birthcity >=", value, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityLessThan(String value) {
            addCriterion("birthcity <", value, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityLessThanOrEqualTo(String value) {
            addCriterion("birthcity <=", value, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityLike(String value) {
            addCriterion("birthcity like", value, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityNotLike(String value) {
            addCriterion("birthcity not like", value, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityIn(List<String> values) {
            addCriterion("birthcity in", values, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityNotIn(List<String> values) {
            addCriterion("birthcity not in", values, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityBetween(String value1, String value2) {
            addCriterion("birthcity between", value1, value2, "birthcity");
            return (Criteria) this;
        }

        public Criteria andBirthcityNotBetween(String value1, String value2) {
            addCriterion("birthcity not between", value1, value2, "birthcity");
            return (Criteria) this;
        }

        public Criteria andEvaluationIsNull() {
            addCriterion("evaluation is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationIsNotNull() {
            addCriterion("evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationEqualTo(String value) {
            addCriterion("evaluation =", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotEqualTo(String value) {
            addCriterion("evaluation <>", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationGreaterThan(String value) {
            addCriterion("evaluation >", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("evaluation >=", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLessThan(String value) {
            addCriterion("evaluation <", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLessThanOrEqualTo(String value) {
            addCriterion("evaluation <=", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLike(String value) {
            addCriterion("evaluation like", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotLike(String value) {
            addCriterion("evaluation not like", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationIn(List<String> values) {
            addCriterion("evaluation in", values, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotIn(List<String> values) {
            addCriterion("evaluation not in", values, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationBetween(String value1, String value2) {
            addCriterion("evaluation between", value1, value2, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotBetween(String value1, String value2) {
            addCriterion("evaluation not between", value1, value2, "evaluation");
            return (Criteria) this;
        }

        public Criteria andIdurlIsNull() {
            addCriterion("idurl is null");
            return (Criteria) this;
        }

        public Criteria andIdurlIsNotNull() {
            addCriterion("idurl is not null");
            return (Criteria) this;
        }

        public Criteria andIdurlEqualTo(String value) {
            addCriterion("idurl =", value, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlNotEqualTo(String value) {
            addCriterion("idurl <>", value, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlGreaterThan(String value) {
            addCriterion("idurl >", value, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlGreaterThanOrEqualTo(String value) {
            addCriterion("idurl >=", value, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlLessThan(String value) {
            addCriterion("idurl <", value, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlLessThanOrEqualTo(String value) {
            addCriterion("idurl <=", value, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlLike(String value) {
            addCriterion("idurl like", value, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlNotLike(String value) {
            addCriterion("idurl not like", value, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlIn(List<String> values) {
            addCriterion("idurl in", values, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlNotIn(List<String> values) {
            addCriterion("idurl not in", values, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlBetween(String value1, String value2) {
            addCriterion("idurl between", value1, value2, "idurl");
            return (Criteria) this;
        }

        public Criteria andIdurlNotBetween(String value1, String value2) {
            addCriterion("idurl not between", value1, value2, "idurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlIsNull() {
            addCriterion("soldierurl is null");
            return (Criteria) this;
        }

        public Criteria andSoldierurlIsNotNull() {
            addCriterion("soldierurl is not null");
            return (Criteria) this;
        }

        public Criteria andSoldierurlEqualTo(String value) {
            addCriterion("soldierurl =", value, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlNotEqualTo(String value) {
            addCriterion("soldierurl <>", value, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlGreaterThan(String value) {
            addCriterion("soldierurl >", value, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlGreaterThanOrEqualTo(String value) {
            addCriterion("soldierurl >=", value, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlLessThan(String value) {
            addCriterion("soldierurl <", value, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlLessThanOrEqualTo(String value) {
            addCriterion("soldierurl <=", value, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlLike(String value) {
            addCriterion("soldierurl like", value, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlNotLike(String value) {
            addCriterion("soldierurl not like", value, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlIn(List<String> values) {
            addCriterion("soldierurl in", values, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlNotIn(List<String> values) {
            addCriterion("soldierurl not in", values, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlBetween(String value1, String value2) {
            addCriterion("soldierurl between", value1, value2, "soldierurl");
            return (Criteria) this;
        }

        public Criteria andSoldierurlNotBetween(String value1, String value2) {
            addCriterion("soldierurl not between", value1, value2, "soldierurl");
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