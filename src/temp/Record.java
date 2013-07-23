package temp;

class Record {
    private Long date;
    private Long countryCode;
    private Long userId;
    private Long siteId;
    private String type;

    public Long getDate() {
        return date;
    }
    public void setDate(Long date) {
        this.date = date;
    }
    public Long getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(Long countryCode) {
        this.countryCode = countryCode;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getSiteId() {
        return siteId;
    }
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
