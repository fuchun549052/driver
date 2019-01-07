package cn.yyb.driver.postBean;

/**
 * 提交认证信息请求bean
 */
public class DriverAddBean {
    private String  TrueName;//姓名
    private String  IdCardNo;//身份证号码
    private String  HeadImageUrl;//本人照片
    private String  IdCardFrontPic;//身份证正面照
    private String  IdCardBackPic;//身份证反面照
    private String  DrivingLicensePic;//驾驶证照片
    private String  VehicleLicensePic;//行驶证照片
    private String  CarLicenseNumber;//车牌号

    public DriverAddBean(String trueName, String idCardNo, String headImageUrl, String idCardFrontPic, String idCardBackPic, String drivingLicensePic, String vehicleLicensePic, String carLicenseNumber) {
        TrueName = trueName;
        IdCardNo = idCardNo;
        HeadImageUrl = headImageUrl;
        IdCardFrontPic = idCardFrontPic;
        IdCardBackPic = idCardBackPic;
        DrivingLicensePic = drivingLicensePic;
        VehicleLicensePic = vehicleLicensePic;
        CarLicenseNumber = carLicenseNumber;
    }

    public String getTrueName() {
        return TrueName;
    }

    public void setTrueName(String trueName) {
        TrueName = trueName;
    }

    public String getIdCardNo() {
        return IdCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        IdCardNo = idCardNo;
    }

    public String getHeadImageUrl() {
        return HeadImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        HeadImageUrl = headImageUrl;
    }

    public String getIdCardFrontPic() {
        return IdCardFrontPic;
    }

    public void setIdCardFrontPic(String idCardFrontPic) {
        IdCardFrontPic = idCardFrontPic;
    }

    public String getIdCardBackPic() {
        return IdCardBackPic;
    }

    public void setIdCardBackPic(String idCardBackPic) {
        IdCardBackPic = idCardBackPic;
    }

    public String getDrivingLicensePic() {
        return DrivingLicensePic;
    }

    public void setDrivingLicensePic(String drivingLicensePic) {
        DrivingLicensePic = drivingLicensePic;
    }

    public String getVehicleLicensePic() {
        return VehicleLicensePic;
    }

    public void setVehicleLicensePic(String vehicleLicensePic) {
        VehicleLicensePic = vehicleLicensePic;
    }

    public String getCarLicenseNumber() {
        return CarLicenseNumber;
    }

    public void setCarLicenseNumber(String carLicenseNumber) {
        CarLicenseNumber = carLicenseNumber;
    }
}
