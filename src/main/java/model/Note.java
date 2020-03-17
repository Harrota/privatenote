package model;

public class Note {
    private long id;
    private String article;
    private String text;

    public Note(long id, String article, String text) {
        this.id = id;
        this.article = article;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "model.Note{" +
                "id=" + id +
                ", article='" + article + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
