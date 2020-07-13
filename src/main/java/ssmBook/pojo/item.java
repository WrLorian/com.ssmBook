package ssmBook.pojo;


import java.util.List;

/**
 * 订单项目实体类
 * 记录订单详细信息
 * @GimmciK 2020.7.8
 */
public class item {
    private Integer itemId;
    private float bPrice;
    private Integer bookId;
    private String bName;
    private Integer bNum;
    private Integer iId;
    private book book;
    private List<item> itemList;

    private float total;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public float getbPrice() {
        return bPrice;
    }

    public void setbPrice(float bPrice) {
        this.bPrice = bPrice;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public Integer getbNum() {
        return bNum;
    }

    public void setbNum(Integer bNum) {
        this.bNum = bNum;
    }

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public book getBook() {
        return book;
    }

    public void setBook(book book) {
        this.book = book;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = (float)Math.round(total*100)/100;
    }

}
