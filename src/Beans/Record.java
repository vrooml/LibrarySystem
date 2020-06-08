package Beans;

public class Record{
    int recordId;
    int bookId;
    int readerId;
    String bookName;
    String borrowDate;
    String returnDate;

    public Record(int recordId,int bookId,int readerId,String bookName,String borrowDate,String returnDate){
        this.recordId=recordId;
        this.bookId=bookId;
        this.readerId=readerId;
        this.bookName=bookName;
        this.borrowDate=borrowDate;
        this.returnDate=returnDate;
    }

    public String getBookName(){
        return bookName;
    }

    public void setBookName(String bookName){
        this.bookName=bookName;
    }

    public int getRecordId(){
        return recordId;
    }

    public void setRecordId(int recordId){
        this.recordId=recordId;
    }

    public int getBookId(){
        return bookId;
    }

    public void setBookId(int bookId){
        this.bookId=bookId;
    }

    public int getReaderId(){
        return readerId;
    }

    public void setReaderId(int readerId){
        this.readerId=readerId;
    }

    public String getBorrowDate(){
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate){
        this.borrowDate=borrowDate;
    }

    public String getReturnDate(){
        return returnDate;
    }

    public void setReturnDate(String returnDate){
        this.returnDate=returnDate;
    }
}
