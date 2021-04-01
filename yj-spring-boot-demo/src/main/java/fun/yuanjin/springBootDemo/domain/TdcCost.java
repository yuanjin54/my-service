package fun.yuanjin.springBootDemo.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName TdcCost
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-01-15 22:29
 * @Version 1.0
 */
public class TdcCost {
    private Integer id;
    private String productName;
    private String priceItem;
    private String priceChildItem;
    private BigDecimal count;
    private String unit;
    private BigDecimal per;
    private String perUnit;
    private BigDecimal cost;
    private String mouthRat;
    private String category;
    private String appKey;
    private String appKeyPriceChange;
    private String appName;
    private String userName;
    private String groupName;
    private Date startTime;
    private Date endTime;
    private String envName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(String priceItem) {
        this.priceItem = priceItem;
    }

    public String getPriceChildItem() {
        return priceChildItem;
    }

    public void setPriceChildItem(String priceChildItem) {
        this.priceChildItem = priceChildItem;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPer() {
        return per;
    }

    public void setPer(BigDecimal per) {
        this.per = per;
    }

    public String getPerUnit() {
        return perUnit;
    }

    public void setPerUnit(String perUnit) {
        this.perUnit = perUnit;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getMouthRat() {
        return mouthRat;
    }

    public void setMouthRat(String mouthRat) {
        this.mouthRat = mouthRat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppKeyPriceChange() {
        return appKeyPriceChange;
    }

    public void setAppKeyPriceChange(String appKeyPriceChange) {
        this.appKeyPriceChange = appKeyPriceChange;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }
}
