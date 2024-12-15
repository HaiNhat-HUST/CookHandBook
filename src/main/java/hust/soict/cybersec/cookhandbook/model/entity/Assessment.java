package hust.soict.cybersec.cookhandbook.model.entity;

public class Assessment {
    private int authorId;
    private int rate;
    private String comment;

    public Assessment() {}

    public Assessment(int authorId, int rate, String comment) {
        this.authorId = authorId;
        this.rate = rate;
        this.comment = comment;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
