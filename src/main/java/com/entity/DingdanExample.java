package com.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Dingdan
 * @Description mybatis持久层数据操作订单表搜索条件及排序封装扩展类
 */
public class DingdanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DingdanExample() {
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

        public Criteria andBianhaoIsNull() {
            addCriterion("bianhao is null");
            return (Criteria) this;
        }

        public Criteria andBianhaoIsNotNull() {
            addCriterion("bianhao is not null");
            return (Criteria) this;
        }

        public Criteria andBianhaoEqualTo(String value) {
            addCriterion("bianhao =", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotEqualTo(String value) {
            addCriterion("bianhao <>", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoGreaterThan(String value) {
            addCriterion("bianhao >", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoGreaterThanOrEqualTo(String value) {
            addCriterion("bianhao >=", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoLessThan(String value) {
            addCriterion("bianhao <", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoLessThanOrEqualTo(String value) {
            addCriterion("bianhao <=", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoLike(String value) {
            addCriterion("bianhao like", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotLike(String value) {
            addCriterion("bianhao not like", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoIn(List<String> values) {
            addCriterion("bianhao in", values, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotIn(List<String> values) {
            addCriterion("bianhao not in", values, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoBetween(String value1, String value2) {
            addCriterion("bianhao between", value1, value2, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotBetween(String value1, String value2) {
            addCriterion("bianhao not between", value1, value2, "bianhao");
            return (Criteria) this;
        }
        public Criteria andJineIsNull() {
            addCriterion("jine is null");
            return (Criteria) this;
        }

        public Criteria andJineIsNotNull() {
            addCriterion("jine is not null");
            return (Criteria) this;
        }

        public Criteria andJineEqualTo(Integer value) {
            addCriterion("jine =", value, "jine");
            return (Criteria) this;
        }

        public Criteria andJineNotEqualTo(Integer value) {
            addCriterion("jine <>", value, "jine");
            return (Criteria) this;
        }

        public Criteria andJineGreaterThan(Integer value) {
            addCriterion("jine >", value, "jine");
            return (Criteria) this;
        }

        public Criteria andJineGreaterThanOrEqualTo(Integer value) {
            addCriterion("jine >=", value, "jine");
            return (Criteria) this;
        }

        public Criteria andJineLessThan(Integer value) {
            addCriterion("jine <", value, "jine");
            return (Criteria) this;
        }

        public Criteria andJineLessThanOrEqualTo(Integer value) {
            addCriterion("jine <=", value, "jine");
            return (Criteria) this;
        }

        public Criteria andJineLike(Integer value) {
            addCriterion("jine like", value, "jine");
            return (Criteria) this;
        }

        public Criteria andJineNotLike(Integer value) {
            addCriterion("jine not like", value, "jine");
            return (Criteria) this;
        }

        public Criteria andJineIn(List<Integer> values) {
            addCriterion("jine in", values, "jine");
            return (Criteria) this;
        }

        public Criteria andJineNotIn(List<Integer> values) {
            addCriterion("jine not in", values, "jine");
            return (Criteria) this;
        }

        public Criteria andJineBetween(Integer value1, Integer value2) {
            addCriterion("jine between", value1, value2, "jine");
            return (Criteria) this;
        }

        public Criteria andJineNotBetween(Integer value1, Integer value2) {
            addCriterion("jine not between", value1, value2, "jine");
            return (Criteria) this;
        }
        public Criteria andZhifushenheIsNull() {
            addCriterion("zhifushenhe is null");
            return (Criteria) this;
        }

        public Criteria andZhifushenheIsNotNull() {
            addCriterion("zhifushenhe is not null");
            return (Criteria) this;
        }

        public Criteria andZhifushenheEqualTo(String value) {
            addCriterion("zhifushenhe =", value, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheNotEqualTo(String value) {
            addCriterion("zhifushenhe <>", value, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheGreaterThan(String value) {
            addCriterion("zhifushenhe >", value, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheGreaterThanOrEqualTo(String value) {
            addCriterion("zhifushenhe >=", value, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheLessThan(String value) {
            addCriterion("zhifushenhe <", value, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheLessThanOrEqualTo(String value) {
            addCriterion("zhifushenhe <=", value, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheLike(String value) {
            addCriterion("zhifushenhe like", value, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheNotLike(String value) {
            addCriterion("zhifushenhe not like", value, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheIn(List<String> values) {
            addCriterion("zhifushenhe in", values, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheNotIn(List<String> values) {
            addCriterion("zhifushenhe not in", values, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheBetween(String value1, String value2) {
            addCriterion("zhifushenhe between", value1, value2, "zhifushenhe");
            return (Criteria) this;
        }

        public Criteria andZhifushenheNotBetween(String value1, String value2) {
            addCriterion("zhifushenhe not between", value1, value2, "zhifushenhe");
            return (Criteria) this;
        }
        public Criteria andFahuoshenheIsNull() {
            addCriterion("fahuoshenhe is null");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheIsNotNull() {
            addCriterion("fahuoshenhe is not null");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheEqualTo(String value) {
            addCriterion("fahuoshenhe =", value, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheNotEqualTo(String value) {
            addCriterion("fahuoshenhe <>", value, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheGreaterThan(String value) {
            addCriterion("fahuoshenhe >", value, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheGreaterThanOrEqualTo(String value) {
            addCriterion("fahuoshenhe >=", value, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheLessThan(String value) {
            addCriterion("fahuoshenhe <", value, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheLessThanOrEqualTo(String value) {
            addCriterion("fahuoshenhe <=", value, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheLike(String value) {
            addCriterion("fahuoshenhe like", value, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheNotLike(String value) {
            addCriterion("fahuoshenhe not like", value, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheIn(List<String> values) {
            addCriterion("fahuoshenhe in", values, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheNotIn(List<String> values) {
            addCriterion("fahuoshenhe not in", values, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheBetween(String value1, String value2) {
            addCriterion("fahuoshenhe between", value1, value2, "fahuoshenhe");
            return (Criteria) this;
        }

        public Criteria andFahuoshenheNotBetween(String value1, String value2) {
            addCriterion("fahuoshenhe not between", value1, value2, "fahuoshenhe");
            return (Criteria) this;
        }
        public Criteria andShouhuoshenheIsNull() {
            addCriterion("shouhuoshenhe is null");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheIsNotNull() {
            addCriterion("shouhuoshenhe is not null");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheEqualTo(String value) {
            addCriterion("shouhuoshenhe =", value, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheNotEqualTo(String value) {
            addCriterion("shouhuoshenhe <>", value, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheGreaterThan(String value) {
            addCriterion("shouhuoshenhe >", value, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheGreaterThanOrEqualTo(String value) {
            addCriterion("shouhuoshenhe >=", value, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheLessThan(String value) {
            addCriterion("shouhuoshenhe <", value, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheLessThanOrEqualTo(String value) {
            addCriterion("shouhuoshenhe <=", value, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheLike(String value) {
            addCriterion("shouhuoshenhe like", value, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheNotLike(String value) {
            addCriterion("shouhuoshenhe not like", value, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheIn(List<String> values) {
            addCriterion("shouhuoshenhe in", values, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheNotIn(List<String> values) {
            addCriterion("shouhuoshenhe not in", values, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheBetween(String value1, String value2) {
            addCriterion("shouhuoshenhe between", value1, value2, "shouhuoshenhe");
            return (Criteria) this;
        }

        public Criteria andShouhuoshenheNotBetween(String value1, String value2) {
            addCriterion("shouhuoshenhe not between", value1, value2, "shouhuoshenhe");
            return (Criteria) this;
        }
        public Criteria andZhifufangshiidIsNull() {
            addCriterion("zhifufangshiid is null");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidIsNotNull() {
            addCriterion("zhifufangshiid is not null");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidEqualTo(Integer value) {
            addCriterion("zhifufangshiid =", value, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidNotEqualTo(Integer value) {
            addCriterion("zhifufangshiid <>", value, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidGreaterThan(Integer value) {
            addCriterion("zhifufangshiid >", value, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhifufangshiid >=", value, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidLessThan(Integer value) {
            addCriterion("zhifufangshiid <", value, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidLessThanOrEqualTo(Integer value) {
            addCriterion("zhifufangshiid <=", value, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidLike(Integer value) {
            addCriterion("zhifufangshiid like", value, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidNotLike(Integer value) {
            addCriterion("zhifufangshiid not like", value, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidIn(List<Integer> values) {
            addCriterion("zhifufangshiid in", values, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidNotIn(List<Integer> values) {
            addCriterion("zhifufangshiid not in", values, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidBetween(Integer value1, Integer value2) {
            addCriterion("zhifufangshiid between", value1, value2, "zhifufangshiid");
            return (Criteria) this;
        }

        public Criteria andZhifufangshiidNotBetween(Integer value1, Integer value2) {
            addCriterion("zhifufangshiid not between", value1, value2, "zhifufangshiid");
            return (Criteria) this;
        }
        public Criteria andXingmingIsNull() {
            addCriterion("xingming is null");
            return (Criteria) this;
        }

        public Criteria andXingmingIsNotNull() {
            addCriterion("xingming is not null");
            return (Criteria) this;
        }

        public Criteria andXingmingEqualTo(String value) {
            addCriterion("xingming =", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotEqualTo(String value) {
            addCriterion("xingming <>", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingGreaterThan(String value) {
            addCriterion("xingming >", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingGreaterThanOrEqualTo(String value) {
            addCriterion("xingming >=", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingLessThan(String value) {
            addCriterion("xingming <", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingLessThanOrEqualTo(String value) {
            addCriterion("xingming <=", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingLike(String value) {
            addCriterion("xingming like", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotLike(String value) {
            addCriterion("xingming not like", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingIn(List<String> values) {
            addCriterion("xingming in", values, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotIn(List<String> values) {
            addCriterion("xingming not in", values, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingBetween(String value1, String value2) {
            addCriterion("xingming between", value1, value2, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotBetween(String value1, String value2) {
            addCriterion("xingming not between", value1, value2, "xingming");
            return (Criteria) this;
        }
        public Criteria andDianhuaIsNull() {
            addCriterion("dianhua is null");
            return (Criteria) this;
        }

        public Criteria andDianhuaIsNotNull() {
            addCriterion("dianhua is not null");
            return (Criteria) this;
        }

        public Criteria andDianhuaEqualTo(String value) {
            addCriterion("dianhua =", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaNotEqualTo(String value) {
            addCriterion("dianhua <>", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaGreaterThan(String value) {
            addCriterion("dianhua >", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaGreaterThanOrEqualTo(String value) {
            addCriterion("dianhua >=", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaLessThan(String value) {
            addCriterion("dianhua <", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaLessThanOrEqualTo(String value) {
            addCriterion("dianhua <=", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaLike(String value) {
            addCriterion("dianhua like", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaNotLike(String value) {
            addCriterion("dianhua not like", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaIn(List<String> values) {
            addCriterion("dianhua in", values, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaNotIn(List<String> values) {
            addCriterion("dianhua not in", values, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaBetween(String value1, String value2) {
            addCriterion("dianhua between", value1, value2, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaNotBetween(String value1, String value2) {
            addCriterion("dianhua not between", value1, value2, "dianhua");
            return (Criteria) this;
        }
        public Criteria andDizhiIsNull() {
            addCriterion("dizhi is null");
            return (Criteria) this;
        }

        public Criteria andDizhiIsNotNull() {
            addCriterion("dizhi is not null");
            return (Criteria) this;
        }

        public Criteria andDizhiEqualTo(String value) {
            addCriterion("dizhi =", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiNotEqualTo(String value) {
            addCriterion("dizhi <>", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiGreaterThan(String value) {
            addCriterion("dizhi >", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiGreaterThanOrEqualTo(String value) {
            addCriterion("dizhi >=", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiLessThan(String value) {
            addCriterion("dizhi <", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiLessThanOrEqualTo(String value) {
            addCriterion("dizhi <=", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiLike(String value) {
            addCriterion("dizhi like", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiNotLike(String value) {
            addCriterion("dizhi not like", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiIn(List<String> values) {
            addCriterion("dizhi in", values, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiNotIn(List<String> values) {
            addCriterion("dizhi not in", values, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiBetween(String value1, String value2) {
            addCriterion("dizhi between", value1, value2, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiNotBetween(String value1, String value2) {
            addCriterion("dizhi not between", value1, value2, "dizhi");
            return (Criteria) this;
        }
        public Criteria andShijianIsNull() {
            addCriterion("shijian is null");
            return (Criteria) this;
        }

        public Criteria andShijianIsNotNull() {
            addCriterion("shijian is not null");
            return (Criteria) this;
        }

        public Criteria andShijianEqualTo(String value) {
            addCriterion("shijian =", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotEqualTo(String value) {
            addCriterion("shijian <>", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianGreaterThan(String value) {
            addCriterion("shijian >", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianGreaterThanOrEqualTo(String value) {
            addCriterion("shijian >=", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianLessThan(String value) {
            addCriterion("shijian <", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianLessThanOrEqualTo(String value) {
            addCriterion("shijian <=", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianLike(String value) {
            addCriterion("shijian like", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotLike(String value) {
            addCriterion("shijian not like", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianIn(List<String> values) {
            addCriterion("shijian in", values, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotIn(List<String> values) {
            addCriterion("shijian not in", values, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianBetween(String value1, String value2) {
            addCriterion("shijian between", value1, value2, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotBetween(String value1, String value2) {
            addCriterion("shijian not between", value1, value2, "shijian");
            return (Criteria) this;
        }
        public Criteria andWuliuIsNull() {
            addCriterion("wuliu is null");
            return (Criteria) this;
        }

        public Criteria andWuliuIsNotNull() {
            addCriterion("wuliu is not null");
            return (Criteria) this;
        }

        public Criteria andWuliuEqualTo(String value) {
            addCriterion("wuliu =", value, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuNotEqualTo(String value) {
            addCriterion("wuliu <>", value, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuGreaterThan(String value) {
            addCriterion("wuliu >", value, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuGreaterThanOrEqualTo(String value) {
            addCriterion("wuliu >=", value, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuLessThan(String value) {
            addCriterion("wuliu <", value, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuLessThanOrEqualTo(String value) {
            addCriterion("wuliu <=", value, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuLike(String value) {
            addCriterion("wuliu like", value, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuNotLike(String value) {
            addCriterion("wuliu not like", value, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuIn(List<String> values) {
            addCriterion("wuliu in", values, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuNotIn(List<String> values) {
            addCriterion("wuliu not in", values, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuBetween(String value1, String value2) {
            addCriterion("wuliu between", value1, value2, "wuliu");
            return (Criteria) this;
        }

        public Criteria andWuliuNotBetween(String value1, String value2) {
            addCriterion("wuliu not between", value1, value2, "wuliu");
            return (Criteria) this;
        }
        public Criteria andBeizhuIsNull() {
            addCriterion("beizhu is null");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNotNull() {
            addCriterion("beizhu is not null");
            return (Criteria) this;
        }

        public Criteria andBeizhuEqualTo(String value) {
            addCriterion("beizhu =", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotEqualTo(String value) {
            addCriterion("beizhu <>", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThan(String value) {
            addCriterion("beizhu >", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThanOrEqualTo(String value) {
            addCriterion("beizhu >=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThan(String value) {
            addCriterion("beizhu <", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThanOrEqualTo(String value) {
            addCriterion("beizhu <=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLike(String value) {
            addCriterion("beizhu like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotLike(String value) {
            addCriterion("beizhu not like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuIn(List<String> values) {
            addCriterion("beizhu in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotIn(List<String> values) {
            addCriterion("beizhu not in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuBetween(String value1, String value2) {
            addCriterion("beizhu between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotBetween(String value1, String value2) {
            addCriterion("beizhu not between", value1, value2, "beizhu");
            return (Criteria) this;
        }
        public Criteria andUsersidIsNull() {
            addCriterion("usersid is null");
            return (Criteria) this;
        }

        public Criteria andUsersidIsNotNull() {
            addCriterion("usersid is not null");
            return (Criteria) this;
        }

        public Criteria andUsersidEqualTo(Integer value) {
            addCriterion("usersid =", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotEqualTo(Integer value) {
            addCriterion("usersid <>", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidGreaterThan(Integer value) {
            addCriterion("usersid >", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidGreaterThanOrEqualTo(Integer value) {
            addCriterion("usersid >=", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLessThan(Integer value) {
            addCriterion("usersid <", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLessThanOrEqualTo(Integer value) {
            addCriterion("usersid <=", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLike(Integer value) {
            addCriterion("usersid like", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotLike(Integer value) {
            addCriterion("usersid not like", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidIn(List<Integer> values) {
            addCriterion("usersid in", values, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotIn(List<Integer> values) {
            addCriterion("usersid not in", values, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidBetween(Integer value1, Integer value2) {
            addCriterion("usersid between", value1, value2, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotBetween(Integer value1, Integer value2) {
            addCriterion("usersid not between", value1, value2, "usersid");
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
