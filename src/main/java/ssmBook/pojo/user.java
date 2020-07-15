package ssmBook.pojo;


/**
 * 用户实体类
 * @GimmciK 2020.7.8
 */
public class user {
    private Integer userId;
    private String userName;
    private String uPassWord;
    private String uSex;
    private Integer uAge;
    private String uTel;
    private String uLoc;

    public int getUserId() {
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

    public String getuPassWord() {
        return uPassWord;
    }

    public void setuPassWord(String uPassWord) {
        this.uPassWord = uPassWord;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public Integer getuAge() {
        return uAge;
    }

    public void setuAge(Integer uAge) {
        this.uAge = uAge;
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel;
    }

    public String getuLoc() {
        return uLoc;
    }

    public void setuLoc(String uLoc) {
        this.uLoc = uLoc;
    }
}
