package logic.engineeringclasses.bean;

public class RateBean {

    private String rateId;
    private String ownId;
    private String resId;
    private String rateVal;
    private String rateTxt;

    public String getRateBeanId(){
        return rateId;
    }

    public void setRateBeanId(String rateId){
        this.rateId = rateId;
    }

    public String getOwnBeanId() {return ownId;}

    public void setOwnBeanId(String ownId) {
        this.ownId = ownId;}

    public String getResBeanId() {
        return resId;
    }

    public void setResBeanId(String resId) {
        this.resId = resId;
    }

    public String getRateBeanVal() {
        return rateVal;
    }

    public void setRateBeanVal(String rateVal) {
        this.rateVal = rateVal;
    }

    public String getRateBeanTxt() {
        return rateTxt;
    }

    public void setRateBeanTxt(String rateTxt) {
        this.rateTxt = rateTxt;
    }
}
