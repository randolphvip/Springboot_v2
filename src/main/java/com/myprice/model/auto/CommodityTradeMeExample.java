package com.myprice.model.auto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hutool.core.util.StrUtil;

/**
 * Trade Me CommodityTradeMeExample
 * @author Cong_自动生成
 * @date 2021-08-29 16:56:02
 */
public class CommodityTradeMeExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommodityTradeMeExample() {
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

        public Criteria andIdLike(Integer value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(Integer value) {
            addCriterion("id not like", value, "id");
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
        
				
        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }
        
				
        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }
        
				
        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(Date value) {
            addCriterion("create_date like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(Date value) {
            addCriterion("create_date not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(Integer value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(Integer value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
        
				
        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(Integer value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(Integer value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }
        
				
        public Criteria andTempletIdIsNull() {
            addCriterion("templet_id is null");
            return (Criteria) this;
        }

        public Criteria andTempletIdIsNotNull() {
            addCriterion("templet_id is not null");
            return (Criteria) this;
        }

        public Criteria andTempletIdEqualTo(Integer value) {
            addCriterion("templet_id =", value, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdNotEqualTo(Integer value) {
            addCriterion("templet_id <>", value, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdGreaterThan(Integer value) {
            addCriterion("templet_id >", value, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("templet_id >=", value, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdLessThan(Integer value) {
            addCriterion("templet_id <", value, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdLessThanOrEqualTo(Integer value) {
            addCriterion("templet_id <=", value, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdLike(Integer value) {
            addCriterion("templet_id like", value, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdNotLike(Integer value) {
            addCriterion("templet_id not like", value, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdIn(List<Integer> values) {
            addCriterion("templet_id in", values, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdNotIn(List<Integer> values) {
            addCriterion("templet_id not in", values, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdBetween(Integer value1, Integer value2) {
            addCriterion("templet_id between", value1, value2, "templetId");
            return (Criteria) this;
        }

        public Criteria andTempletIdNotBetween(Integer value1, Integer value2) {
            addCriterion("templet_id not between", value1, value2, "templetId");
            return (Criteria) this;
        }
        
				
        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(String value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(String value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(String value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(String value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(String value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLike(String value) {
            addCriterion("frequency like", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotLike(String value) {
            addCriterion("frequency not like", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<String> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<String> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(String value1, String value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(String value1, String value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }
        
				
        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }
        
				
        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }
        
				
        public Criteria andStartingPriceIsNull() {
            addCriterion("starting_price is null");
            return (Criteria) this;
        }

        public Criteria andStartingPriceIsNotNull() {
            addCriterion("starting_price is not null");
            return (Criteria) this;
        }

        public Criteria andStartingPriceEqualTo(BigDecimal value) {
            addCriterion("starting_price =", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceNotEqualTo(BigDecimal value) {
            addCriterion("starting_price <>", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceGreaterThan(BigDecimal value) {
            addCriterion("starting_price >", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("starting_price >=", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceLessThan(BigDecimal value) {
            addCriterion("starting_price <", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("starting_price <=", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceLike(BigDecimal value) {
            addCriterion("starting_price like", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceNotLike(BigDecimal value) {
            addCriterion("starting_price not like", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceIn(List<BigDecimal> values) {
            addCriterion("starting_price in", values, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceNotIn(List<BigDecimal> values) {
            addCriterion("starting_price not in", values, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("starting_price between", value1, value2, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("starting_price not between", value1, value2, "startingPrice");
            return (Criteria) this;
        }
        
				
        public Criteria andCloseDatetimeIsNull() {
            addCriterion("close_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeIsNotNull() {
            addCriterion("close_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeEqualTo(Date value) {
            addCriterion("close_datetime =", value, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeNotEqualTo(Date value) {
            addCriterion("close_datetime <>", value, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeGreaterThan(Date value) {
            addCriterion("close_datetime >", value, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("close_datetime >=", value, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeLessThan(Date value) {
            addCriterion("close_datetime <", value, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("close_datetime <=", value, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeLike(Date value) {
            addCriterion("close_datetime like", value, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeNotLike(Date value) {
            addCriterion("close_datetime not like", value, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeIn(List<Date> values) {
            addCriterion("close_datetime in", values, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeNotIn(List<Date> values) {
            addCriterion("close_datetime not in", values, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeBetween(Date value1, Date value2) {
            addCriterion("close_datetime between", value1, value2, "closeDatetime");
            return (Criteria) this;
        }

        public Criteria andCloseDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("close_datetime not between", value1, value2, "closeDatetime");
            return (Criteria) this;
        }
        
				
        public Criteria andBuyNowPriceIsNull() {
            addCriterion("buy_now_price is null");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceIsNotNull() {
            addCriterion("buy_now_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceEqualTo(BigDecimal value) {
            addCriterion("buy_now_price =", value, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceNotEqualTo(BigDecimal value) {
            addCriterion("buy_now_price <>", value, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceGreaterThan(BigDecimal value) {
            addCriterion("buy_now_price >", value, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buy_now_price >=", value, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceLessThan(BigDecimal value) {
            addCriterion("buy_now_price <", value, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buy_now_price <=", value, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceLike(BigDecimal value) {
            addCriterion("buy_now_price like", value, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceNotLike(BigDecimal value) {
            addCriterion("buy_now_price not like", value, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceIn(List<BigDecimal> values) {
            addCriterion("buy_now_price in", values, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceNotIn(List<BigDecimal> values) {
            addCriterion("buy_now_price not in", values, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy_now_price between", value1, value2, "buyNowPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNowPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy_now_price not between", value1, value2, "buyNowPrice");
            return (Criteria) this;
        }
        
				
        public Criteria andConditionLevelIsNull() {
            addCriterion("condition_level is null");
            return (Criteria) this;
        }

        public Criteria andConditionLevelIsNotNull() {
            addCriterion("condition_level is not null");
            return (Criteria) this;
        }

        public Criteria andConditionLevelEqualTo(String value) {
            addCriterion("condition_level =", value, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelNotEqualTo(String value) {
            addCriterion("condition_level <>", value, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelGreaterThan(String value) {
            addCriterion("condition_level >", value, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelGreaterThanOrEqualTo(String value) {
            addCriterion("condition_level >=", value, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelLessThan(String value) {
            addCriterion("condition_level <", value, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelLessThanOrEqualTo(String value) {
            addCriterion("condition_level <=", value, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelLike(String value) {
            addCriterion("condition_level like", value, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelNotLike(String value) {
            addCriterion("condition_level not like", value, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelIn(List<String> values) {
            addCriterion("condition_level in", values, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelNotIn(List<String> values) {
            addCriterion("condition_level not in", values, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelBetween(String value1, String value2) {
            addCriterion("condition_level between", value1, value2, "conditionLevel");
            return (Criteria) this;
        }

        public Criteria andConditionLevelNotBetween(String value1, String value2) {
            addCriterion("condition_level not between", value1, value2, "conditionLevel");
            return (Criteria) this;
        }
        
				
        public Criteria andShippingIsNull() {
            addCriterion("shipping is null");
            return (Criteria) this;
        }

        public Criteria andShippingIsNotNull() {
            addCriterion("shipping is not null");
            return (Criteria) this;
        }

        public Criteria andShippingEqualTo(String value) {
            addCriterion("shipping =", value, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingNotEqualTo(String value) {
            addCriterion("shipping <>", value, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingGreaterThan(String value) {
            addCriterion("shipping >", value, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingGreaterThanOrEqualTo(String value) {
            addCriterion("shipping >=", value, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingLessThan(String value) {
            addCriterion("shipping <", value, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingLessThanOrEqualTo(String value) {
            addCriterion("shipping <=", value, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingLike(String value) {
            addCriterion("shipping like", value, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingNotLike(String value) {
            addCriterion("shipping not like", value, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingIn(List<String> values) {
            addCriterion("shipping in", values, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingNotIn(List<String> values) {
            addCriterion("shipping not in", values, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingBetween(String value1, String value2) {
            addCriterion("shipping between", value1, value2, "shipping");
            return (Criteria) this;
        }

        public Criteria andShippingNotBetween(String value1, String value2) {
            addCriterion("shipping not between", value1, value2, "shipping");
            return (Criteria) this;
        }
        
				
        public Criteria andReserveStatusIsNull() {
            addCriterion("reserve_status is null");
            return (Criteria) this;
        }

        public Criteria andReserveStatusIsNotNull() {
            addCriterion("reserve_status is not null");
            return (Criteria) this;
        }

        public Criteria andReserveStatusEqualTo(Integer value) {
            addCriterion("reserve_status =", value, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusNotEqualTo(Integer value) {
            addCriterion("reserve_status <>", value, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusGreaterThan(Integer value) {
            addCriterion("reserve_status >", value, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserve_status >=", value, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusLessThan(Integer value) {
            addCriterion("reserve_status <", value, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusLessThanOrEqualTo(Integer value) {
            addCriterion("reserve_status <=", value, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusLike(Integer value) {
            addCriterion("reserve_status like", value, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusNotLike(Integer value) {
            addCriterion("reserve_status not like", value, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusIn(List<Integer> values) {
            addCriterion("reserve_status in", values, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusNotIn(List<Integer> values) {
            addCriterion("reserve_status not in", values, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusBetween(Integer value1, Integer value2) {
            addCriterion("reserve_status between", value1, value2, "reserveStatus");
            return (Criteria) this;
        }

        public Criteria andReserveStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("reserve_status not between", value1, value2, "reserveStatus");
            return (Criteria) this;
        }
        
			
		 public Criteria andLikeQuery(CommodityTradeMe record) {
		 	List<String> list= new ArrayList<String>();
		 	List<String> list2= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			 list.add("ifnull(id,'')");
    		}
			if(record.getUrl()!=null&&StrUtil.isNotEmpty(record.getUrl().toString())) {
    			 list.add("ifnull(url,'')");
    		}
			if(record.getCreator()!=null&&StrUtil.isNotEmpty(record.getCreator().toString())) {
    			 list.add("ifnull(creator,'')");
    		}
			if(record.getCreateDate()!=null&&StrUtil.isNotEmpty(record.getCreateDate().toString())) {
    			 list.add("ifnull(create_date,'')");
    		}
			if(record.getStatus()!=null&&StrUtil.isNotEmpty(record.getStatus().toString())) {
    			 list.add("ifnull(status,'')");
    		}
			if(record.getCategoryId()!=null&&StrUtil.isNotEmpty(record.getCategoryId().toString())) {
    			 list.add("ifnull(category_id,'')");
    		}
			if(record.getTempletId()!=null&&StrUtil.isNotEmpty(record.getTempletId().toString())) {
    			 list.add("ifnull(templet_id,'')");
    		}
			if(record.getFrequency()!=null&&StrUtil.isNotEmpty(record.getFrequency().toString())) {
    			 list.add("ifnull(frequency,'')");
    		}
			if(record.getTitle()!=null&&StrUtil.isNotEmpty(record.getTitle().toString())) {
    			 list.add("ifnull(title,'')");
    		}
			if(record.getDescription()!=null&&StrUtil.isNotEmpty(record.getDescription().toString())) {
    			 list.add("ifnull(description,'')");
    		}
			if(record.getStartingPrice()!=null&&StrUtil.isNotEmpty(record.getStartingPrice().toString())) {
    			 list.add("ifnull(starting_price,'')");
    		}
			if(record.getCloseDatetime()!=null&&StrUtil.isNotEmpty(record.getCloseDatetime().toString())) {
    			 list.add("ifnull(close_datetime,'')");
    		}
			if(record.getBuyNowPrice()!=null&&StrUtil.isNotEmpty(record.getBuyNowPrice().toString())) {
    			 list.add("ifnull(buy_now_price,'')");
    		}
			if(record.getConditionLevel()!=null&&StrUtil.isNotEmpty(record.getConditionLevel().toString())) {
    			 list.add("ifnull(condition_level,'')");
    		}
			if(record.getShipping()!=null&&StrUtil.isNotEmpty(record.getShipping().toString())) {
    			 list.add("ifnull(shipping,'')");
    		}
			if(record.getReserveStatus()!=null&&StrUtil.isNotEmpty(record.getReserveStatus().toString())) {
    			 list.add("ifnull(reserve_status,'')");
    		}
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			list2.add("'%"+record.getId()+"%'");
    		}
			if(record.getUrl()!=null&&StrUtil.isNotEmpty(record.getUrl().toString())) {
    			list2.add("'%"+record.getUrl()+"%'");
    		}
			if(record.getCreator()!=null&&StrUtil.isNotEmpty(record.getCreator().toString())) {
    			list2.add("'%"+record.getCreator()+"%'");
    		}
			if(record.getCreateDate()!=null&&StrUtil.isNotEmpty(record.getCreateDate().toString())) {
    			list2.add("'%"+record.getCreateDate()+"%'");
    		}
			if(record.getStatus()!=null&&StrUtil.isNotEmpty(record.getStatus().toString())) {
    			list2.add("'%"+record.getStatus()+"%'");
    		}
			if(record.getCategoryId()!=null&&StrUtil.isNotEmpty(record.getCategoryId().toString())) {
    			list2.add("'%"+record.getCategoryId()+"%'");
    		}
			if(record.getTempletId()!=null&&StrUtil.isNotEmpty(record.getTempletId().toString())) {
    			list2.add("'%"+record.getTempletId()+"%'");
    		}
			if(record.getFrequency()!=null&&StrUtil.isNotEmpty(record.getFrequency().toString())) {
    			list2.add("'%"+record.getFrequency()+"%'");
    		}
			if(record.getTitle()!=null&&StrUtil.isNotEmpty(record.getTitle().toString())) {
    			list2.add("'%"+record.getTitle()+"%'");
    		}
			if(record.getDescription()!=null&&StrUtil.isNotEmpty(record.getDescription().toString())) {
    			list2.add("'%"+record.getDescription()+"%'");
    		}
			if(record.getStartingPrice()!=null&&StrUtil.isNotEmpty(record.getStartingPrice().toString())) {
    			list2.add("'%"+record.getStartingPrice()+"%'");
    		}
			if(record.getCloseDatetime()!=null&&StrUtil.isNotEmpty(record.getCloseDatetime().toString())) {
    			list2.add("'%"+record.getCloseDatetime()+"%'");
    		}
			if(record.getBuyNowPrice()!=null&&StrUtil.isNotEmpty(record.getBuyNowPrice().toString())) {
    			list2.add("'%"+record.getBuyNowPrice()+"%'");
    		}
			if(record.getConditionLevel()!=null&&StrUtil.isNotEmpty(record.getConditionLevel().toString())) {
    			list2.add("'%"+record.getConditionLevel()+"%'");
    		}
			if(record.getShipping()!=null&&StrUtil.isNotEmpty(record.getShipping().toString())) {
    			list2.add("'%"+record.getShipping()+"%'");
    		}
			if(record.getReserveStatus()!=null&&StrUtil.isNotEmpty(record.getReserveStatus().toString())) {
    			list2.add("'%"+record.getReserveStatus()+"%'");
    		}
        	buffer.append(" CONCAT(");
	        buffer.append(StrUtil.join(",",list));
        	buffer.append(")");
        	buffer.append(" like CONCAT(");
        	buffer.append(StrUtil.join(",",list2));
        	buffer.append(")");
        	if(!" CONCAT() like CONCAT()".equals(buffer.toString())) {
        		addCriterion(buffer.toString());
        	}
        	return (Criteria) this;
        }
        
        public Criteria andLikeQuery2(String searchText) {
		 	List<String> list= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
    		list.add("ifnull(id,'')");
    		list.add("ifnull(url,'')");
    		list.add("ifnull(creator,'')");
    		list.add("ifnull(create_date,'')");
    		list.add("ifnull(status,'')");
    		list.add("ifnull(category_id,'')");
    		list.add("ifnull(templet_id,'')");
    		list.add("ifnull(frequency,'')");
    		list.add("ifnull(title,'')");
    		list.add("ifnull(description,'')");
    		list.add("ifnull(starting_price,'')");
    		list.add("ifnull(close_datetime,'')");
    		list.add("ifnull(buy_now_price,'')");
    		list.add("ifnull(condition_level,'')");
    		list.add("ifnull(shipping,'')");
    		list.add("ifnull(reserve_status,'')");
        	buffer.append(" CONCAT(");
	        buffer.append(StrUtil.join(",",list));
        	buffer.append(")");
        	buffer.append("like '%");
        	buffer.append(searchText);
        	buffer.append("%'");
        	addCriterion(buffer.toString());
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