package ssmBook.pojo;


import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 * 记录订单是否处理
 * @GimmciK 2020.7.8
 */
public class indent {

    // 状态 - 未处理
    public static final byte STATUS_WAIT = 1;
    // 状态 - 已处理
    public static final byte STATUS_DOWN = 2;
    // 状态 - 已删除
    public static final byte STATUS_DELETE = 3;

    private Integer iId;
    private float total;
    private Integer amount;
    private int state;
    private Integer userId;
    private String userName;
    private String loc;
    private String tel;
    private Date time;

    private user user;
    private List<item> itemList;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<item> getItemList() {
        return itemList;
    }

    public void setItemList(List<item> itemList) {
        this.itemList = itemList;
    }

    public user getUser() {
        return user;
    }
    public void setUser(user user) {
        this.user = user;
    }
}
