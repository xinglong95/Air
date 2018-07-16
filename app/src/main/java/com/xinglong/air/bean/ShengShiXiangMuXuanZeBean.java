package com.xinglong.air.bean;

import java.util.List;

public class ShengShiXiangMuXuanZeBean {
        private String ShengName;
        private String name;
        private List<ShiDatas> ShiDatas;

    public String getShengName() {
        return ShengName;
    }

    public void setShengName(String shengName) {
        ShengName = shengName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShengShiXiangMuXuanZeBean.ShiDatas> getShiDatas() {
        return ShiDatas;
    }

    public void setShiDatas(List<ShengShiXiangMuXuanZeBean.ShiDatas> shiDatas) {
        ShiDatas = shiDatas;
    }

    public static class ShiDatas {


            public String getShiName() {
                return ShiName;
            }

            public void setShiName(String shiName) {
                ShiName = shiName;
            }

            public List<ShengShiXiangMuXuanZeBean.XiangMuDatas> getXiangMuDatas() {
                return XiangMuDatas;
            }

            public void setXiangMuDatas(List<ShengShiXiangMuXuanZeBean.XiangMuDatas> xiangMuDatas) {
                XiangMuDatas = xiangMuDatas;
            }
            private String ShiName;
            private List<XiangMuDatas> XiangMuDatas;
        }
        public static class XiangMuDatas {
            private String XiangMuName;
            private String XiangMuID;
            private boolean isChecked=false;

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }

            public String getXiangMuName() {
                return XiangMuName;
            }

            public void setXiangMuName(String xiangMuName) {
                XiangMuName = xiangMuName;
            }

            public String getXiangMuID() {
                return XiangMuID;
            }

            public void setXiangMuID(String xiangMuID) {
                XiangMuID = xiangMuID;
            }
        }

}
