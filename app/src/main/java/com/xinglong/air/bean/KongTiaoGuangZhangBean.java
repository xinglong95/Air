package com.xinglong.air.bean;

public class KongTiaoGuangZhangBean {

    /**
     * data : {"Total":100,"SeriousFault":20,"GeneralFault":20,"MinorFault":20,"Normal":20}
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
         * Total : 100
         * SeriousFault : 20
         * GeneralFault : 20
         * MinorFault : 20
         * Normal : 20
         */

        private int Total;
        private int SeriousFault;
        private int GeneralFault;
        private int MinorFault;
        private int Normal;

        public int getTotal() {
            return Total;
        }

        public void setTotal(int Total) {
            this.Total = Total;
        }

        public int getSeriousFault() {
            return SeriousFault;
        }

        public void setSeriousFault(int SeriousFault) {
            this.SeriousFault = SeriousFault;
        }

        public int getGeneralFault() {
            return GeneralFault;
        }

        public void setGeneralFault(int GeneralFault) {
            this.GeneralFault = GeneralFault;
        }

        public int getMinorFault() {
            return MinorFault;
        }

        public void setMinorFault(int MinorFault) {
            this.MinorFault = MinorFault;
        }

        public int getNormal() {
            return Normal;
        }

        public void setNormal(int Normal) {
            this.Normal = Normal;
        }
    }
}
