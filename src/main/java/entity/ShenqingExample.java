package com.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Shangpin
 * @Description mybatis持久层数据操作零食表搜索条件及排序封装扩展类
 */
public class ShangpinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShangpinExample() {
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

        public Criteria andMingchengIsNull() {
            addCriterion("mingcheng is null");
            return (Criteria) this;
        }

        public Criteria andMingchengIsNotNull() {
            addCriterion("mingcheng is not null");
            return (Criteria) this;
        }

        public Criteria andMingchengEqualTo(String value) {
            addCriterion("mingcheng =", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotEqualTo(String value) {
            addCriterion("mingcheng <>", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengGreaterThan(String value) {
            addCriterion("mingcheng >", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengGreaterThanOrEqualTo(String value) {
            addCriterion("mingcheng >=", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengLessThan(String value) {
            addCriterion("mingcheng <", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengLessThanOrEqualTo(String value) {
            addCriterion("mingcheng <=", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengLike(String value) {
            addCriterion("mingcheng like", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotLike(String value) {
            addCriterion("mingcheng not like", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengIn(List<String> values) {
            addCriterion("mingcheng in", values, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotIn(List<String> values) {
            addCriterion("mingcheng not in", values, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengBetween(String value1, String value2) {
            addCriterion("mingcheng between", value1, value2, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotBetween(String value1, String value2) {
            addCriterion("mingcheng not between", value1, value2, "mingcheng");
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
        public Criteria andPinleiidIsNull() {
            addCriterion("pinleiid is null");
            return (Criteria) this;
        }

        public Criteria andPinleiidIsNotNull() {
            addCriterion("pinleiid is not null");
            return (Criteria) this;
        }

        public Criteria andPinleiidEqualTo(Integer value) {
            addCriterion("pinleiid =", value, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidNotEqualTo(Integer value) {
            addCriterion("pinleiid <>", value, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidGreaterThan(Integer value) {
            addCriterion("pinleiid >", value, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pinleiid >=", value, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidLessThan(Integer value) {
            addCriterion("pinleiid <", value, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidLessThanOrEqualTo(Integer value) {
            addCriterion("pinleiid <=", value, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidLike(Integer value) {
            addCriterion("pinleiid like", value, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidNotLike(Integer value) {
            addCriterion("pinleiid not like", value, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidIn(List<Integer> values) {
            addCriterion("pinleiid in", values, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidNotIn(List<Integer> values) {
            addCriterion("pinleiid not in", values, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidBetween(Integer value1, Integer value2) {
            addCriterion("pinleiid between", value1, value2, "pinleiid");
            return (Criteria) this;
        }

        public Criteria andPinleiidNotBetween(Integer value1, Integer value2) {
            addCriterion("pinleiid not between", value1, value2, "pinleiid");
            return (Criteria) this;
        }
        public Criteria andNeirongIsNull() {
            addCriterion("neirong is null");
            return (Criteria) this;
        }

        public Criteria andNeirongIsNotNull() {
            addCriterion("neirong is not null");
            return (Criteria) this;
        }

        public Criteria andNeirongEqualTo(String value) {
            addCriterion("neirong =", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotEqualTo(String value) {
            addCriterion("neirong <>", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongGreaterThan(String value) {
            addCriterion("neirong >", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongGreaterThanOrEqualTo(String value) {
            addCriterion("neirong >=", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLessThan(String value) {
            addCriterion("neirong <", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLessThanOrEqualTo(String value) {
            addCriterion("neirong <=", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLike(String value) {
            addCriterion("neirong like", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotLike(String value) {
            addCriterion("neirong not like", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongIn(List<String> values) {
            addCriterion("neirong in", values, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotIn(List<String> values) {
            addCriterion("neirong not in", values, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongBetween(String value1, String value2) {
            addCriterion("neirong between", value1, value2, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotBetween(String value1, String value2) {
            addCriterion("neirong not between", value1, value2, "neirong");
            return (Criteria) this;
        }
        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }
        public Criteria andYuanshijiageIsNull() {
            addCriterion("yuanshijiage is null");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageIsNotNull() {
            addCriterion("yuanshijiage is not null");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageEqualTo(Integer value) {
            addCriterion("yuanshijiage =", value, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageNotEqualTo(Integer value) {
            addCriterion("yuanshijiage <>", value, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageGreaterThan(Integer value) {
            addCriterion("yuanshijiage >", value, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageGreaterThanOrEqualTo(Integer value) {
            addCriterion("yuanshijiage >=", value, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageLessThan(Integer value) {
            addCriterion("yuanshijiage <", value, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageLessThanOrEqualTo(Integer value) {
            addCriterion("yuanshijiage <=", value, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageLike(Integer value) {
            addCriterion("yuanshijiage like", value, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageNotLike(Integer value) {
            addCriterion("yuanshijiage not like", value, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageIn(List<Integer> values) {
            addCriterion("yuanshijiage in", values, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageNotIn(List<Integer> values) {
            addCriterion("yuanshijiage not in", values, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageBetween(Integer value1, Integer value2) {
            addCriterion("yuanshijiage between", value1, value2, "yuanshijiage");
            return (Criteria) this;
        }

        public Criteria andYuanshijiageNotBetween(Integer value1, Integer value2) {
            addCriterion("yuanshijiage not between", value1, value2, "yuanshijiage");
            return (Criteria) this;
        }
        public Criteria andJiageIsNull() {
            addCriterion("jiage is null");
            return (Criteria) this;
        }

        public Criteria andJiageIsNotNull() {
            addCriterion("jiage is not null");
            return (Criteria) this;
        }

        public Criteria andJiageEqualTo(Integer value) {
            addCriterion("jiage =", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageNotEqualTo(Integer value) {
            addCriterion("jiage <>", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageGreaterThan(Integer value) {
            addCriterion("jiage >", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageGreaterThanOrEqualTo(Integer value) {
            addCriterion("jiage >=", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageLessThan(Integer value) {
            addCriterion("jiage <", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageLessThanOrEqualTo(Integer value) {
            addCriterion("jiage <=", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageLike(Integer value) {
            addCriterion("jiage like", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageNotLike(Integer value) {
            addCriterion("jiage not like", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageIn(List<Integer> values) {
            addCriterion("jiage in", values, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageNotIn(List<Integer> values) {
            addCriterion("jiage not in", values, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageBetween(Integer value1, Integer value2) {
            addCriterion("jiage between", value1, value2, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageNotBetween(Integer value1, Integer value2) {
            addCriterion("jiage not between", value1, value2, "jiage");
            return (Criteria) this;
        }
        public Criteria andDanweiIsNull() {
            addCriterion("danwei is null");
            return (Criteria) this;
        }

        public Criteria andDanweiIsNotNull() {
            addCriterion("danwei is not null");
            return (Criteria) this;
        }

        public Criteria andDanweiEqualTo(String value) {
            addCriterion("danwei =", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotEqualTo(String value) {
            addCriterion("danwei <>", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiGreaterThan(String value) {
            addCriterion("danwei >", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiGreaterThanOrEqualTo(String value) {
            addCriterion("danwei >=", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiLessThan(String value) {
            addCriterion("danwei <", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiLessThanOrEqualTo(String value) {
            addCriterion("danwei <=", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiLike(String value) {
            addCriterion("danwei like", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotLike(String value) {
            addCriterion("danwei not like", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiIn(List<String> values) {
            addCriterion("danwei in", values, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotIn(List<String> values) {
            addCriterion("danwei not in", values, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiBetween(String value1, String value2) {
            addCriterion("danwei between", value1, value2, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotBetween(String value1, String value2) {
            addCriterion("danwei not between", value1, value2, "danwei");
            return (Criteria) this;
        }
        public Criteria andShenheIsNull() {
            addCriterion("shenhe is null");
            return (Criteria) this;
        }

        public Criteria andShenheIsNotNull() {
            addCriterion("shenhe is not null");
            return (Criteria) this;
        }

        public Criteria andShenheEqualTo(String value) {
            addCriterion("shenhe =", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotEqualTo(String value) {
            addCriterion("shenhe <>", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheGreaterThan(String value) {
            addCriterion("shenhe >", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheGreaterThanOrEqualTo(String value) {
            addCriterion("shenhe >=", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheLessThan(String value) {
            addCriterion("shenhe <", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheLessThanOrEqualTo(String value) {
            addCriterion("shenhe <=", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheLike(String value) {
            addCriterion("shenhe like", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotLike(String value) {
            addCriterion("shenhe not like", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheIn(List<String> values) {
            addCriterion("shenhe in", values, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotIn(List<String> values) {
            addCriterion("shenhe not in", values, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheBetween(String value1, String value2) {
            addCriterion("shenhe between", value1, value2, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotBetween(String value1, String value2) {
            addCriterion("shenhe not between", value1, value2, "shenhe");
            return (Criteria) this;
        }
        public Criteria andKucunshuliangIsNull() {
            addCriterion("kucunshuliang is null");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangIsNotNull() {
            addCriterion("kucunshuliang is not null");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangEqualTo(Integer value) {
            addCriterion("kucunshuliang =", value, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangNotEqualTo(Integer value) {
            addCriterion("kucunshuliang <>", value, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangGreaterThan(Integer value) {
            addCriterion("kucunshuliang >", value, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangGreaterThanOrEqualTo(Integer value) {
            addCriterion("kucunshuliang >=", value, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangLessThan(Integer value) {
            addCriterion("kucunshuliang <", value, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangLessThanOrEqualTo(Integer value) {
            addCriterion("kucunshuliang <=", value, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangLike(Integer value) {
            addCriterion("kucunshuliang like", value, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangNotLike(Integer value) {
            addCriterion("kucunshuliang not like", value, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangIn(List<Integer> values) {
            addCriterion("kucunshuliang in", values, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangNotIn(List<Integer> values) {
            addCriterion("kucunshuliang not in", values, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangBetween(Integer value1, Integer value2) {
            addCriterion("kucunshuliang between", value1, value2, "kucunshuliang");
            return (Criteria) this;
        }

        public Criteria andKucunshuliangNotBetween(Integer value1, Integer value2) {
            addCriterion("kucunshuliang not between", value1, value2, "kucunshuliang");
            return (Criteria) this;
        }
        public Criteria andXiaoshoushuliangIsNull() {
            addCriterion("xiaoshoushuliang is null");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangIsNotNull() {
            addCriterion("xiaoshoushuliang is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangEqualTo(Integer value) {
            addCriterion("xiaoshoushuliang =", value, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangNotEqualTo(Integer value) {
            addCriterion("xiaoshoushuliang <>", value, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangGreaterThan(Integer value) {
            addCriterion("xiaoshoushuliang >", value, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangGreaterThanOrEqualTo(Integer value) {
            addCriterion("xiaoshoushuliang >=", value, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangLessThan(Integer value) {
            addCriterion("xiaoshoushuliang <", value, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangLessThanOrEqualTo(Integer value) {
            addCriterion("xiaoshoushuliang <=", value, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangLike(Integer value) {
            addCriterion("xiaoshoushuliang like", value, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangNotLike(Integer value) {
            addCriterion("xiaoshoushuliang not like", value, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangIn(List<Integer> values) {
            addCriterion("xiaoshoushuliang in", values, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangNotIn(List<Integer> values) {
            addCriterion("xiaoshoushuliang not in", values, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangBetween(Integer value1, Integer value2) {
            addCriterion("xiaoshoushuliang between", value1, value2, "xiaoshoushuliang");
            return (Criteria) this;
        }

        public Criteria andXiaoshoushuliangNotBetween(Integer value1, Integer value2) {
            addCriterion("xiaoshoushuliang not between", value1, value2, "xiaoshoushuliang");
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
