package ir.plusteam.jalse8;


/**
 * any information of about returned data from a get request
 */
public class ReturnedData {

    private int responseCode;
    private String content;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
