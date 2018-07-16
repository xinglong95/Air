package com.xinglong.air.bean;

public class LieJianLv {

    /**
     * data : {"HealthStatus":30}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * HealthStatus : 30
         */

        private int HealthStatus;

        public int getHealthStatus() {
            return HealthStatus;
        }

        public void setHealthStatus(int HealthStatus) {
            this.HealthStatus = HealthStatus;
        }
    }
}
