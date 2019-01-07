package cn.yyb.driver.postBean;

/**
 * 添加常用路线请求bean
 */
public class UsualLineAddBean {
    private float   CarLength;//车长
    private String   CarModel;//车型
    private int  Listen;//收听推送 0：否 1：是
    private  FromAreaBean  FromArea;//出发点集合
    private FromAreaBean  TargetArea;//目的地集合

    class FromAreaBean{
        private String  Province;//省
        private String  City;//市
        private String  District;//区

        public String getProvince() {
            return Province;
        }

        public void setProvince(String province) {
            Province = province;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String city) {
            City = city;
        }

        public String getDistrict() {
            return District;
        }

        public void setDistrict(String district) {
            District = district;
        }
    }

    public float getCarLength() {
        return CarLength;
    }

    public void setCarLength(float carLength) {
        CarLength = carLength;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String carModel) {
        CarModel = carModel;
    }

    public int getListen() {
        return Listen;
    }

    public void setListen(int listen) {
        Listen = listen;
    }

    public FromAreaBean getFromArea() {
        return FromArea;
    }

    public void setFromArea(FromAreaBean fromArea) {
        FromArea = fromArea;
    }

    public FromAreaBean getTargetArea() {
        return TargetArea;
    }

    public void setTargetArea(FromAreaBean targetArea) {
        TargetArea = targetArea;
    }
}
