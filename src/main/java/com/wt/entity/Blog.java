package com.lz.entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lize
 */

@Data
public class Blog {
    /**编号*/
    private Long id;

    /**标题*/
    private String title;

    /**内容*/
    private String content;

    /**首部图片地址*/
    private String firstPicture;

    /**原创、翻译、转载*/
    private String flag;

    /**浏览次数*/
    private Integer views;

    /**开启赞赏*/
    private boolean appreciation;

    /**开启分享声名*/
    private boolean shareStatement;

    /**开启评论*/
    private boolean commentabled;

    /**是否发布*/
    private boolean published;

    /**是否推荐*/
    private boolean recommend;

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;

    /**文章描述*/
    private String description;

    /**用于关联*/
    private Long typeId;
    private Long userId;

    /**获取多个标签编号*/
    private String tagIds;

    //下面是级联关系
    private Type type;
    private List<Tag> tags=new ArrayList<>();
    private List<Comment> comments=new ArrayList<>();
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    //将tags集合转换为tagIds字符串：1,2,3
    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }

}
