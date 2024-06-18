package com.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Dx
 * @Description mybatis持久层数据操作信息介绍表搜索条件及排序封装扩展类
 */
public class DxExample {
    protected String orderByClause;

    protected boolean distinct;
    protected List<com.entity.DxExample.Criteria> oredCriteria;

    public DxExample() {
        oredCriteria = new ArrayList<com.entity.DxExample.Criteria>();
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

    public List<com.entity.DxExample.Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(com.entity.DxExample.Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public com.entity.DxExample.Criteria or() {
        com.entity.DxExample.Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public com.entity.DxExample.Criteria createCriteria() {
        com.entity.DxExample.Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected com.entity.DxExample.Criteria createCriteriaInternal() {
        com.entity.DxExample.Criteria criteria = new com.entity.DxExample.Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<com.entity.DxExample.Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<com.entity.DxExample.Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<com.entity.DxExample.Criterion> getAllCriteria() {
            return criteria;
        }

        public List<com.entity.DxExample.Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new com.entity.DxExample.Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new com.entity.DxExample.Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new com.entity.DxExample.Criterion(condition, value1, value2));
        }

        public com.entity.DxExample.Criteria andIdIsNull() {
            addCriterion("id is null");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieIsNull() {
            addCriterion("leibie is null");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieIsNotNull() {
            addCriterion("leibie is not null");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieEqualTo(String value) {
            addCriterion("leibie =", value, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieNotEqualTo(String value) {
            addCriterion("leibie <>", value, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieGreaterThan(String value) {
            addCriterion("leibie >", value, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieGreaterThanOrEqualTo(String value) {
            addCriterion("leibie >=", value, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieLessThan(String value) {
            addCriterion("leibie <", value, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieLessThanOrEqualTo(String value) {
            addCriterion("leibie <=", value, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieLike(String value) {
            addCriterion("leibie like", value, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieNotLike(String value) {
            addCriterion("leibie not like", value, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieIn(List<String> values) {
            addCriterion("leibie in", values, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieNotIn(List<String> values) {
            addCriterion("leibie not in", values, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieBetween(String value1, String value2) {
            addCriterion("leibie between", value1, value2, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andLeibieNotBetween(String value1, String value2) {
            addCriterion("leibie not between", value1, value2, "leibie");
            return (com.entity.DxExample.Criteria) this;
        }
        public com.entity.DxExample.Criteria andContentIsNull() {
            addCriterion("content is null");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (com.entity.DxExample.Criteria) this;
        }
        public com.entity.DxExample.Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (com.entity.DxExample.Criteria) this;
        }
        public com.entity.DxExample.Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeEqualTo(String value) {
            addCriterion("addtime =", value, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeNotEqualTo(String value) {
            addCriterion("addtime <>", value, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeGreaterThan(String value) {
            addCriterion("addtime >", value, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("addtime >=", value, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeLessThan(String value) {
            addCriterion("addtime <", value, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeLessThanOrEqualTo(String value) {
            addCriterion("addtime <=", value, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeLike(String value) {
            addCriterion("addtime like", value, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeNotLike(String value) {
            addCriterion("addtime not like", value, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeIn(List<String> values) {
            addCriterion("addtime in", values, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeNotIn(List<String> values) {
            addCriterion("addtime not in", values, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeBetween(String value1, String value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

        public com.entity.DxExample.Criteria andAddtimeNotBetween(String value1, String value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (com.entity.DxExample.Criteria) this;
        }

    }

    public static class Criteria extends com.entity.DxExample.GeneratedCriteria {

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