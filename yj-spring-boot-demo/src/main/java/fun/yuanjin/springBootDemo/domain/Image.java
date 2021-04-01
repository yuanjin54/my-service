package fun.yuanjin.springBootDemo.domain;

/**
 * @ClassName Image
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 21:51
 * @Version 1.0
 */
public class Image {
    private Long id;
    private Long poiId;
    private Integer typeId;
    private Long objectId;
    private String imgDesc;
    private Boolean isShow;
    private Boolean isFront;
    private Integer sortNum;
    private String url;
    private String imgSize;
    private String imgRemark;
    private Integer createId;
    private String createTime;
    private Integer modifyId;
    private String modifyTime;
    private String appKey;

    public Image(Long poiId, String url) {
        this.poiId = poiId;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPoiId() {
        return poiId;
    }

    public void setPoiId(Long poiId) {
        this.poiId = poiId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public Boolean getShow() {
        return isShow;
    }

    public void setShow(Boolean show) {
        isShow = show;
    }

    public Boolean getFront() {
        return isFront;
    }

    public void setFront(Boolean front) {
        isFront = front;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgSize() {
        return imgSize;
    }

    public void setImgSize(String imgSize) {
        this.imgSize = imgSize;
    }

    public String getImgRemark() {
        return imgRemark;
    }

    public void setImgRemark(String imgRemark) {
        this.imgRemark = imgRemark;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", poiId=" + poiId +
                ", typeId=" + typeId +
                ", objectId=" + objectId +
                ", imgDesc='" + imgDesc + '\'' +
                ", isShow=" + isShow +
                ", isFront=" + isFront +
                ", sortNum=" + sortNum +
                ", url='" + url + '\'' +
                ", imgSize='" + imgSize + '\'' +
                ", imgRemark='" + imgRemark + '\'' +
                ", createId=" + createId +
                ", createTime='" + createTime + '\'' +
                ", modifyId=" + modifyId +
                ", modifyTime='" + modifyTime + '\'' +
                ", appKey='" + appKey + '\'' +
                '}';
    }
}
