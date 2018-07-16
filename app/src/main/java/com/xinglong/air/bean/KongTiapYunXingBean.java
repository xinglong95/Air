package com.xinglong.air.bean;

public class KongTiapYunXingBean {

    /**
     * data : {"Total":90,"Running":83,"Stop":15,"Error":1}
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
         * Total : 90
         * Running : 83
         * Stop : 15
         * Error : 1
         */

        private int Total;
        private int Running;
        private int Stop;
        private int Error;

        public int getTotal() {
            return Total;
        }

        public void setTotal(int Total) {
            this.Total = Total;
        }

        public int getRunning() {
            return Running;
        }

        public void setRunning(int Running) {
            this.Running = Running;
        }

        public int getStop() {
            return Stop;
        }

        public void setStop(int Stop) {
            this.Stop = Stop;
        }

        public int getError() {
            return Error;
        }

        public void setError(int Error) {
            this.Error = Error;
        }
    }
}
