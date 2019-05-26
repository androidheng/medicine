package com.medicine.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOrderExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("orderno is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("orderno is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("orderno =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("orderno <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("orderno >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("orderno >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("orderno <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("orderno <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("orderno like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("orderno not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("orderno in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("orderno not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("orderno between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("orderno not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNull() {
            addCriterion("ordertime is null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNotNull() {
            addCriterion("ordertime is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeEqualTo(String value) {
            addCriterion("ordertime =", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotEqualTo(String value) {
            addCriterion("ordertime <>", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThan(String value) {
            addCriterion("ordertime >", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThanOrEqualTo(String value) {
            addCriterion("ordertime >=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThan(String value) {
            addCriterion("ordertime <", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThanOrEqualTo(String value) {
            addCriterion("ordertime <=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLike(String value) {
            addCriterion("ordertime like", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotLike(String value) {
            addCriterion("ordertime not like", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIn(List<String> values) {
            addCriterion("ordertime in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotIn(List<String> values) {
            addCriterion("ordertime not in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeBetween(String value1, String value2) {
            addCriterion("ordertime between", value1, value2, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotBetween(String value1, String value2) {
            addCriterion("ordertime not between", value1, value2, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrderamtIsNull() {
            addCriterion("orderamt is null");
            return (Criteria) this;
        }

        public Criteria andOrderamtIsNotNull() {
            addCriterion("orderamt is not null");
            return (Criteria) this;
        }

        public Criteria andOrderamtEqualTo(String value) {
            addCriterion("orderamt =", value, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtNotEqualTo(String value) {
            addCriterion("orderamt <>", value, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtGreaterThan(String value) {
            addCriterion("orderamt >", value, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtGreaterThanOrEqualTo(String value) {
            addCriterion("orderamt >=", value, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtLessThan(String value) {
            addCriterion("orderamt <", value, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtLessThanOrEqualTo(String value) {
            addCriterion("orderamt <=", value, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtLike(String value) {
            addCriterion("orderamt like", value, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtNotLike(String value) {
            addCriterion("orderamt not like", value, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtIn(List<String> values) {
            addCriterion("orderamt in", values, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtNotIn(List<String> values) {
            addCriterion("orderamt not in", values, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtBetween(String value1, String value2) {
            addCriterion("orderamt between", value1, value2, "orderamt");
            return (Criteria) this;
        }

        public Criteria andOrderamtNotBetween(String value1, String value2) {
            addCriterion("orderamt not between", value1, value2, "orderamt");
            return (Criteria) this;
        }

        public Criteria andReceivermanIsNull() {
            addCriterion("receiverman is null");
            return (Criteria) this;
        }

        public Criteria andReceivermanIsNotNull() {
            addCriterion("receiverman is not null");
            return (Criteria) this;
        }

        public Criteria andReceivermanEqualTo(String value) {
            addCriterion("receiverman =", value, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanNotEqualTo(String value) {
            addCriterion("receiverman <>", value, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanGreaterThan(String value) {
            addCriterion("receiverman >", value, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanGreaterThanOrEqualTo(String value) {
            addCriterion("receiverman >=", value, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanLessThan(String value) {
            addCriterion("receiverman <", value, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanLessThanOrEqualTo(String value) {
            addCriterion("receiverman <=", value, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanLike(String value) {
            addCriterion("receiverman like", value, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanNotLike(String value) {
            addCriterion("receiverman not like", value, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanIn(List<String> values) {
            addCriterion("receiverman in", values, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanNotIn(List<String> values) {
            addCriterion("receiverman not in", values, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanBetween(String value1, String value2) {
            addCriterion("receiverman between", value1, value2, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReceivermanNotBetween(String value1, String value2) {
            addCriterion("receiverman not between", value1, value2, "receiverman");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneIsNull() {
            addCriterion("reveiverphone is null");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneIsNotNull() {
            addCriterion("reveiverphone is not null");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneEqualTo(String value) {
            addCriterion("reveiverphone =", value, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneNotEqualTo(String value) {
            addCriterion("reveiverphone <>", value, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneGreaterThan(String value) {
            addCriterion("reveiverphone >", value, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneGreaterThanOrEqualTo(String value) {
            addCriterion("reveiverphone >=", value, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneLessThan(String value) {
            addCriterion("reveiverphone <", value, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneLessThanOrEqualTo(String value) {
            addCriterion("reveiverphone <=", value, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneLike(String value) {
            addCriterion("reveiverphone like", value, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneNotLike(String value) {
            addCriterion("reveiverphone not like", value, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneIn(List<String> values) {
            addCriterion("reveiverphone in", values, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneNotIn(List<String> values) {
            addCriterion("reveiverphone not in", values, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneBetween(String value1, String value2) {
            addCriterion("reveiverphone between", value1, value2, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiverphoneNotBetween(String value1, String value2) {
            addCriterion("reveiverphone not between", value1, value2, "reveiverphone");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressIsNull() {
            addCriterion("reveiveraddress is null");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressIsNotNull() {
            addCriterion("reveiveraddress is not null");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressEqualTo(String value) {
            addCriterion("reveiveraddress =", value, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressNotEqualTo(String value) {
            addCriterion("reveiveraddress <>", value, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressGreaterThan(String value) {
            addCriterion("reveiveraddress >", value, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressGreaterThanOrEqualTo(String value) {
            addCriterion("reveiveraddress >=", value, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressLessThan(String value) {
            addCriterion("reveiveraddress <", value, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressLessThanOrEqualTo(String value) {
            addCriterion("reveiveraddress <=", value, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressLike(String value) {
            addCriterion("reveiveraddress like", value, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressNotLike(String value) {
            addCriterion("reveiveraddress not like", value, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressIn(List<String> values) {
            addCriterion("reveiveraddress in", values, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressNotIn(List<String> values) {
            addCriterion("reveiveraddress not in", values, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressBetween(String value1, String value2) {
            addCriterion("reveiveraddress between", value1, value2, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andReveiveraddressNotBetween(String value1, String value2) {
            addCriterion("reveiveraddress not between", value1, value2, "reveiveraddress");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andSelleridIsNull() {
            addCriterion("sellerid is null");
            return (Criteria) this;
        }

        public Criteria andSelleridIsNotNull() {
            addCriterion("sellerid is not null");
            return (Criteria) this;
        }

        public Criteria andSelleridEqualTo(Integer value) {
            addCriterion("sellerid =", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridNotEqualTo(Integer value) {
            addCriterion("sellerid <>", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridGreaterThan(Integer value) {
            addCriterion("sellerid >", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridGreaterThanOrEqualTo(Integer value) {
            addCriterion("sellerid >=", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridLessThan(Integer value) {
            addCriterion("sellerid <", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridLessThanOrEqualTo(Integer value) {
            addCriterion("sellerid <=", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridIn(List<Integer> values) {
            addCriterion("sellerid in", values, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridNotIn(List<Integer> values) {
            addCriterion("sellerid not in", values, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridBetween(Integer value1, Integer value2) {
            addCriterion("sellerid between", value1, value2, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridNotBetween(Integer value1, Integer value2) {
            addCriterion("sellerid not between", value1, value2, "sellerid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNull() {
            addCriterion("orderstatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNotNull() {
            addCriterion("orderstatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusEqualTo(Integer value) {
            addCriterion("orderstatus =", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotEqualTo(Integer value) {
            addCriterion("orderstatus <>", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThan(Integer value) {
            addCriterion("orderstatus >", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderstatus >=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThan(Integer value) {
            addCriterion("orderstatus <", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThanOrEqualTo(Integer value) {
            addCriterion("orderstatus <=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIn(List<Integer> values) {
            addCriterion("orderstatus in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotIn(List<Integer> values) {
            addCriterion("orderstatus not in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusBetween(Integer value1, Integer value2) {
            addCriterion("orderstatus between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("orderstatus not between", value1, value2, "orderstatus");
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